<template>
  <div class="item-list">
    <Item v-for="video in videos" :key="video.cover" :videoItem="video" @click.native="detail(video.id)"/>
  </div>
</template>

<script>
    import Item from "./Item";
    export default {
        name: "ItemList",
        props:{
            videos:{
                type:Array,
                default() {
                    return []
                }
            }
        },
        components:{
            Item
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
    }
</script>

<style scoped>
  .item-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    background-color: var(--color-background);
    padding: 30px;
  }
</style>
