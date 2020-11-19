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
            id = "smile"
          /> 部门
          <a-icon
            type="idcard"
            theme="twoTone"
            two-tone-color="#fb7299"
            :style="{ fontSize: '25px' }"
            id = "idcard"
          /> 工号
        </div>
        <div id="department">
          人力资源部
        </div>
        <div id="num">
          001
        </div>
      </div>
      <a-avatar
        id="avatar"
        :size="100"
        src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
      />
    </div>
    <div id="usual">
      常用操作
    </div>
    <div id="profile">
      个人资料
  </div>
    <div id="record">
      打卡记录
    </div>
    <div id="about">
      关于我们
    </div>
    <div id="settings">
      设置
    </div>
    <div id="logout">
      退出登录
    </div>
  </div>

</template>

<script>
export default {}
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
  position:absolute;
  margin-top: 335px;
  margin-left: 35px;
}
#profile {
    position: absolute;
    margin-top: 370px;
    background-color: rgba(0, 0, 255, 0.109);
    width: 165px;
    height: 63px;
    margin-left: 35px;
    border-radius: 10px 10px 10px 10px;
}
#record {
    position: absolute;
    margin-top: 445px;
    background-color: rgba(0, 0, 255, 0.109);
    width: 165px;
    height: 63px;
    margin-left: 35px;
    border-radius: 10px 10px 10px 10px;
}
#about {
position: absolute;
    margin-top: 445px;
    background-color: rgba(0, 0, 255, 0.109);
    width: 165px;
    height: 63px;
    margin-left: 212px;
    border-radius: 10px 10px 10px 10px;
}
#settings {
    position: absolute;
    margin-top: 370px;
    background-color: rgba(0, 0, 255, 0.109);
    width: 165px;
    height: 63px;
    margin-left: 212px;
    border-radius: 10px 10px 10px 10px;
}
#logout {
    position: absolute;
    margin-top: 550px;
    width: calc(100% - 100px);
    background-color: rgba(0, 0, 255, 0.109);
    height: 63px;
    margin-left: 50px;
    border-radius: 10px 10px 10px 10px;
}
</style>
