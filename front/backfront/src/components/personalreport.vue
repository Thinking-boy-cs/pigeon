<template>
  <div class="container">
    <div class="header-title">员工性别分布</div>
    <Pie-charts class="pie" :chartData="piedata"></Pie-charts>
    <div class="header-title">员工薪酬情况</div>
    <Line-charts class="line" :chartData="linedata"></Line-charts>
    <div class="header-title">入职情况</div>
    <Bar-charts class="bar" :chartData="bardata"></Bar-charts>
    <div class="header-title">员工地域分布</div>
    <charts-map
    class="map"
      :width="width"
      :height="height"
      :data="data"
      :min="min"
      :max="max"
      :text="text"
      :in-range="inRange"
      :title="title"
    ></charts-map>
  </div>
</template>

<script>
import BarCharts from './echarts_bar'
import LineCharts from './echarts_line'
import PieCharts from './echarts_pie'
export default {
  data () {
    return {
      bardata: {
        name: ['2016-12', '2017-12', '2018-12', '2019-12', '2020-12'],
        data: [19, 12, 10, 8, 12]
      },
      linedata: {
        name: ['1001-4000', '4001-7000', '7001-10000', '10000-13000', '13001-16000', '16001-19000'],
        data: [113, 90, 80, 63, 53, 35]
      },
      piedata: [
        { value: 276, name: '男' },
        { value: 256, name: '女' }
      ],
      width: '60%',
      height: '500px',
      title: { show: false },
      data: [
        { name: '上海', value: 16 },
        { name: '云南', value: 16 },
        { name: '内蒙古', value: 17 },
        { name: '北京', value: 15 },
        { name: '台湾', value: 10 },
        { name: '吉林', value: 18 },
        { name: '四川', value: 28 },
        { name: '天津', value: 19 },
        { name: '宁夏', value: 12 },
        { name: '安徽', value: 15 },
        { name: '山东', value: 21 },
        { name: '山西', value: 20 },
        { name: '广东', value: 18 },
        { name: '广西', value: 14 },
        { name: '新疆', value: 12 },
        { name: '江苏', value: 16 },
        { name: '江西', value: 27 },
        { name: '河北', value: 24 },
        { name: '河南', value: 14 },
        { name: '浙江', value: 8 },
        { name: '海南', value: 15 },
        { name: '湖北', value: 25 },
        { name: '湖南', value: 36 },
        { name: '澳门', value: 19 },
        { name: '甘肃', value: 22 },
        { name: '福建', value: 18 },
        { name: '西藏', value: 16 },
        { name: '贵州', value: 25 },
        { name: '辽宁', value: 11 },
        { name: '重庆', value: 36 },
        { name: '陕西', value: 27 },
        { name: '青海', value: 12 },
        { name: '香港', value: 27 },
        { name: '黑龙江', value: 14 }
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
