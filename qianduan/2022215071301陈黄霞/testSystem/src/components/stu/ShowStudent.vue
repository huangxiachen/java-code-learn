<template>
  <div class="content">
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
                      <div class="input-group-text">学生姓名</div>
                    </div>
                    <input
                      type="text"
                      class="form-control"
                      placeholder="请输入学生姓名"
                      v-model="stu.name"
                    />
                  </div>
                </div>
                <div class="col-auto">
                  <div class="input-group mb-2">
                    <div class="input-group-prepend">
                      <div class="input-group-text">学生年龄</div>
                    </div>
                    <input
                      type="number"
                      class="form-control"
                      placeholder="请输入学生年龄"
                      v-model="stu.age"
                    />
                  </div>
                </div>
                <div class="col-auto">
                  <div class="input-group mb-2">
                    <div class="input-group-prepend">
                      <div class="input-group-text">学生班级</div>
                    </div>
                    <input
                      type="text"
                      class="form-control"
                      placeholder="请输入学生班级"
                      v-model="stu.class"
                    />
                  </div>
                </div>
                <div class="col-auto">
                  <div class="input-group mb-2">
                    <div class="input-group-prepend">
                      <div class="input-group-text">学习课程</div>
                    </div>
                    <input
                      type="text"
                      class="form-control"
                      placeholder="请输入学生学习课程"
                      v-model="stu.course"
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

    <div class="card">
      <div class="card-header">添加学生</div>
      <div class="card-body">
        <button type="button" class="btn btn-primary" @click="showAdd()">
          添加学生
        </button>
      </div>
    </div>

    <!-- 表格区域 -->
    <table class="table table-bordered table-hover table-striped">
      <thead>
        <tr>
          <th scope="col">序号</th>
          <th scope="col">学生姓名</th>
          <th scope="col">学生年龄</th>
          <th scope="col">学生班级</th>
          <th scope="col">学习课程</th>
          <th scope="col">加入时间</th>
          <th scope="col">操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item, index) in list" :key="item.id">
          <td>{{ item.id }}</td>
          <td>{{ item.name }}</td>
          <td>{{ item.age }}</td>
          <td>{{ item.class }}</td>
          <td>{{ item.course }}</td>
          <td>{{ item.time | dateFormat }}</td>
          <td>
            <a href="javascript:;" @click="showUpdate(item, index)">更新</a>
            <a href="javascript:;" @click="remove(item.id)">删除</a>
          </td>
        </tr>
      </tbody>
    </table>
    <router-view></router-view>
  </div>
</template>
<script>
import Add from "./Add.vue";
export default {
  components: { Add },
  data() {
    return {
      // 用户输入的学生名称

      isAdd: true, //是否是添加
      isShowDialog: false,
      dialogTitle: "",

      updateIdx: 0,
      stu: { name: "", age: 0, class: "",course: "" },

      // nextId 是下一个，可用的 id

      // 学生的列表数据
      list: [
        { id: 1, name: "小明", age: 18, class: "123", course: "java", time: new Date() },
        { id: 2, name: "小黄", age: 19, class: "123", course: "java", time: new Date() },
        { id: 3, name: "小绿", age: 11, class: "123", course: "java", time: new Date() },
      ],
      nextId: 4,
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
      this.stu.age = item.age;
      this.stu.class = item.class;
       this.stu.course = item.course;
      this.updateIdx = index;
    },
    dialogCancel() {
      this.isShowDialog = false;
      this.stu = {};
    },
    // 阻止表单的默认提交行为之后，触发 add 方法
    add() {
      if (this.isAdd) {
        // 1. 先把要添加的学生对象，整理出来
        this.stu.time = new Date();
        this.stu.id = this.nextId;
        // 2. 往 this.list 数组中 push 步骤 1 中得到的对象
        this.list.push(this.stu);
        // 3. 清空 this.brand；让 this.nextId 自增 +1
        this.stu = { name: "", age: 0, class: "",course: "" }
        this.nextId++;
      } else {
        var needUpdate = this.list[this.updateIdx];
        needUpdate.name = this.stu.name;
        needUpdate.age = this.stu.age;
        needUpdate.class = this.stu.class;
         needUpdate.course = this.stu.course;
        this.stu = { name: "", age: 0, class: "",course: "" }
      }
    },
  },
};
</script>
<style src="@/assets/lib/bootstrap.css" scoped></style>
<style>
.center {
  z-index: 9999;
  position: fixed; /*DIV悬浮(固定位置)*/
  right: 30%;
  top: 20%;
}
table a{
  padding: 0 5px;
}
</style>