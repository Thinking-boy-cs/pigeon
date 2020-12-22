<template>
  <div>
    <!-- <mapbar
      :select="mapprov"
      :datas="cityDatas"
      :style="{ width: '100%', height: `${map_canvas}` }"
    /> -->
    //中国地图
    <mapbar
      :select="mapchina"
      :datas="provDatas"
      :style="{ width: '100%', height: `${map_canvas}` }"
    />
    //广东地图
  </div>
</template>

<script>
import mapbar from './echarts_region'
export default {
  components: {
    mapbar // 地图
  },
  data () {
    return {
      mapchina: 'china',
      mapprov: '广东',
      map_canvas: '70vh',
      // 地图迁徙图设置
      provDatas: [
        [{ name: '黑龙江', value: 0 }, { name: '广东' }],
        [{ name: '内蒙古', value: 10 }, { name: '广东' }],
        [{ name: '吉林', value: 10 }, { name: '广东' }],
        [{ name: '辽宁', value: 10 }, { name: '广东' }],
        [{ name: '河北', value: 13 }, { name: '广东' }],
        [{ name: '广东', value: 10 }, { name: '重庆' }],
        [{ name: '重庆', value: 0 }, { name: '广东' }],
        [{ name: '广东', value: 20 }, { name: '湖南' }],
        [{ name: '广东', value: 18 }, { name: '江西' }],
        [{ name: '江西', value: 12 }, { name: '安徽' }],
        [{ name: '安徽', value: 22 }, { name: '上海' }],
        [{ name: '上海', value: 12 }, { name: '广东' }],
        [{ name: '湖南', value: 30 }, { name: '河北' }],
        [{ name: '重庆', value: 12 }, { name: '四川' }],
        [{ name: '四川', value: 12 }, { name: '广西' }],
        [{ name: '广西', value: 2 }, { name: '广东' }]
      ],
      cityDatas: [
        [{ name: '佛山市', value: 3 }, { name: '茂名市' }],
        [{ name: '东莞市', value: 10 }, { name: '茂名市' }],
        [{ name: '揭阳市', value: 10 }, { name: '茂名市' }],
        [{ name: '汕头市', value: 10 }, { name: '茂名市' }],
        [{ name: '惠州市', value: 10 }, { name: '茂名市' }]
      ]
    }
  }
}
</script>
