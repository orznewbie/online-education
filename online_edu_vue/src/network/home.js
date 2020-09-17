import {request} from "./request";

export function getBannerData() {
  return request({
    url: '/banner/all',
  })
}
