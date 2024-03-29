import Vue from 'vue'
import Router from 'vue-router'
//commit test
Vue.use(Router)

import index from '@/pages/index'
import login from '@/pages/login'
import signup from '@/pages/signup'
import teacherSearch from '@/pages/teacher/search'
import mypage from '@/pages/mypage'
import user from '@/pages/userDetail'
import signupResult from '@/pages/signup-result'
import teacherDetail from '@/pages/teacher/detail'
import like from '@/pages/mypage/student/like'
import messageIndex from '@/pages/mypage/message/index'
import tutoring from '@/pages/mypage/student/tutoring'
import page from '@/pages/page'

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
      path: '/teacher/search',
      component: teacherSearch
    },
    {
      path: '/mypage',
      component: mypage
    },
    {
      path : '/user',
      component : user
    },
    {
      path: '/signupResult',
      component: signupResult
    },
    {
      path: '/teacherDetail',
      component: teacherDetail
    },
    {
      path: '/mypage/student/like',
      component: like
    }, 
    {
      path: '/mypage/student/tutoring',
      component: tutoring
    },  
    {
      path: '/mypage/message',
      component: messageIndex
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