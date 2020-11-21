<template>
  <div class=".page">
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container"></div>
        <div class="page-title">消息</div>
      </div>
    </div>
    <div class="title-container">
      <a-icon id="feature-icon1" type="calendar"></a-icon>
      <a id="calendar">日历</a>
      <a-divider type="vertical" />
      <i class="fa fa-check-square-o" id="feature-icon2" aria-hidden="true"></i>
      <a id="todo">待办</a>
    </div>
    <div id="notification1">
      <a-avatar
        :size="64"
        style="backgroundColor: #f56a00"
        icon="bell"
        id="bell"
      />
      <div id="info1">
        待处理通知
        <br /><span>【签到提醒】</span>
      </div>
    </div>
    <div id="notification2">
      <a-avatar
        :size="64"
        style="backgroundColor: #1890ff"
        icon="user"
        id="admin"
      />
      <div id="info2">管理员通知
      <br /><span>【管理员提醒】</span>
      </div>
    </div>
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
  position: relative;
}
#bell {
  float: left;
  margin-left: 20px;
  margin-top: 15px;
}
#notification2 {
  height: 90px;
  background-color: white;
  position: relative;
}
#admin {
  float: left;
  margin-left: 20px;
  margin-top: 15px;
}
#info1, #info2 {
  position: relative;
  text-align: left;
  padding-top: 3vh;
  color: @text-color;
  font-weight: bold;
  padding-left: 23vw
}
#info1 span, #info2 span{
  font-weight: normal;
}
#title {
  font-size: 20px;
  font-weight: bold;
}
.title-container {
  font-size: 15px;
  background-color: white;
  position: relative;
  width: 100%;
  height: 10vh;
  margin-top: 59px;
}
#notification-header {
  position: relative;
  padding-top: 70px;
}
#feature-icon1 {
  font-size: 24px;
  height: 40px;
  color:  @text-color;
  padding-top: 2vh;
}
#feature-icon2 {
  font-size: 24px;
  height: 40px;
  color:  @text-color;
  padding-left: 70px;
}
#calendar {
  padding-right: 70px;
  color:  @text-color;
  font-weight: bold;
}
#todo {
  color:  @text-color;
  font-weight: bold;
}
</style>
