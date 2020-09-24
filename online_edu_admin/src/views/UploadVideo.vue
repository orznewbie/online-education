<template>
  <div class="uv">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="选择章节">
        <el-select v-model="form.selected_course" placeholder="课程名" @change="getChapters">
          <el-option
            v-for="item in form.courses"
            :key="item.id"
            :label="item.title"
            :value="item.id">
          </el-option>
        </el-select>
        <el-select v-model="form.selected_chapter" placeholder="章节名" @change="getVideos">
          <el-option
            v-for="item in form.chapters"
            :key="item.id"
            :label="item.title"
            :value="item.id">
          </el-option>
        </el-select>
        <el-select placeholder="章节视频">
          <el-option
            v-for="item in form.videos"
            :key="item.id"
            :label="item.title"
            :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="选择视频">
        <el-input v-model="form.title"></el-input>
        <el-upload
          ref="video"
          class="upload-demo"
          drag
          action
          :auto-upload="false"
          :http-request="doUpload"
          multiple>
          <i class="el-icon-upload"></i>
          <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        </el-upload>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">确认上传</el-button>
        <el-button @click="goback">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
    import {uploadV} from '@/utils/oss.js'
    import {getCourse, getChapter, getVideo} from '@/network/common.js'
    import {uploadVideo} from '@/network/admin.js'
    export default {
        data() {
            return {
                form: {
                    courses:[],
                    selected_course: '',
                    chapters:[],
                    selected_chapter: "",
                    videos:[],
                    title: ""
                },
            }
        },
        methods: {
            getCourses() {
                let params = {
                };
                getCourse(params).then(res => {
                    this.form.courses = res.data.data;
                })
            },
            getChapters() {
              let params = {
                  cid: this.form.selected_course
              };
              getChapter(params).then(res => {
                  this.form.chapters = res.data.data
              })
            },
            getVideos() {
                let params = {
                    chid: this.form.selected_chapter
                };
                getVideo(params).then(res => {
                    this.form.videos = res.data.data
                })
            },
            onSubmit() {
                //this.$refs.video.submit();
                let params = {
                    title: this.form.title,
                    url: 'https://xenia.oss-cn-shanghai.aliyuncs.com/userdata/video/course_video/video-test-2.mp4',
                    chid: this.form.selected_chapter,
                };
                uploadVideo(params).then(res => {
                    if (res.data.code == 200) {
                        this.$message({
                            message: "视频创建成功",
                            type: "success",
                            center: true
                        });
                    } else {
                        this.$message({
                            message: "视频创建失败",
                            type: "error",
                            center: true
                        });
                    }
                })
            },
            doUpload(config) {
                uploadV(config.file, 'userdata/video/course_video/')
            },
            goback() {
                this.$router.back(0);
            }
        },
        created() {
            this.getCourses()
        },
        computed: {
            vurl() {
                return this.$store.state.videourl
            }
        }
    }
</script>
