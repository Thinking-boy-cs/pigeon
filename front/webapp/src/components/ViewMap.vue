<template>
  <div>
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
          <a-icon type="left" @click="$router.go(-1)" />
        </div>
                <div class="page-title">签到范围</div>
        <div class="title-container">
          <baidu-map
            class="bm-view"
            :center="circlePath.center"
            :zoom="15"
            :pinch-to-zoom="true"
            @ready="getPoint"
          >
            <bm-circle
              :center="circlePath.center"
              :radius="circlePath.radius"
              stroke-color="blue"
              :stroke-opacity="0.5"
              :stroke-weight="1"
              fillColor="#3291F8"
              :fillOpacity="0.15"
            >
            </bm-circle>
            <bm-marker
              :position="postionMap"
              animation="BMAP_ANIMATION_BOUNCE"
            >
              <bm-label
                :content="add.site"
                :position="circlePath.center"
                :offset="{ width: 20, height: -15 }"
                :labelStyle="{
                  color: '#3291F8',
                  fontSize: '13px',
                  font: 'bolder 12px/20px PingFang SC,sans-serif',
                  border: 0,
                }"
              />
              <!-- <bm-info-window
                :show="show"
                :closeOnClick="false"
                style="font-size: 10px"
                @close="infoWindowClose" @open="infoWindowOpen"
              >
                <p>站点地址：{{ add.site }}</p>
              </bm-info-window> -->
            </bm-marker>
            <bm-navigation anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-navigation>
          </baidu-map>
        </div>
      </div>
    </div>
    <div id="notification-header"></div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      show: false,
      postionMap: {
        lng: 105.588047,
        lat: 29.407702
      },
      location: '',
      address: '',
      add: {
        siteName: '',
        site: '',
        jd: '',
        wd: '',
        desce: '',
        type: '',
        jgName: '',
        jgNum: ''
      },
      organizationData: [],
      jgName: '',
      jgNum: '',
      circlePath: {
        center: {
          lng: 105.585047,
          lat: 29.401702
        },
        radius: 500
      }
    }
  },
  methods: {
    getPoint () {
      // this.show = true
      // this.postionMap.lng = e.point.lng
      // this.postionMap.lat = e.point.lat
      // this.add.jd = e.point.lng
      // this.add.wd = e.point.lat
      // this.zoom = e.target.getZoom()
      let geocoder = new window.BMap.Geocoder()
      let point = new window.BMap.Point(this.postionMap.lng, this.postionMap.lat)
      geocoder.getLocation(point, (rs) => {
        this.add.site = rs.address
        console.log(rs.address) // 这里打印可以看到里面的详细地址信息，可以根据需求选择想要的
        console.log(rs.addressComponents)// 结构化的地址描述(object)
        console.log(rs.addressComponents.province) // 省
        console.log(rs.addressComponents.city) // 城市
        console.log(rs.addressComponents.district) // 区县
        console.log(rs.addressComponents.street) // 街道
        console.log(rs.addressComponents.streetNumber) // 门牌号
        console.log(rs.surroundingPois) // 附近的POI点(array)
        console.log(rs.business) // 商圈字段，代表此点所属的商圈(string)
      })
    }
  }
}
</script>

<style lang="less" scoped>
@import "../style/index.less";
#navigation-container {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 58px;
  line-height: 58px;
  box-shadow: 0px 1px 3px 1px rgba(0, 0, 0, 0.1);
  z-index: 99;
}
#navigation-wrapper {
  position: relative;
  width: calc(100% - 40px);
  margin-left: 20px;
}
.icon-container {
  position: absolute;
  left: 0;
}
.title-container {
  font-size: 18px;
  font-weight: bold;
}
#notification-header {
  position: relative;
  padding-top: 70px;
}
.bm-view {
  width: 100%;
  height: 100vh;
}
.page-title {
  font-size: 20px;
  font-weight: bold;
}
</style>
