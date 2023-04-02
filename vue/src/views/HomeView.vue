<template>
    <el-container>
      <el-header style="position: relative;height: 400px">
        <the-header class="the-header"></the-header>
      </el-header>
      <el-main style="margin-top: 50px">
        <el-carousel :interval="4000" type="card" height="300px">
          <el-carousel-item v-for="item in 4" :key="item">
            <h3 text="2xl" justify="center">{{ item }}</h3>
          </el-carousel-item>
        </el-carousel>
      </el-main>
      <el-footer>
        <the-footer></the-footer>
      </el-footer>
    </el-container>
  <router-view/>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import theHeader from "@/components/the-header.vue";
import theFooter from "@/components/the-footer.vue";


export default {
  name: 'HomeView',
  components: {
    HelloWorld,
    theHeader,
    theFooter
  }
}
</script>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}
.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.the-header{
  position: absolute;
  height: 100%;
  width: 100%;
  left: 0;
}
</style>