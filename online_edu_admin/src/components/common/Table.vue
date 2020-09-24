<template>
  <div>
    <el-table
      :data="tableData"
      border
      style="width: 100%">
      <el-table-column
        prop="id"
        label="用户名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="name"
        label="姓名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="role"
        label="角色"
        width="180">
      </el-table-column>
      <el-table-column
        prop="email"
        label="邮箱"
        width="180">
      </el-table-column>
      <el-table-column
        prop="vip"
        label="会员"
        width="180">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
    export default {
        props: {
            tableData: {
                type: Array,
                default() {
                    return []
                }
            }
        }
    }
</script>
