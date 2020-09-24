<template>
  <div class="mycourse">
      {{mycourses}}
  </div>
</template>

<script>
  import {getMyCourseInfo} from '@/network/student'
  export default {
      name: "MyCourse",
      data() {
        return {
            mycourses: []
        }
      },
      methods: {
          getMyCourse() {
              let params = {
                  sid: this.$store.state.userInfo.id
              };
              getMyCourseInfo(params).then(res => {
                  console.log(res.data)
                  this.mycourses = res.data.data
              })
          }
      },
      created() {
          this.getMyCourse()
      }
  }
</script>

<style lang="css" scoped>

</style>
