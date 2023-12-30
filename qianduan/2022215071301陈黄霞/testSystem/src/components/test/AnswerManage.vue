<template>
  <div>
    <!-- dialog -->
    <div v-show="isShowDialog" class="center" role="dialog">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title" id="myModalLabel">{{ dialogTitle }}</h4>
          </div>
          <form @submit.prevent="add">
            <div class="modal-body">
              <div class="form-row align-items-center">
                
                <div class="col-auto">
                  <div class="input-group mb-2">
                    <div class="input-group-prepend">
                      <div class="input-group-text">答案</div>
                    </div>
                    <input
                      type="file"
                      class="form-control"
                    />
                  </div>
                </div>
              </div>
            </div>
            <div class="modal-footer">
              <button
                type="button"
                class="btn btn-default"
                data-dismiss="modal"
                @click="dialogCancel()"
              >
                关闭
              </button>
              <button
                type="submit"
                class="btn btn-primary"
                @click="isShowDialog = false"
              >
                提交更改
              </button>
            </div>
          </form>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal -->
    </div>

    <div class="content">
      <div class="card">
        <div class="card-header">答案</div>
        <div class="card-body">
          <div class="form-row align-items-center">
            <div class="col-auto">
              <div class="input-group mb-2">
                <div class="input-group-prepend">
                  <div class="input-group-text">答案名称</div>
                </div>
                <input
                  type="text"
                  class="form-control"
                  placeholder="请输入答案名称"
                  v-model.trim="name"
                />
              </div>
            </div>
            <div class="col-auto">
              <button type="submit"   @click="showAdd()" class="btn btn-primary mb-2">创建</button>
            </div>
          </div>

        </div>
      </div>

      <!-- 表格区域 -->
      <table class="table table-bordered table-hover table-striped">
        <thead>
          <tr>
            <th scope="col">序号</th>
            <th scope="col">答案名称</th>
            <th scope="col">上传状态</th>
            <th scope="col">上传时间</th>

            <th scope="col">操作</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(item, index) in list" :key="index">
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
                  >已上传</label
                >
                <label class="custom-control-label" :for="'cb' + item.id" v-else
                  >未上传</label
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
      isAdd: true, //是否是添加
      isShowDialog: false,
      dialogTitle: "",

      updateIdx: 0,
      stu: { id: 1, name: "", status: false, time: null, num: 0 },

      // 用户输入的考试名称
      name: "",
      // nextId 是下一个，可用的 id
      nextId: 4,
      // 考试的列表数据
      list: [
        { id: 1, name: "JAVA", status: true, time: new Date(), num: 44 },
        { id: 2, name: "JAVAWeb", status: false, time: new Date(), num: 54 },
        { id: 3, name: "JAVAEE", status: true, time: new Date(), num: 64 },
      ],
    };
  },

  methods: {
    // 点击链接，删除对应的学生信息
    remove(id) {
      this.list = this.list.filter((item) => item.id !== id);
      this.nextId--;
    },
    showAdd() {
      this.isAdd = true;
      this.isShowDialog = true;
      this.dialogTitle = "添加学生";
    },
    showUpdate(item, index) {
      this.isShowDialog = true;
      this.isAdd = false;

      this.dialogTitle = "更新学生";
      this.stu.id = item.id;
      this.stu.name = item.name;
      this.stu.time = item.time;
      this.stu.num = item.num;
      this.updateIdx = index;
    },
    dialogCancel() {
      this.isShowDialog = false;
      this.stu = { id: 1, name: "", status: false, time: null, num: 0 };
    },
    // 阻止表单的默认提交行为之后，触发 add 方法
    add() {
      if (this.isAdd) {
        // 1. 先把要添加的学生对象，整理出来
        this.stu.id = this.nextId;
        this.stu.name = this.name;
        this.stu.time = new Date()
        // 2. 往 this.list 数组中 push 步骤 1 中得到的对象
        this.list.push(this.stu);
        // 3. 清空 this.brand；让 this.nextId 自增 +1
        this.stu = { id: 1, name: "", status: false, time: null, num: 0 };
        this.name = ""
        this.nextId++;
      } else {
        var needUpdate = this.list[this.updateIdx];
        needUpdate.name = this.stu.name;
        needUpdate.age = this.stu.age;
        needUpdate.time = this.stu.time;
        needUpdate.num = this.stu.num;
        
        this.stu = { id: 1, name: "", status: false, time: null, num: 0 };
      }
    },
  },
};
</script>

<style src="@/assets/css/nomalnize.css"></style>
<style src="@/assets/css/home.css" scoped></style>
<style src="@/assets/lib/bootstrap.css"></style>
<style scoped>
table {
  text-align: center;
}
.center {
  z-index: 9999;
  position: fixed; /*DIV悬浮(固定位置)*/
  right: 30%;
  top: 20%;
}
</style>