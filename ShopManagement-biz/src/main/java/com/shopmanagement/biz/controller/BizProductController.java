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
import com.shopmanagement.biz.domain.BizProduct;
import com.shopmanagement.biz.service.IBizProductService;
import com.shopmanagement.common.utils.poi.ExcelUtil;
import com.shopmanagement.common.core.page.TableDataInfo;

/**
 * 商品信息管理Controller
 * 
 * @author zr
 * @date 2024-01-19
 */
@RestController
@RequestMapping("/biz/product")
public class BizProductController extends BaseController
{
    @Autowired
    private IBizProductService bizProductService;

    /**
     * 查询商品信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('biz:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizProduct bizProduct)
    {
        startPage();
        List<BizProduct> list = bizProductService.selectBizProductList(bizProduct);
        return getDataTable(list);
    }

    /**
     * 导出商品信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('biz:product:export')")
    @Log(title = "商品信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizProduct bizProduct)
    {
        List<BizProduct> list = bizProductService.selectBizProductList(bizProduct);
        ExcelUtil<BizProduct> util = new ExcelUtil<BizProduct>(BizProduct.class);
        util.exportExcel(response, list, "商品信息管理数据");
    }

    /**
     * 获取商品信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:product:query')")
    @GetMapping(value = "/{productId}")
    public AjaxResult getInfo(@PathVariable("productId") Long productId)
    {
        return success(bizProductService.selectBizProductByProductId(productId));
    }

    /**
     * 新增商品信息管理
     */
    @PreAuthorize("@ss.hasPermi('biz:product:add')")
    @Log(title = "商品信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizProduct bizProduct)
    {
        return toAjax(bizProductService.insertBizProduct(bizProduct));
    }

    /**
     * 修改商品信息管理
     */
    @PreAuthorize("@ss.hasPermi('biz:product:edit')")
    @Log(title = "商品信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizProduct bizProduct)
    {
        return toAjax(bizProductService.updateBizProduct(bizProduct));
    }

    /**
     * 删除商品信息管理
     */
    @PreAuthorize("@ss.hasPermi('biz:product:remove')")
    @Log(title = "商品信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{productIds}")
    public AjaxResult remove(@PathVariable Long[] productIds)
    {
        return toAjax(bizProductService.deleteBizProductByProductIds(productIds));
    }
}
