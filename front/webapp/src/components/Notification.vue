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
          待办
        </div>
      </div>
      <div id="notification1">
        <a-avatar :size="64" style="backgroundColor:#87d068" icon="bell" />待处理通知
      </div>
      <div id="notification2">
        <a-avatar :size="64" style="backgroundColor:#87d068" icon="bell" />待处理通知
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
#navigation-container {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 58px;
  line-height: 58px;
  box-shadow: 0px 1px 3px 1px rgba(0, 0, 0, 0.1);
}
#notification1 {
  box-shadow: 0px 1px 0px 1px rgba(0, 0, 0, 0.1);
  height: 80px;
}
#title {
  font-size: 20px;
  font-weight: bold;
}
#navigation-wrapper {
  position: relative;
  width: calc(100% - 40px);
  margin-left: 20px;
}
.title-container {
  font-size: 15px;
  color: rgba(0, 0, 0, 0.65);
}
#notification-header {
  position: relative;
  padding-top: 70px;
}
#feature-icon1 {
  font-size: 24px;
  height: 40px;
  color: @primary-color;
}
#feature-icon2 {
  font-size: 24px;
  height: 40px;
  color: @primary-color;
  padding-left: 50px;
}
#calendar {
  padding-right: 50px;
  color: rgba(0, 0, 0, 0.65);
}
</style>
