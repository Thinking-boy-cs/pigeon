<!--
 * @Date: 2020-11-15 15:48:03
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-22 04:14:48
-->
<template>
  <div id="header-background">
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
          <a-icon type="left" @click="$router.go(-1)" />
        </div>
      </div>

    </div>
    <div id="mask">

    </div>
    <div id="header-container">
      <div id="header-wrapper">
        <div class="header-title">注册</div>
        <div class="header-second-title">
          注册之后可以立即绑定公司帐号，也可以之后再绑定~
        </div>
      </div>
    </div>

    <div id="form-container">
      <a-form-model
        ref="ruleForm"
        :model="submitForm.user"
        :rules="rules"
        @submit="handleSubmit"
        @submit.native.prevent
      >
        <a-form-model-item>
          <a-input
            v-model="submitForm.user.username"
            placeholder="用户名"
            allow-clear
            size="large"
          >
            <a-icon
              slot="prefix"
              type="user"
              style="color: rgba(0, 0, 0, 0.25)"
            />
          </a-input>
        </a-form-model-item>
        <a-form-model-item>
          <a-input
            v-model="submitForm.user.telNumber"
            placeholder="手机号"
            allow-clear
            size="large"
          >
            <a-icon
              slot="prefix"
              type="phone"
              style="color: rgba(0, 0, 0, 0.25)"
            />
          </a-input>
        </a-form-model-item>
        <a-form-model-item has-feedback prop="password">
          <a-input-password
            v-model="submitForm.user.password"
            size="large"
            placeholder="密码"
          >
            <a-icon
              slot="prefix"
              type="lock"
              style="color: rgba(0, 0, 0, 0.25)"
            />
          </a-input-password>
        </a-form-model-item>
        <a-form-model-item has-feedback prop="confirm">
          <a-input-password
            v-model="submitForm.user.confirm"
            size="large"
            placeholder="请再输入一次密码"
          >
            <a-icon
              slot="prefix"
              type="check-circle"
              style="color: rgba(0, 0, 0, 0.25)"
            />
          </a-input-password>
        </a-form-model-item>
        <a-form-model-item>
          <a-row :gutter="20">
            <a-col :span="12"
              ><a-input
                size="large"
                allow-clear
                placeholder="请输入验证码"
                v-model="submitForm.code"
              ></a-input
            ></a-col>
            <a-col :span="12"
              ><img
                :src="imageData"
                id="verifyimage"
                @click="changeImage"
                alt="???"
            /></a-col>
          </a-row>
        </a-form-model-item>

        <a-form-model-item>
          <a-radio :defaultChecked="false" v-model="submitForm.user.agree"
            >勾选表示同意<a href="#">《用户使用协议》</a></a-radio
          >
        </a-form-model-item>
        <a-form-model-item>
          <a-button
            id="register-button"
            type="primary"
            size="large"
            html-type="submit"
            :disabled="
              submitForm.user.username === '' ||
              submitForm.user.password === '' ||
              submitForm.user.password !== submitForm.user.confirm ||
              submitForm.user.agree !== true
            "
          >
            注册
          </a-button>
        </a-form-model-item>
      </a-form-model>
    </div>
        
  </div>
</template>

<script>
export default {
  data () {
    let validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('密码不能为空'))
      } else {
        if (this.submitForm.user.confirm !== '') {
          this.$refs.ruleForm.validateField('confirm')
        }
        callback()
      }
    }
    let validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再输入一次密码'))
      } else if (value !== this.submitForm.user.password) {
        callback(new Error('两次输入不一致！'))
      } else {
        callback()
      }
    }
    return {
      submitForm: {
        user: {
          id: new Date().getTime().toString(),
          username: '',
          telNumber: '',
          password: '',
          confirm: '',
          agree: false
        },
        code: ''
      },
      rules: {
        password: [{ validator: validatePass, trigger: 'blur' }],
        confirm: [{ validator: validatePass2, trigger: 'blur' }]
      },
      imageData: ''
    }
  },
  methods: {
    handleSubmit (e) {
      var that = this
      console.log(this.submitForm)
      this.submitForm.data = this.submitForm.user
      // let postData = new FormData()
      // postData.append('code', this.submitForm.code)
      // postData.append('user', this.submitForm.user)
      this.$axios
        .post('/api/pigeon/user/register1', that.submitForm)
        .then((res) => {
          console.log(res.data)
          if (res.data) {
            if (res.data.status === 0) {
              that.$message.loading('注册成功！跳转中')
              that.$router.push({ path: '/login' })
            } else {
              that.$message.error('注册失败: ' + res.data.msg)
            }
          }
        })
        .catch((err) => {
          that.$message.error('注册失败: ' + err)
          // return ''
        })
    },
    changeImage () {
      var that = this
      this.$axios
        .get('/api/pigeon/user/getImage?time=0.1')
        .then((res) => {
          console.log(res)
          that.imageData = res.data
        })
        .catch((err) => {
          that.$message.error('获取验证码失败:' + err)
          // return ''
        })
    }
  },
  created () {
    var that = this
    this.$axios
      .get('/api/pigeon/user/getImage?time=0.1')
      .then((res) => {
        console.log(res.data)
        that.imageData = res.data
      })
      .catch((err) => {
        that.$message.error('获取验证码失败:' + err)
        // return ''
      })
  }
}
</script>

<style lang="less">
@import "../style/index.less";

* {
  margin: 0;
  padding: 0;
  text-decoration: none;
  color: @text-color;
}

#header-container {
  position: relative;
  text-align: left;
  /* height: calc(100vh - 40px); */
  padding-top: 100px;
  z-index: 4;
}
#header-wrapper {
  width: calc(100% - 90px);
  margin-left: 45px;
}
.header-title {
  font-size: 37px;
  font-weight: bolder;
  color: @text-color;
}
.header-second-title {
  font-size: 18px;
  color: @text-color-secondary;
}
#form-container {
  position: relative;
  width: calc(100% - 90px);
  margin-top: 40px;
  margin-left: 45px;
  z-index: 4;
}
#register-button {
  width: 100%;
}
#verifycode {
  display: inline-block;
  width: 70%;
}
#verifyimage {
  display: inline-block;
  width: 100%;
}
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
  background: linear-gradient(-45deg,#1904E5 10%, #FAB2FF,#F6D242, #FF52E5);
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
#navigation-container {
  z-index: 999;
  box-shadow: none;
  background-color: transparent;
}
#mask {
  position: absolute;
  top: 0;
  background: url(../img/dot.gif);
  width: 100%;
  height: 100%;
  z-index: 3;
}
</style>
