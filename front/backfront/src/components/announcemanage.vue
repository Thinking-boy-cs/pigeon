<template>
  <operation-table
    :tableData="tableData"
    :tableColumns="tableColumns"
    @deleterow="onDelete"
    @saverow="onSave">
    <a slot="action" slot-scope="text">action</a>
  </operation-table>
</template>

<script>
import operaionTable from './utils/operationTable'
const columns = [
  { title: '序号', width: 100, dataIndex: 'id', key: 'id', fixed: 'left', scopedSlots: { customRender: 'id' } },
  { title: '公告内容', dataIndex: 'content', key: 'content', width: 150, scopedSlots: { customRender: 'content' } },
  {
    title: '操作',
    key: 'operation',
    fixed: 'right',
    width: 200,
    scopedSlots: { customRender: 'action' }
  }
]
const data1 = []
for (let i = 0; i < 100; i++) {
  data1.push({
    key: i,
    id: `${i}`,
    content: '这是一条公告！！'
  })
}
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
          method: (e) => {

          }
        },
        {
          name: 'view',
          method: (e) => {

          }
        },
        {
          name: 'delete',
          method: (e) => {

          }
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
    this.$axios.get('http://localhost:8080/api/pigeon/govern/findUserByCompanyId?companyId=232b7da9-9582-4')
      .then((res) => {
        console.log(res)
        that.tableData = res.data.data
      })
  }
}
</script>

<style scoped></style>
