<template>
  <div>
    <div id="title-background"></div>
    <div id="profile-panel">
      <div id="avatar-container">
        <a-avatar id="avatar" :size="100" :src="iconUrl" />
      </div>
      <div id="userinfo">
        <a id="username">{{ userData.username }}</a
        ><br />
        <a id="signature">
          {{ userData.signature }}
        </a>
        <a-row id="userdetail">
          <a-col :span="12" class="detail-bar">
            <div class="detail-title">
              <a-icon
                type="smile"
                theme="twoTone"
                two-tone-color="#fb7299"
                id="smile"
              />
              &nbsp;<span>部门</span>
            </div>
            <div class="detail-content">
              {{ userData.dept ? userData.dept : "无" }}
            </div>
          </a-col>
          <a-col :span="12" class="detail-bar">
            <div class="detail-title">
              <a-icon
                type="idcard"
                theme="twoTone"
                two-tone-color="#fb7299"
                id="idcard"
              />&nbsp;
              <span>工号</span>
            </div>
            <div class="detail-content">{{ userData.id }}</div>
          </a-col>
        </a-row>
      </div>
    </div>
    <div id="usual">常用操作</div>
    <div id="operate-container">
      <a-row :gutter="[16, 16]">
        <a-col :span="12">
          <div id="profile" class="operate-item" @click="$router.push({path: '/EditProfile'})">
            <div id="title1">
              个人资料
              <a-icon type="user" id="title3" />
            </div>
            <div id="title2">修改个人信息</div>
          </div>
        </a-col>
        <a-col :span="12">
          <div id="record" class="operate-item">
            <div id="title1">
              打卡记录
              <a-icon type="carry-out" id="title3" />
            </div>
            <div id="title2">查看打卡考勤记录</div>
          </div>
        </a-col>
        <a-col :span="12">
          <div id="about" class="operate-item">
            <div id="title1">
              关于我们
              <a-icon type="team" id="title3" />
            </div>
            <div id="title2">了解设计团队</div>
          </div>
        </a-col>
        <a-col :span="12">
          <div id="settings" class="operate-item">
            <div id="title1">
              设置中心
              <a-icon type="setting" id="title3" />
            </div>
            <div id="title2">关于APP的设置</div>
          </div>
        </a-col>
      </a-row>
    </div>
    <div id="logout">
      <a-button type="danger" size="large" id="logout-button" @click="logout">
        退出登录
      </a-button>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      userData: null
    }
  },
  computed: {
    iconUrl () {
      var that = this
      console.log(this.userData.icon
        ? '/api/pigeon/photos/' + this.userData.icon
        : 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png')
      return this.userData.icon
        ? '/api/pigeon/photos/' + this.userData.icon
        : 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png'
    }
  },
  methods: {
    toPage (uri) {
      this.$router.push({ path: uri })
    },
    logout () {
      if (localStorage.getItem('user')) {
        localStorage.removeItem('user')
      }
      this.$router.push({ path: '/login' })
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
  }
}
</script>

<style lang="less" scoped>
// @import "~ant-design-vue/dist/antd.less";
@import "../style/index.less";
.page {
  width: 100%;
  position: relative;
  height: 100vh;
}
#title-background {
  position: absolute;
  background: url(../img/01.jpg) no-repeat fixed;
  background-size: 100% 100%;
  width: 100%;
  height: 220px;
  border-radius: 0px 0px 30px 30px;
}
#profile-panel {
  position: relative;
  // margin-top: 148px;
  padding-top: 148px;
  /* min-height: 180px; */
  width: calc(100% - 40px);
  margin-left: 20px;
}
#userinfo {
  position: relative;
  width: 100%;
  background-color: white;

  // height: 100px;
  /* margin-top: 25px; */
  /* margin-left: 15px; */
  padding: 15px;
  text-align: left;
  border-radius: 10px;
}
#username {
  color: @text-color;
  font-weight: bold;
  font-size: 18px;
}
#signature {
  color: #81848d;
  margin-top: 20px;
  font-size: 13px;
}
#userdetail {
  width: 100%;
  margin-top: 10px;
  font-weight: bold;
}
.detail-bar {
  // display: inline-block;
  text-align: center;
}
#avatar-container {
  position: absolute;
  width: 100%;
  height: 100px;
  bottom: 130px;
  right: 0;
  z-index: 999;
  text-align: right;
}
// #smile {
//   padding-left: 70px;
// }
// #idcard {
//   padding-left: 70px;
// }
#department {
  float: left;
  margin-left: 30px;
  text-align: center;
  position: absolute;
  width: 135px;
  margin-top: 10px;
}
#num {
  float: left;
  margin-left: 160px;
  text-align: center;
  position: absolute;
  width: 140px;
  margin-top: 10px;
}

#usual {
  position: relative;
  width: calc(100% - 40px);
  height: 40px;
  margin-left: 20px;
  line-height: 40px;
  font-size: 16px;
  text-align: left;
}
// #profile {
//   position: absolute;
//   margin-top: 370px;
//   background-color: white;
//   width: 165px;
//   height: 63px;
//   margin-left: 35px;
//   border-radius: 10px 10px 10px 10px;
// }
// #record {
//   position: absolute;
//   margin-top: 445px;
//   background-color: white;
//   width: 165px;
//   height: 63px;
//   margin-left: 35px;
//   border-radius: 10px 10px 10px 10px;
// }
// #about {
//   position: absolute;
//   margin-top: 445px;
//   background-color: white;
//   width: 165px;
//   height: 63px;
//   margin-left: 212px;
//   border-radius: 10px 10px 10px 10px;
// }
.detail-title {
  line-height: 30px;
  font-weight: bold;
  color: @text-color;
  font-size: 16px;
}
.detail-content {
  font-size: 14px;
  color: @text-color-secondary;
}
// #settings {
//   position: absolute;
//   margin-top: 370px;
//   background-color: white;
//   width: 165px;
//   height: 63px;
//   margin-left: 212px;
//   border-radius: 10px 10px 10px 10px;
// }
.operate-item {
  background: white;
  border-radius: 10px;
  padding: 10px;

  // margin-top: 10px;
}
#logout {
  // position: absolute;
  // margin-top: 550px;
  width: calc(100% - 40px);
  height: 50px;
  margin-left: 20px;
  margin-top: 20px;
  border-radius: 10px 10px 10px 10px;
}
#title1 {
  text-align: left;
  margin-left: 20px;
  font-weight: bold;
  font-size: 12px;
}
#title2 {
  text-align: left;
  margin-left: 20px;
  color: @text-color;
  font-size: 10px;
}
#title3 {
  font-size: 25px;
  margin-left: 20px;
}
#logout-button {
  // color: red;
  // margin-top: 15px;
  width: 100%;
  font-weight: bold;
}
#operate-container {
  width: calc(100% - 40px);
  margin-left: 20px;
  text-align: center;
}
</style>
