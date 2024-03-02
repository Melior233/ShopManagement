package com.shopmanagement.biz.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.shopmanagement.biz.domain.BizSupplier;
import com.shopmanagement.biz.service.IBizSupplierService;
import com.shopmanagement.common.utils.poi.ExcelUtil;
import com.shopmanagement.common.core.page.TableDataInfo;

/**
 * 供应商信息Controller
 * 
 * @author zr
 * @date 2024-02-27
 */
@RestController
@RequestMapping("/biz/supplier")
public class BizSupplierController extends BaseController
{
    private final IBizSupplierService bizSupplierService;

    public BizSupplierController(IBizSupplierService bizSupplierService) {
        this.bizSupplierService = bizSupplierService;
    }

    /**
     * 查询供应商信息列表
     */
    @PreAuthorize("@ss.hasPermi('biz:supplier:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizSupplier bizSupplier)
    {
        startPage();
        List<BizSupplier> list = bizSupplierService.selectBizSupplierList(bizSupplier);
        return getDataTable(list);
    }

    /**
     * 导出供应商信息列表
     */
    @PreAuthorize("@ss.hasPermi('biz:supplier:export')")
    @Log(title = "供应商信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizSupplier bizSupplier)
    {
        List<BizSupplier> list = bizSupplierService.selectBizSupplierList(bizSupplier);
        ExcelUtil<BizSupplier> util = new ExcelUtil<BizSupplier>(BizSupplier.class);
        util.exportExcel(response, list, "供应商信息数据");
    }

    /**
     * 获取供应商信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:supplier:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizSupplierService.selectBizSupplierById(id));
    }

    /**
     * 新增供应商信息
     */
    @PreAuthorize("@ss.hasPermi('biz:supplier:add')")
    @Log(title = "供应商信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizSupplier bizSupplier)
    {
        return toAjax(bizSupplierService.insertBizSupplier(bizSupplier));
    }

    /**
     * 修改供应商信息
     */
    @PreAuthorize("@ss.hasPermi('biz:supplier:edit')")
    @Log(title = "供应商信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizSupplier bizSupplier)
    {
        return toAjax(bizSupplierService.updateBizSupplier(bizSupplier));
    }

    /**
     * 删除供应商信息
     */
    @PreAuthorize("@ss.hasPermi('biz:supplier:remove')")
    @Log(title = "供应商信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizSupplierService.deleteBizSupplierByIds(ids));
    }
}
