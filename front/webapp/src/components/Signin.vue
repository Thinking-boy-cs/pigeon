<template>
  <div>
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
          <a-icon type="left" @click="$router.go(-1)" />
        </div>
        <div class="page-title">签到</div>
      </div>
    </div>
    <div id="information-bar">
      <div id="avatar"><a-avatar :size="64" icon="user" /></div>
      <div id="userinfo">
        <a id="username">用户名</a>
        <div id="apartment">部门名称</div>
      </div>
      <div id="leave">
        <a-icon type="audit" style="font-size: 24px" />
        <div style="font-weight: bold">请假</div>
      </div>
    </div>
    <div id="main-container">
      <div id="sign-button">
        <div id="sign-title">打卡</div>
      </div>
      <div id="sign-map">
        <a-icon type="environment" id="environment" theme="filled"  />
        <a id="text">查看签到范围</a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {}
  },
  methods: {}
}
</script>

<style lang="less" scoped>
@import "~ant-design-vue/dist/antd.less";
* {
  margin: 0;
  padding: 0;
  text-decoration: none;
  color: @text-color;
}
.icon-container {
  position: absolute;
  left: 0;
}
.page-title {
  font-size: 20px;
  font-weight: bold;
}
#information-bar {
  position: absolute;
  background-color:white;
  margin-top: 80px;
  margin-left: 15px;
  width: calc(100% - 30px);
  height: 100px;
  border-radius: 20px 20px 20px 20px;
}
#avatar {
  margin-left: 20px;
  margin-top: 10px;
  float: left;
}
#userinfo {
  float: left;
  margin-left: 10px;
  margin-top: 20px;
  text-align: left;
}
#username {
  font-weight: bold;
  color: black;
}
#apartment {
  margin-top: 5px;
}
#leave {
  float: left;
  margin-left: 185px;
  margin-top: 20px;
}
#main-container {
  position: absolute;
  background-color: white;;
  margin-top: 200px;
  margin-left: 15px;
  width: calc(100% - 30px);
  height: 500px;
  border-radius: 20px 20px 20px 20px;
}
#sign-button {
  position: absolute;
  background-color: #3291F8;
  margin-top: 20%;
  margin-left: 25%;
  width: 200px;
  height: 200px;
  border-radius: 50%;
  box-shadow: 0px 2px 15px 6px rgba(0, 0, 0, 0.1);
}
#sign-title {
  font-size: 25px;
  font-weight: bold;
  color: white;
  margin-top: 65px;
}
#sign-map {
  margin-top: 85%;
}
#environment {
  font-size: 20px;
  color: #3291f8;
}
#text {
  font-size: 20px;
  color: #3291f8;
  font-weight: bold;
}
</style>
