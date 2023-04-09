<template>
  <div class="header">
    <p style="display: inline;margin-left: 20px;float: left;color: white">
      <router-link to="/booking" style="color: white">预订</router-link>
    </p>
    <p style="display: inline;margin-left: 20px;float: left;color: white">
      <router-link to="/admin/" style="color: white">管理</router-link>
    </p>
    <p style="display: inline;margin-left: 20px;float: left;color: white">加入我们</p>
    <p style="display: inline;margin-left: 20px;float: left;color: white">成为赞助商</p>
    <p style="margin-left: 20px;float: left;color: white">联系酒店</p>
    <div>
          <p style="display: inline;margin-right: 20px;float: right;color: white" >
            <el-text style="color:white" v-show="!user.id" @click="loginVisible">登录</el-text>
          </p>
          <p style="display: inline;margin-right: 20px;float: right;">
            <el-text style="color:white;" v-show="!user.id">注册</el-text>
          </p>
          <el-text class="mx-1" v-show="user.id">您好：{{user.username}}</el-text>
    </div>
    <el-dialog v-model="loginFormVisible" title="登录" style="width: 400px">
      <el-form :model="loginForm" ref="formRef">
        <el-form-item label="用户名" :label-width="formLabelWidth" prop="username">
          <el-input  style="width: 250px" v-model="loginForm.username" autocomplete="off" />
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth" prop="password">
          <el-input type="password" style="width: 250px" v-model="loginForm.password" autocomplete="off" />
        </el-form-item>
      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="visible">取消</el-button>
        <el-button type="primary" @click="login">登录</el-button>
      </span>
      </template>
    </el-dialog>

  </div>



</template>

<script>
import {reactive, ref} from "vue";
import axios from "axios";
import {ElMessage} from "element-plus";

export default {
  name: "the-header",
  setup(){
    const loginForm = reactive({
      id:'',
      username:'',
      password:'',
      role:'',
      phone:'',
      email:'',
      cond:'',
      room:'',
      inTime:'',
      outTime:'',
    })
    const formLabelWidth = '80px'
    const loginFormVisible = ref(false)

    const user = ref({
      id:'',
      username:'',
      role:'',
    });
    // 点击取消，取消登录框
    const visible = () =>{
      loginFormVisible.value = false;
    }
    //点击登录时弹出登录框
    const loginVisible = () =>{
      loginFormVisible.value = true;
    }

    const adminUser = ref();
    const login = () =>{
      console.log("开始登录");
      axios.post("/user/login",{
        params:{
          username:loginForm.username,
          password:loginForm.password,
        }
      }).then((response)=>{
        const data=response.data;
        console.log(data);
        if (data.msg === '成功'){
          user.id = data.data.records.id;
          user.username = data.data.records.username;
          user.role = data.data.records.role;
          loginFormVisible.value = false;
          openMsg('登录成功');
        } else {
          loginFormVisible.value = false;
          openMsg('登录失败');
        }
        if(user.value.role !== '0'){
          adminUser.id = user.value.id;
        }
      });
    }

    /**
     * 删除时显示删除成功
     */
    const openMsg = (msg) => {
      if(msg === '登录成功'){
        ElMessage({
          message: msg,
          type: 'success',
        })
      } else {
        ElMessage({
          message: msg,
          type: 'error',
        })
      }
    }

    return{
      loginVisible,
      visible,
      login,

      loginForm,

      loginFormVisible,
      formLabelWidth,
      user,
      adminUser,
    }
  }
}
</script>

<style scoped>
  .header {
    /*background-color: antiquewhite;*/
    background-image: url("@/assets/house.png");
    width: 100%;
    left: 0;
  }
  .el-menu-demo{
    margin-top: 370px;
    float: bottom;
  }
  a {
    text-decoration: none;
  }
  .router-link-active {
    text-decoration: none;
  }
</style>
