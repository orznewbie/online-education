import axios from 'axios'

export function request(config) {
  const instance = new axios.create({
    baseURL: 'http://localhost:8080/',
    timeout: 5000
  });
  // 请求拦截器
  instance.interceptors.request.use(config => {
    // if (localStorage.getItem('access_token')) {
    //   config.headers.Authorization = localStorage.getItem('access_token')
    // }
    return config;
  }, err => {
    Promise.reject(err)
  })
  // 响应拦截器
  instance.interceptors.response.use(res => {
    return res.data
  }, err => {
    console.log(err)
  })

  return instance(config)
}
