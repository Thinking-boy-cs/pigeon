<!--
 * @Date: 2020-11-15 15:48:03
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-15 20:44:32
-->
<template>
  <div>
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
          <a-icon type="left"/>
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

        :model="formInline"
        @submit="handleSubmit"
        @submit.native.prevent
      >
        <a-form-model-item>
          <a-input v-model="formInline.user" placeholder="Username" allow-clear size="large">
            <a-icon slot="prefix" type="user" style="color:rgba(0,0,0,.25)" />
          </a-input>
        </a-form-model-item>
        <a-form-model-item>
          <a-input-password
            v-model="formInline.password"
            size="large"
            placeholder="Password"
          >
            <a-icon slot="prefix" type="lock" style="color:rgba(0,0,0,.25)" />
          </a-input-password>
        </a-form-model-item>
        <a-form-model-item>
          <a-input-password
            v-model="formInline.confirm"
            size="large"
            placeholder="Confirm your password"
          >
            <a-icon slot="prefix" type="check-circle" style="color:rgba(0,0,0,.25)" />
          </a-input-password>
        </a-form-model-item>
        <a-form-item>
          <a-radio :defaultChecked="false" v-model="formInline.agree">勾选表示同意<a href="#">《用户使用协议》</a></a-radio>
        </a-form-item>
        <a-form-model-item>
          <a-button
            id="register-button"
            type="primary"
            size="large"
            html-type="submit"
            :disabled="formInline.user === '' || formInline.password === '' || formInline.password !== formInline.confirm || formInline.agree !== true"
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
      formInline: {
        user: '',
        password: '',
        confirm: '',
        agree: false
      }
    }
  },
  methods: {
    handleSubmit (e) {
      console.log(this.formInline)
    }
  }
}
</script>

<style lang="less">
@import "~ant-design-vue/dist/antd.less";

* {
  margin: 0;
  padding: 0;
  text-decoration: none;
  color: @text-color;
}
#navigation-container {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 58px;
  line-height: 58px;
  box-shadow: 0px 1px 3px 1px rgba(0, 0, 0, 0.1);
}
#navigation-wrapper {
  position: relative;
  width: calc(100% - 40px);
  margin-left: 20px;
}
.icon-container {
  position: absolute;
  left: 0;
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
</style>
