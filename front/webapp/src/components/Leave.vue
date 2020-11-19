<!--
 * @Date: 2020-11-18 20:37:30
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-19 21:48:52
-->
<template>
  <div>
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
          <div class="leave-item-header">
            <a-icon type="edit" theme="filled" />
            <span class="leave-item-title">{{ item.type }} 申请</span>
          </div>
          <div class="leave-item-body">
            <div class="leave-date-container">
              <span>请假时间</span>
              <span class="leave-date">{{ item.startTime }}</span>
              <span class="leave-date">{{ item.endTime }}</span>
              <span>(共 3 天)</span>
            </div>
            <div class="leave-status-container">
              <span :class="leaveStatusClasses[item.status]">{{
                leaveStatus[item.status]
              }}</span>
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
    startTime: Date(),
    endTime: Date(),
    status: 0
  },
  {
    type: 'type 2',
    startTime: Date(),
    endTime: Date(),
    status: 1
  },
  {
    type: 'type 4',
    startTime: Date(),
    endTime: Date(),
    status: 2
  },
  {
    type: 'type 6',
    startTime: Date(),
    endTime: Date(),
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
  methods: {}
}
</script>

<style lang="less" scoped>
@import "../style/index.less";
.icon-container,
.page-title {
  display: inline-block;
}
.page-title {
  font-size: 20px;
  font-weight: bold;
}
#content-container {
  width: 100%;
  margin-top: 78px;
}
#content-wrapper {
  width: calc(100% - 40px);
  margin-left: 20px;
}
.leave-item {
  position: relative;
  width: 100%;
  height: 100px;
  text-align: left;
}
.leave-item-header {
  position: relative;
  width: 100%;
  height: 40px;
  font-size: 16px;
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
