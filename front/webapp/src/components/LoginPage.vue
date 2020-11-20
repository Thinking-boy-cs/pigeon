<template>
  <div id="header-background">
  <div id="header-container">
    <div id="header-title">
      <p id="welcome">
        欢迎使用Pigeon
        <p class="welcome1">更&nbsp;&nbsp;懂&nbsp;&nbsp;大&nbsp;&nbsp;学&nbsp;&nbsp;生<br /><br /><br />
      </p>
    </div>
    <div id="cover">
    <div id="header-mid">
      <p id="login">账号密码登录</p>
      <a-form
    id="components-form-demo-normal-login"
    :form="form"
    class="login-form"
    @submit="handleSubmit"
  >
    <a-form-item>
      <a-input size="large" id="username"
      allow-clear @change="onChange"
        v-decorator="[
          'userName',
          { rules: [{ required: true, message: '请输入用户名' }] },
        ]"
        placeholder="请输入用户名"
      >
        <a-icon slot="prefix" type="user" style="color: rgba(0,0,0,.25)" />
      </a-input>
    </a-form-item>
    <a-form-item>
      <a-input-password size="large" id="password"
        v-decorator="[
          'password',
          { rules: [{ required: true, message: '请输入密码' }] },
        ]"
        type="password"
        placeholder="请输入密码"
      >
        <a-icon slot="prefix" type="lock" style="color: rgba(0,0,0,.25)" />
      </a-input-password>
    </a-form-item>
    <a-form-item>
      <a-checkbox class="checkbox-remember"
        v-decorator="[
          'remember',
          {
            valuePropName: 'checked',
            initialValue: true,
          },
        ]"
      >
        记住我
      </a-checkbox>
      <a class="login-form-forgot" href="">
        忘记密码
      </a>
      <a-button size="large" type="primary" html-type="submit" class="login-form-button">
        登 录
      </a-button>
      或者
      <a @click="gotoregister">
        现在就注册!
      </a>
    </a-form-item>
  </a-form>
    </div>
    </div>
  </div>
  </div>
</template>

<script>
export default {
  methods: {
    handleSubmit (e) {
      e.preventDefault()
      this.form.validateFields((err, values) => {
        if (!err) {
          console.log('Received values of form: ', values)
        }
      })
    },
    gotoregister () {
      this.$router.push({ path: '/Register' })
    },
    onChange (e) {
      console.log(e)
    }
  }
}
</script>

<style lang="less" scoped>
// @import "~ant-design-vue/dist/antd.less";
@import "../style/index.less";
#header-background {
  background: url(../img/01.jpg ) no-repeat fixed;
  background-size: 100% 100%;
  width:100%;
  height:100%;
  position: relative;
  box-sizing:border-box;
  z-index:1;
}
#header-background:after{
  // background: url(../img/gezi.png) no-repeat fixed;
  content: "";
  width:100%;
  height:100%;
  position: absolute;
  left:0;
  top:0;
  // filter: opacity(30%);
  filter: blur(1px);
  background: inherit;
  z-index: 2;
}
#header-container {
  position: relative;
  z-index: 3;
}
#header-title {
  margin-bottom:50px;
}
* {
  margin: 0;
  padding: 0;
  text-decoration: none;
  font-family: PingFang SC;
}
#welcome {
  padding-top: 65px;
  font-size: 26px;
  text-align: center;
  font-weight: bold;
  color: white;
  margin-bottom: 0.5em;
}
.welcome1 {
  font-size: 15px;
  color: white;
}
#login {
  padding-top: 40px;
  padding-bottom: 25px;
  font-size: 20px;
  text-align: left;
  font-weight: bold;
}
#header-mid {
  margin-left: 45px;
  width: calc(100% - 90px);
}
#cover {
  margin-top: 160px;
  background-color:rgba(255,255,255,1);
  width: calc(100% - 40px);
  margin-left: 20px;
  border-radius: 20px 20px 0px 0px;
  height: 390px;
}
#username,
#password {
  line-height: 20px;
  background-color: rgba(248, 248, 248, 100);
  // color: rgba(16, 16, 16, 100);
  font-size: 14px;
  text-align: left;
  border: 1px solid rgba(255, 255, 255, 100);
}
#components-form-demo-normal-login .login-form {
  max-width: 300px;
}
#components-form-demo-normal-login .login-form-forgot {
  float: right;
}
#components-form-demo-normal-login .checkbox-remember {
  float: left;
}
#components-form-demo-normal-login .login-form-button {
  width: 100%;
}
</style>
