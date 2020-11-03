import Vue from 'vue'
import Router from 'vue-router'
//commit test
Vue.use(Router)

import index from '@/pages/index'
import login from '@/pages/login'
import signup from '@/pages/signup'
import user from '@/pages/userDetail'
import teacherSearch from '@/pages/teacher/search' 
import teacherDetail from '@/pages/teacher/detail'

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      component: index
    },
    {
      path: '/login',
      component: login
    },
    {
      path: '/signup',
      component: signup
    },
    {
      path : '/user',
      component : user
    },
    {
      path : '/teacher/search',
      component : teacherSearch
    },
    {
      path : '/teacher/detail/:id',
      component : teacherDetail
    }
  ]
})

router.beforeEach((to, from, next) => {
  window.scrollTo(0, 0)
  next()
})

export default router;