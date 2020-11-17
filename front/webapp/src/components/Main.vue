<!--
 * @Date: 2020-11-15 17:44:38
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-15 18:37:18
-->
<template>
  <div id="app">
    <div id="carousel-container">
      <a-carousel autoplay>
        <div class="cabg">1</div>
        <div class="cabg">2</div>
        <div class="cabg">3</div>
        <div class="cabg">4</div>
      </a-carousel>
    </div>
    <div class="section-container">
      <div class=""></div>
    </div>
  </div>
</template>

<script>
export default {
}
</script>

<style>
#carousel-container {
  position: relative;
  width: 100%;
  height: 200px;
}
.cabg {
  background-color: aliceblue;
  width: 100%;
  height: 200px;
}
</style>
