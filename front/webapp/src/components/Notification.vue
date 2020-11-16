<template>
<div>
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
        <a-icon type="left"/>
        </div>
        <div class="title-container">
        消息
        </div>
      </div>
    </div>
    <div id="notification-header">
        <a-icon type="calendar" theme="filled" />日历<a-divider type="vertical" />
        
    </div>
</div>
</template>
<script>
export default {}
</script>

<style>
.title-container {
    font-size: 18px;
    font-weight: bold;
}
#notification-header {
    position: relative;
    padding-top: 70px;
}
</style>
