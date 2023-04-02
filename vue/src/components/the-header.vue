<template>
  <div class="header">
    <p style="display: inline;margin-left: 20px;float: left;color: white">
      <router-link to="/booking" style="color: white">预订</router-link>
    </p>
    <p style="display: inline;margin-left: 20px;float: left;color: white">加入我们</p>
    <p style="display: inline;margin-left: 20px;float: left;color: white">成为赞助商</p>
    <p style="margin-left: 20px;float: left;color: white">联系酒店</p>
  </div>

</template>

<script>
export default {
  name: "the-header"
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
</style>