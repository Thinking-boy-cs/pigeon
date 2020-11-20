<!--
 * @Date: 2020-11-20 11:11:01
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-11-20 11:34:00
-->
<template>

</template>

<script>
export default {
  data () {
    return {
      leaveId: null,
      leaveData: null,
      customStatusData: {
        'step': 4,
        'data': [
          {
            'type': 'application',
            'name': '发起申请',
            'handler': 'jecosine'
          },
          {
            'type': 'approval',
            'name': '二级审批',
            'handler': 'manager'
          },
          {
            'type': 'approval',
            'name': '一级审批',
            'handler': 'admin'
          },
          {
            'type': 'status',
            'name': '已通过'
            // '': 
          }
        ]
      }
    }
  },
  methods: {

  },
  created () {
    var that = this
    this.leaveId = this.$route.params.leaveId
    if (this.leaveId !== null) {

      this.leaveData = {
        'type': 'type 1',
        'startTime': '2020-10-11 10:10:10',
        'endTime': '2020-10-11 10:10:10',
        'status': 1,
        'applicant': 'jecosine',
        'approver': 'admin',
        'reason': 'Watch movie',
        'position': 'Chongqing China'
      }
      // this.$axios.get('/api/leave/getById?id=' + that.leaveId)
      //   .then(function (res) {
      //     console.log(res.data)
      //     that.pageData = res.data
      //   })
      //   .catch(function (error) {
      //     console.log(error)
      //   })
    }
  }
}
</script>

<style>

</style>
