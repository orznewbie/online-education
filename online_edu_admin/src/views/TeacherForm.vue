<template>
  <div class="teacher">
    <Table :tableData=teacher></Table>
    <el-pagination
      background
      @current-change="gotoGetTeacher"
      :current-page.sync="currentPage"
      :page-size="12"
      layout="total, prev, pager, next"
      :total="teachercnt">
    </el-pagination>
  </div>
</template>

<script>
  import Table from '@/components/common/Table'
  import {queryUser, queryUserCnt} from '@/network/admin.js'
    export default {
        name: "TeacherForm",
        data() {
            return {
                currentPage: 1,
                teachercnt: 0,
                teacher: [],
                teachers: [[]]
            }
        },
        methods: {
            gotoGetTeacher() {
                if (this.teachers[this.currentPage] !== undefined
                    && this.teachers[this.currentPage] != []) {
                    this.teacher = this.teachers[this.currentPage];
                    return;
                }
                let params = {
                    role: 2,
                    startIndex: (this.currentPage - 1) * 12,
                    offset: 12
                };
                queryUser(params).then(res => {
                    this.teachers[this.currentPage] = res.data.data
                    this.teacher = this.teachers[this.currentPage]
                })
            },
            getTeacherCnt() {
                let params = {
                    role : 2,
                }
                queryUserCnt(params).then(res => {
                    this.teachercnt = res.data.data
                })
            }
        },
        mounted() {
            this.gotoGetTeacher();
            this.getTeacherCnt();
        },
        components: {
            Table
        }
    }
</script>

<style scoped>
</style>
