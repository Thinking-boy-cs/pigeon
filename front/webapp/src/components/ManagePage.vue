<template>
  <div id="page-container">
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container"><a-icon type="left" @click="$router.go(-1)" style="color: black"/></div>
        <div class="page-title">管理</div>
      </div>
    </div>
    <div id="content-container">
      <a-tabs default-active-key="1">
        <a-tab-pane key="1">
          <span slot="tab">
            <a-icon type="container" />
            发布签到
          </span>
          <div id="content-wrapper">
            <a-form-model
              ref="ruleForm"
              :model="form"
              :rules="rules"
              :label-col="labelCol"
              :wrapper-col="wrapperCol"
            >
              <a-form-model-item ref="name" label="签到事件名称" prop="name">
                <a-input
                  v-model="form.name"
                  @blur="
                    () => {
                      $refs.name.onFieldBlur();
                    }
                  "
                />
              </a-form-model-item>
              <a-form-model-item label="签到对象" prop="participants">
                <a-cascader
                  :options="groups"
                  change-on-select
                  v-model="form.participants"
                />
              </a-form-model-item>
              <a-form-model-item label="签到开始时间" required prop="startTime">
                <a-date-picker
                  v-model="form.startTime"
                  show-time
                  type="date"
                  format="YYYY-MM-DD HH:mm:ss"
                  placeholder="选择日期时间"
                  style="width: 100%"
                />
              </a-form-model-item>
              <a-form-model-item label="签到结束时间" required prop="endTime">
                <a-date-picker
                  v-model="form.endTime"
                  show-time
                  type="date"
                  placeholder="Pick a date"
                  format="YYYY-MM-DD HH:mm:ss"
                  style="width: 100%"
                />
              </a-form-model-item>
              <!-- <a-form-model-item label="请选择持续时间" required prop="during">
                <a-time-picker
                  v-model="form.during"
                  :default-open-value="moment('00:00:00', 'HH:mm:ss')"
                />
              </a-form-model-item> -->
              <a-form-model-item :wrapper-col="{ span: 12, offset: 6 }">
                <a-button type="primary" @click="onSubmit"> Create </a-button>
                <a-button style="margin-left: 25px" @click="resetForm">
                  Reset
                </a-button>
              </a-form-model-item>
            </a-form-model>
          </div>
        </a-tab-pane>
        <a-tab-pane key="2">
          <span slot="tab">
            <a-icon type="edit" />
            审批请假
          </span>
          Tab 2
        </a-tab-pane>
      </a-tabs>
    </div>
  </div>
</template>

<script>
// import moment from 'moment'
export default {
  data () {
    return {
      options: [
        {
          value: 'zhejiang',
          label: 'Zhejiang',
          children: [
            {
              value: 'hangzhou',
              label: 'Hangzhou',
              children: [
                {
                  value: 'xihu',
                  label: 'West Lake'
                }
              ]
            }
          ]
        },
        {
          value: 'jiangsu',
          label: 'Jiangsu',
          children: [
            {
              value: 'nanjing',
              label: 'Nanjing',
              children: [
                {
                  value: 'zhonghuamen',
                  label: 'Zhong Hua Men'
                }
              ]
            }
          ]
        }
      ],
      labelCol: { span: 8 },
      wrapperCol: { span: 16 },
      other: '',
      form: {
        name: '',
        participants: null,
        startTime: null,
        endTime: null,
        status: null,
        submitTime: null
      },
      rules: {
        name: [
          {
            required: true,
            message: '请输入签到事件名称',
            trigger: 'blur'
          },
          {
            min: 3,
            max: 5,
            message: 'Length should be 3 to 5',
            trigger: 'blur'
          }
        ],
        target: [
          {
            required: true,
            message: '请选择签到对象',
            trigger: 'change'
          }
        ],
        date: [
          { required: true, message: '请选择一个时间', trigger: 'change' }
        ]
      },
      groups: []
    }
  },
  methods: {
    onSubmit () {
      const that = this
      this.$refs.ruleForm.validate((valid) => {
        if (valid) {
          this.form.startTime = this.form.startTime.format('YYYY-MM-DD HH:mm:ss')
          this.form.endTime = this.form.endTime.format('YYYY-MM-DD HH:mm:ss')
          console.log('submit!', this.form)
          this.$axios.get('/api/pigeon/group/findUserIdsByGroupId?groupId=' + this.form.participants).then((res) => {
            console.log('user data', res)
          })
          // submit
          this.$axios.post('/api/pigeon/record/initiate', this.form).then((res) => {
            console.log('Submitted!')
            if (res.data && res.data.status === 0) {
              that.$message.success('提交签到成功！')
            } else {
              that.$message.error('提交签到失败！' + res.data.msg)
            }
          }).catch((res) => {
            that.$message.error('提交签到失败，请检查网络连接')
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm () {
      this.$refs.ruleForm.resetFields()
    }
  },
  created () {
    const that = this
    this.$axios.get('/api/pigeon/group/findAllGroup').then((res) => {
      console.log(res)
      if (res.data && res.data.status === 0) {
        that.groups = res.data.data
        that.groups.forEach((item, i) => {
          item.value = item.id
          item.label = item.groupName
        })
      }
    })
  }
}
</script>

<style lang="less" scoped>
@import "../style/index.less";

#page-container {
  background-color: white;
  height: 100vh;
}
#first-container {
  position: relative;
  width: 120vw;
  left: 15px;
  top: 30px;
  height: 75vh;
}
#content-container {
  background-color: white;
  position: absolute;
  width: 100%;
  top: 59px;
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
</style>
