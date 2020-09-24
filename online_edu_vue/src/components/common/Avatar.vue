<template>
  <div class="ava">
    <el-upload
      ref="avaup"
      class="avatar-uploader"
      action
      :http-request="doUpload"
      :auto-upload="false"
      :show-file-list="false"
      :on-success="handleAvatarSuccess"
      :on-change="modifystatus"
      :before-upload="beforeAvatarUpload">
      <img v-if="imageUrl" :src="imageUrl" class="avatar">
      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
  </div>
</template>

<script>
    import {upload} from '@/utils/oss'
    export default {
        data() {
            return {
                imageUrl: ''
            };
        },
        methods: {
            doUpload(config) {
                upload(config.file, 'userdata/pic/avatar/')
            },
            handleAvatarSuccess() {
                this.$message.success("头像上传成功");
            },
            beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg';
                if (!isJPG) {
                    this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                return isJPG;
            },
            modifystatus(file) {
                this.imageUrl = URL.createObjectURL(file.raw);
            },
            submit() {
                this.$refs.avaup.submit()
            }
        }
    }
</script>


<style>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 50px;
    height: 50px;
    line-height: 50px;
    text-align: center;
  }
  .avatar {
    width: 50px;
    height: 50px;
    display: block;
  }
</style>
