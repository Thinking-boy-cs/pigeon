<template>
  <div id="page-container">
    <div class="admin-welcome">
      <a-avatar
        class="avatar"
        style="color: white; backgroundColor: #3296fa"
        :size="70"
      >
        帅文
      </a-avatar>
      <div class="text">你好，余帅文</div>
      <div class="user-info">
        <span class="info-text">人事管理员</span>
        <a-divider type="vertical" />
        <span class="info-text">管理范围：全公司</span>
      </div>
    </div>
    <div class="todopanel">
      <div class="calendar-wrapper">
        <a-calendar
          :fullscreen="false"
          @panelChange="onPanelChange"
          :header-render="headerRender"
          :locale="locale"
        />
      </div>
      <div class="todo">
        <a-tabs default-active-key="1" :size="size">
          <a-tab-pane key="1" tab="今日待办(0)">
            <div class="todo-body">太棒了，今天所有待办都处理完了</div>
          </a-tab-pane>
          <a-tab-pane key="3" tab="提前提醒(0)">
            <div class="todo-body">今天没有「提前提醒」事项</div>
          </a-tab-pane>
        </a-tabs>
      </div>
    </div>
    <div class="staff-view-box">
      <div class="staff-view">
        <div class="left-view">
          <p class="kind">在职员工</p>
          <p class="num">527</p>
        </div>
        <div class="right-view1">
          <p class="kind">正式</p>
          <p class="num">493</p>
        </div>
        <div class="right-view2">
          <p class="kind">待离职</p>
          <p class="num">10</p>
        </div>
        <div class="right-view3">
          <p class="kind">已离职</p>
          <p class="num">12</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import 'moment/locale/zh-cn'
import moment from 'moment'
export default {
  data () {
    return {
      size: 'large',
      name: '',
      locale: {
        lang: {
          month: '月',
          year: '年'
        }
      }
    }
  },
  methods: {
    onPanelChange (value, mode) {
      console.log(value, mode)
    },
    headerRender ({ value, type, onChange, onTypeChange }) {
      const start = 0
      const end = 12
      const monthOptions = []
      let currentmonth = moment().format('MM')
      let currentday = moment().format('DD')
      let currentweek = moment().format('dddd')
      const current = value.clone()
      const localeData = value.localeData()
      const months = []
      for (let i = 0; i < 12; i++) {
        current.month(i)
        months.push(localeData.monthsShort(current))
      }

      for (let index = start; index < end; index++) {
        monthOptions.push(
          <a-select-option class="month-item" key={`${index}`}>
            {months[index]}
          </a-select-option>
        )
      }
      const month = value.month()

      const year = value.year()
      const options = []
      for (let i = year - 10; i < year + 10; i += 1) {
        options.push(
          <a-select-option key={i} value={i} class="year-item">
            {i}
          </a-select-option>
        )
      }
      return (
        <div style={{ padding: '10px' }}>
          <a-row type="flex" justify="space-between">
            <a-col>
              <a-select
                style={{ paddingRight: '4px' }}
                size="small"
                dropdownMatchSelectWidth={false}
                class="my-year-select"
                onChange={(newYear) => {
                  const now = value.clone().year(newYear)
                  onChange(now)
                }}
                value={String(year)}
              >
                {options}
              </a-select>
              <a-select
                size="small"
                dropdownMatchSelectWidth={false}
                value={String(month)}
                onChange={(selectedMonth) => {
                  const newValue = value.clone()
                  newValue.month(parseInt(selectedMonth, 10))
                  onChange(newValue)
                }}
              >
                {monthOptions}
              </a-select>
              <span style={{ paddingLeft: '35px', fontSize: '15px' }}>
                今天是{currentmonth}月{currentday}日 {currentweek}
              </span>
            </a-col>
          </a-row>
        </div>
      )
    }
  }
}
</script>

<style scoped>
.admin-welcome {
  position: relative;
  height: 90px;
  border-bottom: 1px solid rgba(25, 31, 37, 0.12);
  padding-top: 5px;
  padding-left: 16px;
  background: #fff;
}
.admin-welcome .avatar {
  position: absolute;
}
.admin-welcome .text {
  margin-left: 85px;
  font-family: PingFangSC-Medium;
  font-size: 18px;
  color: rgba(0, 0, 0, 0.85);
  line-height: 40px;
}
.admin-welcome .user-info {
  margin-left: 85px;
}
.admin-welcome .user-info .info-text {
  font-size: 14px;
  color: rgba(25, 31, 37, 0.56);
  letter-spacing: -0.34px;
  vertical-align: middle;
  display: inline-block;
}
.todopanel {
  width: 100%;
  padding: 24px 0 0 20px;
  background: #fff;
}
.todo {
  width: 500px;
  margin-left: 50px;
  float: left;
}
.calendar-wrapper {
  margin-top: 5px;
  margin-left: 130px;
  width: 350px;
  margin-right: 50px;
  float: left;
}
.todo-body {
  line-height: 262px;
  width: 100%;
  font-size: 14px;
  color: rgba(25, 31, 37, 0.4);
  letter-spacing: -0.34px;
  text-align: center;
}
.staff-view-box {
  float: left;
  width: 565px;
  height: 180px;
  border-radius: 3px;
}
.staff-view {
  width: 100%;
  display: flex;
}
.left-view {
  border-right: 1px solid rgba(21, 24, 27, 0.12);
  color: #3296fa;
  width: 30%;
  margin-left: 80px;
}
.right-view1 {
  width: 20%;
  color: #52c41a;
  margin-left: 45px;
}
.right-view2 {
  width: 20%;
  color:#faad14;
  margin-left: 45px;
}
.right-view3 {
  width: 20%;
  color: #f5222d;
  margin-left: 45px;
}
.left-view .kind {
  margin-top: 20px;
  position: relative;
  font-size: 14px;
  line-height: 22px;
  margin-bottom: 5px;
}
.left-view .num {
  font-size: 48px;
  line-height: 48px;
}
.right-view1 .kind,
.right-view2 .kind,
.right-view3 .kind {
  margin-top: 20px;
  position: relative;
  font-size: 14px;
  line-height: 22px;
  margin-bottom: 5px;
}
.right-view1 .num,
.right-view2 .num,
.right-view3 .num {
  font-size: 48px;
  line-height: 48px;
}
</style>
