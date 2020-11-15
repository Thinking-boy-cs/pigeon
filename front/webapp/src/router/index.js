/*
 * @Date: 2020-11-15 15:20:14
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-15 20:02:39
 */
import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import LoginPage from '@/components/LoginPage'
import Register from '@/components/Register'
import Notification from '@/components/Notification'
import Main from '@/components/Main'
import Antd from 'ant-design-vue/es'
import 'ant-design-vue/dist/antd.less'
Vue.use(Router)
Vue.use(Antd)
export default new Router({
  routes: [
    {
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
    },
    {
      path: '/',
      name: 'Main',
      component: Main
    }
  ]
})
