<template>
  <el-container class="layout-container-demo" style="height: 100%">
    <el-aside width="200px">
      <el-scrollbar>
        <el-menu :default-openeds="['1']">
          <el-sub-menu index="1">
            <template #title>
              <el-icon><message /></el-icon>Navigator One
            </template>
              <el-menu-item index="1-1">Option 1</el-menu-item>
              <el-menu-item index="1-2">Option 2</el-menu-item>
              <el-menu-item index="1-3">Option 3</el-menu-item>
              <el-sub-menu index="1-4">
                <template #title>Option4</template>
                <el-menu-item index="1-4-1">Option 4-1</el-menu-item>
              </el-sub-menu>
          </el-sub-menu>
          <el-sub-menu index="2">
            <template #title>
              <el-icon><Menu /></el-icon>Navigator Two
            </template>
              <el-menu-item index="2-1">Option 1</el-menu-item>
              <el-menu-item index="2-2">Option 2</el-menu-item>
              <el-menu-item index="2-3">Option 3</el-menu-item>
              <el-sub-menu index="2-4">
                <template #title>Option 4</template>
                <el-menu-item index="2-4-1">Option 4-1</el-menu-item>
              </el-sub-menu>
          </el-sub-menu>
          <el-sub-menu index="3">
            <template #title>
              <el-icon><setting /></el-icon>Navigator Three
            </template>
              <el-menu-item index="3-1">Option 1</el-menu-item>
              <el-menu-item index="3-2">Option 2</el-menu-item>
              <el-menu-item index="3-3">Option 3</el-menu-item>
              <el-sub-menu index="3-4">
                <template #title>Option 4</template>
                <el-menu-item index="3-4-1">Option 4-1</el-menu-item>
              </el-sub-menu>
          </el-sub-menu>
        </el-menu>
      </el-scrollbar>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <div class="toolbar">
          <el-dropdown>
            <el-icon style="margin-right: 8px; margin-top: 1px"
            ><setting
            /></el-icon>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>View</el-dropdown-item>
                <el-dropdown-item>Add</el-dropdown-item>
                <el-dropdown-item>Delete</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
          <span>Tom</span>
        </div>
      </el-header>

      <el-main style="margin-top: 10px;margin-left: 10px">
        <el-row>
          <el-col
              v-for="(o, index) in 10"
              :key="o"
              :span="24"
              :offset="index > 0 ? 0 : 0"
          >
            <el-card :body-style="{ padding: '10px'}" style="height: 220px;margin-top: 10px;border-radius: 12px">
              <img src="@/assets/hotel1.png" class="image"/>
              <div style="float: right;width: 78%;">
                <el-descriptions
                    title="Cram Hotel"
                    class="margin-top"
                    :column="3"
                    :size="size"
                    border
                >
                  <el-descriptions-item>
                    <template #label>
                      <div class="cell-item">
                        <el-icon :style="iconStyle">
                          <user />
                        </el-icon>
                        酒店经理
                      </div>
                    </template>
                    王根权
                  </el-descriptions-item>
                  <el-descriptions-item>
                    <template #label>
                      <div class="cell-item">
                        <el-icon :style="iconStyle">
                          <iphone />
                        </el-icon>
                        联系电话
                      </div>
                    </template>
                    18100000000
                  </el-descriptions-item>
                  <el-descriptions-item>
                    <template #label>
                      <div class="cell-item">
                        <el-icon :style="iconStyle">
                          <location />
                        </el-icon>
                        位置
                      </div>
                    </template>
                    Suzhou
                  </el-descriptions-item>
                  <el-descriptions-item>
                    <template #label>
                      <div class="cell-item">
                        <el-icon :style="iconStyle">
                          <tickets />
                        </el-icon>
                        类型
                      </div>
                    </template>
                    <el-tag size="small">五星</el-tag>
                  </el-descriptions-item>
                  <el-descriptions-item>
                    <template #label>
                      <div class="cell-item">
                        <el-icon :style="iconStyle">
                          <office-building />
                        </el-icon>
                        地址
                      </div>
                    </template>
                    No.1188, Wuzhong Avenue, Wuzhong District, Suzhou, Jiangsu Province
                  </el-descriptions-item>
                </el-descriptions>
                <el-descriptions
                    :column="1"
                    :size="size"
                    border
                >
                  <el-descriptions-item>
                    <template #label>
                      <div class="cell-item">
                        <el-icon :style="iconStyle">
                          <office-building />
                        </el-icon>
                        简介
                      </div>
                    </template>
                    Hotel Cram Hotel酒店位于巴塞罗那（Barcelona）中心的Eixample地区，距离加泰罗尼亚广场（Plaza Catalunya）有10分钟的步行路程，设有一个享有城市景观的屋顶游泳池和两个米其林星星角巴塞罗那餐厅（Two Michelin Stars Angle Barcelona）。所有客房均配有免费WiFi和大平板电视。
                  </el-descriptions-item>
                </el-descriptions>
              </div>
            </el-card>
          </el-col>
        </el-row>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import { ref } from 'vue'

export default {
  name: "booking",
  setup() {
    const item = {
      date: '2016-05-02',
      name: 'Tom',
      address: 'No. 189, Grove St, Los Angeles',
    }
    const tableData = ref(Array.from({ length: 20 }).fill(item))
  }
}

</script>

<style scoped>
.layout-container-demo .el-header {
  position: relative;
  background-color: var(--el-color-primary-light-7);
  color: var(--el-text-color-primary);
}
.layout-container-demo .el-aside {
  color: var(--el-text-color-primary);
  background: var(--el-color-primary-light-8);
}
.layout-container-demo .el-menu {
  border-right: none;
}
.layout-container-demo .el-main {
  padding: 0;
}
.layout-container-demo .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  right: 20px;
}
.image{
  width: 20%;
  height: 100%;
  float: left;
  border-radius: 30px;
}
</style>
