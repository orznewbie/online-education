import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'

// elementUI
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// 全局css
import '@/assets/css/global.css'
// 导入axios

Vue.use(ElementUI)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
