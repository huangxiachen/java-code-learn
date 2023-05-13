<template>
  <div>
    <left v-bind:urls="myUrls" />

    <keep-alive>
      <router-view></router-view>
    </keep-alive>
  </div>
</template>

<script>
import Left from "./Left.vue";
export default {
  components: {
    Left,
  },
  data() {
    return {
      myUrls: [
        { url: "/class/makeclass", name: "前端", status: true },
        { url: "/class/makeclass", name: "后端", status: false },
        { url: "/class/makeclass", name: "人工智能开发", status: false },
        { url: "/class/makeclass", name: "UI/UE设计", status: false },
        { url: "/class/makeclass", name: "软件测试", status: false },
      ],
    };
  },
};
</script>

<style src="../assets/css/nomalnize.css"></style>
<style src="../assets/css/home.css" scoped></style>
<style>
</style>
