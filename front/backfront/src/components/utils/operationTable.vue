<template>
  <div style="height: 100%">
    <!-- <a-table class="table-container" :columns="columns1" :data-source="data" :scroll="{ x: 1500 }">
        <a slot="action" slot-scope="text">action</a>
    </a-table> -->
    <a-table class="table-container" :columns="tableColumns" :data-source="tableData" :scroll="{ x: 1500 }">
      <template
      v-for="col in tableColumns"
      :slot="col.key"
      slot-scope="text, record, index"
    >
      <div :key="col.key">
        <a-input
          v-if="record.editable"
          style="margin: -5px 0"
          :value="text"
          @change="e => handleChange(e.target.value, record.id, col.key)"
        />
        <template v-else>
          {{ text }}
        </template>
      </div>
    </template>
      <div slot="action" slot-scope="text, record, index">
        <a-popconfirm
          v-if="tableData.length"
          title="Sure to delete?"
          @confirm="deleteRow(record.id)"
        >
          <a href="javascript:;">删除</a>
        </a-popconfirm>
        <div class="editable-row-operations" style="display: inline-block">
          <span v-if="record.editable">
            <a @click="() => save(record.id)">保存</a>
            <a-popconfirm title="Sure to cancel?" @confirm="() => cancel(record.id)">
              <a>取消</a>
            </a-popconfirm>
          </span>
          <span v-else>
            <a :disabled="editingKey !== ''" @click="() => edit(record.id)">编辑</a>
          </span>
        </div>
      </div>
    </a-table>
  </div>
</template>

<script>
const columns = [
  { title: 'Full Name', width: 100, dataIndex: 'name', key: 'name', fixed: 'left', scopedSlots: { customRender: 'name' } },
  { title: 'Age', width: 100, dataIndex: 'age', key: 'age', fixed: 'left', scopedSlots: { customRender: 'age' } },
  { title: 'Column 1', dataIndex: 'address', key: '1', width: 150, scopedSlots: { customRender: '1' } },
  { title: 'Column 2', dataIndex: 'address', key: '2', width: 150, scopedSlots: { customRender: '2' } },
  { title: 'Column 3', dataIndex: 'address', key: '3', width: 150, scopedSlots: { customRender: '3' } },
  { title: 'Column 4', dataIndex: 'address', key: '4', width: 150, scopedSlots: { customRender: '4' } },
  { title: 'Column 5', dataIndex: 'address', key: '5', width: 150, scopedSlots: { customRender: '5' } },
  { title: 'Column 6', dataIndex: 'address', key: '6', width: 150, scopedSlots: { customRender: '6' } },
  { title: 'Column 7', dataIndex: 'address', key: '7', width: 150, scopedSlots: { customRender: '7' } },
  { title: 'Column 8', dataIndex: 'address', key: '8' },
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
  props: {
    tableData: {
      type: Array,
      default: null
    },
    tableColumns: {
      type: Array
    }
  },
  data () {
    // this.cacheData = this.tableData.map(item => ({ ...item }))
    return {
      columns1: columns,
      data: this.tableData,
      editingKey: '',
      cacheData: null
    }
  },
  methods: {
    deleteRow (key) {
      this.$emit('deleterow', key)
    },
    handleChange (value, key, column) {
      if (this.cacheData === null) {
        this.cacheData = this.tableData.map(item => ({ ...item }))
      }
      const newData = [...this.tableData]
      const target = newData.filter(item => key === item.id)[0]
      if (target) {
        target[column] = value
        this.tableData = newData
      }
    },
    edit (key) {
      if (this.cacheData === null) {
        this.cacheData = this.tableData.map(item => ({ ...item }))
      }
      const newData = [...this.tableData]
      const target = newData.filter(item => key === item.id)[0]
      this.editingKey = key
      if (target) {
        target.editable = true
        this.tableData = newData
      }
    },
    save (key) {
      if (this.cacheData === null) {
        this.cacheData = this.tableData.map(item => ({ ...item }))
      }
      const newData = [...this.tableData]
      const newCacheData = [...this.cacheData]
      const target = newData.filter(item => key === item.id)[0]
      const targetCache = newCacheData.filter(item => key === item.id)[0]
      console.log(newCacheData)
      if (target && targetCache) {
        delete target.editable
        this.tableData = newData
        Object.assign(targetCache, target)
        this.cacheData = newCacheData
        console.log('target saved')
      }
      this.editingKey = ''
      console.log(target)
      this.$emit('saverow', target)
    },
    cancel (key) {
      const newData = [...this.tableData]
      const target = newData.filter(item => key === item.id)[0]
      this.editingKey = ''
      if (target) {
        Object.assign(target, this.cacheData.filter(item => key === item.id)[0])
        delete target.editable
        this.tableData = newData
      }
    }
  },
  created () {
    let that = this
    window.tableData = this
    // this.$nextTick(() => {
    //   that.cacheData = that.tableData.map(item => ({ ...item }))
    // })
   
  }
}
</script>

<style scoped>
.table-container {
  height: 100%;
}
/deep/ .ant-table-body{
  height: 100%;
}
</style>
