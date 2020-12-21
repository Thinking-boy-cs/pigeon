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
  { title: '职员号', width: 200, dataIndex: 'id', key: 'id', fixed: 'left', scopedSlots: { customRender: 'id' } },
  { title: '用户名', width: 100, dataIndex: 'username', key: 'username', fixed: 'left', scopedSlots: { customRender: 'age' } },
  { title: '性别', dataIndex: 'sex', key: 'sex', width: 150, scopedSlots: { customRender: 'sex' } },
  { title: '密码', dataIndex: 'password', key: 'password', width: 150, scopedSlots: { customRender: 'password' } },
  { title: '电话号码', dataIndex: 'telNumber', key: 'telNumber', width: 150, scopedSlots: { customRender: 'telNumber' } },
  { title: '邮箱', dataIndex: 'email', key: 'email', width: 150, scopedSlots: { customRender: 'email' } },
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
