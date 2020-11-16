<!--
 * @Date: 2020-11-15 17:44:38
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-16 20:17:49
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
    <i class="fa fa-address-book-o">face</i>
    <!-- <div class="section-container">
      <div class="section-title">最近常用</div>
      <div class="item-container">
          <a-row>
              <a-col :span="6" v-for="(item, i) in pageData.recents" :key="i">
                  <div class="feature-icon"><a-icon :type="item.icon" /></div>
                  <div class="feature-name"><a-icon :type="item.name" /></div>
              </a-col>
          </a-row>
      </div>
    </div> -->
    <div class="section-container">
      <div class="section-title"></div>
      <div class="item-container"></div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {

    }
  },
  created () {
    //   this.$axios.get('/')
  }
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
