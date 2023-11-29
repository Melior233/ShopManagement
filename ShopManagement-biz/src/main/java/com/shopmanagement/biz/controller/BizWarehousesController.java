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
import com.shopmanagement.biz.domain.BizWarehouses;
import com.shopmanagement.biz.service.IBizWarehousesService;
import com.shopmanagement.common.utils.poi.ExcelUtil;
import com.shopmanagement.common.core.page.TableDataInfo;

/**
 * 商铺仓库Controller
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
@RestController
@RequestMapping("/system/warehouses")
public class BizWarehousesController extends BaseController
{
    @Autowired
    private IBizWarehousesService bizWarehousesService;

    /**
     * 查询商铺仓库列表
     */
    @PreAuthorize("@ss.hasPermi('system:warehouses:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizWarehouses bizWarehouses)
    {
        startPage();
        List<BizWarehouses> list = bizWarehousesService.selectBizWarehousesList(bizWarehouses);
        return getDataTable(list);
    }

    /**
     * 导出商铺仓库列表
     */
    @PreAuthorize("@ss.hasPermi('system:warehouses:export')")
    @Log(title = "商铺仓库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizWarehouses bizWarehouses)
    {
        List<BizWarehouses> list = bizWarehousesService.selectBizWarehousesList(bizWarehouses);
        ExcelUtil<BizWarehouses> util = new ExcelUtil<BizWarehouses>(BizWarehouses.class);
        util.exportExcel(response, list, "商铺仓库数据");
    }

    /**
     * 获取商铺仓库详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:warehouses:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizWarehousesService.selectBizWarehousesById(id));
    }

    /**
     * 新增商铺仓库
     */
    @PreAuthorize("@ss.hasPermi('system:warehouses:add')")
    @Log(title = "商铺仓库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizWarehouses bizWarehouses)
    {
        return toAjax(bizWarehousesService.insertBizWarehouses(bizWarehouses));
    }

    /**
     * 修改商铺仓库
     */
    @PreAuthorize("@ss.hasPermi('system:warehouses:edit')")
    @Log(title = "商铺仓库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizWarehouses bizWarehouses)
    {
        return toAjax(bizWarehousesService.updateBizWarehouses(bizWarehouses));
    }

    /**
     * 删除商铺仓库
     */
    @PreAuthorize("@ss.hasPermi('system:warehouses:remove')")
    @Log(title = "商铺仓库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizWarehousesService.deleteBizWarehousesByIds(ids));
    }
}
