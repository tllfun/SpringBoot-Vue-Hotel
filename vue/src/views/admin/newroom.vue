<template>
  <div style="background-color: white;height: 100%">
    <div style="background-color: white;height: 100%">
      <br/>
      <el-form ref="formRef" :model="form" label-width="120px" style="margin-top: 10px">
        <el-form-item label="room" :label-width="formLabelWidth" prop="room">
          <el-input v-model="form.room" autocomplete="off" />
        </el-form-item>
        <el-form-item label="type" :label-width="formLabelWidth" prop="type">
          <el-input v-model="form.type" autocomplete="off" />
        </el-form-item>
        <el-form-item label="floor" :label-width="formLabelWidth" prop="floor">
          <el-input v-model="form.floor" autocomplete="off" />
        </el-form-item>
        <el-form-item label="available" :label-width="formLabelWidth" prop="available">
          <el-input v-model="form.available" autocomplete="off" />
        </el-form-item>
        <el-form-item label="picture1" :label-width="formLabelWidth" prop="picture1">
          <el-input v-model="form.picture1" autocomplete="off" />
        </el-form-item>
        <el-form-item label="picture2" :label-width="formLabelWidth" prop="picture2">
          <el-input v-model="form.picture2" autocomplete="off" />
        </el-form-item>
        <el-form-item label="picture3" :label-width="formLabelWidth" prop="picture3">
          <el-input v-model="form.picture3" autocomplete="off" />
        </el-form-item>
        <el-form-item label="picture4" :label-width="formLabelWidth" prop="picture4">
          <el-input v-model="form.picture4" autocomplete="off" />
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="handleAdd">创建</el-button>
          <el-button @click="clear(formRef)">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>

import {reactive, ref} from 'vue'
import axios from "axios";
import {ElMessage} from "element-plus";
import {FormInstance} from "element-plus";

export default {
  name: "newroom",

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
    const formLabelWidth = '140px';
    const formRef = ref('');

    /**
     * 添加
     * @type {Ref<any>}
     */
    const msg1 = ref();
    const handleAdd = () => {
      console.log(form);
      axios.post("/room/insert",form).then((response)=>{
        const data=response.data;//data = CommonResp
        msg1.value = data.msg;
        if(msg1.value === "成功"){
          openMsg();
          // resetFormData.resetFields();
        }
      });
    };


    const clear = (formEl) => {
      formEl.resetFields();
    }


    /**
     * 删除时显示删除成功
     */
    const openMsg = () => {
      ElMessage({
        message: '添加成功',
        type: 'success',
      })
    }
    return{
      handleAdd,
      openMsg,
      clear,

      form,

      formLabelWidth,
      formRef,
    }
  }
}
</script>

<style scoped>

</style>
