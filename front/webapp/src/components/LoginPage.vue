<template>
  <div id="header-container">
    <div id="header-title">
      <p id="welcome">
        欢迎使用Pigeon<br />
        <a class="welcome1">更&nbsp;&nbsp;懂&nbsp;&nbsp;大&nbsp;&nbsp;学&nbsp;&nbsp;生</a><br /><br /><br />
      </p>
    </div>
    <div id="test">
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
      <a href="">
        现在就注册!
      </a>
    </a-form-item>
  </a-form>
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
    onChange (e) {
      console.log(e)
    }
  }
}
</script>

<style type="text/css">
body{
  background-color: tomato;
}
#welcome {
  margin-top: 80px;
  color: white;
  font-size: 29px;
  text-align: center;
  font-family: PingFangSC-Regular;
  font-weight: bold;
}
.welcome1 {
  font-size: 18px;
  color: white;
  font-weight: normal;
}
#login {
  padding-top: 50px;
  color: rgba(16, 16, 16, 100);
  font-size: 20px;
  text-align: left;
  font-family: PingFangSC-Regular;
  font-weight: bold;
}
#header-mid {
  margin-left: 45px;
  width: calc(100% - 90px);
}
#test {
  margin-top: 65px;
  background-color: white;
  width: calc(100% - 40px);
  margin-left: 20px;
  height: 600px;
  border-radius: 20px 20px 0px 0px;
}
#username,
#password {
  line-height: 20px;
  background-color: rgba(248, 248, 248, 100);
  color: rgba(16, 16, 16, 100);
  font-size: 14px;
  text-align: left;
  font-family: PingFangSC-Regular;
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
