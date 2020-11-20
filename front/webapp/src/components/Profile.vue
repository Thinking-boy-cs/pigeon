<template>
  <div>
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
          <a-icon type="left" @click="$router.go(-1)" />
        </div>
        <div class="page-title">编辑</div>
      </div>
    </div>
    <div id="personalize">
      请假类型
    </div>

    <div id="basic-information"></div>

    <div id="further-information"></div>
  </div>
</template>

<script>
export default {}
</script>

<style lang="less" scoped>
@import "../style/index.less";
.page-title {
  font-size: 20px;
  font-weight: bold;
}
#personalize {
  background: white;
  height: 103px;
  width: 100%;
  margin-top: 82px;
  position: absolute;
}
#basic-information {
  background: white;
  height: 100px;
  width: 100%;
  margin-top: 201px;
  position: absolute;
}
#further-information {
  background: white;
  height: 100px;
  width: 100%;
  margin-top: 322px;
  position: absolute;
}
#form1 {
  width: 50%;
}
</style>
