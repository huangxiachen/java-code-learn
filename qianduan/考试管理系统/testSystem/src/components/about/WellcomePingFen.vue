<template>
  <div class="content">
    <div id="pie" :style="{ width: '700px', height: '600px' }"></div>
  </div>
</template>

<script>
export default {
  name: "pingfen",
  data() {
    return {
      msg: "",
    };
  },
  mounted() {
    this.drawPie();
  },
  methods: {
    drawPie() {
      let charts = this.$echarts.init(document.getElementById("pie"));
      charts.setOption({
        title: {
          text: "",
          subtext: "纯属虚构",
          x: "center",
        },
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b} : {c} ({d}%)",
        },
        legend: {
          orient: "vertical",
          bottom: "bottom",
          data: ["非常满意", "比较满意", "很满意", "一般", "满意"],
        },
        series: [
          {
            name: "满意度",
            type: "pie",
            radius: "55%",
            center: ["50%", "60%"],
            data: [
              { value: 335, name: "非常满意" },
              { value: 310, name: "比较满意" },
              { value: 234, name: "很满意" },
              { value: 135, name: "一般" },
              { value: 1548, name: "满意" },
            ],
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: "rgba(0, 0, 0, 0.5)",
              },
            },
          },
        ],
      });
    },
  },
};
</script>



<style>
</style>