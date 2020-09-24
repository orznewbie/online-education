import Vuex from 'vuex'
import Vue from 'vue'

Vue.use(Vuex);

const store = new Vuex.Store({
  state:{
    userInfo:{},
    isLogin:false,
    rememberMe:false
  },
  mutations:{
    setUserInfo(state,user){
      state.userInfo = user
    },

    deleteUserInfo(state){
      state.userInfo = {}
      state.isLogin = false
    },

    setRememberMe(state){
      state.rememberMe = true
    },

    setLogin(state){
      state.isLogin = true
    }
  },
  actions:{
    setUserInfo({commit},user){
      commit('setUserInfo',user)
    },
    deleteUserInfo({commit}){
      commit('deleteUserInfo')
    },
    setRememberMe({commit}){
      commit('setRememberMe')
    },
    setLogin({commit}){
      commit('setLogin')
    }
  }
})
export default store;


