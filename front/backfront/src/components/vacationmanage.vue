<template>
  <operation-table
    :tableData="tableData"
    :tableColumns="tableColumns"
    @deleterow="onDelete"
    @saverow="onSave"
  >
    <a slot="action" slot-scope="text">action</a>
  </operation-table>
</template>

<script>
import moment from 'moment'
import operaionTable from './utils/operationTable'
const columns = [
  {
    title: '序号',
    width: 80,
    dataIndex: 'id',
    key: 'id',
    fixed: 'left',
    scopedSlots: { customRender: 'id' }
  },
  {
    title: '员工ID',
    dataIndex: 'userId',
    key: 'userId',
    width: 80,
    scopedSlots: { customRender: 'userId' }
  },
  {
    title: '请假原因',
    dataIndex: 'reason',
    key: 'reason',
    width: 100,
    scopedSlots: { customRender: 'reason' }
  },
  {
    title: '开始时间',
    dataIndex: 'startTime',
    key: 'startTime',
    width: 100,
    scopedSlots: { customRender: 'startTime' },
    customRender: (text) => {
      return moment(text).format('YYYY-MM-DD HH:mm:ss')
    }
  },
  {
    title: '结束时间',
    dataIndex: 'endTime',
    key: 'endTime',
    width: 100,
    scopedSlots: { customRender: 'endTime' },
    customRender: (text) => {
      return moment(text).format('YYYY-MM-DD HH:mm:ss')
    }
  },
  {
    title: '状态',
    dataIndex: 'state',
    key: 'state',
    width: 50,
    scopedSlots: { customRender: 'state' }
  },
  {
    title: '提交时间',
    dataIndex: 'submitTime',
    key: 'submitTime',
    width: 150,
    scopedSlots: { customRender: 'submitTime' },
    customRender: (text) => {
      return moment(text).format('YYYY-MM-DD HH:mm:ss')
    }
  },
  {
    title: '操作',
    key: 'operation',
    fixed: 'right',
    width: 200,
    scopedSlots: { customRender: 'action' }
  }
]
const data1 = []
// for (let i = 0; i < 100; i++) {
//   data1.push({
//     key: i,
//     id: `${i}`,
//     userId: `${i}`,
//     Reason: '家里有事',
//     startTime: '2021-3-12 16:21:02',
//     endTime: '2021-3-12 16:21:02',
//     state: '已通过',
//     submitTime: '2021-3-12 16:21:02'
//   })
// }
export default {
  components: {
    'operation-table': operaionTable
  },
  data () {
    return {
      tableColumns: columns,
      tableData: data1,
      childData: 'test data',
      options: [
        {
          name: 'edit',
          method: (e) => {}
        },
        {
          name: 'view',
          method: (e) => {}
        },
        {
          name: 'delete',
          method: (e) => {}
        }
      ]
    }
  },
  methods: {
    onDelete (key) {
      const tableData = [...this.tableData]
      console.log(key)
      // this.tableData = tableData.filter(item => item.key !== key)
    },
    onSave (obj) {
      this.$axios.post('', obj).then((res) => {
        console.log(res)
      })
    }
  },
  created () {
    const that = this
    this.$axios
      .get(
        'http://localhost:8989/api/pigeon/govern/findLeaved?companyId=a81e3f81-7d30-4&theTime=2021-03-13'
      )
      .then((res) => {
        console.log(res)
        that.tableData = res.data.data
      })
  }
}
</script>

<style scoped></style>
