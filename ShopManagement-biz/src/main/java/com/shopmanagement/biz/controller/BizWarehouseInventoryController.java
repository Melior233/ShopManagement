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
import com.shopmanagement.biz.domain.BizWarehouseInventory;
import com.shopmanagement.biz.service.IBizWarehouseInventoryService;
import com.shopmanagement.common.utils.poi.ExcelUtil;
import com.shopmanagement.common.core.page.TableDataInfo;

/**
 * 商铺仓库商品库存Controller
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
@RestController
@RequestMapping("/system/inventory")
public class BizWarehouseInventoryController extends BaseController
{
    @Autowired
    private IBizWarehouseInventoryService bizWarehouseInventoryService;

    /**
     * 查询商铺仓库商品库存列表
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizWarehouseInventory bizWarehouseInventory)
    {
        startPage();
        List<BizWarehouseInventory> list = bizWarehouseInventoryService.selectBizWarehouseInventoryList(bizWarehouseInventory);
        return getDataTable(list);
    }

    /**
     * 导出商铺仓库商品库存列表
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:export')")
    @Log(title = "商铺仓库商品库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizWarehouseInventory bizWarehouseInventory)
    {
        List<BizWarehouseInventory> list = bizWarehouseInventoryService.selectBizWarehouseInventoryList(bizWarehouseInventory);
        ExcelUtil<BizWarehouseInventory> util = new ExcelUtil<BizWarehouseInventory>(BizWarehouseInventory.class);
        util.exportExcel(response, list, "商铺仓库商品库存数据");
    }

    /**
     * 获取商铺仓库商品库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizWarehouseInventoryService.selectBizWarehouseInventoryById(id));
    }

    /**
     * 新增商铺仓库商品库存
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:add')")
    @Log(title = "商铺仓库商品库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizWarehouseInventory bizWarehouseInventory)
    {
        return toAjax(bizWarehouseInventoryService.insertBizWarehouseInventory(bizWarehouseInventory));
    }

    /**
     * 修改商铺仓库商品库存
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:edit')")
    @Log(title = "商铺仓库商品库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizWarehouseInventory bizWarehouseInventory)
    {
        return toAjax(bizWarehouseInventoryService.updateBizWarehouseInventory(bizWarehouseInventory));
    }

    /**
     * 删除商铺仓库商品库存
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:remove')")
    @Log(title = "商铺仓库商品库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizWarehouseInventoryService.deleteBizWarehouseInventoryByIds(ids));
    }
}
