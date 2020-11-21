<template>
  <div>
    <div id="title-background"></div>
    <div id="profile-panel">
      <div id="userinfo">
        <a id="username">老张</a><br />
        <a id="signature">
          个性签名：志向但是是记忆的奴隶，生气勃勃地降生，但却很难成长。
        </a>
        <div id="userdetail">
          <a-icon
            type="smile"
            theme="twoTone"
            two-tone-color="#fb7299"
            :style="{ fontSize: '25px' }"
            id="smile"
          />
          部门
          <a-icon
            type="idcard"
            theme="twoTone"
            two-tone-color="#fb7299"
            :style="{ fontSize: '25px' }"
            id="idcard"
          />
          工号
        </div>
        <div id="department">人力资源部</div>
        <div id="num">001</div>
      </div>
      <a-avatar
        id="avatar"
        :size="100"
        src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
      />
    </div>
    <div id="usual">常用操作</div>
    <div id="profile">
      <div id="title1" @click="toPage('/EditProfile')">
        个人资料
        <a-icon type="user" id="title3" />
      </div>
      <div id="title2">修改个人信息</div>
    </div>
    <div id="record">
      <div id="title1">
        打卡记录
        <a-icon type="carry-out" id="title3" />
      </div>
      <div id="title2">查看打卡考勤记录</div>
    </div>
    <div id="about">
      <div id="title1">
        关于我们
        <a-icon type="team" id="title3" />
      </div>
      <div id="title2">了解设计团队</div>
    </div>
    <div id="settings">
      <div id="title1">
        设置中心
        <a-icon type="setting" id="title3" />
      </div>
      <div id="title2">关于APP的设置</div>
    </div>
    <div id="logout">
      <div id="logout-button">退出登录</div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    toPage (uri) {
      this.$router.push({ path: uri })
    }
  }
}
</script>

<style lang="less" scoped>
@import "~ant-design-vue/dist/antd.less";
#title-background {
  position: absolute;
  background: url(../img/01.jpg) no-repeat fixed;
  background-size: 100% 100%;
  width: 411px;
  height: 220px;
  border-radius: 0px 0px 30px 30px;
}
#profile-panel {
  position: absolute;
  margin-top: 140px;
  background-color: white;
  height: 180px;
  width: calc(100% - 60px);
  margin-left: 30px;
  border-radius: 10px 10px 10px 10px;
}
#avatar {
  position: absolute;
  margin-top: -60px;
  margin-left: 30px;
}
#userinfo {
  position: absolute;
  margin-top: 25px;
  margin-left: 15px;
  text-align: left;
}
#username {
  color: black;
  font-weight: bold;
  font-size: 18px;
}
#signature {
  color: #81848d;
  margin-top: 20px;
  font-size: 13px;
}
#userdetail {
  margin-top: 10px;
  font-weight: bold;
}
#smile {
  padding-left: 70px;
}
#idcard {
  padding-left: 70px;
}
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
  position: absolute;
  margin-top: 335px;
  margin-left: 35px;
}
#profile {
  position: absolute;
  margin-top: 370px;
  background-color: white;
  width: 165px;
  height: 63px;
  margin-left: 35px;
  border-radius: 10px 10px 10px 10px;
}
#record {
  position: absolute;
  margin-top: 445px;
  background-color: white;
  width: 165px;
  height: 63px;
  margin-left: 35px;
  border-radius: 10px 10px 10px 10px;
}
#about {
  position: absolute;
  margin-top: 445px;
  background-color: white;
  width: 165px;
  height: 63px;
  margin-left: 212px;
  border-radius: 10px 10px 10px 10px;
}
#settings {
  position: absolute;
  margin-top: 370px;
  background-color: white;
  width: 165px;
  height: 63px;
  margin-left: 212px;
  border-radius: 10px 10px 10px 10px;
}
#logout {
  position: absolute;
  margin-top: 550px;
  width: calc(100% - 100px);
  background-color: white;
  height: 50px;
  margin-left: 50px;
  border-radius: 10px 10px 10px 10px;
}
#title1 {
  margin-top: 5px;
  text-align: left;
  margin-left: 20px;
  font-weight: bold;
  font-size: 12px;
}
#title2 {
  text-align: left;
  margin-left: 20px;
  color: #81848d;
  font-size: 10px;
}
#title3 {
  font-size: 25px;
  margin-left: 50px;
}
#logout-button {
  color: red;
  margin-top: 15px;
  font-weight: bold;
}
</style>
