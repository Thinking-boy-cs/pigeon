/*
 * @Date: 2020-11-15 15:20:14
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-15 16:42:08
 */
import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import LoginPage from '@/components/LoginPage'
import Register from '@/components/Register'
import Notification from '@/components/Notification'
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'

Vue.use(Router)
Vue.use(Antd)
export default new Router({
  routes: [{
    path: '/',
    name: 'HelloWorld',
    component: HelloWorld
  },
  {
    path: '/login',
    name: 'Login',
    component: LoginPage
  },
  {
    path: '/register',
    name: 'Regist',
    component: Register
  },
  {
    path: '/Notification',
    name: 'Notification',
    component: Notification
  }
  ]
})
