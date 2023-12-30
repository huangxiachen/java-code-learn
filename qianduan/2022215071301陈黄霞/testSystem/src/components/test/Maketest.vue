<template>
  <div>
    <!-- <left v-bind:urls="myUrls" /> -->
    <div class="content">
      <div class="card">
        <div class="card-header">创建考试</div>
        <div class="card-body">
          <form @submit.prevent="add">
            <div class="form-row align-items-center">
              <div class="col-auto">
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                    <div class="input-group-text">考试名称</div>
                  </div>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="请输入考试名称"
                    v-model.trim="brand"
                  />
                </div>
              </div>
              <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-2">添加</button>
              </div>
            </div>
          </form>
        </div>
      </div>

      <!-- 表格区域 -->
      <table class="table table-bordered table-hover table-striped">
        <thead>
          <tr>
            <th scope="col">序号</th>
            <th scope="col">考试名称</th>
            <th scope="col">考试状态</th>
            <th scope="col">创建时间</th>
            <th scope="col">操作</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in list" :key="item.id">
            <td>{{ item.id }}</td>
            <td>{{ item.name }}</td>
            <td>
              <div class="custom-control custom-switch">
                <!-- 使用 v-model 实现双向数据绑定 -->
                <input
                  type="checkbox"
                  class="custom-control-input"
                  :id="'cb' + item.id"
                  v-model="item.status"
                />
                <!-- 使用 v-if 结合 v-else 实现按需渲染 -->
                <label
                  class="custom-control-label"
                  :for="'cb' + item.id"
                  v-if="item.status"
                  >已开始</label
                >
                <label class="custom-control-label" :for="'cb' + item.id" v-else
                  >未开始</label
                >
              </div>
            </td>
            <td>{{ item.time | dateFormat }}</td>
            <td>
              <a href="javascript:;" @click="remove(item.id)">删除</a>
            </td>
          </tr>
        </tbody>
      </table>
      <router-view></router-view>
    </div>
  </div>
</template>




<script>

export default {
  data() {
    return {
     
      brand: "",
      // nextId 是下一个，可用的 id
      nextId: 4,
      // 考试的列表数据
      list: [
        { id: 1, name: "JAVA", status: true, time: new Date() },
        { id: 2, name: "JAVAWeb", status: false, time: new Date() },
        { id: 3, name: "JAVAEE", status: true, time: new Date() },
      ],
    };
  },
  

  methods: {
    // 点击链接，删除对应的考试信息
    remove(id) {
      this.list = this.list.filter((item) => item.id !== id);
    },
    // 阻止表单的默认提交行为之后，触发 add 方法
    add() {
      // 如果判断到 brand 的值为空字符串，则 return 出去
      if (this.brand === "") return alert("必须填写考试名称！");
      // 如果没有被 return 出去，应该执行添加的逻辑
      // 1. 先把要添加的考试对象，整理出来
      const obj = {
        id: this.nextId,
        name: this.brand,
        status: true,
        time: new Date(),
      };
      // 2. 往 this.list 数组中 push 步骤 1 中得到的对象
      this.list.push(obj);
      // 3. 清空 this.brand；让 this.nextId 自增 +1
      this.brand = "";
      this.nextId++;
    },
  },
};
</script>

<style src="@/assets/css/nomalnize.css"></style>
<style src="@/assets/css/home.css" scoped></style>
<style src="@/assets/lib/bootstrap.css"></style>
<style>

</style>