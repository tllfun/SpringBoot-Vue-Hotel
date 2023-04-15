<template>
  <div class="header">
    <p style="display: inline;margin-left: 20px;float: left;color: white">
      <router-link to="/booking" style="color: white">预订</router-link>
    </p>
    <p style="display: inline;margin-left: 20px;float: left;color: white">加入我们</p>
    <p style="display: inline;margin-left: 20px;float: left;color: white">成为赞助商</p>
    <p style="margin-left: 20px;float: left;color: white">联系酒店</p>
    <p style="display: inline;margin-left: 20px;float: left;color: white">
      <router-link to="/admin/" style="color: white" v-if="!adminUser.flag">
        管理
      </router-link>
    </p>
    <div>
          <p style="display: inline;margin-right: 20px;float: right;color: white" v-if="user.flag">
            <el-text style="color:white"  @click="loginVisible">登录</el-text>
          </p>
          <p style="display: inline;margin-right: 20px;float: right;" v-if="user.flag">
            <el-text style="color:white;" @click="registerVisible">注册</el-text>
          </p>
          <p style="display: inline;margin-right: 20px;float: right;" v-if="!user.flag">
            <el-text style="color:white;margin-right: 10px">您好：{{user.username}}</el-text>
            <span style="color:white;margin-right: 10px">|</span>
            <el-text style="color:white;" @click="logout">退出登录</el-text>
          </p>
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

    <el-dialog v-model="registerFormVisible" title="注册" style="width: 400px">
      <el-form :model="registerForm" ref="RForm">
        <el-form-item label="用户名" :label-width="formLabelWidth" prop="username">
          <el-input  style="width: 250px" v-model="registerForm.username" autocomplete="off" />
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth" prop="password">
          <el-input type="password" style="width: 250px" v-model="registerForm.password" autocomplete="off" />
        </el-form-item>
        <el-form-item label="电话" :label-width="formLabelWidth" prop="phone">
          <el-input style="width: 250px" v-model="registerForm.phone" autocomplete="off" />
        </el-form-item>
        <el-form-item label="邮箱" :label-width="formLabelWidth" prop="email">
          <el-input style="width: 250px" v-model="registerForm.email" autocomplete="off" />
        </el-form-item>
      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="visible1">取消</el-button>
        <el-button type="primary" @click="register">注册</el-button>
      </span>
      </template>
    </el-dialog>

  </div>



</template>

<script>
import {provide, reactive, ref} from "vue";
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
    const registerForm = reactive({
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
    const registerFormVisible = ref(false)

    let user = reactive({
      id:'',
      username:'',
      role:'',
      flag:true
    });
    // 点击取消，取消登录框
    const visible = () =>{
      loginFormVisible.value = false;
    }
    //点击登录时弹出登录框
    const loginVisible = () =>{
      loginFormVisible.value = true;
    }
    // 点击取消，取消注册框
    const visible1 = () =>{
      registerFormVisible.value = false;
    }
    //点击注册时弹出注册框
    const registerVisible = () =>{
      registerFormVisible.value = true;
    }

    const adminUser = ref({
      flag:true,
    });
    const login = () =>{
      console.log("开始登录");
      console.log(loginForm);
      const params = new URLSearchParams();
      params.append('username', loginForm.username);
      params.append('password', loginForm.password);
      axios.post("/user/login",params).then((response)=>{
        const data=response.data;
        console.log(data);
        if (data.code === '0'){
          user.id = data.data.id;
          user.username = data.data.username;
          user.role = data.data.role;
          user.flag = false;
          loginFormVisible.value = false;
          openMsg('登录成功');
        } else {
          loginFormVisible.value = false;
          openMsg('登录失败');
        }
        if(user.role !== 0){
          adminUser.value.flag = user.flag;
        }
      });
    }

    const logout =()=>{
      console.log("开始退出登录");
      user.flag = true;
      adminUser.value.flag = true;
      openMsg("退出登录成功");
    }

    const register =()=>{
      registerForm.role = 0;
      console.log("开始注册");
      console.log(registerForm);
      axios.post("/user/register",registerForm).then((response)=>{
        const data=response.data;
        console.log(data);
        if (data.code === '0'){
          registerFormVisible.value = false;
          openMsg('注册成功');
        } else {
          registerFormVisible.value = false;
          openMsg('注册失败');
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
      } else if(msg==='退出登录成功'){
        ElMessage({
          message: msg,
          type: 'success',
        })
      }else if(msg==='注册成功'){
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
      visible1,
      registerVisible,
      loginVisible,
      visible,
      login,
      logout,
      register,

      registerForm,
      loginForm,

      registerFormVisible,
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
