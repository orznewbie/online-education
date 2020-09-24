// 导入ali-oss
import OSS from 'ali-oss';
import store from '@/store'

const region = 'oss-cn-shanghai';  // 换成自己的region
const accessKeyId = 'LTAI4GE6yqPinirwBQbUGH2V';  // 换成自己的accessKeyId
const accessKeySecret = '05XF9qaadW7E0QC0s311MCHaA4lwSQ';  // 换成自己的accessKeySecret
const bucket = "xenia";  // 换成自己的bucket

let client = new OSS({
  region : region,
  accessKeyId : accessKeyId,
  accessKeySecret : accessKeySecret,
  bucket : bucket
});

/**
 *
 * @param {上传是设置文件key , 一般为文件名称} objectKey
 * @param {文件file} file
 */

//  上传
export async function upload(file, dir) {
  let ramdom_filename = `${dir}${random_string(6)}_${file.name}`;
  client.multipartUpload(ramdom_filename, file).then(res =>{
    store.dispatch("setCoverUrl", res.res.requestUrls[0]);
    store.coverurl = res.res.requestUrls[0];
  })
}

export async function uploadV(file, dir) {
  let ramdom_filename = `${dir}${random_string(6)}_${file.name}`;
  client.multipartUpload(ramdom_filename, file).then(res =>{
    store.videourl = res.res.requestUrls[0];
  })
}

// 下载
export function downloadFile(key) {
}

// 随机字符串
function random_string(len) {
  len = len || 32
  var chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678'
  var maxPos = chars.length
  var pwd = ''
  for (let i = 0; i < len; i++) {
    pwd += chars.charAt(Math.floor(Math.random() * maxPos))
  }
  return pwd
}


