<template lang='pug'>
  v-card.mx-auto.cardspace(max-width='500')
    v-card-title List
    v-card-text
      v-container
        v-list(shaped)
          template(v-for='(item) in items')
            TodoItem(:item='item.description' :done='item.done' :i='item.id')
    v-card-actions
      v-spacer
      v-dialog(v-model='dialog' persistent max-width='600px')
        template(v-slot:activator='{ on, attrs }')
          v-btn(dark text color='primary' v-bind='attrs' v-on='on') New
        v-card
          v-card-title Todo Item
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
  mounted () {
    this.$store.dispatch('getItems')
  },
  computed: {
    items: {
      get () {
        return this.$store.state.items
      },
      set (newitems) {
        this.$store.state.items = newitems
      }
    },
    text: {
      get () {
        return this.$store.state.text
      },
      set (newtext) {
        this.$store.state.text = newtext
      }
    },
    dialog: {
      get () {
        return this.$store.state.dialog
      },
      set (newdialog) {
        this.$store.state.dialog = newdialog
      }
    }
  },
  methods: {
    saveItem () {
      this.$store.dispatch('createItem', this.text)
    },
    cancelItem () {
      this.$store.commit('HIDE_DIALOG')
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
