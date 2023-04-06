<template>
    <div class="mt-4">
      <el-input
          v-model="input1"
          placeholder="Please input"
          class="input-with-select"
      >
        <template #prepend>
          <el-button :icon="Search" />
        </template>
        <template #append>
          <el-select v-model="select" placeholder="Select" style="width: 115px">
            <el-option label="Restaurant" value="1" />
            <el-option label="Order No." value="2" />
            <el-option label="Tel" value="3" />
          </el-select>
        </template>
      </el-input>
    </div>
    <el-table :data="house" style="width: 100%;height: 93%">
      <el-table-column fixed prop="id" label="id" width="120" align="center"/>
      <el-table-column prop="room" label="room" width="120" align="center"/>
      <el-table-column prop="type" label="type" width="120" align="center"/>
      <el-table-column prop="floor" label="floor" width="120" align="center"/>
      <el-table-column prop="available" label="available" width="120" align="center" />
      <el-table-column prop="picture1" label="picture1" width="120" align="center"/>
      <el-table-column prop="picture2" label="picture2" width="120" align="center"/>
      <el-table-column prop="picture3" label="picture3" width="120" align="center"/>
      <el-table-column prop="picture4" label="picture4" width="120" align="center"/>
      <el-table-column fixed="right" label="操作" width="120" align="center">
        <template v-slot="scope" #default >
          <el-button link type="primary" size="small" @click="handleClick">修改</el-button>
          <el-popconfirm
              confirm-button-text="Yes"
              cancel-button-text="No"
              icon="InfoFilled"
              icon-color="#626AEF"
              title="Are you sure to delete this?"
              @confirm="handleDelete(scope.row.id)"
              @cancel="cancelEvent"
          >
            <template #reference>
              <el-button link type="primary" size="small">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

  <el-dialog v-model="dialogFormVisible" title="Shipping address">
    <el-form :model="form">
      <el-form-item label="Promotion name" :label-width="formLabelWidth">
        <el-input v-model="form.name" autocomplete="off" />
      </el-form-item>
      <el-form-item label="Zones" :label-width="formLabelWidth">
        <el-select v-model="form.region" placeholder="Please select a zone">
          <el-option label="Zone No.1" value="shanghai" />
          <el-option label="Zone No.2" value="beijing" />
        </el-select>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="dialogFormVisible = false">
          Confirm
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script>
import {Search} from "@element-plus/icons-vue";
import {onMounted, reactive, ref} from "vue";
import axios from "axios";
import {ElMessage} from "element-plus";

export default {
  name: "housekeeping",
  computed: {
    Search() {
      return Search
    }
  },

  setup(){
    const form = reactive({
      name: '',
      region: '',
      date1: '',
      date2: '',
      delivery: false,
      type: [],
      resource: '',
      desc: '',
    })
    const formLabelWidth = '140px'
    const input1 = ref('');
    const select = ref('');
    const dialogFormVisible = ref(false)
    const handleClick = () => {
      dialogFormVisible.value = true;
      console.log('click')
    }

    const house = ref();
    /*
     *数据查询
     **/
    const handleQuery = () => {
      // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
      axios.get("/room/list").then((response)=>{
        const data=response.data;
        console.log(data);
        house.value = data.data.records;
      });
    };

    const msg = ref();
    const handleDelete = (id) =>{
      console.log(id);
      axios.delete("/room/delete/"+id).then((response)=>{
        const data=response.data;//data = CommonResp
        msg.value = data.msg;
        if(msg.value === "删除成功"){
          //重新加载列表
          handleQuery();
          openMsg();
        }

      });
    }

    const openMsg = () => {
      ElMessage({
        message: '删除成功',
        type: 'success',
      })
    }

    onMounted(()=>{
      handleQuery();
    });

    return{
      handleClick,
      handleQuery,
      handleDelete,
      openMsg,

      form,

      dialogFormVisible,
      formLabelWidth,
      input1,
      select,
      house
    }
  }
}
</script>

<style scoped>
  .input-with-select{
    margin-top: 10px;
    margin-left: 10px;
    width: 500px;
    float: left;
  }
  .mt-4{
    width: 100%;
    height: 10%;
    background-color: white;
  }

</style>
