<template>
    <el-container>
      <el-header style="position: relative;height: 400px">
        <the-header class="the-header"></the-header>
      </el-header>
      <el-main style="margin-top: 50px">
        <el-carousel :interval="4000" type="card" height="300px">
          <el-carousel-item v-for="item in carouseData" :key="item">
<!--            <h3 text="2xl" justify="center">{{ item }}</h3>-->
            <img style="height: 100%;width: 100%" :src="item.url"  alt=""/>
          </el-carousel-item>
        </el-carousel>

        <el-row style="margin-top: 20px">
          <el-col :span="6"  style="margin-right: 5%;margin-left: 7%">
            <el-card :body-style="{ padding: '0px' }">
              <img
                  src="@/assets/006.png"
                  class="image"
              />
              <div style="padding: 15px;">
                <h1>更实惠的价格</h1>
              </div>
            </el-card>
          </el-col>
          <el-col :span="6"  style="margin-right: 5%">
            <el-card :body-style="{ padding: '0px' }">
              <img
                  src="@/assets/005.png"
                  class="image"
              />
              <div style="padding: 15px;">
                <h1>更优质的服务</h1>
              </div>
            </el-card>
          </el-col>

          <el-col :span="6">
            <el-card :body-style="{ padding: '0px' }">
              <img
                  src="@/assets/hotel1.png"
                  class="image"
              />
              <div style="padding: 15px;">
                <h1>更动人的福利</h1>
              </div>
            </el-card>
          </el-col>
        </el-row>
<!--        <div style="background-color:  #a0cfff">-->
<!--          <h1 style="align-content: center">-->
<!--            酒店简介-->
<!--          </h1>-->
<!--          <el-text tag="b" size="large">-->
<!--            枫叶酒店是一家高档商务酒店。酒店地处南宁商贸中心，位于七里街与华北大道相交处，酒店紧靠广西大学-->
<!--          </el-text>-->
<!--          <br/>-->
<!--          <el-text tag="i" size="large" style="align-content: center" >-->
<!--            枫叶酒店装修时尚高雅，设施齐全，环境舒适。拥有跃层商务客房，酒店还配有豪华餐饮包厢、中西自助餐厅、会议厅、商务中心、精品屋、美容美发和足浴中心等，服务配套与娱乐设施一应俱全。酒店以“宾客至上，服务第一”为经营宗旨，采用了科学的经营机制和管理方法，不断追求卓越，得到了社会的认可，更被省有关部门确定**接待酒店。无论商务、宴会、休闲、娱乐，都是您的理想之选。-->
<!--          </el-text>-->
<!--          <h2>枫叶酒店欢迎您！</h2>-->
<!--        </div>-->
      </el-main>
      <el-footer style="background-color: #d3dce6">
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
  },
  setup(){
    const carouseData = [
      {url: require("@/assets/001.png")},
      {url: require("@/assets/002.png")},
      {url: require("@/assets/003.png")},
      {url: require("@/assets/004.png")},
    ];
    return{
      carouseData,
    }
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
.image {
  width: 100%;
  display: block;
}
.time {
  font-size: 12px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.button {
  padding: 0;
  min-height: auto;
}
</style>
