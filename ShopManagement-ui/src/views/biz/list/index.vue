<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="仓库名称" prop="warehouseName">
        <el-input
          v-model="queryParams.warehouseName"
          placeholder="请输入仓库名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入库商品名称" prop="productName">
        <el-input
          v-model="queryParams.productName"
          placeholder="请输入入库商品名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入库商品类别" prop="productCategory">
        <el-select v-model="queryParams.productCategory" placeholder="请选择入库商品类别" clearable>
          <el-option
            v-for="dict in dict.type.biz_product_category"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="供应商名称" prop="supplierName">
        <el-input
          v-model="queryParams.supplierName"
          placeholder="请输入供应商名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="质检状态" prop="qualityInspectionStatus">
        <el-select v-model="queryParams.qualityInspectionStatus" placeholder="请选择质检状态" clearable>
          <el-option
            v-for="dict in dict.type.biz_quality"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否入库" prop="isInbound">
        <el-select v-model="queryParams.isInbound" placeholder="请选择是否入库" clearable>
          <el-option
            v-for="dict in dict.type.biz_is_inbound"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['biz:list:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['biz:list:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['biz:list:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['biz:list:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="listList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="仓库名称" align="center" prop="warehouseName" />
      <el-table-column label="入库商品名称" align="center" prop="productName" />
      <el-table-column label="入库商品类别" align="center" prop="productCategory">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.biz_product_category" :value="scope.row.productCategory"/>
        </template>
      </el-table-column>
      <el-table-column label="入库商品数量" align="center" prop="productQuantity" />
      <el-table-column label="入库商品总价" align="center" prop="productTotalPrice" />
      <el-table-column label="入库规格" align="center" prop="productSpecification" />
      <el-table-column label="入库人姓名" align="center" prop="inboundPersonName" />
      <el-table-column label="供应商名称" align="center" prop="supplierName" />
      <el-table-column label="质检状态" align="center" prop="qualityInspectionStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.biz_quality" :value="scope.row.qualityInspectionStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="是否入库" align="center" prop="isInbound">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.biz_is_inbound" :value="scope.row.isInbound"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['biz:list:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['biz:list:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改入库清单管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="仓库ID" prop="warehouseId">
          <el-input v-model="form.warehouseId" placeholder="请输入仓库ID" />
        </el-form-item>
        <el-form-item label="仓库名称" prop="warehouseName">
          <el-input v-model="form.warehouseName" placeholder="请输入仓库名称" />
        </el-form-item>
        <el-form-item label="入库商品名称" prop="productName">
          <el-input v-model="form.productName" placeholder="请输入入库商品名称" />
        </el-form-item>
        <el-form-item label="入库商品类别" prop="productCategory">
          <el-select v-model="form.productCategory" placeholder="请选择入库商品类别">
            <el-option
              v-for="dict in dict.type.biz_product_category"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="入库商品数量" prop="productQuantity">
          <el-input v-model="form.productQuantity" placeholder="请输入入库商品数量" />
        </el-form-item>
        <el-form-item label="入库商品总价" prop="productTotalPrice">
          <el-input v-model="form.productTotalPrice" placeholder="请输入入库商品总价" />
        </el-form-item>
        <el-form-item label="入库规格" prop="productSpecification">
          <el-input v-model="form.productSpecification" placeholder="请输入入库规格" />
        </el-form-item>
        <el-form-item label="入库人姓名" prop="inboundPersonName">
          <el-input v-model="form.inboundPersonName" placeholder="请输入入库人姓名" />
        </el-form-item>
        <el-form-item label="供应商名称" prop="supplierName">
          <el-input v-model="form.supplierName" placeholder="请输入供应商名称" />
        </el-form-item>
        <el-form-item label="质检状态" prop="qualityInspectionStatus">
          <el-select v-model="form.qualityInspectionStatus" placeholder="请选择质检状态">
            <el-option
              v-for="dict in dict.type.biz_quality"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否入库" prop="isInbound">
          <el-select v-model="form.isInbound" placeholder="请选择是否入库">
            <el-option
              v-for="dict in dict.type.biz_is_inbound"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listList, getList, delList, addList, updateList } from "@/api/biz/list";

export default {
  name: "List",
  dicts: ['biz_is_inbound', 'biz_quality', 'biz_product_category'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 入库清单管理表格数据
      listList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        warehouseName: null,
        productName: null,
        productCategory: null,
        supplierName: null,
        qualityInspectionStatus: null,
        isInbound: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询入库清单管理列表 */
    getList() {
      this.loading = true;
      listList(this.queryParams).then(response => {
        this.listList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        inboundListId: null,
        warehouseId: null,
        warehouseName: null,
        productName: null,
        productCategory: null,
        productQuantity: null,
        productTotalPrice: null,
        productSpecification: null,
        inboundPersonName: null,
        supplierName: null,
        qualityInspectionStatus: null,
        isInbound: null,
        tenantId: null,
        createdBy: null,
        createdTime: null,
        lastModifiedBy: null,
        lastModifiedTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.inboundListId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加入库清单管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const inboundListId = row.inboundListId || this.ids
      getList(inboundListId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改入库清单管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.inboundListId != null) {
            updateList(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addList(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const inboundListIds = row.inboundListId || this.ids;
      this.$modal.confirm('是否确认删除入库清单管理编号为"' + inboundListIds + '"的数据项？').then(function() {
        return delList(inboundListIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('biz/list/export', {
        ...this.queryParams
      }, `list_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
