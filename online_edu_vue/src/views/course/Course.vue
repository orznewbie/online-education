<template>
  <div class="container clearfix">
    <div class="main">
      <div class="category">
        <div class="item">
          课程分类：
          <ul>
            <li
              v-for="category in categorys"
              :key="category.id"
              :class="{active:category_id===category.id}"
            >
              <span @click="setCategory(category.id)">{{category.title}}</span>
            </li>
          </ul>
        </div>
        <div class="condition">
          筛&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选：
          <ul>
            <li v-for="con in conditon" :key="con.id" :class="{active:condition_id===con.id}">
              <span @click="setQuery(con.query,con.id)">{{con.title}}</span>
              <span v-if="con.query==='price'" class="condition-span">
                <span class="condition-i i-top" ref="spantop"></span>
                <span class="condition-i i-buttom" ref="spanbuttom"></span>
              </span>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <ItemList :videos="course"></ItemList>
    <el-pagination
      class="daohang"
      background
      @current-change="gotoGetCourse"
      :current-page.sync="currentPage"
      :page-size="12"
      layout="total, prev, pager, next"
      :total="coursecnt">
    </el-pagination>
  </div>
</template>

<script>
    import ItemList from "@/components/contents/item/ItemList"
    import {getCourse, getCourseCnt, getCategory} from '@/network/common'
    export default {
        name: "Course",
        components: {ItemList},
        data() {
            return {
                isActive: false,
                // 修改当前的筛选条件id,选中条件高亮显示
                condition_id: 0,
                conditon: [
                    {id: 0, title: "默认", query: ""},
                    {id: 1, title: "热门", query: "hot"},
                    {id: 2, title: "价格", query: "price"}
                ],
                categorys: [],
                // 课程种类id, pre用来记录是否需要清空course
                category_id: 0,
                // 筛选名称
                query: "",
                currentPage: 1,
                coursecnt: 0,
                course: [],
                courses: []
            };
        },
        methods: {
            // 设置课程种类
            setCategory(category_id) {
                this.courses = [];
                if (category_id != this.category_id) {
                    this.category_id = category_id;
                } else {
                    this.category_id = 0;
                }
                this.gotoGetCourse()
                this.gotoGetCourseCnt()
            },
            // 设置筛选种类
            setQuery(query, id) {
                this.condition_id = id;
                if (query != "price") {
                    // 清除条件为非价格时三角形图标样式
                    this.$refs.spantop[0].className = "condition-i i-top";
                    this.$refs.spanbuttom[0].className = "condition-i i-buttom";
                    // 筛选种类变化则清空结果集
                    if (query != this.query) {
                        this.courses = []
                        this.query = query;
                        this.gotoGetCourse();
                    } else {
                        this.query = query;
                    }
                } else {
                    // 点击价格也有变化，需要清空结果集
                    this.courses = [];
                    if (this.query == "-price") {
                        this.query = "price";
                        this.$refs.spantop[0].className = "condition-i i-top active";
                        this.$refs.spanbuttom[0].className = "condition-i i-buttom";
                    } else {
                        this.query = "-price"
                        this.$refs.spantop[0].className = "condition-i i-top";
                        this.$refs.spanbuttom[0].className = "condition-i i-buttom active";
                    }
                    this.gotoGetCourse();
                }
            },
            gotoGetCourse() {
                // 如果已经查询过，则不用再去查了
                if (this.courses[this.currentPage] !== undefined
                    && this.courses[this.currentPage] != []) {
                    this.course = this.courses[this.currentPage];
                    return;
                }
                let o = "";
                if (this.query == "hot") {
                    o = "salecntDesc"
                } else if (this.query == "price") {
                    o = "priceDesc"
                } else if (this.query == "-price") {
                    o = "priceAsc"
                }
                let params = {
                    category: this.category_id,
                    ordered: o,
                    startIndex: (this.currentPage - 1) * 12,
                    offset: 12
                };
                getCourse(params).then(res => {
                    this.courses[this.currentPage] = res.data.data
                    this.course = this.courses[this.currentPage];
                })
            },
            gotoGetCourseCnt() {
                let params = {
                    category: this.category_id
                }
                getCourseCnt(params).then(res => {
                    this.coursecnt = res.data.data
                })
            }
        },
        created() {
            getCategory().then(res => {
                this.categorys = res.data.data
            })
            this.gotoGetCourse()
            this.gotoGetCourseCnt()
        }
    }
</script>

<style lang="css" scoped>
  .daohang {
    padding-left: 500px;
  }
  .main {
    width: 960px;
    height: auto;
    margin: 0 auto;
    padding-top: 35px;
  }

  span {
    margin-left: 2px;
    cursor: pointer;
    transition: all 0.3s ease;
  }

  span.active {
    color: #00b4e4;
  }

  .category {
    width: 910px;
    margin: 0 auto;
    padding-top: 20px;
    height: auto;
    margin-bottom: 35px;
    padding: 25px 30px 25px 20px;
    background: #fff;
    border-radius: 4px;
    box-shadow: 0 2px 4px 0 #f0f0f0;
  }

  .item {
    display: flex;
    align-items: center;
    font-size: 16px;
    color: #888;
    letter-spacing: 0.36px;
    display: flex;
  }

  .item ul li {
    list-style: none;
    float: left;
    line-height: 16px;
    margin-left: 14px;
    position: relative;
    transition: all 0.3s ease;
    cursor: pointer;
    padding: 6px 7px;
  }
  .item ul li.active {
    color: #00b4e4;
    border-radius: 30px;
    border: 1px solid #00b4e4;
  }

  .condition {
    display: flex;
    align-items: center;
    font-size: 16px;
    color: #888;
    letter-spacing: 0.36px;
    margin-top: 20px;
  }

  .condition ul {
    margin-top: 14px;
  }
  .condition ul li {
    list-style: none;
    float: left;
    line-height: 16px;
    margin-left: 14px;
    position: relative;
    transition: all 0.3s ease;
    cursor: pointer;
    padding: 6px 7px;
  }
  .condition ul li.active {
    color: #00b4e4;
    border-radius: 30px;
  }

  .condition-span .i-top {
    content: "test";
    width: 0;
    border: 5px solid transparent;
    border-top-color: #d8d8d8;
    position: absolute;
    right: 0;
    bottom: 20.5px;
  }

  .condition-span .i-buttom {
    content: "test";
    width: 0;
    border: 5px solid transparent;
    border-bottom-color: #d8d8d8;
    position: absolute;
    right: 0;
    top: 2.5px;
  }

  .condition-span .i-top.active {
    border-top-color: #00b4e4;
  }
  .condition-span .i-buttom.active {
    border-bottom-color: #00b4e4;
  }
  .course-list .image {
    width: 423px;
    height: 210px;
  }
  .course-list dl {
    height: auto;
    background: #fff;
    padding: 20px 30px 20px 20px;
    display: -ms-flexbox;
    display: flex;
    margin: 35px auto;
    border-radius: 2px;
    cursor: pointer;
    box-shadow: 2px 3px 16px rgba(0, 0, 0, 0.1);
    transition: all 0.2s ease;
    position: relative;
  }

  .course-list dl dt {
    width: 423px;
    height: 210px;
    margin-right: 30px;
  }

  .course-list ul {
    display: flex;
    -ms-flex-wrap: wrap;
    flex-wrap: wrap;
    -ms-flex-align: center;
    align-items: center;
    -ms-flex-pack: justify;
    justify-content: space-between;
  }

  .course-list ul li {
    width: 48%;
    display: -ms-flexbox;
    display: flex;
    align-items: center;
    font-size: 14px;
    color: #666;
    margin-bottom: 15px;
    cursor: pointer;
  }
  .course-list ul li p {
    max-width: 227px;
    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
    font-family: PingFangSC-Regular;
  }

  .course-list ul li span {
    color: #ffc210;
    border: 1px solid #ffc210;
  }
  .name > p {
    font-size: 19px;
    color: #070505;
    font-weight: bold;
  }

  .name p span {
    font-size: 15px;
    color: rgb(249, 29, 29);
    margin-right: 8px;
  }

  .teacher p span {
    font-size: 15px;
    color: rgb(239, 189, 77);
    font-weight: bolder;
    margin-right: 8px;
  }
  .course-list dl dd .price button:hover {
    color: #fff;
    background: #ffc210;
    border: 1px solid #ffc210;
  }
</style>

