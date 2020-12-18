import Vue from 'vue'
import Router from 'vue-router'
import Antd from 'ant-design-vue/es'
import 'ant-design-vue/dist/antd.less'
Vue.use(Router)
Vue.use(Antd)
export default new Router({
  routes: [
    {
      path: '/',
      name: 'Main',
      component: resolve => require(['@/components/Main.vue'], resolve),
      children: [
        {
          path: '/index',
          name: 'index',
          component: resolve => require(['@/components/index.vue'], resolve),
          meta: {
            name: '首页'
          }
        },
        {
          path: '/groupmanage',
          name: 'groupmanage',
          component: resolve => require(['@/components/groupmanage.vue'], resolve),
          meta: {
            parent: '人员管理',
            name: '部门管理'
          }
        },
        {
          path: '/staffmanage',
          name: 'staffmanage',
          component: resolve => require(['@/components/staffmanage.vue'], resolve),
          meta: {
            parent: '人员管理',
            name: '员工管理'
          }
        },
        {
          path: '/birthday',
          name: 'birthday',
          component: resolve => require(['@/components/birthday.vue'], resolve),
          meta: {
            parent: '人员管理',
            name: '生日关怀'
          }
        },
        {
          path: '/personnel',
          name: 'personnel',
          component: resolve => require(['@/components/personnel.vue'], resolve),
          meta: {
            parent: '人员管理',
            name: '人事变动'
          }
        },
        {
          path: '/personalreport',
          name: 'personalreport',
          component: resolve => require(['@/components/personalreport.vue'], resolve),
          meta: {
            parent: '人员管理',
            name: '人事报表'
          }
        },
        {
          path: '/signin',
          name: 'signin',
          component: resolve => require(['@/components/signin.vue'], resolve),
          meta: {
            parent: '考勤管理',
            name: '签到活动'
          }
        },
        {
          path: '/vacationmanage',
          name: 'vacationmanage',
          component: resolve => require(['@/components/vacationmanage.vue'], resolve),
          meta: {
            parent: '考勤管理',
            name: '假期管理'
          }
        },
        {
          path: '/attendancereport',
          name: 'attendancereport',
          component: resolve => require(['@/components/attendancereport.vue'], resolve),
          meta: {
            parent: '考勤管理',
            name: '考勤报表'
          }
        },
        {
          path: '/infocollect',
          name: 'infocollect',
          component: resolve => require(['@/components/infocollect.vue'], resolve),
          meta: {
            parent: '审批管理',
            name: '信息收集'
          }
        },
        {
          path: '/persosnalreport',
          name: 'personalreport',
          component: resolve => require(['@/components/personalreport.vue'], resolve),
          meta: {
            parent: '审批管理',
            name: '审批活动'
          }
        },
        {
          path: '/personnel',
          name: 'personnel',
          component: resolve => require(['@/components/personnel.vue'], resolve),
          meta: {
            parent: '通知公告',
            name: '分类管理'
          }
        },
        {
          path: '/persosnalreport',
          name: 'personalreport',
          component: resolve => require(['@/components/personalreport.vue'], resolve),
          meta: {
            parent: '通知公告',
            name: '公告管理'
          }
        },
        {
          path: '/personnel',
          name: 'personnel',
          component: resolve => require(['@/components/personnel.vue'], resolve),
          meta: {
            parent: '数据管理',
            name: '人事报表'
          }
        },
        {
          path: '/persosnalreport',
          name: 'personalreport',
          component: resolve => require(['@/components/personalreport.vue'], resolve),
          meta: {
            parent: '数据管理',
            name: '考勤报表'
          }
        },
        {
          path: '/regionreport',
          name: 'regionreport',
          component: resolve => require(['@/components/regionreport.vue'], resolve),
          meta: {
            parent: '数据管理',
            name: '地区战略'
          }
        }
      ]
    }
  ]
})
