<template>
  <div>
    <el-carousel indicator-position="outside" height="500px">
      <el-carousel-item v-for="img in imgs" :key="img.id">
        <a :href="img.link">
          <img :src="img.url" alt="">
        </a>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  name: "Banner",
  props: {
    imgs: {
      type: Array,
      default() {
          return []
      }
    }
  }
};
</script>

<style lang="css" scoped>
  img {
    width: 100%;
  }
</style>
