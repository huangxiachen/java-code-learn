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
        { url: "/wellcome", name: "课程人数统计", status: true },
        { url: "/wellcomePingFen", name: "课程满意度", status: false },
      
      ],
    };
  },


};
</script>

<style>
</style>
