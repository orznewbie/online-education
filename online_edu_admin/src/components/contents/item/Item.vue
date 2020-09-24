<template>
  <div class="item">
    <img :src="videoItem.cover" alt="">
    <div class="video-info">
      <div class="title">{{videoItem.title}}</div>
      <span class="cnt"><span class="el-icon-user"></span>{{videoItem.salecnt}}</span>
      <span class="price"><span class="el-icon-coin"></span>{{videoItem.price}}</span>
    </div>
  </div>

</template>

<script>
    export default {
        name: "Item",
        props:{
            videoItem: {
                type: Object,
                default() {
                    return {}
                }
            }
        },
    }
</script>

<style scoped>
  .item {
    height: 200px;
    padding-bottom: 20px;
    padding-right: 2px;
    position: relative;
    width: 280px;
  }
  .item img {
    width: 100%;
    height: 150px;
    border-radius: 5px;
    border:3px solid var(--color-tint);
  }
  .video-info {
    font-size: 12px;
    position: relative;
    bottom: 5px;
    left: 0;
    right: 0;
    overflow: hidden;

  }
  .video-info .cnt {
    color: var(--color-high-text);
    margin-left: 0px;
    text-align: left;
  }
  .video-info .price {
    color: var(--color-high-text);
    position: absolute;
    right: 5px
  }

  /*.video-info .price::before {*/
  /*  content: '';*/
  /*  position: absolute;*/
  /*  left: -15px;*/
  /*  top: -1px;*/
  /*  width: 14px;*/
  /*  height: 14px;*/
  /*}*/
</style>
