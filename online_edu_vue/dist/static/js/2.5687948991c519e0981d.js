webpackJsonp([2],{"42Dr":function(e,t){},KQvT:function(e,t,s){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a={name:"Login",data:function(){return{username:"",password:"",checked:"",validateResult:{}}},methods:{open3:function(){this.$message({message:"请先点击验证按钮进行验证",type:"warning",center:!0})},open4:function(){this.$message({message:"请先输入账号密码",type:"error",center:!0})},loginHandler:function(){var e=this;if(this.validateResult.geetest_challenge)if(this.username||this.password){var t={username:this.username,passwd:this.password,geetest_challenge:this.validateResult.geetest_challenge,geetest_validate:this.validateResult.geetest_validate,geetest_seccode:this.validateResult.geetest_seccode};this.$http.login(t).then(function(t){t.error?e.$message({message:"登录失败，请重试",type:"error",center:!0}):(localStorage.setItem("access_token",t.data.access_token),localStorage.setItem("username",t.data.username),localStorage.setItem("avatar",t.data.avatar),localStorage.setItem("shop_cart_num",t.data.shop_cart_num),localStorage.setItem("balance",t.data.balance),e.$store.dispatch("getUserInfo",t.data),e.$router.push({name:"Home"}))}).catch(function(e){console.log(e)})}else this.open4();else this.open3()},rememberMe:function(){this.$store.dispatch("rememberUserInfo")},getGeetest:function(){var e=this;this.$http.geetest().then(function(t){var s=t;initGeetest({gt:s.gt,challenge:s.challenge,offline:!s.success,new_captcha:!0,product:"popup",width:"100%"},function(t){t.appendTo("#geetest"),t.onReady(function(){}).onSuccess(function(){var s=t.getValidate();e.validateResult=s}).onError(function(){})})}).catch(function(e){console.log(e)})},toRegister:function(){this.$router.push({name:"Register"})}},created:function(){this.getGeetest()},mounted:function(){document.getElementsByClassName("el-container")[0].setAttribute("style","display:none")}},n={render:function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"box"},[s("img",{attrs:{src:"https://s2.ax1x.com/2019/04/14/AOarGT.jpg",alt:""}}),e._v(" "),s("el-button",{attrs:{plain:!0},on:{click:e.open3}}),e._v(" "),s("el-button",{attrs:{plain:!0},on:{click:e.open4}}),e._v(" "),s("div",{staticClass:"login"},[e._m(0),e._v(" "),s("div",{staticClass:"login_box"},[e._m(1),e._v(" "),s("div",{staticClass:"inp"},[s("input",{directives:[{name:"model",rawName:"v-model",value:e.username,expression:"username"}],staticClass:"user",attrs:{type:"text",placeholder:"用户名"},domProps:{value:e.username},on:{input:function(t){t.target.composing||(e.username=t.target.value)}}}),e._v(" "),s("input",{directives:[{name:"model",rawName:"v-model",value:e.password,expression:"password"}],staticClass:"pwd",attrs:{type:"password",name:"",placeholder:"密码"},domProps:{value:e.password},on:{input:function(t){t.target.composing||(e.password=t.target.value)}}}),e._v(" "),s("div",{attrs:{id:"geetest"}}),e._v(" "),s("div",{staticClass:"rember"},[s("p",{on:{click:e.rememberMe}},[s("el-checkbox",[e._v("记住密码")])],1),e._v(" "),s("p",[e._v("忘记密码")])]),e._v(" "),s("button",{staticClass:"login_btn",on:{click:e.loginHandler}},[e._v("立即登录")]),e._v(" "),s("p",{staticClass:"go_login"},[e._v("\n          没有账号?\n          "),s("span",{on:{click:e.toRegister}},[e._v("立即注册")])])])])])],1)},staticRenderFns:[function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"login-title"},[t("p",[this._v("机会永远只留给有准备的人")]),this._v(" "),t("br"),this._v(" "),t("br")])},function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"title"},[t("span",[this._v("密码登录")]),this._v(" "),t("span",[this._v("短信登录")])])}]};var i=s("VU/8")(a,n,!1,function(e){s("42Dr")},"data-v-1bafc4fb",null);t.default=i.exports}});
//# sourceMappingURL=2.5687948991c519e0981d.js.map