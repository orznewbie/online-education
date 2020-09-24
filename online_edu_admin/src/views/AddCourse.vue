<template>
  <div class="ac">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="课程标题">
        <el-input v-model="form.title"></el-input>
      </el-form-item>
      <el-form-item label="选择种类">
        <el-select v-model="form.category" placeholder="请选择">
          <el-option
            v-for="item in form.categorys"
            :key="item.id"
            :label="item.title"
            :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="课程介绍">
        <el-input type="textarea"  v-model="form.intro"></el-input>
      </el-form-item>
      <el-form-item label="课程价格">
        <el-input v-model="form.price"></el-input>
      </el-form-item>
      <el-form-item label="选择老师">
        <el-select v-model="form.teacher" placeholder="请选择">
          <el-option
            v-for="item in form.teachers"
            :key="item.id"
            :label="item.name"
            :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="课程封面">
        <el-upload
          ref="cover"
          class="upload-demo"
          drag
          action
          :auto-upload="false"
          :http-request="doUpload"
          multiple>
          <i class="el-icon-upload"></i>
          <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
          <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">确认创建</el-button>
        <el-button @click="goback">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
    import {addCourse, queryUser, getCategory} from '@/network/admin'
    import {upload} from '@/utils/oss.js'
    export default {
        data() {
            return {
                form: {
                    title: '',
                    category: '',
                    categorys: [],
                    intro: '',
                    price: 0,
                    teacher: '',
                    teachers: []
                },
            }
        },
        methods: {
            onSubmit() {
              this.$refs.cover.submit();
              let params = {
                  title: this.form.title,
                  cover: 'https://xenia.oss-cn-shanghai.aliyuncs.com/userdata/pic/course_cover/FQ74QR_Az0XCj.jpg',
                  category: this.form.category,
                  intro: this.form.intro,
                  price: this.form.price,
                  tid: this.form.teacher
              };
              addCourse(params).then(res => {
                  if (res.data.code == 200) {
                      this.$message({
                          message: "课程创建成功",
                          type: "success",
                          center: true
                      });
                  } else {
                      this.$message({
                          message: "课程创建失败",
                          type: "error",
                          center: true
                      });
                  }
              })
            },
            doUpload(config) {
                upload(config.file, 'userdata/pic/course_cover/')
            },
            getCategory() {
                getCategory().then(res => {
                    this.form.categorys = res.data.data
                })
            },
            getTeacher() {
                let params = {
                    role: 2
                };
                queryUser(params).then(res => {
                    this.form.teachers = res.data.data
                })
            },
            goback() {
                this.$router.back(0);
            }
        },
        created() {
            this.getCategory();
            this.getTeacher();
        },
        computed: {
            theurl() {
                return this.$store.state.coverurl
            }
        }
    }
</script>
