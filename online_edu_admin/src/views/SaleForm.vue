<template>
  <div class="Sale">
    <CourseTable :tableData=sale></CourseTable>
    <el-pagination
      background
      @current-change="gotoGetSale"
      :current-page.sync="currentPage"
      :page-size="12"
      layout="total, prev, pager, next"
      :total="salecnt">
    </el-pagination>
  </div>
</template>

<script>
    import CourseTable from '@/components/contents/CourseTable'
    import {queryCourse, queryCourseCnt} from '@/network/admin.js'
    export default {
        name: "SaleForm",
        data() {
            return {
                currentPage: 1,
                salecnt: 0,
                sale: [],
                sales: [[]]
            }
        },
        methods: {
            gotoGetSale() {
                if (this.sales[this.currentPage] !== undefined
                    && this.sales[this.currentPage] != []) {
                    this.sale = this.sales[this.currentPage];
                    return;
                }
                let params = {
                    ordered: 'salecntDesc',
                    startIndex: (this.currentPage - 1) * 12,
                    offset: 12
                };
                queryCourse(params).then(res => {
                    this.sales[this.currentPage] = res.data.data
                    this.sale = this.sales[this.currentPage]
                })
            },
            getSaleCnt() {
                let params = {}
                queryCourseCnt(params).then(res => {
                    this.salecnt = res.data.data
                })
            }
        },
        mounted() {
            this.gotoGetSale();
            this.getSaleCnt();
        },
        components: {
            CourseTable
        }
    }
</script>

<style scoped>
</style>
