import Vue from 'vue'
import VueRouter from 'vue-router'

const PageLost =()=> import('@/components/common/PageLost')
const Home =()=> import('@/views/home/Home')
const Course =()=> import('@/views/course/Course')
const CourseDetail =()=> import('@/views/course/CourseDetail')
const Login =()=> import('@/views/user/Login')
const Register =()=> import('@/views/user/Register')
const Profile =()=> import('@/views/user/Profile')
const Player =()=> import('@/components/common/Player')
const MyCourse =()=> import('@/views/user/MyCourse')
const Vip =()=> import('@/views/user/Vip')
const ModifyPwd =()=> import('@/views/user/ModifyPwd')

Vue.use(VueRouter)

export default new VueRouter({
  linkActiveClass: 'is-active',
  mode: 'history',
  base: '/online_edu/',
  routes: [
    {
      path: '/',
      redirect: '/home',
      meta: {
        noauth: true
      }
    },
    {
      path: "/home",
      component: Home,
      meta: {
        noauth: true
      }
    },
    {
      path: '/login',
      component: Login,
      meta: {
        noauth: true
      }
    },
    {
      path: '/register',
      component: Register,
      meta: {
        noauth: true
      }
    },
    {
      path: '/course',
      component: Course,
      meta: {
        noauth: true
      }
    },
    {
      path: '/profile',
      component: Profile,
      meta: {
        noauth: false
      }
    },
    {
      path: '/coursedetail',
      component: CourseDetail,
      meta: {
        noauth: true
      }
    },
    {
      path: '/mycourse',
      component: MyCourse,
      meta: {
        noauth: false
      }
    },
    {
      path: '/modifypwd',
      component: ModifyPwd,
      meta: {
        noauth: false
      }
    },
    {
      path: '/vip',
      component: Vip,
      meta: {
        noauth: false
      }
    },
    {
      path: '/playv',
      component: Player,
      meta: {
        noauth: true
      }
    },
    {
      path: '*',
      component: PageLost,
      meta: {
        noauth: true
      }
    },
  ]
})


