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
import com.shopmanagement.biz.domain.BizProducts;
import com.shopmanagement.biz.service.IBizProductsService;
import com.shopmanagement.common.utils.poi.ExcelUtil;
import com.shopmanagement.common.core.page.TableDataInfo;

/**
 * 商铺商品Controller
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
@RestController
@RequestMapping("/system/products")
public class BizProductsController extends BaseController
{
    @Autowired
    private IBizProductsService bizProductsService;

    /**
     * 查询商铺商品列表
     */
    @PreAuthorize("@ss.hasPermi('system:products:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizProducts bizProducts)
    {
        startPage();
        List<BizProducts> list = bizProductsService.selectBizProductsList(bizProducts);
        return getDataTable(list);
    }

    /**
     * 导出商铺商品列表
     */
    @PreAuthorize("@ss.hasPermi('system:products:export')")
    @Log(title = "商铺商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizProducts bizProducts)
    {
        List<BizProducts> list = bizProductsService.selectBizProductsList(bizProducts);
        ExcelUtil<BizProducts> util = new ExcelUtil<BizProducts>(BizProducts.class);
        util.exportExcel(response, list, "商铺商品数据");
    }

    /**
     * 获取商铺商品详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:products:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizProductsService.selectBizProductsById(id));
    }

    /**
     * 新增商铺商品
     */
    @PreAuthorize("@ss.hasPermi('system:products:add')")
    @Log(title = "商铺商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizProducts bizProducts)
    {
        return toAjax(bizProductsService.insertBizProducts(bizProducts));
    }

    /**
     * 修改商铺商品
     */
    @PreAuthorize("@ss.hasPermi('system:products:edit')")
    @Log(title = "商铺商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizProducts bizProducts)
    {
        return toAjax(bizProductsService.updateBizProducts(bizProducts));
    }

    /**
     * 删除商铺商品
     */
    @PreAuthorize("@ss.hasPermi('system:products:remove')")
    @Log(title = "商铺商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizProductsService.deleteBizProductsByIds(ids));
    }
}
