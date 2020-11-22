/*
 * @Date: 2020-11-11 09:58:43
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-22 19:48:55
 */
// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import formatDate from './utils'
import axios from 'axios'
import 'babel-polyfill'
// import $ from 'jquery'

import 'font-awesome/css/font-awesome.min.css'
axios.defaults.withCredentials = true
Vue.prototype.$axios = axios
Vue.prototype.$formatDate = formatDate
Vue.config.productionTip = false
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
