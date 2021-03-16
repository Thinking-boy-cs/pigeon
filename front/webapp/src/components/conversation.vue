<template>
  <div>
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
          <a-icon type="left" @click="$router.go(-1)" />
        </div>
        <div class="page-title">
          {{ titleName }}
        </div>
      </div>
    </div>
    <div id="content-container">
      <transition-group appear tag="div">
        <div
          class="message-item"
          v-for="(item, i) in $store.state.messageData.chats[0].data"
          :key="i"
        >
          <div class="message-time">
            {{ item.time }}
          </div>
          <a-row class="message-main">
            <a-col :span="10" class="message-label">发起人</a-col>
            <a-col :span="14" class="message-content">{{ item.userId }}</a-col>
            <a-col :span="10" class="message-label">活动内容</a-col>
            <a-col :span="14" class="message-content">{{ item.content }}</a-col>
            <a-divider type="horizontal" />
            <div class="message-link">
              <router-link :to="'/Signin/' + item.url">
                <a-icon type="double-right" /> 详情</router-link
              >
            </div>
          </a-row>
        </div>
      </transition-group>
    </div>
  </div>
</template>

<script>
const nameMap = ['通知公告', '待办消息', '活动信息']
export default {
  data () {
    return {
      titleName: '',
      conData: {
        name: 'test',
        data: [
          {
            fromUser: {
              id: '9514233f-14b7-4',
              name: 'jecosine',
              icon: '867ecc603cde457aba0eb8309bc02cd4.png'
            },
            dept: {
              id: '92ad18b6-5054-4',
              name: '前端',
              icon: '',
              background: '#1890ff'
            },
            content: {
              title: '【任务】与后台对接',
              content: '对接内容详情见邮件'
            },
            date: '2020-11-24 17:00',
            read: false
          }
        ]
      }
    }
  },
  computed: {},
  created () {
    const that = this
    this.$router.onReady(() => {
      that.titleName = nameMap[parseInt(this.$route.params.conId)]
    })
  }
}
</script>

<style lang="less" scoped>
@import "../style/index.less";
.v-enter,
.v-leave-to {
  opacity: 0; //设置元素的不透明级别：
  transform: translateY(80px); // 开始和结束位置在Y轴的80px处
}

.v-enter-active,
.v-leave-active {
  transition: all 0.6s ease; // 从Y轴的80px处渐渐移动到上面
}
.v-move {
  transition: all 0.6s ease;
}
.v-leave-active {
  position: absolute;
}
.message-label,
.message-content {
  height: 30px;
  line-height: 30px;
}
.message-label {
  text-align: left;
  font-weight: bold;
}
.message-content {
  text-align: left;
}
.message-item {
  width: calc(100% - 40px);
  margin-top: 20px;
  margin-left: 20px;
}
.message-main {
  background: white;
  padding: 10px;
  border-radius: 10px;
  box-shadow: 0 0 2px 2px rgba(0, 0, 0, 0.1);
}
.message-time {
  margin: 0 auto;
  padding: 5px;
  width: fit-content;
  border-radius: 5px;
  color: white;
  font-size: 12px;
  font-weight: bold;
  background-color: rgba(0, 0, 0, 0.2);
  margin-bottom: 10px;
}
.message-link {
  text-align: left;
}
#content-container {
  position: absolute;
  width: 100%;
  top: 58px;
  margin-bottom: 20px;
  padding-bottom: 30px;
}
#navigation-container {
  z-index: 999;
}
</style>
