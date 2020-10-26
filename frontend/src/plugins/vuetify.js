// src/plugins/vuetify.js

import Vue from 'vue'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import ko from 'vuetify/es5/locale/ko'

Vue.use(Vuetify)

const opts = {
  lang: {
    locales: { ko },
    current: 'ko'
  }
}

export default new Vuetify(opts)