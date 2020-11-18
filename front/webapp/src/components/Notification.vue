<template>
  <div>
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
          <a-icon type="left" />
        </div>
        <div class="title-container">
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

<style>
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
.title-container {
  font-size: 18px;
  font-weight: bold;
}
#notification-header {
  position: relative;
  padding-top: 70px;
}
</style>
