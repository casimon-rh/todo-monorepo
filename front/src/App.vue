<template lang="pug">
  v-app
    v-app-bar(app color="primary" dark)
      v-toolbar-title Todo App
    v-main
      TodoList
</template>

<script lang="ts">
import Vue from 'vue'
import TodoList from './pages/TodoList.vue'

export default Vue.extend({
  name: 'App',
  components: { TodoList }
})
</script>

<style lang="sass" scoped>
</style>
