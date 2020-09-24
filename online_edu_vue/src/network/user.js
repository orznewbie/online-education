import {request} from "./request";

// 修改密码
export function updatePwd(params) {
  return request({
    url: '/user/updp',
    method: 'put',
    params: params
  })
}

// 修改个人信息
export function modifyProfile(params) {
  return request({
    url: '/user/upduser',
    method: 'put',
    params: params
  })
}


