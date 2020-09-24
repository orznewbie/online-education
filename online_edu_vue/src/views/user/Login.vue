<template>
  <div class="box">
    <img src="https://s2.ax1x.com/2019/04/14/AOarGT.jpg" alt>
    <div class="login">
      <div class="login-title">
        <p>在线教育平台</p>
        <br>
        <br>
      </div>
      <div class="login_box">
        <div class="title">
          <span>密码登录</span>
          <span>短信登录</span>
        </div>
        <div class="inp">
          <input v-model="id" type="text" placeholder="用户名" class="user">
          <input v-model="pwd" type="password" class="pwd" placeholder="密码">
          <div class="rember">
            <p @click="rememberMe">
              <el-checkbox>记住密码</el-checkbox>
            </p>
            <p>忘记密码</p>
          </div>
          <button class="login_btn" @click="loginHandler">立即登录</button>
          <p class="go_login">
            没有账号?
            <span @click="toRegister">立即注册</span>
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import {userLogin} from "@/network/common";

  export default {
  name: "Login",
  data() {
    return {
      id: "",
      pwd: "",
      checked: "",
    };
  },

  methods: {
    checkEmptyInput() {
      this.$message({
        message: "账号或密码不能为空",
        type: "error",
        center: true
      });
    },

    loginHandler() {
      if (!this.id || !this.pwd) {
        this.checkEmptyInput();
      } else {
        let params = {
          'id': this.id,
          'pwd': this.pwd,
        };
          userLogin(params).then(res => {
            res = res.data
            if (res.code == 200) {
              localStorage.setItem("access_token", res.data.access_token);
              localStorage.setItem("id", res.data.user.id);
              localStorage.setItem("name", res.data.user.name);
              localStorage.setItem("avatar", res.data.user.avatar);
              localStorage.setItem("email", res.data.user.email);
              localStorage.setItem("intro", res.data.user.intro);
              localStorage.setItem("vip", res.data.user.vip);
              localStorage.setItem("balance", res.data.user.balance);
              localStorage.setItem("role", res.data.user.role);
              this.$router.push({
                path: "/home"
              });
            } else {
              this.$message({
                message: res.msg,
                type: "error",
                center: true
              });
            }
          })
      }
    },

    // 记住密码
    rememberMe() {
      this.$store.dispatch("rememberUserInfo");
    },
    toRegister() {
      this.$router.push({
        path: "register"
      });
    }
  },
  created() {
    // 把顶部的导航栏去掉
    document
      .getElementsByClassName("el-container")[0]
      .setAttribute("style", "display:none");
  }
};
</script>

<style lang="css" scoped>
.box {
  width: 100%;
  position: relative;
}
.box img {
  width: 100%;
}
.box .login {
  position: absolute;
  width: 500px;
  height: 400px;
  top: 50%;
  left: 50%;
  margin-left: -250px;
  margin-top: -300px;
  opacity: 0.9;
}
.login .login-title {
  width: 100%;
  text-align: center;
}
.login-title img {
  width: 190px;
  height: auto;
}
.login-title p {
  font-family: PingFangSC-Regular;
  font-size: 18px;
  color: #fff;
  letter-spacing: 0.29px;
  padding-top: 10px;
}
.login_box {
  width: 400px;
  height: auto;
  background: #fff;
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.5);
  border-radius: 4px;
  margin: 0 auto;
  padding-bottom: 40px;
}
.login_box .title {
  font-size: 20px;
  color: #9b9b9b;
  letter-spacing: 0.32px;
  border-bottom: 1px solid #e6e6e6;
  display: flex;
  justify-content: space-around;
  padding: 50px 60px 0 60px;
  margin-bottom: 20px;
  cursor: pointer;
}
.login_box .title span:nth-of-type(1) {
  color: #4a4a4a;
  border-bottom: 2px solid #00b4e4;
}

.inp {
  width: 350px;
  margin: 0 auto;
}
.inp input {
  border: 0;
  outline: 0;
  width: 100%;
  height: 45px;
  border-radius: 4px;
  border: 1px solid #d9d9d9;
  text-indent: 20px;
  font-size: 14px;
  background: #fff !important;
}
.inp input.user {
  margin-bottom: 16px;
}
.inp .rember {
  display: flex;
  justify-content: space-between;
  align-items: center;
  position: relative;
  margin-top: 10px;
}
.inp .rember p:first-of-type {
  font-size: 12px;
  color: #4a4a4a;
  letter-spacing: 0.19px;
  margin-left: 22px;
  display: -ms-flexbox;
  display: flex;
  -ms-flex-align: center;
  align-items: center;
  /*position: relative;*/
}
.inp .rember p:nth-of-type(2) {
  font-size: 14px;
  color: #9b9b9b;
  letter-spacing: 0.19px;
  cursor: pointer;
}

.inp .rember p span {
  display: inline-block;
  font-size: 12px;
  width: 100px;
  /*position: absolute;*/
  /*left: 20px;*/
}
#geetest {
  margin-top: 20px;
}
.login_btn {
  width: 100%;
  height: 45px;
  background: #00b4e4;
  border-radius: 5px;
  font-size: 16px;
  color: #fff;
  letter-spacing: 0.26px;
  margin-top: 30px;
}
.inp .go_login {
  text-align: center;
  font-size: 14px;
  color: #9b9b9b;
  letter-spacing: 0.26px;
  padding-top: 20px;
}
.inp .go_login span {
  color: #00b4e4;
  cursor: pointer;
}
</style>
