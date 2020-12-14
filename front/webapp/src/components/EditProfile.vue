<!--
 * @Date: 2020-11-20 15:40:11
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-20 16:39:08
-->
<template>
  <div id="page-container">
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
          <a-icon type="left" @click="$router.go(-1)" />
        </div>
        <div class="page-title">修改个人资料</div>
      </div>
    </div>
    <div id="content-container">
      <div id="header-image-container"></div>
      <div id="content-wrapper">
        <div id="avatar-container">
          <div id="avatar"></div>
        </div>
        <a-form-model
          :model="form"
          :label-col="labelCol"
          :wrapper-col="wrapperCol"
        >
          <a-form-model-item label="用户名">
            <a-input v-model="userData.username" />
          </a-form-model-item>
          <a-form-model-item label="部门">
            <a-select v-model="form.dept" placeholder="please select your zone">
              <a-select-option value="shanghai"> 上海 </a-select-option>
              <a-select-option value="beijing"> 北京 </a-select-option>
            </a-select>
          </a-form-model-item>
          <a-form-model-item label="性别">
            <a-radio-group v-model="userData.sex">
              <a-radio value="1"> 男 </a-radio>
              <a-radio value="2"> 女 </a-radio>
            </a-radio-group>
          </a-form-model-item>
          <a-form-model-item label="家乡">
            <a-select
              v-model="form.hometown"
              placeholder="please select your zone"
            >
              <a-select-option value="shanghai"> 上海 </a-select-option>
              <a-select-option value="beijing"> 北京 </a-select-option>
            </a-select>
          </a-form-model-item>
          <a-form-model-item label="生日">
            <a-date-picker
              v-model="form.date1"
              type="date"
              placeholder="请选择日期"
              style="width: 100%"
            />
          </a-form-model-item>
        <a-form-model-item label="邮箱">
          <a-auto-complete
            @search="handleSearch"
            v-model="form.email"
          >
            <template slot="dataSource">
              <a-select-option v-for="email in result" :key="email">
                {{ email }}
              </a-select-option>
            </template>
          </a-auto-complete>
        </a-form-model-item>
          <!-- <a-form-model-item label="Instant delivery">
            <a-switch v-model="form.delivery" />
          </a-form-model-item>
          <a-form-model-item label="Activity type">
            <a-checkbox-group v-model="form.type">
              <a-checkbox value="1" name="type">
                Online
              </a-checkbox>
              <a-checkbox value="2" name="type">
                Promotion
              </a-checkbox>
              <a-checkbox value="3" name="type">
                Offline
              </a-checkbox>
            </a-checkbox-group>
          </a-form-model-item> -->

          <a-form-model-item label="个性签名">
            <a-input v-model="form.desc" type="textarea" />
          </a-form-model-item>
          <a-form-model-item :wrapper-col="{ span: 12, offset: 6 }">
            <a-button type="primary" @click="onSubmit"> Create </a-button>
            <a-button style="margin-left: 10px"> Cancel </a-button>
          </a-form-model-item>
        </a-form-model>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      result: [],
      labelCol: { span: 5, offset: 2 },
      wrapperCol: { span: 16 },
      form: {
        username: '',
        dept: '后勤部',
        hometown: '重庆',
        email: '123@qq.com',
        date1: undefined,
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      }
    }
  },
  methods: {
    onSubmit () {
      console.log('submit!', this.form)
    },
    handleSearch (value) {
      let result
      if (!value || value.indexOf('@') >= 0) {
        result = []
      } else {
        result = ['gmail.com', '163.com', 'qq.com'].map(domain => `${value}@${domain}`)
      }
      this.result = result
    }
  },
  created () {
    this.userData = window.localStorage.getItem('user')

    console.log(this.userData)
    if (this.userData) {
      this.userData = JSON.parse(this.userData)
    } else {
      this.$router.push({ path: '/login' })
    }
  },
  mounted () {}
}
</script>

<style lang="less" scoped>
@import "../style/index.less";

#page-container {
  background-color: white;
  height: 100vh;
}
#content-container {
  position: absolute;
  width: 100%;
  top: 68px;
}
#content-wrapper {
  position: relative;
  width: calc(100% - 40px);
  margin-left: 20px;
}
#content-wrapper .ant-form-item {
  display: flex;
  flex-direction: row;
  align-items: center;
}
// #content-wrapper .ant-input {
//   border: none;
//   background-image: transparent;
// }
</style>
