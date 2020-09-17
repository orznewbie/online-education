import Vue from 'vue'
import VueRouter from 'vue-router'

const PageLost =()=> import('@/components/common/PageLost')
const Home =()=> import('@/components/home/Home')
const Login =()=> import('@/components/user/Login')
const Register =()=> import('@/components/user/Register')

Vue.use(VueRouter)

export default new VueRouter({
  linkActiveClass: 'is-active',
  mode: 'history',
  base: '/online_edu/',
  routes: [
    {
      path: '/',
      redirect: '/home'
    },
    {
      path: "/home",
      component: Home
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/register',
      component: Register
    },
    {
      path: '*',
      component: PageLost
    }
  ]
})
