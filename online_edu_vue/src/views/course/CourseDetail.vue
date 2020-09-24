<template>
  <div class="course_detail">
    <div class="title">{{course.title}}</div>
    <div class="foo">{{course.salecnt}}人已报名</div>
    <el-button round class="joinstudy" @click="playVideo">加入学习</el-button>
    <img :src="course.cover" alt="">
    <div class="courseintro">
      <div class="intro_title">课程介绍</div>
      <div class="intro">{{course.intro}}</div>
    </div>
    <div class="intro_title">课程章节</div>
    <TreeData :chapters="chapters" :videos="videos"></TreeData>
  </div>
</template>


<script>
  import TreeData from "@/components/common/TreeData";
  import {getCourse, getcv} from '@/network/common'
  export default {
      name: "CD",
      data() {
          return {
              course: [],
              chapters: [],
              videos: [[]]
          }
      },
      components: {
          TreeData
      },
      methods: {
          getCourseById() {
              let params = {
                  "id": this.$route.query.courseid
              };
              getCourse(params).then(res => {
                  this.course = res.data.data[0]
              })
          },
          playVideo() {
              this.$router.push({
                  path: '/playv',
                  query: {
                      vlink: '//vjs.zencdn.net/v/oceans.mp4'
                  }
              })
          },
          getcoursevideo() {
              let params = {
                  "cid": this.$route.query.courseid
              };
              getcv(params).then(res => {
                  this.chapters = res.data.data.chapterList
                  this.videos = res.data.data.videoList
              })
          }
      },
      created() {
          this.getCourseById()
          this.getcoursevideo()
      }
  }
</script>

<style scoped>
  img {
    width: 100%;
    height: 500px
  }
  .title {
    font: bolder;
    font-size: 30px;
    color: white;
    position: absolute;
    left: 50px;
    top: 150px
  }
  .foo {
    font: bolder;
    font-size: 20px;
    color: white;
    position: absolute;
    left: 50px;
    top:500px
  }
  .intro_title {
    font: bolder;
    font-size: 40px;
    padding-top: 50px;
    text-align: center;
    padding-bottom: 50px;
  }
  .intro {
    text-align: center;
    position: relative;
    padding-left: 100px;
    padding-right: 100px;
  }
  .joinstudy {
    position: absolute;
    right: 50px;
    top: 480px;
  }
</style>
