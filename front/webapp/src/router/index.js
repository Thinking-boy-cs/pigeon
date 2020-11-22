/*
 * @Date: 2020-11-15 15:20:14
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-22 16:18:14
 */
import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
// import LoginPage from '@/components/LoginPage'
// import Register from '@/components/Register'
// import Leave from '@/components/Leave'
// import Notification from '@/components/Notification'
// import Me from '@/components/Me'
// import Map from '@/components/Map'
// import Main from '@/components/Main'
// import Signin from '@/components/Signin'
// import LeaveDetail from '@/components/LeaveDetail'
// import Profile from '@/components/Profile'
// import EditProfile from '@/components/EditProfile'
// import LeaveApplication from '@/components/LeaveApplication'
import Antd from 'ant-design-vue/es'
import 'ant-design-vue/dist/antd.less'
import BaiduMap from 'vue-baidu-map'
import { component } from 'vue/types/umd'
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
      // component: LoginPage,
      component: () => import('@/components/LoginPage'),

      meta: {
        id: -1
      }
    },
    {
      path: '/register',
      name: 'Regist',
      // component: Register,
      component: () => import('@/components/Register'),

      meta: {
        id: -2
      }
    },
    {
      path: '/Notification',
      name: 'Notification',
      // component: Notification,
      component: () => import('@/components/Notification'),
      meta: {
        id: 1
      }
    },
    {
      path: '/Me',
      name: 'Me',
      component: () => import('@/components/Me'),
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
      // component: Signin
      component: () => import('@/components/Signin')
    },
    {
      path: '/Profile',
      name: 'Profile',
      // component: Profile,
      component: () => import('@/components/Profile'),
      meta: {
        id: -13
      }
    },
    {
      path: '/EditProfile',
      name: 'EditProfile',
      // component: EditProfile
      component: () => import('@/components/EditProfile')
    },
    {
      path: '/LeaveApplication',
      name: 'LeaveApplication',
      // component: LeaveApplication,
      component: () => import('@/components/LeaveApplication'),
      meta: {
        id: -14
      }
    },
    {
      path: '/',
      name: 'Main',
      component: () => import('@/components/Main'),
      meta: {
        id: 0
      }
    },
    {
      path: '/leave',
      name: 'Leave',
      component: () => import('@/components/Leave'),
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
      component: () => import('@/components/LeaveDetail')
    }
  ]
})

router.beforeEach((route, redirect, next) => {
  if (!localStorage.getItem('user')) {
    if (route.path !== '/login' && route.path !== '/register') {
      next({
        path: '/login',
        query: { redirect: route.fullPath }
      })
    } else {
      next()
    }
  } else {
    if (route.path === '/login') {
      next({
        path: '/',
        query: { redirect: route.fullPath }
      })
    }
    console.log('-------------------', route, redirect)
    next()
  }
})

export default router
