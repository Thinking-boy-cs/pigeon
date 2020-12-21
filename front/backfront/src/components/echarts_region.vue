<template>
  <div ref="map" />
</template>
<script>
import 'echarts/china.js' // 引入中国地图数据
export default {
  props: {
    select: {// 用来判断是加载哪个地图，China，还是world，还是广东
      type: String
    },
    datas: {
      type: Array,
      required: true
    }
  },
  data () {
    return {
      // 下面是经纬度，用哪个地方的就填哪个地方的就可以
      geoCoordMap: {
        '黑龙江': [127.9688, 45.368],
        '内蒙古': [110.3467, 41.4899],
        '吉林': [125.8154, 44.2584],
        '辽宁': [123.1238, 42.1216],
        '河北': [114.4995, 38.1006],
        '天津': [117.4219, 39.4189],
        '山西': [112.3352, 37.9413],
        '陕西': [109.1162, 34.2004],
        '甘肃': [103.5901, 36.3043],
        '宁夏': [106.3586, 38.1775],
        '青海': [101.4038, 36.8207],
        '新疆': [87.9236, 43.5883],
        '西藏': [91.11, 29.97],
        '北京': [116.4551, 40.2539],
        '四川': [103.9526, 30.7617],
        '重庆': [108.384366, 30.439702],
        '山东': [117.1582, 36.8701],
        '河南': [113.4668, 34.6234],
        '江苏': [118.8062, 31.9208],
        '安徽': [117.29, 32.0581],
        '湖北': [114.3896, 30.6628],
        '浙江': [119.5313, 29.8773],
        '福建': [119.4543, 25.9222],
        '江西': [116.0046, 28.6633],
        '湖南': [113.0823, 28.2568],
        '贵州': [106.6992, 26.7682],
        '云南': [102.9199, 25.4663],
        '广东': [113.12244, 23.009505],
        '广西': [108.479, 23.1152],
        '海南': [110.3893, 19.8516],
        '上海': [121.4648, 31.2891],

        '广州市': [113.264385, 23.129112],
        '云浮市': [112.044439, 22.929801],
        '韶关市': [113.597313, 24.811094],
        '惠州市': [114.412599, 23.079404],
        '深圳市': [114.085947, 22.547],
        '汕头市': [116.708463, 23.37102],
        '佛山市': [113.122717, 23.028762],
        '江门市': [113.094942, 22.590431],
        '湛江市': [110.364977, 21.274898],
        '茂名市': [110.919229, 21.659751],
        '肇庆市': [112.472529, 23.051546],
        '梅州市': [116.117582, 24.299112],
        '汕尾市': [115.364238, 22.774485],
        '河源市': [114.697802, 23.746266],
        '阳江市': [111.975107, 21.859222],
        '东莞市': [113.746262, 23.046237],
        '揭阳市': [116.355733, 23.543778],
        '潮州市': [116.62286, 23.656324],
        '珠海市': [113.553986, 22.224979],
        '澄海市': [116.756092, 23.46596],
        '清远市': [113.056892, 23.680117],
        '中山市': [113.382391, 22.521113]

      }
      // Datas: [
      //   [{ name: '黑龙江', value: 0 }, { name: '广东' }],
      //   [{ name: '内蒙古', value: 10 }, { name: '广东' }],
      //   [{ name: '吉林', value: 10 }, { name: '广东' }],
      //   [{ name: '辽宁', value: 10 }, { name: '广东' }],
      //   [{ name: '河北', value: 10 }, { name: '广东' }]]
    }
  },
  watch: {
    datas (n, o) { // 不要使用箭头函数  不然会发生this改变
      this.mapEchartsInit()
    }
  },
  mounted () {
    this.mapEchartsInit()
  },
  methods: {
    mapEchartsInit () {
      const self = this
      const convertData = function (data) {
        const res = []
        for (let i = 0; i < data.length; i++) {
          const dataItem = data[i]
          const fromCoord = self.geoCoordMap[dataItem[0].name] // 迁出点
          const toCoord = self.geoCoordMap[dataItem[1].name] // 迁入点
          if (fromCoord && toCoord) {
            res.push([{
              coord: fromCoord,
              value: dataItem[0].value
            }, {
              coord: toCoord
            }])
          }
        }
        return res
      }
      const series = [];
      // 迁入地特殊显示//广东
      [[`${self.datas[0][1].name}`, self.datas]].forEach(function (item, i) {
        series.push({
          type: 'lines',
          zlevel: 2,

          effect: {
            show: true,
            period: 4, // 箭头指向速度，值越小速度越快
            trailLength: 0.02, // 特效尾迹长度[0,1]值越大，尾迹越长重
            symbol: 'arrow', // 箭头图标
            symbolSize: 5 // 图标大小
          },
          lineStyle: {
            normal: {
              width: 0.2, // 尾迹线条宽度
              opacity: 1, // 尾迹线条透明度
              curveness: 0.3 // 尾迹线条曲直度
            }
          },
          data: convertData(item[1])
        }, {
          type: 'effectScatter',
          coordinateSystem: 'geo',
          zlevel: 2,
          rippleEffect: { // 涟漪特效
            period: 4, // 动画时间，值越小速度越快
            brushType: 'stroke', // 波纹绘制方式 stroke, fill
            scale: 3 // 波纹圆环最大限制，值越大波纹越大
          },
          label: {
            normal: {
              show: true,
              position: 'right', // 显示位置
              offset: [5, 0], // 偏移设置
              formatter (params) { // 圆环显示文字
                return params.data.name
              },
              fontSize: 13
            },
            emphasis: {
              show: true
            }
          },
          symbol: 'circle',
          symbolSize (val) {
            return 1 + val[2] / 5e3 // 圆环大小
          },
          itemStyle: {
            normal: {
              show: false,
              color: '#f00'
            }
          },
          data: item[1].map(function (dataItem) {
            return {
              name: dataItem[0].name,
              value: self.geoCoordMap[dataItem[0].name].concat([dataItem[0].value])
            }
          })
        },
        // 迁入点
        {
          type: 'scatter',
          coordinateSystem: 'geo',
          zlevel: 2,
          rippleEffect: {
            period: 4,
            brushType: 'stroke',
            scale: 4
          },
          label: {
            normal: {
              show: true,
              position: 'right',
              offset: [5, 0],
              color: '#0f0',
              formatter: '{b}',
              textStyle: {
                color: '#0f0'
              }
            },
            emphasis: {
              show: true,
              color: '#f60'
            }
          },
          symbol: 'pin',
          symbolSize: 20,
          data: [{
            name: item[0],
            value: self.geoCoordMap[item[0]].concat([10])
          }]
        }
        )
      })
      const option = {
        tooltip: {
          trigger: 'item',
          formatter (params, ticket, callback) {
            // 根据业务自己拓展要显示的内容
            let res = ''
            const name = params.name
            const value = params.value[params.seriesIndex + 1]
            if (value !== undefined) {
              res = "<span style='color:#fff;'>" + name + '</span><br/>游客人数：' + value
              return res
            }
          }
        },
        backgroundColor: 'rgba(166, 200, 76, 0)',
        visualMap: { // 图例值控制
          min: 0,
          max: 1,
          calculable: true,
          show: false,
          color: ['#4169E1', '#fc9700', '#ffde00', '#ffde00', '#00eaff'],
          textStyle: {
            color: '#fff'
          }
        },
        geo: {
          map: `${self.select}`,
          zoom: 1.2,
          label: {
            emphasis: {
              show: false
            }
          },
          roam: true, // 是否允许缩放
          itemStyle: {
            normal: {
              borderColor: 'rgba(147, 235, 248, 1)',
              borderWidth: 1,
              areaColor: {
                type: 'radial',
                x: 0.5,
                y: 0.5,
                r: 0.8,
                colorStops: [{
                  offset: 0,
                  color: 'rgba(147, 235, 248, 0)' // 0% 处的颜色
                }, {
                  offset: 1,
                  color: 'rgba(147, 235, 248, .2)' // 100% 处的颜色
                }],
                globalCoord: false // 缺省为 false
              },
              shadowColor: 'rgba(128, 217, 248, 1)',
              // shadowColor: 'rgba(255, 255, 255, 1)',
              shadowOffsetX: -2,
              shadowOffsetY: 2,
              shadowBlur: 10
            },
            emphasis: {
              areaColor: '#389BB7',
              borderWidth: 0
            }
          }
        },
        series
      }
      const myChart = this.$echarts.init(this.$refs.map)
      myChart.setOption(option, true)
      // console.log(option)
      window.addEventListener('resize', function () {
        myChart.resize()
      })
    }
  }
}
</script>
