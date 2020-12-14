 <template>
      <div class="pie-container">
          <div ref="pcPie" :style="{width: chartWidth,height: chartHeight}">
         </div>
      </div>
  </template>
<script>
import * as charts from 'echarts'
export default {
  name: 'pc-pie',
  props: {
    chartWidth: {
      type: [String, Number],
      default: '400px'
    },
    chartHeight: {
      type: [String, Number],
      default: '400px'
    },
    title: Object,
    legend: Object,
    chartData: [Object, Array],
    name: String,
    chartColor: {
      type: Array,
      default: () => []
    }
  },
  mounted () {
    this.initChart()
  },
  methods: {
    initChart () {
      let datas = []
      if (Object.prototype.toString.call(this.chartData) === '[object Array]') {
        datas = this.chartData
      } else {
        const keyArray = this.chartData.columns
        this.chartData.rows.forEach(item => {
          datas.push({
            value: item[keyArray[1]],
            name: item[keyArray[0]]
          })
        })
      }
      const initCharts = charts.init(this.$refs.pcPie)
      const chartColor = this.chartColor.length === 0 ? null : this.chartColor

      const options = {
        tooltip: {
          trigger: 'item',
          formatter: '{b} : {c} ({d}%)'
        },
        title: this.title,
        legend: this.legend,
        series:
              {
                name: this.name,
                type: 'pie',
                radius: '55%',
                data: datas,
                itemStyle: {
                  emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                  },
                  color: chartColor
                }
              }
      }
      initCharts.setOption(options)
    }
  },
  watch: {
    chartData: {
      handler () {
        this.initChart()
      },
      deep: true
    }
  }
}
</script>
