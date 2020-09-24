import Vue from 'vue'
import VueRouter from 'vue-router'

const Home =()=> import('@/views/Home')
const Login =()=> import('@/views/Login')
const TeacherForm =()=> import('@/views/TeacherForm')
const VipForm =()=> import('@/views/VipForm')
const SaleForm =()=> import('@/views/SaleForm')
const AddCourse =()=> import('@/views/AddCourse')
const UploadVideo =()=> import('@/views/UploadVideo')

Vue.use(VueRouter)

export default new VueRouter({
  linkActiveClass: 'is-active',
  mode: 'history',
  base: '/online_edu/',
  routes: [
    {
      path: '/',
      redirect: '/login',
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
      path: "/admin",
      component: Home,
      children: [
        {path: 'tform', component: TeacherForm},
        {path: 'vform', component: VipForm},
        {path: 'sform', component: SaleForm},
        {path: 'addc', component: AddCourse},
        {path: 'uploadv', component: UploadVideo}
      ],
      meta: {
        noauth: true
      }
    },
    // {
    //   path: '*',
    //   component: PageLost,
    //   meta: {
    //     noauth: true
    //   }
    // },
  ]
})


