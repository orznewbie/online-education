<template>
  <div>
    <Banner :imgs="imgs"></Banner>
    <TopCourse></TopCourse>
  </div>
</template>

<script>
import Banner from './Banner'
import TopCourse from './TopCourse'
// 导入axios请求函数
import {getBannerData} from '@/network/home.js'
export default {
  name: "Home",
  components: {
    Banner,
    TopCourse
  },
  data() {
    return {
      imgs: []
    }
  },
  mounted() {
    getBannerData().then(result => {
      this.imgs = result.data
    })
  }
};
</script>

<style lang="css" scoped>
  img {
    width: 100%;
  }
</style>
