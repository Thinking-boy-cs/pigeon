<template> 
  <operation-table :data1="childData"></operation-table>
</template>

<script>
import opertaionTable from './utils/operationTable'
export default {
  components: {
    opertaionTable
  },
  data () {
    return  {
      childData: 'test data'
    }
  }
}
</script>

<sty
    OperationTablele></style>
