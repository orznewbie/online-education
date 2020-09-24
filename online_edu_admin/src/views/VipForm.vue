<template>
  <div class="teacher">
    <Table :tableData=vip_></Table>
    <el-pagination
      background
      @current-change="gotoGetTeacher"
      :current-page.sync="currentPage"
      :page-size="12"
      layout="total, prev, pager, next"
      :total="vipcnt">
    </el-pagination>
  </div>
</template>

<script>
    import Table from '@/components/common/Table'
    import {queryUser, queryUserCnt} from '@/network/admin.js'
    export default {
        name: "VipForm",
        data() {
            return {
                currentPage: 1,
                vipcnt: 0,
                vip_: [],
                vips: [[]]
            }
        },
        methods: {
            gotoGetVip() {
                if (this.vips[this.currentPage] !== undefined
                    && this.vips[this.currentPage] != []) {
                    this.vip_ = this.vips[this.currentPage];
                    return;
                }
                let params = {
                    vip: 1,
                    startIndex: (this.currentPage - 1) * 12,
                    offset: 12
                };
                queryUser(params).then(res => {
                    this.vips[this.currentPage] = res.data.data
                    this.vip_ = this.vips[this.currentPage]
                })
            },
            getVipCnt() {
                let params = {
                    vip: 1,
                }
                queryUserCnt(params).then(res => {
                    this.vipcnt = res.data.data
                })
            }
        },
        mounted() {
            this.gotoGetVip();
            this.getVipCnt();
        },
        components: {
            Table
        }
    }
</script>

<style scoped>
</style>
