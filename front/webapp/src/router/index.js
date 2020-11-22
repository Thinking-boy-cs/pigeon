/*
 * @Date: 2020-11-15 15:20:14
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-22 04:15:41
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
import LeaveDetail from '@/components/LeaveDetail'
import Profile from '@/components/Profile'
import EditProfile from '@/components/EditProfile'
import LeaveApplication from '@/components/LeaveApplication'
import Antd from 'ant-design-vue/es'
import 'ant-design-vue/dist/antd.less'
import BaiduMap from 'vue-baidu-map'
Vue.use(Router)
Vue.use(Antd)
Vue.use(BaiduMap, {
  ak: 'pXbxmFWZNykvWBGwt9jVD6grmkpVkzwg'
})

const router = new Router({
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
        id: -13
      }
    },
    {
      path: '/EditProfile',
      name: 'EditProfile',
      component: EditProfile
    },
    {
      path: '/LeaveApplication',
      name: 'LeaveApplication',
      component: LeaveApplication,
      meta: {
        id: -14
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
    },
    {
      path: '/getLeave/:leaveid',
      name: 'LeaveDetail',
      meta: {
        id: -11
      },
      component: LeaveDetail
    }
  ]
})

router.beforeEach((route, redirect, next) => {
  if (!localStorage.getItem('user')) {
    if (route.path !== '/login' && route.path !== '/register') {
      next({
        path: '/login',
        query: {redirect: route.fullPath}
      })
    } else {
      next()
    }
  } else {
    if (route.path === '/login') {
      next({
        path: '/',
        query: {redirect: route.fullPath}
      })
    }
    console.log('-------------------', route, redirect)
    next()
  }
})

export default router
