<template>
  <div> {{data1}} </div>
</template>

<script>
export default {
  name: 'operation-table',
  props: {
    data1: {
      type: String,
      default: 'null !',
      require: true
    }
  },
  data () {
    return {

    }
  }
}
</script>

<style>

</style>
