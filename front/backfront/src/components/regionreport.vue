<template>
  <div>
    <mapbar
      :select="mapprov"
      :datas="cityDatas"
      :style="{ width: '100%', height: `${map_canvas}` }"
    />
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
      map_canvas: '26vh',
      // 地图迁徙图设置
      provDatas: [
        [{ name: '黑龙江', value: 0 }, { name: '广东' }],
        [{ name: '内蒙古', value: 10 }, { name: '广东' }],
        [{ name: '吉林', value: 10 }, { name: '广东' }],
        [{ name: '辽宁', value: 10 }, { name: '广东' }],
        [{ name: '河北', value: 10 }, { name: '广东' }]
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
