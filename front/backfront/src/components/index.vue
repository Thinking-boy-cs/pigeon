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
          :style="{ width: '450px' }"
        />
      </div>
      <div class="todo">
        <a-tabs default-active-key="1" :size="size">
          <a-tab-pane key="1" tab="今日待办">
            <div class="todo-body">太棒了，今天所有待办都处理完了</div>
          </a-tab-pane>
          <a-tab-pane key="3" tab="提前提醒">
            今天没有「提前提醒」事项
          </a-tab-pane>
        </a-tabs>
      </div>
    </div>
    <div class="staff-view-box">
      <div class="staff-view">
        <div class="left-view">
          <p class="kind">在职员工</p>
          <p class="num">1</p>
        </div>
        <div class="right-view">
          <p class="kind">正式</p>
          <p class="num">0</p>
        </div>
        <div class="right-view">
          <p class="kind">待离职</p>
          <p class="num">0</p>
        </div>
        <div class="right-view">
          <p class="kind">离职</p>
          <p class="num">0</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      size: 'large'
    }
  },
  methods: {
    onPanelChange (value, mode) {
      console.log(value, mode)
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
  width: 952px;
  padding: 24px 0 0 20px;
  background: #fff;
}
.todo {
  width: 400px;
  /* margin-right: 50px; */
  float: left;
}
.calendar-wrapper {
  margin-top: 5px;
  width: 300px;
  margin-right: 230px;
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
.right-view {
  width: 20%;
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
.right-view .kind {
  margin-top: 20px;
  position: relative;
  font-size: 14px;
  line-height: 22px;
  margin-bottom: 5px;
}
.right-view .num {
  font-size: 48px;
  line-height: 48px;
}
</style>
