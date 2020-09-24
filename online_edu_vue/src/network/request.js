import axios from 'axios'
import router from '@/router'
import store from '@/store'

export function request(config) {
  const instance = new axios.create({
    baseURL: '/api',
    timeout: 5000
  });
  // 请求拦截器，每次向服务器发送请求时携带上token
  instance.interceptors.request.use(config => {
    if (localStorage.getItem('access_token')) {
      config.headers.Authorization = localStorage.getItem('access_token')
    }
    return config
  }, err => {
    return Promise.reject(err)
  })

  // 响应拦截器，每次状态码是否为301检测token是否已经过期
  instance.interceptors.response.use(res => {
    if (res.data.code == 301) {
      store.dispatch("deleteUserInfo");
      localStorage.clear()
      return router.push({
        path:'home'
      })
    }
    return res
  }, err => {
    return Promise.reject(err)
  })

  return instance(config)
}
