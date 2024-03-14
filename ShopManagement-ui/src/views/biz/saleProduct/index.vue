<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品编号" prop="productNumber">
        <el-input
          v-model="queryParams.productNumber"
          placeholder="请输入商品编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品名称" prop="productName">
        <el-input
          v-model="queryParams.productName"
          placeholder="请输入商品名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品类别" prop="productCategory">
        <el-select v-model="queryParams.productCategory" placeholder="请选择商品类别" clearable>
          <el-option
            v-for="dict in dict.type.biz_product_category"
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
        <!-- <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['biz:saleProduct:add']"
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
          v-hasPermi="['biz:saleProduct:edit']"
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
          v-hasPermi="['biz:saleProduct:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['biz:saleProduct:export']"
        >导出</el-button> -->
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

  <el-row :gutter="20">

      <el-col :span="12">
      <el-table v-loading="loading" :data="cartList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="商品名称" align="center" prop="productName" />
      <el-table-column label="商品单价" align="center" prop="unitPrice" />
      <el-table-column label="数量" align="center" prop="count" >
        <template slot-scope="scope">
            <span> x {{ scope.row.count }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            @click="handleEdit(scope.row)"
          >修改</el-button>
        </template>
      </el-table-column>
      </el-table>
      <el-row>
        <el-col :span="12" style="text-align: center;">
          <span>商品合计：{{ totalAmount }}</span>
        </el-col>
        <!-- <el-col :span="12">去支付</el-col> -->
         <el-button
          type="primary"
          plain
          size="mini"
          @click="handleAdd"
        >去支付</el-button>
      </el-row>

      </el-col>

    
    <el-col :span="12">
      <el-table v-loading="loading" :data="saleProductList" @selection-change="handleSelectionChange" @row-click="handleTableRowClick">
      <!-- <el-table-column type="selection" width="55" align="center" /> -->
      <el-table-column label="商品名称" align="center" prop="productName" />
      <el-table-column label="商品库存" align="center" prop="productStock" />
      <el-table-column label="商品单价" align="center" prop="unitPrice" />
    </el-table>
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
    </el-col>
  </el-row>
    


    <!-- 添加或修改商品收银对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品编号" prop="productNumber">
          <el-input v-model="form.productNumber" placeholder="请输入商品编号" />
        </el-form-item>
        <el-form-item label="商品名称" prop="productName">
          <el-input v-model="form.productName" placeholder="请输入商品名称" />
        </el-form-item>
        <el-form-item label="商品单位" prop="productUnit">
          <el-input v-model="form.productUnit" placeholder="请输入商品单位" />
        </el-form-item>
        <el-form-item label="商品类别" prop="productCategory">
          <el-select v-model="form.productCategory" placeholder="请选择商品类别">
            <el-option
              v-for="dict in dict.type.biz_product_category"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="商品库存" prop="productStock">
          <el-input v-model="form.productStock" placeholder="请输入商品库存" />
        </el-form-item>
        <el-form-item label="商品所属仓库ID" prop="warehouseId">
          <el-input v-model="form.warehouseId" placeholder="请输入商品所属仓库ID" />
        </el-form-item>
        <el-form-item label="商品单价" prop="unitPrice">
          <el-input v-model="form.unitPrice" placeholder="请输入商品单价" />
        </el-form-item>
        <el-form-item label="商品进货价" prop="purchasePrice">
          <el-input v-model="form.purchasePrice" placeholder="请输入商品进货价" />
        </el-form-item>
        <el-form-item label="告警阈值" prop="alarmThreshold">
          <el-input v-model="form.alarmThreshold" placeholder="请输入告警阈值" />
        </el-form-item>
        <el-form-item label="是否告警" prop="isalarm">
          <el-select v-model="form.isalarm" placeholder="请选择是否告警">
            <el-option
              v-for="dict in dict.type.biz_is_inbound"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="租户ID" prop="tenantId">
          <el-input v-model="form.tenantId" placeholder="请输入租户ID" />
        </el-form-item>
        <el-form-item label="创建者" prop="createdBy">
          <el-input v-model="form.createdBy" placeholder="请输入创建者" />
        </el-form-item>
        <el-form-item label="创建时间" prop="createdTime">
          <el-date-picker clearable
            v-model="form.createdTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="最后修改者" prop="lastModifiedBy">
          <el-input v-model="form.lastModifiedBy" placeholder="请输入最后修改者" />
        </el-form-item>
        <el-form-item label="最后修改时间" prop="lastModifiedTime">
          <el-date-picker clearable
            v-model="form.lastModifiedTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择最后修改时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

        <!-- 修改商品数量 -->
    <el-dialog title="修改商品数量" :visible.sync="editProCountOpne" width="500px" append-to-body>
      <el-form ref="cartItemForm" :model="cartItemForm" label-width="80px">
        <el-form-item label="商品名称" prop="productName">
          <el-input v-model="cartItemForm.productName" disabled />
        </el-form-item>
        <el-form-item label="商品单价" prop="unitPrice">
          <el-input v-model="cartItemForm.unitPrice" disabled/>
        </el-form-item>
        <el-form-item label="商品数量" prop="count">
          <el-input v-model="cartItemForm.count" placeholder="请输入商品数量" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitCartItemForm">确 定</el-button>
        <el-button @click="editProCountOpne  = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listSaleProduct, getSaleProduct, delSaleProduct, addSaleProduct, updateSaleProduct } from "@/api/biz/saleProduct";
import { Alert } from "element-ui";

export default {
  name: "SaleProduct",
  dicts: ['biz_is_inbound', 'biz_product_category'],
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
      showSearch: false,
      // 总条数
      total: 0,
      totalAmount: 0.0,
      cartList: [],
      // 商品收银表格数据
      saleProductList: [],
      // 弹出层标题
      title: "",
      cartItemForm: {},
      editProCountOpne: false,
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        productNumber: null,
        productName: null,
        productUnit: null,
        productCategory: null,
        productStock: null,
        warehouseId: 0,
        unitPrice: null,
        purchasePrice: null,
        alarmThreshold: null,
        isalarm: null,
        tenantId: null,
        createdBy: null,
        createdTime: null,
        lastModifiedBy: null,
        lastModifiedTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        productNumber: [
          { required: true, message: "商品编号不能为空", trigger: "blur" }
        ],
        productCategory: [
          { required: true, message: "商品类别不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    submitCartItemForm() {
      for(let i = 0; i < this.cartList.length; i++) {
          if (this.cartList[i].productId === this.cartItemForm.productId) {
            this.cartList[i].count = parseInt(this.cartItemForm.count);
            this.cartList = JSON.parse(JSON.stringify(this.cartList));
            this.cartItemForm = {};
            this.editProCountOpne = false;
            return;
          }
        }
    },
    handleEdit(row) {
        
        this.cartItemForm.productName = row.productName;
        this.cartItemForm.productUnit = row.productUnit;
        this.cartItemForm.count = parseInt(row.count);
        this.editProCountOpne = true;
    },
    handleTableRowClick(row, $index, event) {
      if (this.cartList.length === 0) {
          row.count = 1;
          this.cartList.push(row);
          this.totalAmount = this.totalAmount+row.unitPrice
      }else {
        let flag = true;
        for(let i = 0; i < this.cartList.length; i++) {
          if (this.cartList[i].productId === row.productId) {
            this.cartList[i].count = parseInt(this.cartList[i].count) + 1;
            this.cartList = JSON.parse(JSON.stringify(this.cartList));
            flag = false;
            this.totalAmount = this.totalAmount+row.unitPrice
            return;
          }
        }
        if (flag) {
          row.count = 1;
          this.cartList.push(row);
          this.totalAmount = this.totalAmount+row.unitPrice
        }
      }
    },

    /** 查询商品收银列表 */
    getList() {
      this.loading = true;
      listSaleProduct(this.queryParams).then(response => {
        this.saleProductList = response.rows;
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
        productId: null,
        productNumber: null,
        productName: null,
        productUnit: null,
        productCategory: null,
        productStock: null,
        warehouseId: null,
        unitPrice: null,
        purchasePrice: null,
        alarmThreshold: null,
        isalarm: null,
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
      this.ids = selection.map(item => item.productId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加商品收银";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const productId = row.productId || this.ids
      getSaleProduct(productId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改商品收银";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.productId != null) {
            updateSaleProduct(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSaleProduct(this.form).then(response => {
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
      const productIds = row.productId || this.ids;
      this.$modal.confirm('是否确认删除商品收银编号为"' + productIds + '"的数据项？').then(function() {
        return delSaleProduct(productIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('biz/saleProduct/export', {
        ...this.queryParams
      }, `saleProduct_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
