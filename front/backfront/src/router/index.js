import Vue from 'vue'
import Router from 'vue-router'
import Antd from 'ant-design-vue/es'
Vue.use(Router)
Vue.use(Antd)
export default new Router({
  routes: [
    {
      path: '/',
      name: 'Main',
      component: resolve => require(['@/components/Main'], resolve)
    }
  ]
})
