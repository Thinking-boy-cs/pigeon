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
      var myChart = echarts.init(this.$refs.echarts)
      myChart.setOption({
        tooltip: {},
        xAxis: {
          data: this.chartData.name
        },
        yAxis: {},
        series: [
          {
            type: 'line',
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
