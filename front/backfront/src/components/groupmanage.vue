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
  { title: '部门号', width: 200, dataIndex: 'id', key: 'id', fixed: 'left', scopedSlots: { customRender: 'id' } },
  { title: '部门名', width: 200, dataIndex: 'name', key: 'name', scopedSlots: { customRender: 'name' } },
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
    name: `Edrward ${i}`,
    age: 32,
    address: `London Park no. ${i}`
  })
}
export default {
  components: {
    'operation-table': operaionTable
  },
  data () {
    return {
      tableColumns: columns,
      tableData: undefined,
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
      // this.$axios.post('', obj).then((res) => {
      //   console.log(res)
      // })
    }
  },
  created () {
    const that = this
    this.$axios.get('http://localhost:8989/api/pigeon/group/findAllGroup?companyId=232b7da9-9582-4')
      .then((res) => {
        console.log(res)
        that.tableData = res.data.data
      })
  }
}
</script>

<style scoped></style>
