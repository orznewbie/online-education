<template>
  <div>
    <!-- 菜单组件 -->
    <el-menu
      default-active="1"
      class="el-menu-vertical-demo"
    >
      <!-- 子菜单：用户管理 -->
      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>用户统计</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="11" @click="doTeacher">教师统计</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group>
          <el-menu-item index="12" @click="doVip">会员统计</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <!-- 子菜单：商品管理 -->
      <el-submenu index="2">
        <template slot="title">
          <i class="el-icon-menu"></i>
          <span>课程管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="21" @click="doSale">销量统计</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group>
          <el-menu-item index="22" @click="doAddCourse">添加课程</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group>
          <el-menu-item index="23" @click="doUploadVideo">视频上传</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <!-- 子菜单：订单管理 -->
      <el-submenu index="3">
        <template slot="title">
          <i class="el-icon-document"></i>
          <span>订单管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="31">订单管理</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <!-- 子菜单：会员管理 -->
      <el-submenu index="4">
        <template slot="title">
          <i class="el-icon-setting"></i>
          <span>会员管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="41">会员管理</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
    export default {
        data() {
            return {};
        },
        methods: {
            doTeacher() {
                this.$router.push("/admin/tform")
            },
            doVip() {
                this.$router.push("/admin/vform")
            },
            doSale() {
                this.$router.push("/admin/sform")
            },
            doAddCourse() {
                this.$router.push("/admin/addc")
            },
            doUploadVideo() {
                this.$router.push("/admin/uploadv")
            }
        }
    };
</script>

<style scoped>
</style>
