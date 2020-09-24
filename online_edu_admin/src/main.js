import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'

// viedo.js播放器差价
import Video from 'video.js'
import 'video.js/dist/video-js.css'
Vue.prototype.$video = Video
// elementUI
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// 全局css
import '@/assets/css/global.css'
// 导入axios

Vue.use(ElementUI)

const whiteRoute = ['login'];
// 路由守卫
// router.beforeEach((to, from, next) => {
//   // 用户的登入信息保存在磁盘中
//   if (localStorage.getItem('access_token_')) {
//     // 如果用户新开一个窗口isLogin会是false，信息也为空，所以需要重新
//     // LocalStorage中赋值
//     if (store.state.isLogin == false) {
//       store.state.isLogin = true
//       let user = {
//         id: localStorage.getItem('id_'),
//         role: localStorage.getItem('role_'),
//         name: localStorage.getItem('name_'),
//         avatar: localStorage.getItem('avatar_'),
//         email: localStorage.getItem('email_'),
//         intro: localStorage.getItem('intro_'),
//         vip: localStorage.getItem('vip_'),
//         balance: localStorage.getItem('balance_')
//       }
//       store.dispatch('setUserInfo', user)
//     }
//     next()
//   } else if (to.meta.noauth) {
//     next()
//   } else {
//     next('login')
//   }
// })

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
