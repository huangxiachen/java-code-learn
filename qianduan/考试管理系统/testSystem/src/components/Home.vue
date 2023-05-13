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
        {url: "/test/manage", name: "首页", status: true },
        { url: "/test/Maketest", name: "考试管理", status: false },
        { url: "/class", name: "课程管理", status: false },
        { url: "/student", name: "学员管理", status: false },
        { url: "/test/makeup", name: "补考管理", status: false },
        { url: "/test/answerManage", name: "答案管理", status: false },
      ],
    };
  },
};
</script>


<style src="@/assets/css/nomalnize.css"></style>
<style src="@/assets/css/home.css" scoped></style>
<style>
</style>
