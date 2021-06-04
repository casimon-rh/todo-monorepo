<template lang='pug'>
  v-list-item(:key='`item-${i}`' :value='item')
    v-list-item-content
      v-list-item-title(v-text='item')
    v-checkbox(color='primary accent-4' :input-value='done' @click="toggleMarkItem(i, done)")
    v-dialog(v-model='confirm' persistent max-width='600px')
      template(v-slot:activator='{ on, attrs }')
        v-btn(dark icon color="error" v-bind='attrs' v-on='on')
          v-icon mdi-delete
      v-card
        v-card-title Are you sure you want to delete {{ item }}?
        v-card-actions
          v-spacer
          v-btn(dark text color='error' @click='cancelItem') No
          v-btn(dark text color='primary' @click='deleteItem(i)') Yes

</template>

<script lang='ts'>
import Vue from 'vue'
export default Vue.extend({
  name: 'TodoItem',
  props: ['item', 'done', 'i'],
  computed: {
    confirm: {
      get () {
        return this.$store.state.confirm
      },
      set (newComp) {
        this.$store.state.confirm = newComp
      }
    }
  },
  methods: {
    deleteItem (id: number) {
      this.$store.dispatch('deleteItem', id)
    },
    cancelItem () {
      this.$store.commit('HIDE_CONFIRM')
    },
    toggleMarkItem (id: number, active: boolean) {
      this.$store.dispatch(active ? 'markUnDone' : 'markDone', id)
    }
  }
})
</script>

<style lang='sass' scoped>
</style>
