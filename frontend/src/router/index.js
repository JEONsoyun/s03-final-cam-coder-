import Vue from 'vue'
import Router from 'vue-router'
//commit test
Vue.use(Router)

import index from '@/pages/index'
import signup_result from '@/pages/signup-result'
import teacher_profile from '@/pages/teacher-profile'
import page from '@/pages/page'

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      component: index
    },
    {
      path: '/signup_result',
      component: signup_result
    },
    {
      path: '/teacher_profile',
      component: teacher_profile
    },
    {
      path: '/page',
      component: page
    },    

  ]
})

router.beforeEach((to, from, next) => {
  window.scrollTo(0, 0)
  next()
})

export default router;