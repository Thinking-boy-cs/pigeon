<template>
  <div id="page-container">
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
          <a-icon type="left" @click="$router.go(-1)" style="color: black" />
        </div>
        <div class="page-title">签到数据</div>
      </div>
    </div>
    <div id="content-container">
      <a-tabs default-active-key="1">
        <a-tab-pane key="1">
          <span slot="tab">
            <a-icon type="close-circle" />
            未签到
          </span>
          <div
            v-infinite-scroll="handleInfiniteOnLoad"
            class="demo-infinite-container"
            :infinite-scroll-disabled="busy"
            :infinite-scroll-distance="10"
          >
            <a-list :data-source="data">
              <a-list-item slot="renderItem" slot-scope="item">
                <a-list-item-meta :description="item.email">
                  <a slot="title" :href="item.href">{{ item.username }}</a>
                  <a-avatar
                    slot="avatar"
                    icon="user"
                  />
                </a-list-item-meta>
                <div>未签到</div>
              </a-list-item>
              <div v-if="loading && !busy" class="demo-loading-container">
                <a-spin />
              </div>
            </a-list>
          </div>
        </a-tab-pane>
        <a-tab-pane key="2">
          <span slot="tab">
            <a-icon type="clock-circle" />
            已请假
          </span>
          Tab 2
        </a-tab-pane>
        <a-tab-pane key="3">
          <span slot="tab">
            <a-icon type="check-circle" />
            已签到
          </span>
          Tab 3
        </a-tab-pane>
      </a-tabs>
    </div>
  </div>
</template>

<script>
import reqwest from 'reqwest'
// const fakeDataUrl = 'https://randomuser.me/api/?results=10&inc=name,gender,email,nat&noinfo'
const fakeDataUrl = 'http://test.jecosine.com/api/pigeon/govern/findUnsigned?companyId=232b7da9-9582-4&theTime=2020-03-17'
export default {
  data () {
    return {
      data: [],
      loading: false,
      busy: false
    }
  },
  beforeMount () {
    this.fetchData(res => {
      this.data = res.data
    })
  },
  methods: {
    fetchData (callback) {
      reqwest({
        url: fakeDataUrl,
        type: 'json',
        method: 'get',
        contentType: 'application/json',
        success: res => {
          callback(res)
        }
      })
    },
    handleInfiniteOnLoad () {
      const data = this.data
      this.loading = true
      if (data.length > 14) {
        this.$message.warning('Infinite List loaded all')
        this.busy = true
        this.loading = false
        return
      }
      this.fetchData(res => {
        this.data = data.concat(res.data)
        this.loading = false
      })
    }
  }
}
</script>

<style lang="less" scoped>
@import "~ant-design-vue/dist/antd.less";
#page-container {
  background-color: white;
  height: 100vh;
}
#content-container {
  background-color: white;
  position: absolute;
  width: 100%;
  top: 59px;
}
.demo-infinite-container {
  border-radius: 4px;
  overflow: auto;
  padding: 8px 24px;
  height: 80vh;
}
.demo-loading-container {
  position: absolute;
  bottom: 40px;
  width: 100%;
  text-align: center;
}
</style>
