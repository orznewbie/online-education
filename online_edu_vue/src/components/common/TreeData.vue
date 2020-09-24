<template>
  <div class="treedata">
    <el-tree :data="treedata"
             highlight-current
             @node-click="playVideo"></el-tree>
  </div>
</template>

<script>
    export default {
        data() {
            return {
                treedata: [],
            }
        },
        props: {
            chapters: {
                type: Array,
                default() {
                    return []
                }
            },
            videos: {
                type: Array,
                default() {
                    return [[]]
                }
            }
        },
        methods: {
            playVideo() {
                this.$router.push({
                    path: '/playv',
                    query: {
                        vlink: 'https://xenia.oss-cn-shanghai.aliyuncs.com/userdata/video/course_video/video-test-2.mp4'
                    }
                })
            },
            initdata() {
                for (var i = 0; i < this.chapters.length; i++) {
                    let temp = [];
                    for (var j = 0; j < this.videos[i].length; j++) {
                        temp.push({
                            id: j,
                            label: this.videos[i][j].title
                        })
                    }
                    this.treedata.push({
                        id: i*10+j,
                        label: '第'+i+'章 ' + this.chapters[i].title,
                        children: temp
                    })
                }
            }
        },
        watch: {
            'chapters': function () {
               this.initdata()
           }
        }
    };
</script>


<style>
  .treedata {
    position: center;
    padding-left: 50px;
    padding-right: 50px;
  }
</style>
