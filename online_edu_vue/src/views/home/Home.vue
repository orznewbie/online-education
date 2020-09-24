<template>
  <div>
    <Banner :imgs="imgs"></Banner>
    <div class="title">热门课程</div>
    <ItemList :videos="courses"></ItemList>
  </div>
</template>

<script>
import Banner from './Banner'
import ItemList from '@/components/contents/item/ItemList'
// 导入axios请求函数
import {getBannerData, getTopCourse} from '@/network/common.js'
export default {
  name: "Home",
  components: {
    Banner,
      ItemList
  },
  data() {
    return {
      imgs: [],
      courses: []
    }
  },
  methods: {
      getBanner() {
          getBannerData().then(result => {
              this.imgs = result.data.data
          })
      },
      getCourse() {
          getTopCourse().then(result => {
              this.courses = result.data.data
          })
      }
  },
  created() {
      this.getBanner()
      this.getCourse()
  }
};
</script>

<style lang="css" scoped>
  img {
    width: 100%;
  }
  .title {
    padding-top: 30px;
    text-align: center;
    font: bolder;
    font-size: 40px;
  }
</style>
