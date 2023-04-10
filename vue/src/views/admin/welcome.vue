<template>
  <div id="app" style="background-color: #CCCCCC">
    <div class="box">
      <el-container>
        <el-header class="header">
          <span style="color:#ffd04b;float: left;margin-top: 20px">Hotel Management</span>
        </el-header>
        <el-container style="margin-top: 10px;height: 100%">
          <el-aside width="150px">
            <el-menu router
                     :default-active="this.$router.path"
                     active-text-color="#ffd04b"
                     background-color="#545c64"
                     class="el-menu-vertical-demo"
                     text-color="#fff"
                     @open="handleOpen"
                     @close="handleClose"
            >
              <el-menu-item index="/admin/theWelcome">
                <el-icon><House /></el-icon>
                <span>首页</span>
              </el-menu-item>
              <el-sub-menu index="2">
                <template #title>
                  <el-icon><location /></el-icon>
                  <span>客房管理</span>
                </template>
                <el-menu-item index="/admin/housekeeping">客房管理</el-menu-item>
                <el-menu-item index="/admin/newroom">新增客房</el-menu-item>
              </el-sub-menu>
              <el-menu-item index="/admin/orders">
                <el-icon><Menu /></el-icon>
                <span>订单管理</span>
              </el-menu-item>
              <el-menu-item index="/admin/users">
                <el-icon><document /></el-icon>
                <span>用户管理</span>
              </el-menu-item>
            </el-menu>
          </el-aside>
          <el-container>
            <el-main>
              <router-view></router-view>
            </el-main>
          </el-container>
        </el-container>
        <el-footer style="background-color: #545c64;margin-top: 10px">
          <span style="color:#ffd04b;margin-left: 45%">酒店管理系统</span>
        </el-footer>
      </el-container>
    </div>
  </div>
</template>

<script>
export default {
  name: "the-welcome"
}
</script>

<style scoped>
  .header{
    background-color: #545c64;
  }
  .router-link-active {
    text-decoration: none;
    color: #ffd04b;
  }
  a {
    text-decoration: none;
    color: #fff;
  }
  .el-footer {
    display: flex;
    height: 50px;
    width: 100%;
    align-items: center;
  }
  html,
  body {
    margin: 0;
    padding: 0;
    height: 100%;
  }
  #app,
  .box{
    height: 100%;
  }
  .el-container {
    height: 100%;
  }
  .el-menu{
    height:100%;
  }
</style>
