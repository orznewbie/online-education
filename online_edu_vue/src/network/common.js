import {request} from "./request";

// 请求滚动条数据
export function getBannerData() {
  return request({
    url: '/common/allbanner',
    method: 'get'
  })
}

// 请求推荐课程数据
export function getTopCourse() {
  return request({
    url: '/common/topcourse',
    method: 'get'
  })
}

// 用户登入
export function userLogin(params) {
  return request({
    url: '/common/login',
    method: 'post',
    params: params
  })
}

// 用户注册
export function userRegister(params) {
  return request({
    url: '/common/register',
    method: 'post',
    params: params
  })
}
// 检查id是否存在
export function checkUserId(params) {
  return request({
    url: '/common/checkid',
    method: 'get',
    params: params
  })
}

// 查询课程
export function getCourse(params) {
  return request({
    url: '/common/qcourse',
    method: 'get',
    params: params
  })
}

// 获取课程
export function getCourseCnt(params) {
  return request({
    url: '/common/coursecnt',
    method: 'get',
    params: params
  })
}

// 获取课程章节和视频
export function getcv(params) {
  return request({
    url: '/common/allcv',
    method: 'get',
    params: params
  })
}

// 请求课程类别
export function getCategory() {
  return request({
    url: '/common/ccat',
    method: 'get'
  })
}

