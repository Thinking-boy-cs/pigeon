<template>
  <div id="header-background">
    <div id="header-container">
      <div id="header-title">
        <p id="welcome">Pigeon</p>
        <p id="welcome1">坚持每天打卡，拒绝下次一定</p>
        <!-- <a-icon :style="{ fontSize: '120px', color: 'white' }" type="yuque" /> -->
        <img src="../img/APP_LOGO1.png" style="width: 35%">
      </div>
    </div>
    <div id="mask">

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
            <a-input
              size="large"
              id="username"
              allow-clear
              @change="onChange"
              v-model="form.telNumber"
              placeholder="请输入手机号码"
            >
              <a-icon
                slot="prefix"
                type="user"
                style="color: rgba(0, 0, 0, 0.25)"
              />
            </a-input>
          </a-form-item>
          <a-form-item>
            <a-input-password
              size="large"
              id="password"
              v-model="form.password"
              type="password"
              placeholder="请输入密码"
            >
              <a-icon
                slot="prefix"
                type="lock"
                style="color: rgba(0, 0, 0, 0.25)"
              />
            </a-input-password>
          </a-form-item>

          <a-form-item>
            <a-checkbox class="checkbox-remember"> 记住我 </a-checkbox>
            <a class="login-form-forgot" href=""> 忘记密码 </a>
            <a-button
              size="large"
              type="primary"
              html-type="submit"
              class="login-form-button"
            >
              登 录
            </a-button>
            或者
            <a @click="gotoregister"> 现在就注册! </a>
          </a-form-item>
        </a-form>
      </div>
    </div>
  </div>
</template>

<script>
const key = 'updatable'
export default {
  data () {
    return {
      form: {
        id: '',
        password: '',
        wsUrl: 'ws://127.0.0.1:5000/api/pigeon/ws',
        loadingWS: this.$message.loading({ content: '登录成功，跳转中', duration: 0, key })
      }
    }
  },
  methods: {
    onOpen: function () {
      console.log('Opened')
    },
    onMessage: function (e) {
      console.log('GetMessage: ', e)
    },
    onError: function (e) {
      console.log('Error da☆ze', e)
    },
    onClose: function (e) {
      console.log('Closed')
    },
    sendMessage: function (msg) {
      this.$store.state.ws.send(msg)
    },
    initWS () {
      var that = this
      this.$store.dispatch('openWebSocketFunction', {
        url: that.wsUrl,
        onOpenHandler: that.onOpen,
        onCloseHandler: that.onClose,
        onErrorHandler: that.onError,
        onMessageHandler: that.onMessage
      })
    },
    handleSubmit (e) {
      var that = this
      e.preventDefault()
      console.log(this.form)
      // this.form.validateFields((err, values) => {
      //   if (!err) {
      //     console.log('Received values of form: ', values)
      //   }
      // })
      this.$axios.post('/api/pigeon/user/login', this.form).then((res) => {
        console.log(res)
        if (res.data && res.data.status === 0) {
          window.localStorage.setItem('user', JSON.stringify(res.data.data))
          const msg = this.$message.loading({ content: '登录成功，跳转中', duration: 0, key })
          that.initWS().then(() => {
            setTimeout(msg, 100)
            that.$router.push({ path: '/' })
          })

          // setTimeout(() => {
          //   // this.$message.success({ content: '跳转成功', key, duration: 2 })
          // }, 1000)
        } else {
          this.$message.error('登录失败，请检查账号和密码')
        }
      })
    },
    gotoregister () {
      this.$router.push({ path: '/register' })
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
@keyframes gradientBG {
  0% {
    background-position: 0% 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0% 50%;
  }
}

#header-background {
  // background: url(../img/05.jpg) no-repeat fixed;
  background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
  animation: gradientBG 7s ease infinite;
  // background-size: 100% 100%;
  background-size: 400% 400%;
  width: 100%;
  height: 100%;
  position: relative;
  box-sizing: border-box;
  z-index: 1;
}
#header-background:after {
  // background: url(../img/gezi.png) no-repeat fixed;
  content: "";
  width: 100%;
  height: 100%;
  position: absolute;
  left: 0;
  top: 0;
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
  margin-bottom: 50px;
  text-align: center  ;
}
* {
  margin: 0;
  padding: 0;
  text-decoration: none;
  font-family: PingFang SC;
}
#welcome {
  padding-top: 65px;
  font-size: 30px;
  text-align: center;
  font-weight: bold;
  color: white;
  margin-bottom:0.1em;
}
#welcome1 {
  font-size: 16px;
  text-align: center;
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
  background-color: rgba(255, 255, 255, 1);
  width: calc(100% - 60px);
  margin-left: 30px;
  border-radius: 20px 20px 0px 0px;
  height: 390px;
  bottom: 0;
  position: absolute;
  z-index: 99;
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
#mask {
  position: absolute;
  top: 0;
  background: url(../img/dot.gif);
  width: 100%;
  height: 100%;
  z-index: 90;
}
</style>
