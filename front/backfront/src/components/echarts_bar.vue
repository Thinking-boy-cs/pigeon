<template>
  <div>
    <div style="width: 50%; height: 300px" ref="echarts"></div>
  </div>
</template>

<script>
import * as echarts from 'echarts'
export default {
  name: 'EchartsComponents',
  props: {
    chartData: {
      type: Array,
      default: () => []
    }
  },
  data () {
    return {
      count: 1
    }
  },
  methods: {
    drawChart () {
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(this.$refs.echarts)
      // 绘制图表
      myChart.setOption({
        tooltip: {},
        xAxis: {
          data: this.chartData.name
        },
        yAxis: {},
        series: [
          {
            type: 'bar',
            data: this.chartData.data
          }
        ]
      })
    }
  },
  computed: {},
  mounted: function () {
    const vm = this
    vm.$nextTick(() => {
      vm.drawChart()
    })
  },
  created: () => {}
}
</script>

<style scoped>
</style>
