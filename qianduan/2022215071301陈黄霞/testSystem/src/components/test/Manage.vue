<template>
  <div>
    <div class="content">
      <div class="top">
        <span class="info">公告栏</span>
        <router-link to="/test/Maketest">更多>></router-link>
      </div>

      <table>
        <tr>
          <td><router-link to="/test/Maketest"><img src="../../assets/lib/test.png" alt=""> 创建考试</router-link></td>
          <td><router-link to="/test/makeExecrise"><img src="../../assets/lib/excise.png" alt="">创建练习</router-link></td>
          <td><router-link to="/test/makeQuestion"><img src="../../assets/lib/question.png" alt="">创建问卷</router-link></td>
        </tr>
        <tr>
          <td><router-link to="/test/makeTestQuestion"><img src="../../assets/lib/testq.png" alt="">创建试题</router-link></td>
          <td><router-link to="/test/Maketest"><img src="../../assets/lib/shij.png" alt="">试卷导入</router-link></td>
        </tr>
      </table>

      <keep-alive>
        <router-view></router-view>
      </keep-alive>
    </div>
  </div>
</template>
<style src="@/assets/css/home.css"></style>
<style scoped>
.content .top {
  width: 90%;
  height: 50px;
  padding: 10px 5px;
  background: rgb(233, 228, 228);
}
.top > a {
  float: right;
  color: #4caf50;
}
.content .info {
  float: left;
  font-weight: 700;
  font-size: 18px;
}
.content table {
  margin-top: 20px;
  background: rgb(233, 228, 228);
  border-radius: 10px;
}
.content table td{
    width: 180px;
    height: 100px;
    padding: 10px;
   
}
.content table td a{
    display: block;
    width: 180px;
    height: 100px;
    color: #4caf50;
    line-height: 100px;
    text-align: center;
    background: rgb(214, 202, 202);
    border-radius: 10px;
}
.content table td a img{
  
  margin-right: 5px;
}
</style>