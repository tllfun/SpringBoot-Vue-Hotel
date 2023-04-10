<template>
    <div class="mt-4">
      <el-input
          v-model="input1"
          placeholder="请输入用户名进行查询"
          class="input-with-select"
      >
        <template #prepend>
          <el-button :icon="Search" @click="handleSearch"/>
        </template>
        <template #append>
          <el-select v-model="select.region" placeholder="Select" style="width: 150px">
            <el-option label="通过用户名查询" value="1" />
            <el-option label="通过身份查询" value="2" />
            <el-option label="通过房间查询" value="3" />
            <el-option label="通过电话查询" value="4" />
          </el-select>
        </template>
      </el-input>
      <div style="float: right;margin-right: 45%;margin-top: 10px">
        <el-button round @click="add">添加</el-button>
      </div>
    </div>

    <el-table :data="user" style="width: 100%;height: 90%" height="420">
      <el-table-column fixed prop="id" label="id" width="120" align="center"/>
      <el-table-column prop="username" label="username" width="120" align="center"/>
      <el-table-column prop="password" label="password" width="120" align="center"/>
      <el-table-column prop="role" label="role" width="120" align="center"/>
      <el-table-column prop="phone" label="phone" width="120" align="center" />
      <el-table-column prop="email" label="email" width="120" align="center"/>
      <el-table-column prop="room" label="room" width="120" align="center"/>
      <el-table-column prop="inTime" label="inTime" width="120" align="center"/>
      <el-table-column prop="outTime" label="outTime" width="120" align="center"/>
      <el-table-column fixed="right" label="操作" width="120" align="center">
        <template v-slot="scope" #default >
          <el-button link type="primary" size="small" @click="handleClick(scope.row.id)">修改</el-button>
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

  <el-dialog v-model="dialogFormVisible" title="信息修改">
    <el-form :model="form" ref="editFormRef">
      <el-form-item label="username" :label-width="formLabelWidth" prop="username">
        <el-input v-model="form.username" autocomplete="off" />
      </el-form-item>
      <el-form-item label="password" :label-width="formLabelWidth" prop="password">
        <el-input v-model="form.password" autocomplete="off" />
      </el-form-item>
      <el-form-item label="role" :label-width="formLabelWidth" prop="role">
        <el-input v-model="form.role" autocomplete="off" />
      </el-form-item>
      <el-form-item label="phone" :label-width="formLabelWidth" prop="phone">
        <el-input v-model="form.phone" autocomplete="off" />
      </el-form-item>
      <el-form-item label="email" :label-width="formLabelWidth" prop="email">
        <el-input v-model="form.email" autocomplete="off" />
      </el-form-item>
      <el-form-item label="cond" :label-width="formLabelWidth" prop="cond">
        <el-input v-model="form.cond" autocomplete="off" />
      </el-form-item>
      <el-form-item label="room" :label-width="formLabelWidth" prop="room">
        <el-input v-model="form.room" autocomplete="off" />
      </el-form-item>
      <el-form-item label="inTime" :label-width="formLabelWidth" prop="inTime">
        <el-input v-model="form.inTime" autocomplete="off" />
      </el-form-item>
      <el-form-item label="outTime" :label-width="formLabelWidth" prop="outTime">
        <el-input v-model="form.outTime" autocomplete="off" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="clearVisible(editFormRef)">取消</el-button>
        <el-button type="primary" @click="handleEdit(editFormRef)">
          修改
        </el-button>
      </span>
    </template>
  </el-dialog>

  <el-dialog v-model="AddFormVisible" title="用户添加">
    <el-form :model="addForm" ref="formRef">
      <el-form-item label="id" :label-width="formLabelWidth" prop="id">
        <el-input v-model="addForm.id" autocomplete="off" />
      </el-form-item>
      <el-form-item label="username" :label-width="formLabelWidth" prop="username">
        <el-input v-model="addForm.username" autocomplete="off" />
      </el-form-item>
      <el-form-item label="password" :label-width="formLabelWidth" prop="password">
        <el-input v-model="addForm.password" autocomplete="off" />
      </el-form-item>
      <el-form-item label="role" :label-width="formLabelWidth" prop="role">
        <el-input v-model="addForm.role" autocomplete="off" />
      </el-form-item>
      <el-form-item label="phone" :label-width="formLabelWidth" prop="phone">
        <el-input v-model="addForm.phone" autocomplete="off" />
      </el-form-item>
      <el-form-item label="email" :label-width="formLabelWidth" prop="email">
        <el-input v-model="addForm.email" autocomplete="off" />
      </el-form-item>
      <el-form-item label="cond" :label-width="formLabelWidth" prop="cond">
        <el-input v-model="addForm.cond" autocomplete="off" />
      </el-form-item>
      <el-form-item label="room" :label-width="formLabelWidth" prop="room">
        <el-input v-model="addForm.room" autocomplete="off" />
      </el-form-item>
      <el-form-item label="inTime" :label-width="formLabelWidth" prop="inTime">
        <el-input v-model="addForm.inTime" autocomplete="off" />
      </el-form-item>
      <el-form-item label="outTime" :label-width="formLabelWidth" prop="outTime">
        <el-input v-model="addForm.outTime" autocomplete="off" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="clearVisible(formRef)">取消</el-button>
        <el-button type="primary" @click="handleAdd(formRef)">创建</el-button>
        <el-button @click="clear(formRef)">重置</el-button>
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
  name: "user",
  computed: {
    Search() {
      return Search
    }
  },

  setup(){
    const form = reactive({
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
    const addForm = reactive({
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
    const formLabelWidth = '140px'
    const input1 = ref('');
    const select = ref({
      region:'1',
    });
    const dialogFormVisible = ref(false)
    const AddFormVisible = ref(false)
    const editFormRef = ref('');
    const handleClick = (id) => {
      form.id = id;
      dialogFormVisible.value = true;
    }

    const user = ref();
    /*
     *数据查询
     **/
    const handleQuery = () => {
      axios.get("/user/list").then((response)=>{
        const data=response.data;
        console.log(data);
        user.value = data.data.records;
      });
    };

    /*
     *通过特定的属性查询的数据查询
     **/
    const handleSearch = () =>{
      console.log(select.value.region);
      if (input1.value == null || input1.value === ''){
        handleQuery();
      } else if(select.value.region === '1'){
        //用户名查询
        user.value = [];
        // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
        console.log(input1)
        axios.get("/user/query/username",{
          params:{
            currentPage:'',
            pageSize:'',
            username:input1.value,
          }
        }).then((response)=>{
          const data=response.data;
          console.log(data);
          user.value = data.data.records;
        });
      } else if(select.value.region === '2'){
        //身份查询
        user.value = [];
        console.log(input1)
        axios.get("/user/query/role",{
          params:{
            currentPage:'',
            pageSize:'',
            role:input1.value,
          }
        }).then((response)=>{
          const data=response.data;
          console.log(data);
          user.value = data.data.records;
        });
      } else if(select.value.region === '3'){
        //房间查询
        user.value = [];
        console.log(input1)
        axios.get("/user/query/room",{
          params:{
            currentPage:'',
            pageSize:'',
            room:input1.value,
          }
        }).then((response)=>{
          const data=response.data;
          console.log(data);
          user.value = data.data.records;
        });
      } else if(select.value.region === '4'){
        //电话查询
        user.value = [];
        // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
        console.log(input1)
        axios.get("/user/query/phone",{
          params:{
            currentPage:'',
            pageSize:'',
            phone:input1.value,
          }
        }).then((response)=>{
          const data=response.data;
          console.log(data);
          user.value = data.data.records;
        });
      }
    }



    const msg = ref();
    const handleDelete = (row) =>{
      console.log(row);
      axios.delete("/user/delete", {data:row}).then((response)=>{
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
        message: '成功',
        type: 'success',
      })
    }

    /*
    编辑
     */
    const msg1 = ref();
    const handleEdit = (editFormRef) => {
        console.log(form);
        axios.put("/user/update",form).then((response)=>{
          const data=response.data;//data = CommonResp
          msg1.value = data.code;
          if(msg1.value === '0'){
            //重新加载列表
            handleQuery();
            dialogFormVisible.value = false;
            openMsg();
            clear(editFormRef);
          }
        });
    };

    /**
     * 点击添加触发
     */
    const add = () => {
      AddFormVisible.value = true;
    }

    /**
     * 添加
     * @type {Ref<any>}
     */
    const formRef = ref('');
    const addMsg = ref();
    const handleAdd = (formRef) => {
      axios.post("/user/insert", addForm).then((response)=>{
        const data=response.data;//data = CommonResp
        addMsg.value = data.code;
        if(addMsg.value === '0'){
          handleQuery();
          AddFormVisible.value = false;
          openMsgAdd();
          clearVisible(formRef);
        }
      });
    };

    /**
     * 修改表单清空数据
     * @param formEl
     */
    const clear = (formEl) => {
      formEl.resetFields();
    }

    /**
     * 添加时显示成功
     */
    const openMsgAdd = () => {
      ElMessage({
        message: '添加成功',
        type: 'success',
      })
    }

    /**
     * 添加表单，关闭时清空表单
     * @param formEl
     */
    const clearVisible = (formEl) =>{
      AddFormVisible.value = false;
      dialogFormVisible.value = false;
      formEl.resetFields();
    }

    onMounted(()=>{
      handleQuery();
    });

    return{
      handleClick,
      handleQuery,
      handleDelete,
      openMsg,
      openMsgAdd,
      handleSearch,
      handleEdit,
      handleAdd,
      clear,
      add,
      clearVisible,

      form,
      addForm,
      formRef,
      editFormRef,

      dialogFormVisible,
      AddFormVisible,
      formLabelWidth,
      input1,
      select,
      user
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
