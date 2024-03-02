package com.shopmanagement.biz.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shopmanagement.common.annotation.Log;
import com.shopmanagement.common.core.controller.BaseController;
import com.shopmanagement.common.core.domain.AjaxResult;
import com.shopmanagement.common.enums.BusinessType;
import com.shopmanagement.biz.domain.BizSaleProduct;
import com.shopmanagement.biz.service.IBizSaleProductService;
import com.shopmanagement.common.utils.poi.ExcelUtil;
import com.shopmanagement.common.core.page.TableDataInfo;

/**
 * 商品收银Controller
 * 
 * @author zr
 * @date 2024-03-02
 */
@RestController
@RequestMapping("/biz/saleProduct")
public class BizSaleProductController extends BaseController
{
    @Autowired
    private IBizSaleProductService bizSaleProductService;

    /**
     * 查询商品收银列表
     */
    @PreAuthorize("@ss.hasPermi('biz:saleProduct:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizSaleProduct bizSaleProduct)
    {
        startPage();
        List<BizSaleProduct> list = bizSaleProductService.selectBizSaleProductList(bizSaleProduct);
        return getDataTable(list);
    }

    /**
     * 导出商品收银列表
     */
    @PreAuthorize("@ss.hasPermi('biz:saleProduct:export')")
    @Log(title = "商品收银", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizSaleProduct bizSaleProduct)
    {
        List<BizSaleProduct> list = bizSaleProductService.selectBizSaleProductList(bizSaleProduct);
        ExcelUtil<BizSaleProduct> util = new ExcelUtil<BizSaleProduct>(BizSaleProduct.class);
        util.exportExcel(response, list, "商品收银数据");
    }

    /**
     * 获取商品收银详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:saleProduct:query')")
    @GetMapping(value = "/{productId}")
    public AjaxResult getInfo(@PathVariable("productId") Long productId)
    {
        return success(bizSaleProductService.selectBizSaleProductByProductId(productId));
    }

    /**
     * 新增商品收银
     */
    @PreAuthorize("@ss.hasPermi('biz:saleProduct:add')")
    @Log(title = "商品收银", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizSaleProduct bizSaleProduct)
    {
        return toAjax(bizSaleProductService.insertBizSaleProduct(bizSaleProduct));
    }

    /**
     * 修改商品收银
     */
    @PreAuthorize("@ss.hasPermi('biz:saleProduct:edit')")
    @Log(title = "商品收银", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizSaleProduct bizSaleProduct)
    {
        return toAjax(bizSaleProductService.updateBizSaleProduct(bizSaleProduct));
    }

    /**
     * 删除商品收银
     */
    @PreAuthorize("@ss.hasPermi('biz:saleProduct:remove')")
    @Log(title = "商品收银", businessType = BusinessType.DELETE)
	@DeleteMapping("/{productIds}")
    public AjaxResult remove(@PathVariable Long[] productIds)
    {
        return toAjax(bizSaleProductService.deleteBizSaleProductByProductIds(productIds));
    }
}
