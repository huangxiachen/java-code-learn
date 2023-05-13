import Vue from 'vue'
import App from './App.vue'
// 引入VueRouter
import VueRouter from 'vue-router'
// 引入路由器
import router from './router/index.js'
import dayjs from './assets/lib/dayjs.min.js'
// 引入图表
import echarts from 'echarts'
Vue.prototype.$echarts = echarts 

Vue.config.productionTip = false

// 应用插件
Vue.use(VueRouter)

// 声明格式化时间的全局过滤器
Vue.filter("dateFormat", function (time) {
  // 1. 对 time 进行格式化处理，得到 YYYY-MM-DD HH:mm:ss
  // 2. 把 格式化的结果，return 出去

  // 直接调用 dayjs() 得到的是当前时间
  // dayjs(给定的日期时间) 得到指定的日期
  const dtStr = dayjs(time).format("YYYY-MM-DD HH:mm:ss");
  return dtStr;
});

// 挂载路由
new Vue({
  el: '#app',
  render: h => h(App),
  router: router
}).$mount('#app')
