<template>
  <div>
    <el-carousel indicator-position="outside" height="500px">
      <el-carousel-item v-for="img in imgs" :key="img.id">
        <img :src="img.url" alt="" @click="detail(img.cid)">
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
  },
  methods: {
      detail(num){
          this.$router.push({
              path: '/coursedetail',
              query: {
                  courseid: num
              }
          })
      },
  }
};
</script>

<style lang="css" scoped>
  img {
    width: 100%
  }
</style>
