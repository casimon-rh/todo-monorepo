<template lang='pug'>
  v-card.mx-auto.cardspace(max-width='500')
    v-card-title List
    v-card-text
      v-container
        v-list(shaped)
          template(v-for='(item) in items')
            TodoItem(:item='item.name' :active='item.active' :i='item.id')
    v-card-actions
      v-spacer
      v-dialog(v-model='dialog' persistent max-width='600px')
        template(v-slot:activator='{ on, attrs }')
          v-btn(dark text color='primary' v-bind='attrs' v-on='on') New
        v-card
          v-card-title
            span.text-h5 Todo Item
          v-card-text
            v-container
              v-text-field(label='Description' required v-model='text')
          v-card-actions
            v-spacer
            v-btn(dark text color='error' @click='cancelItem') Cancel
            v-btn(dark text color='primary' @click='saveItem') Save

</template>

<script lang='ts'>
import Vue from 'vue'
import TodoItem from '../components/TodoItem.vue'
export default Vue.extend({
  name: 'TodoList',
  components: { TodoItem },
  data: () => ({
    dialog: false,
    text: '',
    items: [
      { name: 'Dog Photos', active: true, id: 1 },
      { name: 'Cat Photos', active: false, id: 2 },
      { name: 'Potatoes', active: false, id: 3 },
      { name: 'Carrots', active: false, id: 4 }
    ]
  }),
  methods: {
    saveItem () {
      // eslint-disable-next-line
      console.info(this.text)
      this.dialog = false
      this.text = ''
    },
    cancelItem () {
      this.dialog = false
      this.text = ''
    }
  }
})
</script>

<style lang='sass' scoped>
.v-list
  overflow: auto
  max-height: 300px
.cardspace
  margin-top: 20px
</style>
