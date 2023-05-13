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
        { url: "/stu/clazz", name: "班级管理", status: true },
        { url: "/stu/list", name: "学生信息", status: false },
      ],
    };
  },
};
</script>

<style src="../assets/css/nomalnize.css"></style>
<style src="../assets/css/home.css" scop></style>
<style>
</style>
