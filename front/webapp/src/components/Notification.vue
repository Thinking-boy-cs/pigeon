<template>
  <div>
    <div id="navigation-container">
        <a id="title">消息</a>
      <div id="navigation-wrapper">
        <div class="title-container">
          日历
        </div>
      </div>
    </div>
    <div id="notification-header"></div>
  </div>
</template>
<script>
export default {
  methods: {
  }
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
  font-size: 18px;
  font-weight: bold;
}
#notification-header {
  position: relative;
  padding-top: 70px;
}
</style>
