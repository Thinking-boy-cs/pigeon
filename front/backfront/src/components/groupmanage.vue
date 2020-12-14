<template> 
<div>
  <operationTable :data1="childData"></operationTable>
</div>
</template>

<script>
import operaionTable from './utils/operationTable'
export default {
  components: {
    operaionTable
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
