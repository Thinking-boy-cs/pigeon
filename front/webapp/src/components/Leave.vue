<!--
 * @Date: 2020-11-18 20:37:30
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-19 21:48:52
-->
<template>
  <div class=".page">
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
          <a-icon type="left" @click="$router.go(-1)" />
        </div>
        <div class="page-title">
          请假
        </div>
      </div>
    </div>
    <div id="content-container">
      <div id="content-wrapper">
        <div class="leave-item" v-for="(item, i) in leaveData" :key="i">
          <div class="leave-wrapper">
            <div class="leave-item-header">
              <a-icon type="edit" theme="filled" />
              <span class="leave-item-title">{{ item.type }} 申请</span>
            </div>
            <div class="leave-item-body">
              <div class="leave-date-container">
                <span style="font-weight: bold;">请假时间</span>
                <span class="leave-date">{{ item.startTime }}~{{ item.endTime }}</span>
                <span>(共 3 天)</span>
              </div>
              <div class="leave-status-container">
                <span :class="leaveStatusClasses[item.status]"><a-icon type="info-circle" />{{
                  leaveStatus[item.status]
                }}</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- <div>leave page</div> -->
  </div>
</template>

<script>
var testData = [
  {
    type: 'type 1',
    startTime: '2020-09-10 12:21:22',
    endTime: '2020-09-10 12:21:22',
    status: 0
  },
  {
    type: 'type 2',
    startTime: '2020-09-10 12:21:22',
    endTime: '2020-09-10 12:21:22',
    status: 1
  },
  {
    type: 'type 4',
    startTime: '2020-09-10 12:21:22',
    endTime: '2020-09-10 12:21:22',
    status: 2
  },
  {
    type: 'type 6',
    startTime: '2020-09-10 12:21:22',
    endTime: '2020-09-10 12:21:22',
    status: 1
  }
]

export default {
  data () {
    return {
      leaveData: testData,
      leaveStatus: ['准备休假', '休假中', '已完成'],
      leaveStatusClasses: ['leave-prepare', 'leave-ing', 'leave-finished']
    }
  },
  methods: {

  }
}
</script>

<style lang="less" scoped>
@import "../style/index.less";

#content-container {
  position: absolute;
  width: 100%;
  top: 78px;
  // background-color: white;
}
#content-wrapper {
  // width: calc(100% - 40px);
  // margin-left: 20px;
}
.leave-item {
  position: relative;
  width: 100%;
  // height: 100px;
  text-align: left;
  margin-top: 20px;
  box-shadow: 0 0 3px 1px rgba(0, 0, 0, 0.1);
  background-color: white;

}
.leave-item-body {
  padding: 5px;
}
.leave-wrapper {
  // width: calc(100% - 40px);
  padding-left: 20px;
  padding-right: 20px;
  // margin-left: 20px;
}
.leave-item-header {
  position: relative;
  width: 100%;
  height: 40px;
  line-height: 40px;
  font-size: 16px;
  font-weight: bold;
}
.leave-date {
  font-size: 10px;
}
.leave-prepare,
.leave-finished,
.leave-ing {
  font-weight: bold;
}
.leave-prepare {
  color: @warning-color;
}
.leave-ing {
  color: @primary-color;
}
.leave-finished {
  color: @success-color;
}
</style>
