<template>
  <div class="content">
    <div id="myChart" :style="{ width: '700px', height: '700px' }"></div>
  </div>
</template>

<script>
export default {
  name: "wellcome",
  data() {
    return {
      msg: "",
    };
  },
  mounted() {
    this.drawLine();
  },
  methods: {
    drawLine() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById("myChart"));
      // 绘制图表
      myChart.setOption({
        title: { text: "" },
        tooltip: {},
        xAxis: {
          data: ["JAVA", "JAVAEE", "HTML$CSS", "Jquary", "C语言", "Pathon数据可视化"],
        },
        yAxis: {},
        series: [
          {
            name: "人数",
            type: "bar",
            data: [35, 70, 105, 140, 175, 205],
          },
        ],
      });
    },
  },
};
</script>



<style>
</style>