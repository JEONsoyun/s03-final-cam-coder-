import Vue from 'vue'
import Router from 'vue-router'
//commit test
Vue.use(Router)

import index from '@/pages/index'
import login from '@/pages/login'
import signup from '@/pages/signup'

import teacherSearch from '@/pages/teacher/search' 
import teacherDetail from '@/pages/teacher/detail'
import sendMessage from '@/pages/teacher/send-message'

import mypageEdit from '@/pages/mypage/edit'
import mypageMessageIndex from '@/pages/mypage/message/index'
import mypageMessageDetail from '@/pages/mypage/message/detail'
import mypageStudent from '@/pages/mypage/student/index'
import mypageStudentLike from '@/pages/mypage/student/like'
import mypageStudentTutoring from '@/pages/mypage/student/tutoring'
import mypageTeacher from '@/pages/mypage/teacher/index'
import mypageTeacherTutoring from '@/pages/mypage/teacher/tutoring'
import mypageTeacherEdit from '@/pages/mypage/teacher/edit'


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

    // {
    //   path : '/user',
    //   component : user
    // },
    {
      path: '/teacher/search',
      component: teacherSearch
    },
    {
      path : '/teacher/detail/:id',
      component : teacherDetail
    },
    {
      path : '/teacher/send-message/:userid',
      component : sendMessage
    },
    {
      path : '/mypage/student',
      component : mypageStudent
    },
    {
      path: '/mypage/teacher',
      component: mypageTeacher
    },
    {
      path : '/mypage/edit',
      component : mypageEdit
    },
    {
      path : '/mypage/message',
      component : mypageMessageIndex
    },
    {
      path : '/mypage/message/:usercode',
      component : mypageMessageDetail
    },
    {
      path : '/mypage/student/tutoring',
      component : mypageStudentTutoring
    },
    {
      path : '/mypage/student/like',
      component : mypageStudentLike
    },
    {
      path : '/mypage/teacher/tutoring',
      component : mypageTeacherTutoring
    },
    {
      path : '/mypage/teacher/edit',
      component : mypageTeacherEdit
    },
  ]
})

router.beforeEach((to, from, next) => {
  window.scrollTo(0, 0)
  next()
})

export default router;