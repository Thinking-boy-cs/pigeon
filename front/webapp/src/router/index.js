/*
 * @Date: 2020-11-15 15:20:14
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-19 20:56:46
 */
import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import LoginPage from '@/components/LoginPage'
import Register from '@/components/Register'
import Leave from '@/components/Leave'
import Notification from '@/components/Notification'
import Me from '@/components/Me'
import Map from '@/components/Map'
import Main from '@/components/Main'
import Signin from '@/components/Signin'
import Profile from '@/components/Profile'
import Antd from 'ant-design-vue/es'
import 'ant-design-vue/dist/antd.less'
import BaiduMap from 'vue-baidu-map'
Vue.use(Router)
Vue.use(Antd)
Vue.use(BaiduMap, {
  ak: 'pXbxmFWZNykvWBGwt9jVD6grmkpVkzwg'
})

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: LoginPage,
      meta: {
        id: -1
      }
    },
    {
      path: '/register',
      name: 'Regist',
      component: Register,
      meta: {
        id: -2
      }
    },
    {
      path: '/Notification',
      name: 'Notification',
      component: Notification,
      meta: {
        id: 1
      }
    },
    {
      path: '/Me',
      name: 'Me',
      component: Me,
      meta: {
        id: 2
      }
    },
    {
      path: '/Map',
      name: 'Map',
      component: Map
    },
    {
      path: '/Signin',
      name: 'Signin',
      component: Signin
    },
    {
      path: '/Profile',
      name: 'Profile',
      component: Profile,
      meta: {
        id: -11
      }
    },
    {
      path: '/',
      name: 'Main',
      component: Main,
      meta: {
        id: 0
      }
    },
    {
      path: '/leave',
      name: 'Leave',
      component: Leave,
      meta: {
        id: -10
      }
    }
  ]
})
