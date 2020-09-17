<template>
  <div class="container">
    <div class="lost-pic">
      <img src="https://s2.ax1x.com/2019/05/12/Ehgt3t.png">
    </div>
    <h3>真不巧，页面走丢了~</h3>
    <h3>
      <el-button type="text" @click="toHome">返回首页</el-button>
      <el-button type="text" @click="toPre">返回上一页</el-button>
    </h3>
  </div>
</template>

<script>
export default {
  name: "PageLost",
  data() {
    return {};
  },
  methods: {
    toHome() {
      this.$router.push({
        name: "Home"
      });
    },
    toPre() {
      this.$router.go(-1);
    }
  }
};
</script>

<style lang="css" scoped>
.container img {
  width: 100%;
}
.lost-pic {
  width: 400px;
  margin: 0 auto;
}
</style>
