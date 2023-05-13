<template>
  <div>
    <nav>
      <ul>
        <li  v-on:click="light(index)" v-for="(item, index) in routerList" :key="index">
          <router-link
            v-bind:to="item.url"
            v-bind:class="{ active: item.status }"
            >{{ item.name }}</router-link
          >
        </li>
      </ul>
    </nav>
    
  </div>
</template>

<script>
export default {
  name: "Left",
  props: ["urls"],
  data() {
    return {
      // routerList: this.urls,
      // routerList:[]
    };
  },
  watch: {
    $route: {
      handler: function (val, oldVal) {
        console.log(val + "to");
      },
      // 深度观察监听
      deep: true,
    },
  },
  methods: {
      light(index){
        this.routerList.forEach(element => {
            element.status = false
        });
         this.routerList[index].status = true
      }
  },
};
</script>
<style></style>