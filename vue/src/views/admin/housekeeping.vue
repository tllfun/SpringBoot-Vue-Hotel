<template>
    <div class="mt-4">
      <el-input
          v-model="input1"
          placeholder="Please input"
          class="input-with-select"
      >
        <template #prepend>
          <el-button :icon="Search" @click="handleSearch"/>
        </template>
        <template #append>
          <el-select v-model="select.region" placeholder="Select" style="width: 115px">
            <el-option label="通过id查询" value="1" />
            <el-option label="通过type查询" value="2" />
            <el-option label="通过floor查询" value="3" />
          </el-select>
        </template>
      </el-input>
    </div>
    <el-table :data="house" style="width: 100%;height: 90%">
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
          <el-button link type="primary" size="small" @click="handleClick(scope.row)">修改</el-button>
          <el-popconfirm
              confirm-button-text="确定"
              cancel-button-text="取消"
              icon="InfoFilled"
              icon-color="#626AEF"
              title="确定要删除吗?"
              @confirm="handleDelete(scope.row)"
              @cancel="cancelEvent"
          >
            <template #reference>
              <el-button link type="primary" size="small">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

  <el-dialog v-model="dialogFormVisible" title="客房修改">
    <el-form :model="form">
      <el-form-item label="room" :label-width="formLabelWidth">
        <el-input v-model="form.room" autocomplete="off" />
      </el-form-item>
      <el-form-item label="type" :label-width="formLabelWidth">
        <el-input v-model="form.type" autocomplete="off" />
      </el-form-item>
      <el-form-item label="floor" :label-width="formLabelWidth">
        <el-input v-model="form.floor" autocomplete="off" />
      </el-form-item>
      <el-form-item label="available" :label-width="formLabelWidth">
        <el-input v-model="form.available" autocomplete="off" />
      </el-form-item>
      <el-form-item label="picture1" :label-width="formLabelWidth">
        <el-input v-model="form.picture1" autocomplete="off" />
      </el-form-item>
      <el-form-item label="picture2" :label-width="formLabelWidth">
        <el-input v-model="form.picture2" autocomplete="off" />
      </el-form-item>
      <el-form-item label="picture3" :label-width="formLabelWidth">
        <el-input v-model="form.picture3" autocomplete="off" />
      </el-form-item>
      <el-form-item label="picture4" :label-width="formLabelWidth">
        <el-input v-model="form.picture4" autocomplete="off" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="handleEdit">
          修改
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
      id:'',
      room:'',
      type:'',
      floor:'',
      available:'',
      picture1:'',
      picture2:'',
      picture3:'',
      picture4:'',
    })
    const formLabelWidth = '140px'
    const input1 = ref('');
    const select = ref({
      region:'1',
    });
    const dialogFormVisible = ref(false)
    const handleClick = (row) => {
      form.id = row.id;
      form.room=row.room;
      form.type=row.type;
      form.floor=row.floor;
      form.available=row.available;
      form.picture1=row.picture1;
      form.picture2=row.picture2;
      form.picture3=row.picture3;
      form.picture4=row.picture4;
      dialogFormVisible.value = true;
    }

    const house = ref();
    /*
     *数据查询
     **/
    const handleQuery = () => {
      axios.get("/room/list").then((response)=>{
        const data=response.data;
        console.log(data);
        house.value = data.data.records;
      });
    };

    /*
     *通过特定的属性查询的数据查询
     **/
    const handleSearch = () =>{
      house.value = [];
      // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
      if(input1.value == null || input1.value === ''){
        handleQuery();
      } else {
        axios.get("/room/query/all",{
          params:{
            type:select.value.region,
            keyWord:input1.value
          }
        }).then((response)=>{
          const data=response.data;
          console.log(data);
          house.value = data.data.records;
        });
      }
    }



    const msg = ref();
    const handleDelete = (roomData) =>{
      console.log(roomData);
      axios.delete("/room/delete", {data:roomData}).then((response)=>{
        const data=response.data;//data = CommonResp
        msg.value = data.code;
        if(msg.value === '0'){
          //重新加载列表
          handleQuery();
          openMsg();
        }

      });
    }

    /**
     * 删除时显示删除成功
     */
    const openMsg = () => {
      ElMessage({
        message: '删除成功',
        type: 'success',
      })
    }

    /*
    编辑
     */
    const msg1 = ref();
    const handleEdit = () => {
        console.log(form);
        axios.put("/room/update",form).then((response)=>{
          const data=response.data;//data = CommonResp
          msg1.value = data.code;
          if(msg1.value === '0'){
            //重新加载列表
            handleQuery();
            Msg();
            dialogFormVisible.value = false;
          }
        });
    };
    /**
     * 修改时显示修改成功
     */
    const Msg = () => {
      ElMessage({
        message: '修改成功',
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
      handleSearch,
      handleEdit,
      Msg,

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
