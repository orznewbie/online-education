<template>
  <div class="box">
    <div class="mydata">
      <img src="https:////s2.ax1x.com/2019/04/14/AOaUqs.jpg" alt>
    </div>
    <div class="data-box">
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <h3>修改密码</h3>
        <el-form-item label="原密码  " prop="oldpass">
          <el-input type="password" v-model="ruleForm.oldpass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pass">
          <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="checkPass">
          <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  import {updatePwd} from "@/network/user";

  export default {
        data() {
            var validatePass = (rule, value, callback) => {
                        if (value === '') {
                            callback(new Error('请输入密码'));
                        } else {
                            if (this.ruleForm.checkPass !== '') {
                                this.$refs.ruleForm.validateField('checkPass');
                            }
                            callback();
                }
            };
            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.ruleForm.pass) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            return {
                ruleForm: {
                    oldpass: '',
                    pass: '',
                    checkPass: '',
                },
                rules: {
                    pass: [
                        { validator: validatePass, trigger: 'blur' }
                    ],
                    checkPass: [
                        { validator: validatePass2, trigger: 'blur' }
                    ],
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        let params = {
                            id: this.$store.state.userInfo.id,
                            oldpwd: this.ruleForm.oldpass,
                            newpwd: this.ruleForm.pass
                        };
                        updatePwd(params).then(res => {console.log(res)
                            if (res.data.code == 200) {
                                this.$message({
                                    message: "修改成功",
                                    type: "success",
                                    center: true
                                });
                                this.resetForm('ruleForm')
                            } else {
                                this.$message({
                                    message: "修改失败",
                                    type: "error",
                                    center: true
                                });
                            }
                        })
                    } else {
                        this.$message({
                            message: "输入错误",
                            type: "error",
                            center: true
                        });
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style lang="css" scoped>
  .box {
    position: relative;
    min-height: 710px;
  }
  .mydata {
    position: absolute;
  }

  .mydata img {
    opacity: 0.8;
    width: 100%;
  }
  .data-box {
    margin-top: 80px;
    position: absolute;
    background: white;
    margin-left: 450px;
    padding: 30px;
  }
  .data-box img {
    width: 60px;
  }

  .el-form h3 {
    margin-top: 20px;
    margin-bottom: 20px;
  }
</style>
