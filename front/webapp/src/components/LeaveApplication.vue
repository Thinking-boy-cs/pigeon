<template>
  <div>
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
          <a-icon type="left" @click="$router.go(-1)" />
        </div>
        <div class="page-title">我要请假</div>
      </div>
    </div>
    <div id="type">
      <a id="text"><span style="color: red">*</span>请假类型</a>
      <a-select
        v-model="form.selectType"
        id="type-select"
        style="width: 120px"
        @change="handleChange"
      >
        <a-icon slot="suffixIcon" type="right" />
        <a-select-option value="type1"> 事假 </a-select-option>
        <a-select-option value="type2"> 病假 </a-select-option>
        <a-select-option value="type3"> 其它 </a-select-option>
      </a-select>
    </div>
    <div id="start-time">
      <a id="text"><span style="color: red">*</span>开始时间</a>
      <a-date-picker
        v-model="form.startTime"
        id="startTime"
        v-decorator="['date-time-picker', config]"
        show-time
        format="YYYY-MM-DD HH:mm:ss"
        @change="handleStart"
      />
    </div>
    <div id="end-time">
      <a id="text"><span style="color: red">*</span>结束时间</a>
      <a-date-picker
        v-model="form.endTime"
        id="endTime"
        v-decorator="['date-time-picker', config]"
        show-time
        format="YYYY-MM-DD HH:mm:ss"
        @change="handleEnd"
      />
    </div>
    <div id="cause">
      <a id="text"><span style="color: red">*</span>请假理由</a>
      <a-textarea
        class="causetext"
        placeholder="请输入请假理由"
        v-model="form.cause"
        allow-clear
        @change="onChange"
        :auto-size="{ minRows: 3, maxRows: 5 }"
      />
    </div>
    <div id="appendix">
      <a id="text">添加附件</a>
      <a-upload
        action="https://www.mocky.io/v2/5cc8019d300000980a055e76"
        :multiple="true"
        :file-list="fileList"
        @change="handleappendix"
      >
        <a-button> <a-icon type="upload" /> Upload </a-button>
      </a-upload>
    </div>
    <div id="sendto">
      <a id="text">抄送人</a>
      <a-select
        v-model="form.selectSender"
        id="sender-select"
        style="width: 120px"
        @change="handleChange"
      >
        <a-icon slot="suffixIcon" type="right" />
        <a-select-option value="sender1"> 管理员1 </a-select-option>
        <a-select-option value="sender2"> 管理员2 </a-select-option>
        <a-select-option value="sender3"> 管理员3 </a-select-option>
      </a-select>
    </div>
    <a-button id="submit" type="primary" block> 提交 </a-button>
  </div>
</template>

<script>
export default {
  data () {
    return {
      form: {
        selectType: '',
        startTime: '',
        endTime: '',
        selectSender: '',
        cause: ''
      },
      fileList: [
        {
          uid: '-1',
          name: 'xxx.png',
          status: 'done',
          url: 'http://www.baidu.com/xxx.png'
        }
      ]
    }
  },
  methods: {
    handleChange (value) {
      console.log(`selected ${value}`)
    },
    handleStart (value, dateString) {
      console.log('Selected Time: ', value)
      console.log('Formatted Selected Time: ', dateString)
    },
    handleEnd (value) {
      console.log(`selected ${value}`)
    },
    onChange (e) {
      console.log(e)
    },
    handleappendix (info) {
      let fileList = [...info.fileList]

      // 1. Limit the number of uploaded files
      //    Only to show two recent uploaded files, and old ones will be replaced by the new
      fileList = fileList.slice(-2)

      // 2. read from response and show file link
      fileList = fileList.map((file) => {
        if (file.response) {
          // Component will show file.url as link
          file.url = file.response.url
        }
        return file
      })

      this.fileList = fileList
    }
  }
}
</script>

<style lang="less" scoped>
@import "../style/index.less";
.page-title {
  font-size: 20px;
  font-weight: bold;
}
#type {
  background: white;
  height: 45px;
  width: 100%;
  margin-top: 82px;
  position: absolute;
  box-shadow: 0px 1px 0px 1px rgba(0, 0, 0, 0.1);
  text-align: left;
  padding-left: 15px;
  padding-top: 8px;
}
#text {
  color: black;
  font-size: 16px;
}
#type-select {
  float: right;
  margin-right: 10px;
}
.page > div:not(id=navigation-container) {
  margin-top: 10px;
  margin-bottom: 10px;
}
#sender-select {
  float: right;
  margin-right: 10px;
}
#start-time {
  background: white;
  height: 45px;
  width: 100%;
  margin-top: 128px;
  position: absolute;
  box-shadow: 0px 1px 0px 1px rgba(0, 0, 0, 0.1);
  text-align: left;
  padding-left: 15px;
  padding-top: 8px;
}
#end-time {
  background: white;
  height: 45px;
  width: 100%;
  margin-top: 174px;
  position: absolute;
  box-shadow: 0px 1px 0px 1px rgba(0, 0, 0, 0.1);
  text-align: left;
  padding-left: 15px;
  padding-top: 8px;
}
#startTime {
  float: right;
  margin-right: 10px;
}
#endTime {
  float: right;
  margin-right: 10px;
}
#cause {
  background: white;
  height: 120px;
  width: 100%;
  margin-top: 220px;
  position: absolute;
  box-shadow: 0px 1px 0px 1px rgba(0, 0, 0, 0.1);
  text-align: left;
  padding-left: 15px;
  padding-top: 8px;
}
.causetext {
  float: right;
  margin-right: 4px;
  margin-top: 10px;
}
#appendix {
  background: white;
  height: 120px;
  width: 100%;
  margin-top: 341px;
  position: absolute;
  box-shadow: 0px 1px 0px 1px rgba(0, 0, 0, 0.1);
  text-align: left;
  padding-left: 15px;
  padding-top: 8px;
}
#sendto {
  background: white;
  height: 45px;
  width: 100%;
  margin-top: 462px;
  position: absolute;
  box-shadow: 0px 1px 0px 1px rgba(0, 0, 0, 0.1);
  text-align: left;
  padding-left: 15px;
  padding-top: 8px;
}
#submit {
  height: 45px;
  margin-top: 554px;
}
</style>
