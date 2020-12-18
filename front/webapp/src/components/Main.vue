<!--
 * @Date: 2020-11-15 17:44:38
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2020-11-26 06:59:51
-->
<template>
  <div id="app"  key="0">
    <div id="carousel-container">
      <a-carousel autoplay>
        <div class="cabg">
          <!-- <img src='../img/01.jpg'/> -->
        </div>
        <div class="cabg">
        </div>
        <div class="cabg">
        </div>
        <div class="cabg">

        </div>
      </a-carousel>
    </div>
    <!-- <i class="fa fa-address-book-o">face</i> -->
    <div class="section-container">
      <div class="section-wrapper">
        <div class="section-title">最近常用</div>
        <div class="item-container">
          <a-row>
            <a-col
              class="feature-item"
              :span="8"
              v-for="(item, i) in pageData.recents"
              :key="i" @click="toPage(item.link)"
            >
              <div class="feature-icon">
                <a-icon :type="item.icon" two-tone-color="#fb7299" />
              </div>
              <div class="feature-name">{{ item.name }}</div>
            </a-col>
          </a-row>
        </div>
        <div class="section-container">
          <div class="section-title">所有应用</div>
          <div class="item-container">
            <a-row>
              <a-col
                class="feature-item"
                :span="8"
                v-for="(item, i) in pageData.all"
                :key="i"
              >
                <div class="feature-icon">
                  <a-icon :type="item.icon" two-tone-color="#fb7299" />
                </div>
                <div class="feature-name">{{ item.name }}</div>
              </a-col>
            </a-row>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      pageData: {},
      id: null
    }
  },
  methods: {
    toPage (uri) {
      this.$router.push({ path: uri })
    }
  },
  computed: {

  },
  created () {
    var that = this
    this.user = JSON.parse(window.localStorage.getItem('user'))
    // get page layout
    this.$axios
      .get('/static/pageData.json')
      .then(function (res) {
        console.log(res.data)
        that.pageData = res.data
        that.pageData.recents = that.pageData.recents.filter((item) => {
          return (!item.admin) || (that.user.id === '1606060960')
        })
      })
      .catch(function (error) {
        console.log(error)
      })
  }
}
</script>

<style lang="less" scoped>
@import "../style/index.less";

#carousel-container {
  position: relative;
  width: 100%;
  height: 200px;
}
.cabg {
  background-color: rgba(251, 114, 153, 0.514);
  width: 100%;
  height: 200px;
}
.section-container {
  margin-top: 20px;
}
.section-title {
  text-align: left;
  font-weight: bold;
  font-size: 16px;
  height: 40px;
  line-height: 40px;
  color: @text-color;
}
.section-wrapper {
  width: calc(100% - 40px);
  margin-left: 20px;
}
.feature-item {
  display: inline-flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  height: 80px;
  padding: 10px;
}
.feature-icon {
  font-size: 24px;
  height: 40px;
  color: @primary-color;
  font-weight: bold;
}
.feature-name {
  font-size: 16px;
  height: 20px;
  line-height: 20px;
  color: @text-color;
}
</style>
