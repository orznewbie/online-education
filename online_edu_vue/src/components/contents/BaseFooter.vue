<template>
  <div class="footer" id="footer">
    <div class="w1200">
      <p>
        作者邮箱:
        <a href="orznewbie@gmail.com">orznewbie@gmail.com</a><br>
      <p>
        <img src="#" alt>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "BaseFooter",
  data() {
    return {};
  },
};
</script>

<style lang="css" scoped>
.footer {
  width: 100%;
  height: 120px;
  padding: 35px 0;
  background: #2e3137;
}
.w1200 {
  margin: 0 auto;
  width: 1200px;
  overflow: hidden;
  position: relative;
}
a {
  color: #409eff
}
.footer p {
  color: #999;
  text-align: center;
  line-height: 24px;
}
.footer img {
  width: auto;
  height: auto;
  vertical-align: middle;
}
img {
  width: 100%;
  height: 100%;
}
</style>
