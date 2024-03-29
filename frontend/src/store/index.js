import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    ISLOGGEDIN: null,
    USER: {},
    ISSKIP: false,
    AUTHTOKEN:null,
    config : {
      headers: { Authorization:null}
   },
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
    SET_AUTHTOKEN(state, val) {
      state.AUTHTOKEN = val,
      state.config.headers.Authorization = `Bearer `+val
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
    },
    AUTHTOKEN(state) {
      return state.AUTHTOKEN;
    },
  }
})
