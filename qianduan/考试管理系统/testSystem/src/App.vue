<template>
  <div id="app">
    <header>
      <nav>
        <div class="name">
          <em>考试管理系统</em>
        </div>
        <div class="list">
            <router-link to="/home">首页</router-link>
            <router-link to="/class">课程管理</router-link>
            <router-link to="/student">学员管理</router-link>
            <router-link to="/about">数据统计</router-link>
            <router-link to="/community">社区</router-link>
            <router-link to="/login">登录</router-link>
        </div>
      </nav>
    </header>
      <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "App",
}
</script>

<style src="./assets/css/header.css" scoped></style>





