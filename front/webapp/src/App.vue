<!--
 * @Date: 2020-11-11 09:58:43
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-15 17:58:32
-->
<template>
  <div id="subapp">
    <!-- <img src="./assets/logo.png"> -->
    <router-view/>
    <div id="navigator-container"></div>
  </div>
</template>

<script>
export default {
  name: 'App'

}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
}
</style>
