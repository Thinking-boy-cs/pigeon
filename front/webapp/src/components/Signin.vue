<template>
  <div>
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
          <a-icon type="left" @click="$router.go(-1)" />
        </div>
        <div class="page-title">签到</div>
      </div>
    </div>
    <div id="content-container">
      <div id="information-bar">
        <div id="avatar"><a-avatar :size="64" :src="iconUrl" /></div>
        <div id="userinfo">
          <a id="username">{{ userData.username }}</a>
          <div id="apartment">{{ userData.dept ? userData.dept : "无" }}</div>
        </div>
        <div id="leave">
          <a-icon type="audit" style="font-size: 24px" />
          <div style="font-weight: bold" @click="goLeave()">请假</div>
        </div>
      </div>
      <div id="main-container">
        <div id="title">{{ activity ? activity.name : "" }}</div>
        <a-tabs default-active-key="1" :size="size">
    <a-tab-pane key="1">
      <span slot="tab">
        <a-icon type="environment" />
        {{(isLeft)? '已请假': '签到打卡'}}
      </span>
              <div>
        <div
          id="sign-button"
          :class="{ signed: signed, unsign: !signed }"
          @click="signin"
        >
          <div id="sign-title" v-if="!loading">{{(isLeft)?'已清假':'打卡'}}</div>
          <div id="sign-title" v-else><a-icon type="loading" /></div>
        </div>
        <div id="sign-map">
          <a-icon type="environment" id="environment" theme="filled" />
          <a id="text" @click="$router.push({ path: '/ViewMap' })"
            >查看签到范围</a
          >
        </div>
        </div>
    </a-tab-pane>
    <a-tab-pane key="2">
      <span slot="tab">
        <a-icon type="camera" />
        拍照打卡
      </span>
        <div
          id="sign-button"
          :class="{ signed: signed, unsign: !signed }"
          @click="signin"
        >
          <div v-if="!loading"><a-icon id="sign-title1" type="camera" :style="{ fontSize: '100px'}" /></div>
          <div id="sign-title" v-else><a-icon type="loading" /></div>
        </div>
    </a-tab-pane>
  </a-tabs>

      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      userData: null,
      activity: null,
      signed: false,
      loading: false,
      text: '打卡',
      size: 'large',
      isLeft: false
    }
  },
  computed: {
    iconUrl () {
      var that = this
      console.log(
        this.userData.icon
          ? '/api/pigeon/pthotos/' + this.userData.icon
          : 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png'
      )
      return this.userData.icon
        ? '/api/pigeon/pthotos/' + this.userData.icon
        : 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png'
    }
  },
  methods: {
    goLeave () {
      setTimeout(() => {
        this.isLeft = true
        this.signed = true
      }, 1000);
      this.$router.push({ path: `/LeaveApplication?id=${this.$route.params.id}` })
    },
    signin () {
      const that = this

      this.$axios
        .get('/api/pigeon/application/sign?activityId=' + this.$route.params.id)
        .then((res) => {
          console.log(res)
          if (res.data && res.data.status === 0) {
            setTimeout(() => {
              that.signed = true
              that.text = '已打卡'
            }, 800)
          }
        })
    },
    getStatus () {
      const that = this
      this.loading = true
      this.$axios
        .get(
          '/api/pigeon/application/getStatus?activityId=' +
            that.$route.params.id
        )
        .then((res) => {
          console.log('???', res)
          that.signed = res.data ? res.data.data === 1 : false
          that.text = that.signed ? '已打卡' : '打卡'
          that.loading = false
        })
        .catch((res) => {
          that.$message.error('获取失败，请检查您的网络连接')
          that.loading = false
        })
    }
  },
  created () {
    const that = this
    this.userData = window.localStorage.getItem('user')

    console.log('???', this.userData)
    if (this.userData) {
      this.userData = JSON.parse(this.userData)
    } else {
      this.$router.push({ path: '/login' })
    }
    this.$axios
      .get('/api/pigeon/application/getById?id=' + this.$route.params.id)
      .then((res) => {
        console.log('???', res)
        that.activity = res.data ? res.data.data : null
        // if (!that.activity) that.$message.error('获取失败')
      })
      .catch((res) => {
        that.$message.error('获取失败，请检查您的网络连接')
      })
    this.getStatus()
    this.$nextTick(()=>{
      if(window.location.href.indexOf('leave=1') >= 0) {
        this.signed = true
        this.isLeft = true
      }
    })
    
  }
}
</script>

<style lang="less" scoped>
@import "~ant-design-vue/dist/antd.less";
* {
  margin: 0;
  padding: 0;
  text-decoration: none;
  color: @text-color;
}
.icon-container {
  position: absolute;
  left: 0;
}
.page-title {
  font-size: 20px;
  font-weight: bold;
}
#title {
  height: 60px;
  line-height: 60px;
  font-size: 16px;
  font-weight: bold;
}
#content-container {
  position: absolute;
  width: 100%;
  top: 70px;
}
#information-bar {
  position: relative;
  background-color: white;
  margin-left: 15px;
  width: calc(100% - 30px);
  height: 100px;
  border-radius: 20px 20px 20px 20px;
  display: flex;
}
#avatar {
  margin-left: 20px;
  margin-top: 10px;
}
#userinfo {
  margin-left: 10px;
  margin-top: 20px;
  text-align: left;
}
#username {
  font-weight: bold;
  color: black;
}
#apartment {
  margin-top: 5px;
}
#leave {
  position: relative;
  padding-left: 95px;
  margin: 0 auto;
  align-self: end;
  bottom: 30px;
  top: 20px;
}
#main-container {
  position: relative;
  background-color: white;
  margin-left: 15px;
  width: calc(100% - 30px);
  height: 70vh;
  border-radius: 20px 20px 20px 20px;
  top: 20px;
  display: flex;
  flex-direction: column;
}
.unsign {
  background-color: #3291f8;
}
.signed {
  background-color: @success-color;
}
#sign-button {
  position: relative;
  width: 200px;
  height: 200px;
  border-radius: 50%;
  box-shadow: 0px 2px 15px 6px rgba(0, 0, 0, 0.1);
  margin: 0 auto;
  margin-top: 20%;
  align-self: center;
  display: flex;
}
#sign-title {
    font-size: 32px;
    font-weight: bold;
    color: white;
    text-align: center;
    width: 100%;
    /* padding-left: 70px; */
    /* top: 70px; */
    line-height: 200px;
    position: relative;
}
#sign-title1 {
  font-size: 25px;
  font-weight: bold;
  color: white;
  align-self: center;
  padding-left: 50px;
  padding-top: 45px;
}
#sign-map {
  padding-top: 20px;
}
#environment {
  font-size: 20px;
  color: #3291f8;
}
#text {
  font-size: 16px;
  color: #3291f8;
  font-weight: bold;
}
</style>
