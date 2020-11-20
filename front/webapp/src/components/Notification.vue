<template>
  <div>
    <div id="navigation-container">
      <a id="title">消息</a>
      <div id="navigation-wrapper">
        <div class="title-container">
          <a-icon id="feature-icon1" type="calendar"></a-icon>
          <a id="calendar">日历</a>
          <a-divider type="vertical" />
          <i
            class="fa fa-check-square-o"
            id="feature-icon2"
            aria-hidden="true"
          ></i>
          <a id="todo">待办</a>
        </div>
      </div>
      <div id="notification1">
        <a-avatar :size="64" style="backgroundColor:#f56a00" icon="bell" id="bell" />
        <a>待处理通知</a>
        <div id="info1">【签到提醒】</div>
      </div>
      <div id="notification2">
        <a-avatar :size="64" style="backgroundColor:#1890ff" icon="user" id="admin" />
        <a>管理员通知</a>
        <div id="info2">【管理员提醒】</div>
      </div>
    </div>
    <div id="notification-header"></div>
  </div>
</template>
<script>
export default {
  methods: {}
}
</script>
<style lang="less" scoped>
@import "../style/index.less";
#notification1 {
  box-shadow: 0px 1px 0px 1px rgba(0, 0, 0, 0.1);
  height: 90px;
  background-color: white;
}
#notification1 a{
  color: black;
  float: left;
  font-weight: bold;
  margin-left: 10px ;
}
#bell {
  float: left;
  margin-left: 20px;
  margin-top:15px;
}
#notification2 {
  height: 90px;
  background-color: white;
}
#notification2 a{
  color: black;
  float: left;
  font-weight: bold;
  margin-left: 10px ;
}
#admin{
  float: left;
  margin-left: 20px;
  margin-top:15px;
}
#info1 {
  position: absolute;
  text-align: left;
  margin-top: 30px;
  margin-left: 100px;
  color:#81848D;
}
#info2 {
  position: absolute;
  text-align: left;
  margin-top: 30px;
  margin-left: 100px;
  color:#81848D;
}
#title {
  font-size: 20px;
  font-weight: bold;
}
#navigation-wrapper {
  position: relative;
  width: 100%;
  margin-left: 0px;
}
.title-container {
  font-size: 15px;
  background-color: white;
}
#notification-header {
  position: relative;
  padding-top: 70px;
}
#feature-icon1 {
  font-size: 24px;
  height: 40px;
  color: rgba(0, 0, 0, 0.65);
}
#feature-icon2 {
  font-size: 24px;
  height: 40px;
  color: rgba(0, 0, 0, 0.65);
  padding-left: 70px;
}
#calendar {
  padding-right: 70px;
  color: rgba(0, 0, 0, 0.65);
  font-weight: bold;
}
#todo {
  color: rgba(0, 0, 0, 0.65);
  font-weight: bold;
}
</style>
