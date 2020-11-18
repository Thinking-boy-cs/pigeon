<template>
  <div>
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
          <a-icon type="left" />
        </div>
        <div class="title-container">
          <baidu-map
            class="bm-view"
            :center="circlePath.center"
            :zoom="15"
            @click="getPoint"
            @ready="handler"
          >
            <bm-circle
              :center="circlePath.center"
              :radius="circlePath.radius"
              stroke-color="blue"
              :stroke-opacity="0.5"
              :stroke-weight="2"
              @lineupdate="updateCirclePath"
            >
            </bm-circle>
            <bm-marker
              :position="circlePath.center"
              animation="BMAP_ANIMATION_BOUNCE"
            >
              <bm-info-window
                :show="show"
                :closeOnClick="false"
                style="font-size: 14px"
                @close="infoWindowClose" @open="infoWindowOpen"
              >
                <p>站点地址：{{ add.site }}</p>
              </bm-info-window>
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
        lng: 120.211486,
        lat: 30.256576
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
          lng: 116.404,
          lat: 39.915
        },
        radius: 500
      }
    }
  },
  methods: {
    getPoint (e) {
      this.show = true
      this.postionMap.lng = e.point.lng
      this.postionMap.lat = e.point.lat
      this.add.jd = e.point.lng
      this.add.wd = e.point.lat
      this.zoom = e.target.getZoom()
      let geocoder = new window.BMap.Geocoder()
      geocoder.getLocation(e.point, rs => {
        this.add.site = rs.address
      })
    },
    updateCirclePath (e) {
      this.circlePath.center = e.target.getCenter()
      this.circlePath.radius = e.target.getRadius()
    },

    infoWindowClose () {
      this.show = false
    },
    infoWindowOpen () {
      setInterval(() => {
        this.show = true
      }, 100)
    }
  }
}
</script>

<style>
#navigation-container {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 58px;
  line-height: 58px;
  box-shadow: 0px 1px 3px 1px rgba(0, 0, 0, 0.1);
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
  padding-top: 60px;
}
#notification-header {
  position: relative;
  padding-top: 70px;
}
.bm-view {
  width: 100%;
  height: 750px;
}
</style>
