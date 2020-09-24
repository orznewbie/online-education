<template>
  <div class="box">
    <div class="mydata">
      <img src="https:////s2.ax1x.com/2019/04/14/AOaUqs.jpg" alt>
    </div>
    <div class="data-box">
      <el-form ref="form" :model="form" label-width="80px" v-model="labelPosition">
        <h3>我的资料</h3>
        <el-form-item label="姓名">
          <el-input type="name" :placeholder="userInfo.name" v-model="form.name" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="头像">
          <Avatar ref="child"></Avatar>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input type="email" :placeholder="userInfo.email" v-model="form.email" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="会员">
          <span>{{userInfo.vip == 1?"是":"否"}}</span>
        </el-form-item>
        <el-form-item label="账户余额">
          <span>￥{{userInfo.balance}}</span>
        </el-form-item>
        <el-form-item label="自我介绍">
          <el-input type="textarea" :placeholder="userInfo.intro" v-model="form.intro"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">保存</el-button>
          <el-button @click="goback">取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
    import Avatar from "@/components/common/Avatar";
    import {modifyProfile} from '@/network/user'
    import store from '@/store'
    export default {
        name: "Profile",
        data() {
            return {
                form: {
                    name: "",
                    email: "",
                    intro: "",
                },
                labelPosition: "right",
            };
        },
        components: {
            Avatar
        },
        methods: {
            onSubmit() {
                this.$refs.child.submit()
                localStorage.name = this.form.name;
                localStorage.email = this.form.email;
                localStorage.intro = this.form.intro;
                let params = {
                    id: localStorage.id,
                    role: localStorage.role,
                    name: localStorage.name,
                    avatar: localStorage.avatar,
                    email: localStorage.email,
                    intro: localStorage.intro,
                    vip: localStorage.vip,
                    balance: localStorage.balance,
                };
                store.dispatch('setUserInfo', params)
                modifyProfile(params).then(res => {
                    if (res.data.code == 200) {
                        this.$message({
                            message: "信息修改成功",
                            type: "success",
                            center: true
                        });
                    } else {
                        this.$message({
                            message: "修改失败",
                            type: "error",
                            center: true
                        });
                    }
                })
            },
            goback() {
                this.$router.back(0)
            }
        },
        computed: {
            userInfo() {
                return this.$store.state.userInfo;
            }
        },
    };
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
