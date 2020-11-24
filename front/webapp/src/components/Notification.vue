<template>
  <div class=".page">
    <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container"></div>
        <div class="page-title">消息</div>
      </div>
    </div>
    <div id="content-container">
      <div class="title-container">
        <a-icon id="feature-icon1" type="calendar"></a-icon>
        <a id="calendar" @click="showDrawer">日历</a>
        <a-divider type="vertical" />
        <i
          class="fa fa-check-square-o"
          id="feature-icon2"
          aria-hidden="true"
        ></i>
        <a id="todo">待办</a>
      </div>
      <div class="notify-container" v-for="(item, i) in messageData.chats" :key="i">
        <a-avatar
          class="notify-avatar"
          :size="64"
          :style="{backgroundColor: item.background}"
          :icon="item.icon"
        />
        <div class="notify-right">
          <div class="notify-head">
            <div class="notify-title">{{item.name}}</div>
            <div class="notify-time">{{item.lastest}}</div>
          </div>
          <div class="notify-preview">{{item.preview}}</div>
          <div class="notify-red-icon">{{item.unRead}}</div>
        </div>
      </div>
      <div id="notification1">
        <a-avatar
          :size="64"
          style="backgroundColor: #f56a00"
          icon="bell"
          id="bell"
        />
        <div id="info1">
          待处理通知
          <br /><span>【签到提醒】</span>
        </div>
      </div>
      <div id="notification2">
        <a-avatar
          :size="64"
          style="backgroundColor: #1890ff"
          icon="user"
          id="admin"
        />
        <div id="info2">管理员通知 <br /><span>【管理员提醒】</span></div>
      </div>
      <a-drawer
        title="Basic Drawer"
        placement="left"
        :closable="false"
        :visible="visible"
        :after-visible-change="afterVisibleChange"
        @close="onClose"
        width="350px"
      >
        <a-calendar :fullscreen="false">
          <ul slot="dateCellRender" slot-scope="value" class="events">
            <li v-for="item in getListData(value)" :key="item.content">
              <a-badge :status="item.type" />
            </li>
          </ul>
        </a-calendar>
      </a-drawer>
    </div>
  </div>
</template>
<script>
import moment from 'moment'
export default {
  data () {
    return {
      visible: false,
      CheckinStatus: {
        'attendanceDate': [
          {
            date: '2020-04-1',
            state: 0// 正常 green
          },
          {
            date: '2020-04-2',
            state: 1// 缺勤 yellow
          }
        ]
      },
      messageData: {
        chats: [
          {
            type: 'build-in',
            name: '待处理提醒',
            icon: 'bell',
            background: '#f56a00',
            avatar: '',
            preview: '【签到提醒】2020-11-24 部门签到',
            lastest: '2020-11-24 17:00',
            unRead: 1
          },
          {
            type: 'build-in',
            name: '通知公告',
            icon: 'user',
            background: '#1890ff',
            avatar: '',
            preview: '【通知】下午进行体检',
            lastest: '2020-11-24 17:00',
            unRead: 0
          }
        ]
      }
    }
  },
  methods: {
    afterVisibleChange (val) {
      console.log('visible', val)
    },
    showDrawer () {
      this.visible = true
    },
    onClose () {
      this.visible = false
    },
    onPanelChange (value, mode) {
      console.log(value, mode)
    },
    getListData (value) {
      let listData
      let currentmonth = moment().format('MM')
      if (value.month() === currentmonth - 1) {
        switch (value.date()) {
          case 8:
            listData = [
              { type: 'warning' }
            ]
            break
          case 10:
            listData = [
              { type: 'success' }
            ]
            break
          default:
        }
      }
      return listData
    }
  }
}
</script>
<style lang="less" scoped>
@import "../style/index.less";
#content-container {
  position: absolute;
  width: 100%;

  top: 58px;
}
.notify-container {
  width: 100%;
  padding-left: 20px;
  height: 90px;
  padding: 10px;
  background-color: white;
  position: relative;
  border-bottom: solid 1px rgba(0, 0, 0, 0.1);
  text-align: left;
}
.notify-avatar {
  float: left;
  margin-right: 20px;
}
.notify-right {
  position: relative;
  width: calc(100% - 84px);
  // height: 90px;
  margin-left: 84px;
}
.notify-head {
  width: 100%;
  height: 30px;
  line-height: 30px;
}
.notify-title {
  font-weight: bold;
  float: left;
}
.notify-time {
  float: right;
  font-size: 10px;
}
.notify-red-icon {
  position: absolute;
  right: 20px;
  top: 35px;
  width: 16px;
  height: 16px;
  background-color: red;
  border-radius: 50%;
  text-align: center;
  font-size: 10px;
  color: white;
}
#notification1 {
  box-shadow: 0px 1px 0px 1px rgba(0, 0, 0, 0.1);
  height: 90px;
  background-color: white;
  position: relative;
  margin-top: 1px;
}
#bell {
  float: left;
  margin-left: 20px;
  margin-top: 15px;
}
#notification2 {
  height: 90px;
  background-color: white;
  position: relative;
}
#admin {
  float: left;
  margin-left: 20px;
  margin-top: 15px;
}
#info1,
#info2 {
  position: relative;
  text-align: left;
  padding-top: 3vh;
  color: @text-color;
  font-weight: bold;
  padding-left: 23vw;
}
#info1 span,
#info2 span {
  font-weight: normal;
}
#title {
  font-size: 20px;
  font-weight: bold;
}
.title-container {
  font-size: 15px;
  background-color: white;
  position: relative;
  width: 100%;
  height: 10vh;
  box-shadow:1px 1px 3px 1px rgba(0, 0, 0, 0.1);
}
#notification-header {
  position: relative;
  padding-top: 70px;
}
#feature-icon1 {
  font-size: 24px;
  height: 40px;
  color: @text-color;
  padding-top: 2vh;
}
#feature-icon2 {
  font-size: 24px;
  height: 40px;
  color: @text-color;
  padding-left: 70px;
}
#calendar {
  padding-right: 70px;
  color: @text-color;
  font-weight: bold;
}
#todo {
  color: @text-color;
  font-weight: bold;
}
.events {
  list-style: none;
  margin: 0;
  padding: 0;
}
.events .ant-badge-status {
  white-space: nowrap;
  width: 100%;
  text-overflow: ellipsis;
  font-size: 12px;
  padding-left: 10px;
  padding-top: 5px;
}
.notes-month {
  text-align: center;
  font-size: 28px;
}
.notes-month section {
  font-size: 28px;
}
</style>
