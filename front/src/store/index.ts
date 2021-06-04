import axios from 'axios'
import Vue from 'vue'
import Vuex, { Commit } from 'vuex'
import Item from '../classes/Item'
import State from '../classes/State'

Vue.use(Vuex)
const baseurl = 'http://localhost:8081/todo'
const loadItems = async (commit: Commit) => commit('SET_ITEMS', await (await axios.get(baseurl)).data)

export default new Vuex.Store<State>({
  state: {
    items: [],
    dialog: false,
    confirm: false,
    text: ''
  },
  mutations: {
    SET_ITEMS (state, items: Array<Item>) {
      state.items = items
    },
    SHOW_DIALOG (state) {
      state.dialog = true
    },
    HIDE_DIALOG (state) {
      state.dialog = false
      state.text = ''
    },
    SHOW_CONFIRM (state) {
      state.confirm = true
    },
    HIDE_CONFIRM (state) {
      state.confirm = false
    },
    CLEAR_TEXT (state) {
      state.text = ''
    }
  },
  actions: {
    getItems: async ({ commit }) => loadItems(commit),
    markDone: async ({ commit }, id: number) => {
      await axios.post(`${baseurl}/done/${id}`)
      await loadItems(commit)
    },
    markUnDone: async ({ commit }, id: number) => {
      await axios.post(`${baseurl}/undone/${id}`)
      await loadItems(commit)
    },
    deleteItem: async ({ commit }, id: number) => {
      await axios.delete(`${baseurl}/del/${id}`)
      await loadItems(commit)
      commit('HIDE_CONFIRM')
    },
    createItem: async ({ commit }, desc: string) => {
      await axios.post(`${baseurl}/new`, desc, { headers: { 'Content-Type': 'text/plain' } })
      await loadItems(commit)
      commit('HIDE_DIALOG')
    }
  },
  modules: {
  }
})
