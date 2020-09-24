<template>
  <div id="app">
    <BaseHeader></BaseHeader>
    <router-view/>
    <BaseFooter></BaseFooter>
  </div>
</template>

<script>
import BaseHeader from "@/components/contents/BaseHeader";
import BaseFooter from "@/components/contents/BaseFooter";
export default {
  name: "App",
  components: {
    BaseHeader,
    BaseFooter
  }
};
</script>

<style>
  @import "./assets/css/global.css";
</style>
