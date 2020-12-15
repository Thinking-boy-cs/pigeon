<template> 
  <operation-table :data1="childData"></operation-table>
</template>

<script>
import operaionTable from './utils/operationTable'
export default {
  components: {
    'operation-table': operaionTable
  },
  data () {
    return  {
      childData: 'test data'
    }
  }
}
</script>

<style scoped>

</style>
