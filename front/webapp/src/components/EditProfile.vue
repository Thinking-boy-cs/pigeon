<!--
 * @Date: 2020-11-20 15:40:11
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-20 16:39:08
-->
<template>
  <div>
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
          <a-icon type="left" @click="$router.go(-1)" />
        </div>
        <div class="page-title">
          修改个人资料
        </div>
      </div>
    </div>
    <div id="content-container">
      <div id="header-image-container"></div>
      <div id="content-wrapper">
        <div id="avatar-container">
          <div id="avatar"></div>
        </div>
        <a-form-model :model="form" :label-col="labelCol" :wrapper-col="wrapperCol">
          <a-form-model-item label="Activity name">
            <a-input v-model="form.name" />
          </a-form-model-item>
          <a-form-model-item label="Activity zone">
            <a-select
              v-model="form.region"
              placeholder="please select your zone"
            >
              <a-select-option value="shanghai">
                Zone one
              </a-select-option>
              <a-select-option value="beijing">
                Zone two
              </a-select-option>
            </a-select>
          </a-form-model-item>
          <a-form-model-item label="Activity time">
            <a-date-picker
              v-model="form.date1"
              show-time
              type="date"
              placeholder="Pick a date"
              style="width: 100%;"
            />
          </a-form-model-item>
          <a-form-model-item label="Instant delivery">
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
          </a-form-model-item>
          <a-form-model-item label="Resources">
            <a-radio-group v-model="form.resource">
              <a-radio value="1">
                Sponsor
              </a-radio>
              <a-radio value="2">
                Venue
              </a-radio>
            </a-radio-group>
          </a-form-model-item>
          <a-form-model-item label="Activity form">
            <a-input v-model="form.desc" type="textarea" />
          </a-form-model-item>
          <a-form-model-item :wrapper-col="{ span: 14, offset: 4 }">
            <a-button type="primary" @click="onSubmit">
              Create
            </a-button>
            <a-button style="margin-left: 10px;">
              Cancel
            </a-button>
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
      labelCol: { span: 8 },
      wrapperCol: { span: 16 },
      form: {
        name: '',
        region: undefined,
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
    }
  },
  mounted () {}
}
</script>

<style lang="less" scoped>
@import "../style/index.less";

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
#content-wrapper .ant-input {
  border: none;
  background-image: transparent;
}
</style>
