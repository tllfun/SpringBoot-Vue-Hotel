<template>

  <div class="blank">
    <img src="@/assets/logo.png"/>
    <el-divider>
      <el-icon><star-filled /></el-icon>
    </el-divider>
    <div>
      <el-image class="image"  :src="require('@/assets/jiangsu.png')" fit="contain"/>
      <el-image class="image"  :src="require('@/assets/shenzhen.png')" fit="contain"/>
      <el-image class="image"  :src="require('@/assets/guangzhou.png')" fit="contain"/>
    </div>
  </div>

</template>

<script>
export default {
  name: "the-welcome"
}
</script>

<style scoped>
  .blank{
    background-color: white;
    width: 100%;
    height: 95%;
  }
  .image{
    width: 300px;
    height: 300px;
    margin-right: 10px;
    border-radius: 50px;
  }


</style>
