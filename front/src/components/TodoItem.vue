<template lang='pug'>
  v-list-item(:key='`item-${i}`' :value='item')
    v-list-item-content
      v-list-item-title(v-text='item')
    v-checkbox(:input-value='active' color='primary accent-4')
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
  props: ['item', 'active', 'i'],
  data: () => ({
    confirm: false
  }),
  methods: {
    deleteItem (id: number) {
      // eslint-disable-next-line
      console.info(id)
      this.confirm = false
    },
    cancelItem () {
      this.confirm = false
    }
  }
})
</script>

<style lang='sass' scoped>
</style>
