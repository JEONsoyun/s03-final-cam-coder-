// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

// Library
import axios from 'axios'
import VueAxios from 'vue-axios'
import vuetify from '@/plugins/vuetify'
import 'material-design-icons-iconfont/dist/material-design-icons.css'
import moment from 'moment'
import VueAwesomeSwiper from 'vue-awesome-swiper'
import Swiper from 'swiper';
import lineClamp from 'vue-line-clamp'
import numeral from 'numeral'
import { padStart } from 'lodash'

Vue.use(lineClamp)
Vue.prototype.$numeral = numeral
Vue.prototype._ = {
  padStart
}

// import Swiper styles
import 'swiper/swiper-bundle.css';

// API
import api from './plugins/api'
Vue.prototype.$api = api

import store from './store'

Vue.use(VueAxios, axios)
Vue.prototype.$moment = moment
Vue.use(VueAwesomeSwiper, /* { default options with global component } */)

// utility
Vue.prototype.$validateUrl = (value) => {
  return /^(?:(?:(?:https?|ftp):)?\/\/)(?:\S+(?::\S*)?@)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,})))(?::\d{2,5})?(?:[/?#]\S*)?$/i.test(value);
}

// global variable
Vue.prototype.$teamLogos = {
}

// Layout
// import SMainLayout from './layouts/s-main-layout'

// Vue.component('s-main-layout', SMainLayout)

// Component
// import SButton from './components/common/s-button'

// Vue.component('s-button', SButton)

// HTML 태그 제거용
Vue.filter('striphtml', function (value) {
  var div = document.createElement("div")
  div.innerHTML = value
  var text = div.textContent || div.innerText || ""
  return text
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  store,
  vuetify
})