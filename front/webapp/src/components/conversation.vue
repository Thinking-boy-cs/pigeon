<template>
<div>
  <div id="navigation-container">
      <div id="navigation-wrapper">
        <div class="icon-container">
          <a-icon type="left" @click="$router.go(-1)" />
        </div>
        <div class="page-title">
          {{titleName}}
        </div>
      </div>
    </div>
  <div id="content-container">
  </div>
</div>
</template>

<script>
const nameMap = ['通知公告', '待办消息', '活动信息']
export default {
  data () {
    return {
      titleName: '',
      conData: {
        'name': 'test',
        'data': [
          {
            'fromUser': {
              'id': '1606060960',
              'name': 'jecosine',
              'icon': '867ecc603cde457aba0eb8309bc02cd4.png'
            },
            'dept': {
              'id': '925014575aa049b',
              'name': '前端',
              'icon': '',
              'background': '#1890ff'
            },
            'content': {
              'title': '【任务】与后台对接',
              'content': '对接内容详情见邮件'
            },
            'date': '2020-11-24 17:00',
            'read': false
          }
        ]
      }
    }
  },
  computed: {

  },
  created () {
    this.titleName = nameMap[parseInt[this.$router.params.conId]]
  }
}
</script>

<style lang="less" scoped>
@import '../style/index.less';

</style>
