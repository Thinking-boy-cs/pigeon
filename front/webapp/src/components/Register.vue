<!--
 * @Date: 2020-11-15 15:48:03
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-22 04:14:48
-->
<template>
  <div>
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
          <a-icon type="left" @click="$router.go(-1)"/>
        </div>
      </div>
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
        :model="submitForm.user"
        @submit="handleSubmit"
        @submit.native.prevent
      >
        <a-form-model-item>
          <a-input
            v-model="submitForm.user.username"
            placeholder="Username"
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
          <a-input-password
            v-model="submitForm.user.password"
            size="large"
            placeholder="Password"
          >
            <a-icon
              slot="prefix"
              type="lock"
              style="color: rgba(0, 0, 0, 0.25)"
            />
          </a-input-password>
        </a-form-model-item>
        <a-form-model-item>
          <a-input-password
            v-model="submitForm.user.confirm"
            size="large"
            placeholder="Confirm your password"
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
                placeholder="请输入图中的验证码"
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
              submitForm.user.user === '' ||
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
    return {
      submitForm: {
        user: {
          id: new Date().getTime().toString(),
          username: '',
          password: '',
          confirm: '',
          agree: false
        },
        code: ''
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
        .then(res => {
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
        .catch(err => {
          that.$message.error('注册失败: ' + err)
          // return ''
        })
    },
    changeImage () {
      var that = this
      this.$axios
        .get('/api/pigeon/user/getImage?time=0.1')
        .then(res => {
          console.log(res)
          that.imageData = res.data
        })
        .catch(err => {
          that.$message.error('获取验证码失败:' + err)
          // return ''
        })
    }
  },
  created () {
    var that = this
    this.$axios
      .get('/api/pigeon/user/getImage?time=0.1')
      .then(res => {
        console.log(res.data)
        that.imageData = res.data
      })
      .catch(err => {
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
</style>
