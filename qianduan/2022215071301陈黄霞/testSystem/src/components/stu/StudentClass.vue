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
                      <div class="input-group-text">班级名称</div>
                    </div>
                    <input
                      type="text"
                      class="form-control"
                      placeholder="请输入班级名称"
                      v-model="clazz.name"
                    />
                  </div>
                </div>
                <div class="col-auto">
                  <div class="input-group mb-2">
                    <div class="input-group-prepend">
                      <div class="input-group-text">班级人数</div>
                    </div>
                    <input
                      type="number"
                      class="form-control"
                      placeholder="请输入班级人数"
                      v-model="clazz.num"
                    />
                  </div>
                </div>
                <div class="col-auto">
                  <div class="input-group mb-2">
                    <div class="input-group-prepend">
                      <div class="input-group-text">开班时间</div>
                    </div>
                    <input
                      type="date"
                      class="form-control"
                      placeholder="请输入开班时间"
                      v-model="clazz.time"
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
      <div class="card-header">添加班级</div>
      <div class="card-body">
        <button type="button" class="btn btn-primary" @click="showAdd()">
          添加班级
        </button>
      </div>
    </div>

    <!-- 表格区域 -->
    <table class="table table-bordered table-hover table-striped">
      <thead>
        <tr>
          <th scope="col">序号</th>
          <th scope="col">班级姓名</th>
          <th scope="col">是否开班</th>
          <th scope="col">开班时间</th>
          <th scope="col">班级人数</th>
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
                v-model="item.enabled"
              />
              <!-- 使用 v-if 结合 v-else 实现按需渲染 -->
              <label
                class="custom-control-label"
                :for="'cb' + item.id"
                v-if="item.enabled"
                >已开始</label
              >
              <label class="custom-control-label" :for="'cb' + item.id" v-else
                >未开始</label
              >
            </div>
          </td>

          <td>{{ item.time | dateFormat }}</td>
          <td>{{ item.num }}</td>
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
      // 用户输入的班级名称

      isAdd: true, //是否是添加
      isShowDialog: false,
      dialogTitle: "",

      updateIdx: 2,
      clazz: { name: "", enabled: false, time: null, num: 0 },

      // nextId 是下一个，可用的 id

      // 班级的列表数据
      list: [
        {
          id: 1,
          name: "Vue班",
          enabled: false,
          time: new Date(),
          num: 0,
        },
      ],
      nextId: 2,
    };
  },

  methods: {
    // 点击链接，删除对应的班级信息
    remove(id) {
      this.list = this.list.filter((item) => item.id !== id);
      this.nextId--;
    },
    showAdd() {
      this.isAdd = true;
      this.isShowDialog = true;
      this.dialogTitle = "添加班级";
    },
    showUpdate(item, index) {
      this.isShowDialog = true;
      this.isAdd = false;

      this.dialogTitle = "更新班级";
      this.clazz.id = item.id;
      this.clazz.name = item.name;
      this.clazz.time = item.time;
      this.clazz.num = item.num;
      this.updateIdx = index;
    },
    dialogCancel() {
      this.isShowDialog = false;
      this.clazz = {};
    },
    // 阻止表单的默认提交行为之后，触发 add 方法
    add() {
      if (this.isAdd) {
        // 1. 先把要添加的班级对象，整理出来
    
        this.clazz.id = this.nextId;
        // 2. 往 this.list 数组中 push 步骤 1 中得到的对象
        this.list.push(this.clazz);
        // 3. 清空 this.brand；让 this.nextId 自增 +1
        this.stu =  { name: "", enabled: false, time: null, num: 0 }
        this.nextId++;
      } else {
        var needUpdate = this.list[this.updateIdx];
        needUpdate.name = this.clazz.name;
        needUpdate.time = this.clazz.time;
        needUpdate.num = this.clazz.num;
        this.stu =  { name: "", enabled: false, time: null, num: 0 }
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