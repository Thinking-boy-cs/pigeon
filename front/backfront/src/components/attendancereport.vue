<template>
  <div class="container">
    <div class="header-title">今日签到情况</div>
    <Pie-charts class="pie" :chartData="piedata"></Pie-charts>
    <div class="header-title">近七天出勤率</div>
    <Line-charts class="line" :chartData="linedata1"></Line-charts>
    <div class="header-title">近三月请假率</div>
    <Line-charts class="line" :chartData="linedata2"></Line-charts>
  </div>
</template>

<script>
import BarCharts from './echarts_bar'
import LineCharts from './echarts_line'
import PieCharts from './echarts_pie'
export default {
  data () {
    return {
      linedata1: {
        name: ['2021-3-06', '2021-3-07', '2021-3-08', '2021-3-09', '2021-3-10', '2021-3-11', '2021-3-12'],
        data: [100, 97, 92, 90, 98, 100, 95]
      },
      linedata2: {
        name: ['2020-10', '2020-11', '2020-12'],
        data: [5.5, 4.8, 4.3]
      },
      piedata: [
        { value: 318, name: '已签到' },
        { value: 305, name: '未签到' }
      ],
      width: '60%',
      height: '500px',
      title: { show: false },
      data: [
      ]
    }
  },
  methods: {},
  components: {
    BarCharts,
    LineCharts,
    PieCharts
  }
}
</script>

<style scoped>
.header-title {
  font-size: 17px;
  font-family: PingFang SC;
}
.pie {
  margin-left: 28%;
}
.line {
  margin-left: 25%;
}
.bar {
  margin-left: 25%;
}
.map {
  margin-left: 25%;
}
.container {
    /* background: #ffffff; */
}
</style>
