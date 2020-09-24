import {request} from "./request";

// 查询已买课程
export function getMyCourseInfo(params) {
  return request({
    url: "/stu/qcourse",
    method: "get",
    params: params
  })
}

// 购买课程
export function buyCourse() {
  return request({
    url: "",
    method: "post"
  })
}
