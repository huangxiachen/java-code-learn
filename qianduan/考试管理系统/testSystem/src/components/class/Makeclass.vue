<template>
  <div>
    <div v-show="isShowDialog" class="dialog">
      <div class="addclass">
        <form action="#" method="post" id="formAdd" onsubmit="return false">
          <h3 >{{dialogTitle}}</h3>

          <div>
            <span>课程名称:</span>
            <input type="text" v-model="stu.name" placeholder="课程名称" />
          </div>
          <div>
            <span>开课时间</span>
            <input type="date" v-model="stu.time" placeholder="开课时间" />
          </div>
          <div>
            <span>教师姓名</span>
            <input type="text" v-model="stu.teacher" placeholder="教师姓名" />
          </div>
          <button id="addBtn" @click="add()">提交</button>
          <button id="addBtn" @click="dialogCancel()">取消</button>
        </form>
      </div>
    </div>

    <div class="content">
      <table class="table table-hover">
        <thead>
          <div class="a">
            <b>HTML&JS+前端</b>
            <button style="margin: 0 5px; padding: 5px 15px" @click="showAdd()">添加课程</button>
          </div>
          <tr>
            <th>课程名称</th>
            <th>时间</th>
            <th>老师</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(item, index) in list" :key="index">
            <td>{{item.name}}</td>
            <td>{{ item.time | dateFormat }}</td>
            <td>{{item.teacher}}</td>
            <td><button @click="remove(item.id)">删除</button></td>
          </tr>
        
        </tbody>
      </table>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      // 用户输入的学生名称

      isAdd: true, //是否是添加
      isShowDialog: false,
      dialogTitle: "",

      updateIdx: 0,
      stu: { name: "", teacher: "", time: ""},

      // nextId 是下一个，可用的 id

      // 学生的列表数据
      list: [
        {
          id: 1,
          name: "JavaScript",
          time: new Date(),
          teacher: "王五"
        },
        {
          id: 2,
          name: "Html",
          time: new Date(),
          teacher: "王五"
        }
      ],
      nextId: 3,
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
      this.dialogTitle = "添加课程";
    },
    showUpdate(item, index) {
      this.isShowDialog = true;
      this.isAdd = false;

      this.dialogTitle = "更新课程";
      this.stu.id = item.id;
      this.stu.name = item.name;
      this.stu.time = item.time;
      this.stu.teacher = item.teacher;
      this.updateIdx = index;
    },
    dialogCancel() {
      this.isShowDialog = false;
      this.stu = { name: "", teacher: "", time: ""}
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
        this.stu ={ name: "", teacher: "", time: ""}
        this.isShowDialog = false
        this.nextId++;
      } else {
        var needUpdate = this.list[this.updateIdx];
        needUpdate.name = this.stu.name;
        needUpdate.time = this.stu.time;
        needUpdate.teacher = this.stu.teacher;
        this.isShowDialog = false
        this.stu = { name: "", teacher: "", time: ""}
      }
    },
  },
};
</script>

<style src="@/assets/css/add.css"scoped></style>
<style src="@/assets/lib/bootstrap.css"></style>
<style src="@/assets/css/nomalnize.css"></style>

<style scoped>
b {
  color: rgb(10, 72, 134);
}

button {
  padding: 5px 10px;
  border-radius: 5px;
}
.a {
  padding: 10px 0;
}
.addclass {
  position: absolute;
}
.dialog {
  z-index: 9999;
  position: fixed; /*DIV悬浮(固定位置)*/
  right: 70%;
  top: 20%;
}
#addBtn{
  margin:  15px;
}

</style>
