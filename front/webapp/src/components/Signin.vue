<template>
  <div>
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
          <a-icon type="left" id="back" />
          <a id="title">签到</a>
        </div>
      </div>
    </div>
    <div id="information-bar">
        <div id="avatar">头像</div>
        <div id="username">用户名</div>
        <div id="apartment">部门名称</div>
    </div>
  </div>
</template>

<script>
export default {}
</script>

<style lang="less" scoped>
@import "~ant-design-vue/dist/antd.less";
* {
  margin: 0;
  padding: 0;
  text-decoration: none;
  color: @text-color;
}
#navigation-container {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 58px;
  line-height: 58px;
  box-shadow: 0px 1px 3px 1px rgba(0, 0, 0, 0.1);
}
#navigation-wrapper {
  position: relative;
  width: calc(100% - 40px);
  margin-left: 20px;
}
.icon-container {
  position: absolute;
  left: 0;
}
#title {
  font-size: 20px;
  font-weight: bold;
  margin-left: 148px;
}
#information-bar {
    position:absolute;
    background-color: greenyellow;
    margin-top: 80px;
    margin-left: 15px;
    width: calc(100% - 30px);
    height: 100px;
    border-radius: 20px 20px 20px 20px;
}
</style>
