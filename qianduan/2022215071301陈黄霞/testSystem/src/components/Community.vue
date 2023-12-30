<template>
  <div>
    <left v-bind:urls="myUrls" />

    <div class="content">
      <h3>联系方式</h3>
      <div class="contact">
        <p><span>电话:</span><em>12345678910</em></p>
        <p><span>邮箱:</span><em>1234@qq.com</em></p>
        <p><span>地址:</span><em>湖北省武汉市</em></p>
      </div>
      <h3>留言</h3>
      <div class="contact">
        <div>
          <div class="bt_com">
            <textarea name="" id="" cols="50" rows="10" v-model="com.context" maxlength="250">
            </textarea>
          </div>
          <button class="bt_comment" @click="add()">Message</button>
        </div>
        <div class="comment">
          <ul>
            <li v-for="(item, index) in comment" :key="index">
              
              <div class="user">
                <span>
                  <img :src="item.icon" alt="" />
                </span>
                <em>{{item.username}}</em>
              </div>
              <div class="del">
                 <a href="javascript:;" @click="remove(item.id)">删除</a>
              </div>
              <p>{{item.context}}</p>
            </li>
          </ul>
        </div>
      </div>

      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import Left from "./Left.vue";
export default {
  components: {
    Left,
  },
  data() {
    return {
      myUrls: [{ url: "#", name: "网站留言", status: true }],
      comment:[
        {id:1,username:"小明",icon: require("../assets/lib/icon9.png"),context:"大家好啊"},
         {id:2,username:"小天",icon: require("../assets/lib/icon8.png"),context:"同志们好啊"},
      ],
      com: {id:0,username:"小霞",icon:require("../assets/lib/icon7.png"),context:""},
       nextId: 3,
    };
  },
  methods:{
    add(){
      this.com.id = this.nextId
      this.nextId++;
      this.comment.push(this.com);
      this.com = {username:"小霞",icon:require("../assets/lib/icon7.png"),context:""}
    },
    remove(id){
      this.comment = this.comment.filter((item) => item.id !== id);
      this.nextId--;
    }
  }
};
</script>
<style src="@/assets/css/nomalnize.css"></style>
<style scoped>
.content {
  color: #666;
}
.contact {
  width: 90%;
  border: 2px solid rgb(230, 222, 222);
  margin: 10px 0;
  padding: 0 10px;
  border-radius: 10px;
}
.content h3 {
  width: 90%;
  height: 40px;
  line-height: 25px;
  padding: 5px 15px;
  background: rgb(230, 222, 222);
}
.content span {
  font-weight: 700;
  padding-right: 5px;
}
.content em {
  font-size: 15px;
}
.content button {
  width: 120px;
  height: 45px;
  border: 0;
  outline: none;
  margin: 20px 0;
  background: rgb(212, 36, 46);
  border-radius: 5px;
  color: #fff;
  transition: background 1s;
}
.content button:hover {
  cursor: pointer;
  background: rgb(113, 209, 205);
}

.bt_com {
  width: 400px;
  height: 160px;
  margin-top: 10px;
  border-radius: 10px;
}
.bt_com textarea {
  color: #666;
  font-size: 14px;
  line-height: 15px;
  outline: none;
  resize: none;
   border-radius: 10px;
  border: 2px solid rgb(113, 209, 205);
}
.comment {
  width: 800px;
  padding-left: 20px;
}
.comment li {
  width: 100%;
  padding: 15px 0;
  color: #666;
  border-bottom: 1px solid rgb(209, 255, 140);
}
.comment li {
  clear: both;
  zoom: 1;
}

.comment li::after {
  content: "";
  display: block;
  height: 0;
  clear: both;
  visibility: hidden;
}

.comment li p {
  clear: both;
  zoom: 1;
}

.comment li p::after {
  content: "";
  display: block;
  height: 0;
  clear: both;
  visibility: hidden;
}
.user {
  float: left;
  padding-right: 20px;
}
.del {
  float: left;
}
.del a {
  line-height: 34px;
  font-size: 14px;
  padding: 0 5px;
  cursor: pointer;
  background: rgb(113, 209, 205);
  border-radius: 3px;
  transition: background 1s;
}
.del a:hover {
  background: tomato;
  color: #fff;
}
.comment li span {
  float: left;
  width: 34px;
  height: 34px;
  border-radius: 34px;
  background: rgb(255, 220, 226);
}
.comment li p {
  float: left;
  line-height: 25px;
  padding-left: 15px;
}
.comment li em {
  float: left;
  line-height: 34px;
  font-weight: 700px;
  font-size: 18px;
  padding-left: 10px;
}
</style>
