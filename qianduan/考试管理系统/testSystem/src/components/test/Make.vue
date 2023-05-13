<template>
  <div>
    <left v-bind:urls="myUrls" />

    <router-view></router-view>
  </div>
</template>
<script>
import Left from "@/components/Left.vue";
export default {
  data() {
    return {
      // 动态生成侧边栏
      myUrls: [
        { url: "/test/maketest", name: "创建考试", status: true },
        { url: "/test/makeExecrise", name: "创建练习", status: false },
        { url: "/test/makeQuestion", name: "创建问卷", status: false },
        { url: "/test/makeTestQuestion", name: "创建试题", status: false },
        { url: "/test/maketest", name: "试卷导入", status: false },
      ],
    };
  },
  components: {
    Left,
  },
};
</script>

<style src="@/assets/css/nomalnize.css"></style>
<style src="@/assets/css/home.css" scoped></style>
<style src="@/assets/lib/bootstrap.css"></style>
<style></style>