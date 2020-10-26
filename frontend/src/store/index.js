import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    ISLOGGEDIN: null,
    USER: {},
    ISSKIP: false,
  },
  mutations: {
    ISLOGGEDIN(state, val) {
      state.ISLOGGEDIN = val
    },
    USER(state, val) {
      state.USER = val
    },
    ISSKIP(state, val) {
      state.ISSKIP = val
    },

  },
  actions: {
  },
  modules: {
  },
  getters: {
    USER(state) {
      return state.USER;
    },
    ISLOGGEDIN(state) {
      return state.ISLOGGEDIN;
    }
  }
})
