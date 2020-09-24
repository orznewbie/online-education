<template>
  <div>
    <el-table
      :data="tableData"
      border
      style="width: 100%">
      <el-table-column
        prop="id"
        label="课程编号"
        width="180">
      </el-table-column>
      <el-table-column
        prop="title"
        label="课程名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="price"
        label="课程价格"
        width="180">
      </el-table-column>
      <el-table-column
        prop="salecnt"
        label="销量"
        width="180">
      </el-table-column>
      <el-table-column
        prop="tid"
        label="老师编号"
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
