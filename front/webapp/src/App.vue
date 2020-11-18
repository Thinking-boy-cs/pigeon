<!--
 * @Date: 2020-11-11 09:58:43
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-17 21:53:55
-->
<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <router-view />
    <div id="navigator-container">
      <a-row>
        <a-col :span="8" class="menu-item" @click="switchTab(0)">
          <a-icon
            theme="filled"
            type="home"
            :class="{'menu-icon': true, 'selected': currentTab===1}"
          />
          <div class="menu-name">主页</div>
        </a-col>
        <a-col :span="8" class="menu-item" @click="switchTab(1)">
          <a-icon theme="filled" type="bell" class="menu-icon" />
          <div class="menu-name">消息</div>
        </a-col>
        <a-col :span="8" class="menu-item" @click="switchTab(2)">
          <a-icon theme="filled" type="idcard" class="menu-icon" />
          <div class="menu-name">我的</div>
        </a-col>
      </a-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      paths: ["/", "/notification", "/me"],
      currentTab: -1
    };
  },
  methods: {
    switchTab: function(t) {
      var that = this;
      this.$router.push({ path: that.paths[t] });
    }
  }
};
</script>

<style lang="less">
@import "~ant-design-vue/dist/antd.less";

#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  width: 100vw;
  height: 100vh;
  /* margin-top: 60px; */
}
.selected {
  color: @primary-color;
}
#navigator-container {
  position: fixed;
  width: 100%;
  bottom: 0;
  height: 60px;
  box-shadow: 0px -1px 3px 2px rgba(0, 0, 0, 0.1);
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
