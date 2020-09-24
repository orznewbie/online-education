import {request} from "./request";

export function queryUser(params) {
  return request({
    url: '/admin/quser',
    method: 'get',
    params: params
  })
}

export function queryUserCnt(params) {
  return request({
    url: '/admin/usercnt',
    method: 'get',
    params: params
  })
}

export function queryCourseCnt(params) {
  return request({
    url: '/common/coursecnt',
    method: 'get'
  })
}

export function queryCourse(params) {
  return request({
    url: '/common/qcourse',
    method: 'get',
    params: params
  })
}

export function addCourse(params) {
  return request({
    url: '/admin/inscourse',
    method: 'post',
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

export function uploadVideo(params) {
  return request({
    url: "/admin/uploadv",
    method: 'post',
    params: params
  })
}
