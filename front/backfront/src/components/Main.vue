<template>
  <a-layout id="components-layout-demo-top-side-2">
    <a-layout-header class="header">
      <div class="logo" />
      <a-menu
        theme="dark"
        mode="horizontal"
        :default-selected-keys="['2']"
        :style="{ lineHeight: '64px' }"
      >
        <a-menu-item key="1"> nav 1 </a-menu-item>
        <a-menu-item key="2"> nav 2 </a-menu-item>
        <a-menu-item key="3"> nav 3 </a-menu-item>
      </a-menu>
    </a-layout-header>
    <a-layout>
      <a-layout-sider width="200" style="background: #fff">
        <a-menu
          mode="inline"
          :default-selected-keys="['1']"
          :default-open-keys="['sub1']"
          :style="{ height: '100%', borderRight: 0 }"
        >
          <a-sub-menu key="sub1">
            <span slot="title"><a-icon type="user" />人员管理</span>
            <a-menu-item key="1"> 部门管理 </a-menu-item>
            <a-menu-item key="2"> 员工管理 </a-menu-item>
            <a-menu-item key="3"> 生日关怀 </a-menu-item>
            <a-menu-item key="4"> 人事变动 </a-menu-item>
            <a-menu-item key="5"> 人事报表 </a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="attendance">
            <span slot="title"><a-icon type="laptop" />考勤管理</span>
            <a-menu-item key="5"> 签到活动 </a-menu-item>
            <a-menu-item key="6"> 假期管理 </a-menu-item>
            <a-menu-item key="7"> 考勤报表 </a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="approval">
            <span slot="title"><a-icon type="form" />审批管理</span>
            <a-menu-item key="9"> 信息收集 </a-menu-item>
            <a-menu-item key="10"> 审批活动 </a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="announcement">
            <span slot="title"><a-icon type="notification" />通知公告</span>
            <a-menu-item key="9"> 分类管理 </a-menu-item>
            <a-menu-item key="10"> 公告管理 </a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="statistic">
            <span slot="title"><a-icon type="area-chart" />数据管理</span>
            <a-menu-item key="9"> 人事报表 </a-menu-item>
            <a-menu-item key="10"> 考勤报表 </a-menu-item>
          </a-sub-menu>
        </a-menu>
      </a-layout-sider>
      <a-layout style="padding: 0 24px 24px">
        <a-breadcrumb style="margin: 16px 0">
          <a-breadcrumb-item>Home</a-breadcrumb-item>
          <a-breadcrumb-item>List</a-breadcrumb-item>
          <a-breadcrumb-item>App</a-breadcrumb-item>
        </a-breadcrumb>
        <a-layout-content
          :style="{
            background: '#fff',
            padding: '24px',
            margin: 0,
            minHeight: '280px',
          }"
        >
          <!-- <Bar-charts :chartData="bardata"></Bar-charts>
          <Line-charts :chartData="linedata"></Line-charts>
          <Pie-charts :chartData="piedata"></Pie-charts> -->
        </a-layout-content>
      </a-layout>
    </a-layout>
  </a-layout>
</template>
<script>
import BarCharts from './echarts_bar'
import LineCharts from './echarts_line'
import PieCharts from './echarts_pie'
export default {
  data () {
    return {
      bardata: {
        name: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子'],
        data: [5, 20, 36, 10, 10, 20]
      },
      linedata: {
        name: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子'],
        data: [52, 2, 46, 15, 10, 30]
      },
      piedata: [
        {value: 335, name: '直接访问'},
        {value: 310, name: '邮件营销'},
        {value: 234, name: '联盟广告'},
        {value: 135, name: '视频广告'},
        {value: 1548, name: '搜索引擎'}
      ]
    }
  },
  components: {
    BarCharts, LineCharts, PieCharts
  }
}
</script>

<style>
#components-layout-demo-top-side-2 {
  width: 100vw;
  height: 100vh;
}
#components-layout-demo-top-side-2 .logo {
  width: 120px;
  height: 31px;
  background: rgba(255, 255, 255, 0.2);
  margin: 16px 28px 16px 0;
  float: left;
}
</style>
