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
    <div id="content-container">
      <div id="information-bar">
        <div id="avatar"><a-avatar :size="64" :src="iconUrl" /></div>
        <div id="userinfo">
          <a id="username">{{ userData.username }}</a>
          <div id="apartment"> {{ userData.dept ? userData.dept : "无" }}</div>
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
          <a-icon type="environment" id="environment" theme="filled" />
          <a id="text">查看签到范围</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return { userData: null }
  },
  computed: {
    iconUrl () {
      var that = this
      console.log(this.userData.icon
        ? '/api/pigeon/pthotos/' + this.userData.icon
        : 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png')
      return this.userData.icon
        ? '/api/pigeon/pthotos/' + this.userData.icon
        : 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png'
    }
  },
  methods: {
  },
  created () {
    this.userData = window.localStorage.getItem('user')

    console.log(this.userData)
    if (this.userData) {
      this.userData = JSON.parse(this.userData)
    } else {
      this.$router.push({ path: '/login' })
    }
  }
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
#content-container {
  position: absolute;
  width: 100%;
  top: 70px;
}
#information-bar {
  position: relative;
  background-color: white;
  margin-left: 15px;
  width: calc(100% - 30px);
  height: 100px;
  border-radius: 20px 20px 20px 20px;
  display: flex;
}
#avatar {
  margin-left: 20px;
  margin-top: 10px;
}
#userinfo {
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
  position: relative;
  padding-left: 95px;
  margin: 0 auto;
  align-self: end;
  bottom: 30px;
}
#main-container {
  position: relative;
  background-color: white;
  margin-left: 15px;
  width: calc(100% - 30px);
  height: 70vh;
  border-radius: 20px 20px 20px 20px;
  top: 20px;
  display: flex;
  flex-direction: column;
}
#sign-button {
  position: relative;
  background-color: #3291f8;
  width: 200px;
  height: 200px;
  border-radius: 50%;
  box-shadow: 0px 2px 15px 6px rgba(0, 0, 0, 0.1);
  margin: 0 auto;
  margin-top: 20%;
  align-self: center;
  display: flex;
}
#sign-title {
  font-size: 25px;
  font-weight: bold;
  color: white;
  align-self: center;
  padding-left: 75px;
}
#sign-map {
  padding-top:20px;
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
