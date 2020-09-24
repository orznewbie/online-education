<template>
  <!-- element-ui -->
  <el-container>
    <el-header height="80px">
      <div class="header">
        <div class="nav-left">
          <img src="@/assets/img/student.png" alt>
        </div>
        <div class="nav-center">
          <ul>
            <li v-for="list in headerList" :key="list.id">
              <router-link :to="list.name">{{list.title}}</router-link>
            </li>
          </ul>
        </div>

        <div
          class="nav-right"
          v-if="this.$store.state.isLogin">
          <span class="count" @click="toMyCourse">
            <i class="el-icon-star-off"></i>我的课程
          </span>
          <span class="user" @click="toVip">
            <i class="el-icon-shopping-cart-2"></i>会员中心
          </span>
          <img :src="userInfo.avatar" alt>
          <el-dropdown>
            <span class="el-dropdown-link">
              {{userInfo.name}}<i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item @click.native="toProfile">个人信息</el-dropdown-item>
              <el-dropdown-item @click.native="toModifyPwd">修改密码</el-dropdown-item>
              <el-dropdown-item @click.native="logout">退出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
        <!-- </el-dropdown> -->
        <div class="nav-right" v-else>
          <span @click="loginHander">登录</span>
          |
          <span @click="registerHander">注册</span>
        </div>
      </div>
    </el-header>

  </el-container>
</template>

<script>
    export default {
        name: "BaseHeader",
        data() {
            return {
                headerList: [
                    { id: "1", name: "home", title: "首页" },
                    { id: "2", name: "course", title: "全部课程" },
                ],
            };
        },
        methods: {
            loginHander() {
                this.$router.push({
                    path: '/login'
                });
            },
            registerHander() {
                this.$router.push({
                    path: "/register"
                });
            },
            // 去个人课程界面
            toMyCourse() {
                this.$router.push({
                    path: "/myCourse"
                });
            },
            // 去会员中心
            toVip(){
                this.$router.push({
                    path:'/vip'
                })
            },
            toProfile(){
                this.$router.push({
                    path:'/profile'
                })
            },
            toModifyPwd() {
                this.$router.push({
                    path:'/modifypwd'
                })
            },
            // 退出
            logout() {
                this.$store.dispatch("deleteUserInfo");
                if (!this.$store.state.isRemember) {
                    localStorage.clear();
                }
                this.$router.push({
                    path:'/home'
                })
            },
        },
        computed: {
            userInfo() {
                return this.$store.state.userInfo;
            }
        },
        watch: {
            $route(to, from) {
                // 从登录组件过来的，恢复导航栏显示
                if (from.path == "/login" || from.path =='/register') {
                    document
                        .getElementsByClassName("el-container")[0]
                        .setAttribute("style", "");
                }
            }
        }
    };
</script>

<style lang="css" scoped>
  .el-header {
    border-bottom: #c9c9c9;
    box-shadow: 0 0.5px 0.5px 0 #e3e3e3;
  }
  .header {
    width: 1200px;
    height: 80px;
    line-height: 80px;
    margin: 0 auto;
  }
  .nav-left {
    float: left;
    margin-top: 10px;
  }

  .nav-left img {
    margin-top: 10px;
    width: 40px;
    height: 40px;
  }
  .nav-center {
    float: left;
    margin-left: 100px;
    width: "";
  }
  .nav-center ul {
    overflow: hidden;
  }
  .nav-center ul li {
    float: left;
    margin: 0 5px;
    /*width: 100px;*/
    padding: 0 20px;
    height: 80px;
    line-height: 80px;
    text-align: center;
  }
  .nav-center ul li a {
    color: #4a4a4a;
    width: 100%;
    height: 60px;
    display: inline-block;
  }
  .nav-center ul li a:hover {
    color: #b3b3b3;
  }
  .nav-center ul li a.is-active {
    color: #4a4a4a;
    border-bottom: 4px solid #409eff;
  }
  .nav-right {
    float: right;
    position: relative;
    z-index: 100;
  }
  .nav-right span {
    cursor: pointer;
  }
  .nav-right .user {
    margin-left: 15px;
  }
  .nav-right img {
    width: 26px;
    height: 26px;
    border-radius: 50%;
    display: inline-block;
    vertical-align: middle;
    margin-left: 15px;
  }
  .nav-right ul {
    position: absolute;
    width: 221px;
    z-index: 100;
    font-size: 12px;
    top: 80px;
    background: #fff;
    border-top: 2px solid #d0d0d0;
    box-shadow: 0 2px 4px 0 #e8e8e8;
  }
  .nav-right ul li {
    height: 40px;
    color: #4a4a4a;
    padding-left: 30px;
    padding-right: 20px;
    font-size: 12px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    cursor: pointer;
    transition: all 0.2s linear;
  }
  .nav-right ul li span.msg {
    margin-left: -80px;
    color: red;
  }
  .nav-right ul li span.count {
    margin-left: -100px;
    color: red;
  }
  .el-dropdown-link {
     cursor: pointer;
     color: #4a4a4a;
  }
  .el-icon-arrow-down {
    font-size: 12px;
  }
</style>
