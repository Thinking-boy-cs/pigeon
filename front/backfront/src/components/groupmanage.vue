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
  { title: 'id', width: 100, dataIndex: 'id', key: 'id', fixed: 'left',scopedSlots: { customRender: 'id' } },
  { title: 'username', width: 100, dataIndex: 'username', key: 'username', fixed: 'left', scopedSlots: { customRender: 'age' } },
  { title: 'sex', dataIndex: 'sex', key: 'sex', width: 150, scopedSlots: { customRender: 'sex' } },
  { title: 'password', dataIndex: 'password', key: 'password', width: 150, scopedSlots: { customRender: 'password' } },
  { title: 'telephone', dataIndex: 'telNumber', key: 'telNumber', width: 150, scopedSlots: { customRender: 'telNumber' } },
  { title: 'email', dataIndex: 'email', key: 'email', width: 150, scopedSlots: { customRender: 'email' } },
  {
    title: 'Action',
    key: 'operation',
    fixed: 'right',
    width: 100,
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
  }
}
</script>

<style scoped></style>
