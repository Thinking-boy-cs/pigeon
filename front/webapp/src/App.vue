<!--
 * @Date: 2020-11-11 09:58:43
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-18 15:04:37
-->
<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <transition :name="animationName" mode="out-in">
      <router-view class="page" :key="$route.name" />
    </transition>
    <div id="navigator-container">
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
export default {
  name: 'App',
  data () {
    return {
      paths: ['/', '/notification', '/me'],
      currentTab: this.$route.meta.id,
      animationName: 'slide-left'
    }
  },
  methods: {
    switchTab: function (t) {
      var that = this
      this.$router.push({ path: that.paths[t] })
      this.currentTab = t
    }
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
      if (to.meta.id > from.meta.id) {
        this.animationName = 'slide-left'
      } else {
        this.animationName = 'slide-right'
      }
    }
  },
  mounted () {
    window.Vue = this
  }
}
</script>

<style lang="less" scoped>
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
  animation: slideInLeft 0.3s forwards;
  z-index: 5;
}

.slide-left-leave-active {
  animation: slideLeftOut 0.3s forwards;
  z-index: 3;
}
.slide-right-enter-active {
  animation: slideInRight 0.3s forwards;
  z-index: 5;
}

.slide-right-leave-active {
  animation: slideRightOut 0.3s forwards;
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
</style>
