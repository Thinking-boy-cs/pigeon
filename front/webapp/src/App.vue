<!--
 * @Date: 2020-11-11 09:58:43
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2020-11-24 17:17:41
-->
<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <transition :name="animationName" mode="out-in">
      <router-view class="page" :key="$route.name" />
    </transition>
    <a-spin size="large" v-if="loading" />
    <div id="navigator-container" v-if="$route.meta.id >= 0">
      <a-row>
        <a-col :span="8" class="menu-item" @click="switchTab(0)">
          <a-icon
            theme="filled"
            type="home"
            :class="{ 'menu-icon': true, selected: currentTab === 0 }"
          />
          <div class="menu-name">主页</div>
        </a-col>
        <a-col :span="8" class="menu-item" @click="switchTab(1)">
          <a-icon
            theme="filled"
            type="bell"
            :class="{ 'menu-icon': true, selected: currentTab === 1 }"
          />
          <div id="red-icon">
            <div>{{ unreadCount }}</div>
          </div>
          <div class="menu-name">消息</div>
        </a-col>
        <a-col :span="8" class="menu-item" @click="switchTab(2)">
          <a-icon
            theme="filled"
            type="idcard"
            :class="{ 'menu-icon': true, selected: currentTab === 2 }"
          />
          <div class="menu-name">我的</div>
        </a-col>
      </a-row>
    </div>
  </div>
</template>

<script>
// import SockJS from 'sockjs-client'
// import Stomp from 'stompjs'
export default {
  name: 'App',
  data () {
    return {
      paths: ['/', '/notification', '/me'],
      currentTab: null,
      animationName: 'slide-left',
      // wsUrl: 'ws://127.0.0.1:5000/api/pigeon/ws'
      ws: null,
      loading: false,
      unreadCount: 1
    }
  },
  beforeDestroy () {
    // 如果跳转别的页面的时候不仍保持websocket通信，此步可注释，否则定时器要清除
    // clearInterval(this.timer)
    this.$store.state.ws.dispatch('disconnect')
  },

  methods: {
    switchTab: function (t) {
      var that = this
      if (this.currentTab === t) {
        return
      }
      this.currentTab = t
      this.$router.push({ path: that.paths[t] })
    },
    connection () {
      let socket = new this.SockJS('/api/pigeon/sjs', null, { timeout: 15000 }) // 后端提供协议字段
      this.stompClient = this.Stomp.over(socket)
      let that = this
      this.stompClient.connect(
        {},
        function connectCallback () {
          console.log('Connect success!')
          that.stompClient.subscribe(
            '/user/1606060960448/queue/getResponse',
            res => {
              // 后端提供订阅地址
              console.log(res) // 接收后端response数据
            }
          )
        },
        function errorCallBack (error) {
          console.log('连接失败:' + error)
        }
      )
    },
    disconnect () {
      // console.log(this.timer)
      // clearInterval(this.timer)
      if (this.stompClient) {
        this.stompClient.disconnect()
      }
    },
    onmessage (res) {
      console.log(this.animationName, res)
    }
  },
  created () {
    var that = this
    setTimeout(() => {
      this.currentTab = this.$route.meta.id
    }, 500)
    window.myApp = this
    // open websocket
    // this.$store.dispatch('openWebSocketFunction', {
    //   url: that.wsUrl,
    //   onOpenHandler: that.onOpen,
    //   onCloseHandler: that.onClose,
    //   onErrorHandler: that.onError,
    //   onMessageHandler: that.onMessage
    // })
    // this.$store.dispatch('setWebSocketHandlerFunction', this.onOpen, this.onClose, this.onMessage, this.onError)
  },
  // beforeRouteUpdate (to, from, next) {
  //   const toDepth = to.path.split('/').length
  //   const fromDepth = from.path.split('/').length
  //   this.animationName = toDepth < fromDepth ? 'slide-right' : 'slide-left'
  //   console.log('Current transition:' + this.animationName)
  //   next()
  // }
  watch: {
    $route (to, from) {
      console.log(to)
      this.loading = true
      this.currentTab = to.meta.id
      if (to.meta.id > from.meta.id) {
        this.animationName = 'slide-left'
      } else {
        this.animationName = 'slide-right'
      }
    }
  },
  mounted () {
    var that = this
    window.Vue = this
    // this.connection()
    this.$store.dispatch('connectFunc', {
      userId: '1606060960448',
      subscribes: ['/user/1606060960448/queue/getResponse'],
      onmessage: this.onmessage,
      connectCallback: this.onmessage,
      errorCallBack: this.onmessage
    })
    this.$router.onReady(() => {
      setTimeout(() => {
        that.loading = false
      }, 500)
    })
  }
}
</script>

<style lang="less">
@import "./style/index.less";
.page {
  // position: absolute;
  // width: 100%;
  box-sizing: border-box;
  transition: all 0.5s;
  opacity: 1 important;
}

// @import "~ant-design-vue/dist/antd.less";
@keyframes slideInLeft {
  from {
    transform: translate3d(100%, 0, 0);
    opacity: 1;
  }
  to {
    transform: translate3d(0, 0, 0);
    opacity: 1;
  }
}
@keyframes slideInRight {
  from {
    transform: translate3d(-100%, 0, 0);
    opacity: 1;
  }
  to {
    transform: translate3d(0, 0, 0);
    opacity: 1;
  }
}
@keyframes slideLeftOut {
  from {
    transform: translate3d(0, 0, 0);
    opacity: 0;
  }
  to {
    transform: translate3d(100%, 0, 0);
    opacity: 0;
  }
}
@keyframes slideRightOut {
  from {
    transform: translate3d(0, 0, 0);
    opacity: 0;
  }
  to {
    transform: translate3d(-100%, 0, 0);
    opacity: 0;
  }
}
.slide-left-enter-active {
  animation: slideInLeft 0.1s forwards;
  z-index: 5;
}

.slide-left-leave-active {
  animation: slideLeftOut 0.1s forwards;
  z-index: 3;
}
.slide-right-enter-active {
  animation: slideInRight 0.1s forwards;
  z-index: 5;
}

.slide-right-leave-active {
  animation: slideRightOut 0.1s forwards;
  z-index: 3;
}
#app {
  font-family: "PingFang SC", "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  width: 100vw;
  height: 100vh;
  /* margin-top: 60px; */
}
.selected {
  color: @primary-color!important;
}
#navigator-container {
  position: fixed;
  width: 100%;
  bottom: 0;
  height: 60px;
  box-shadow: 0px -1px 3px 2px rgba(0, 0, 0, 0.1);
  background: #fff;
}
.menu-item {
  color: @text-color-secondary;
  padding: 7px;
}
.menu-icon {
  height: 30px;
  font-size: 24px;
}
.menu-name {
  height: 14px;
  line-height: 14px;
  font-size: 12px;
}
#red-icon {
  position: absolute;
  right: calc(50% - 20px);
  top: 5px;
  background-color: red;
  width: 14px;
  height: 14px;
  border-radius: 50%;
  color: white;
  font-size: 10px;
  text-align: center;
}
</style>
