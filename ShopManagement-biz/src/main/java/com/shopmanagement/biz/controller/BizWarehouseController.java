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
import com.shopmanagement.biz.domain.BizWarehouse;
import com.shopmanagement.biz.service.IBizWarehouseService;
import com.shopmanagement.common.utils.poi.ExcelUtil;
import com.shopmanagement.common.core.page.TableDataInfo;

/**
 * 仓库信息Controller
 * 
 * @author zr
 * @date 2024-01-19
 */
@RestController
@RequestMapping("/biz/warehouse")
public class BizWarehouseController extends BaseController
{
    @Autowired
    private IBizWarehouseService bizWarehouseService;

    /**
     * 查询仓库信息列表
     */
    @PreAuthorize("@ss.hasPermi('biz:warehouse:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizWarehouse bizWarehouse)
    {
        startPage();
        List<BizWarehouse> list = bizWarehouseService.selectBizWarehouseList(bizWarehouse);
        return getDataTable(list);
    }

    /**
     * 导出仓库信息列表
     */
    @PreAuthorize("@ss.hasPermi('biz:warehouse:export')")
    @Log(title = "仓库信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizWarehouse bizWarehouse)
    {
        List<BizWarehouse> list = bizWarehouseService.selectBizWarehouseList(bizWarehouse);
        ExcelUtil<BizWarehouse> util = new ExcelUtil<BizWarehouse>(BizWarehouse.class);
        util.exportExcel(response, list, "仓库信息数据");
    }

    /**
     * 获取仓库信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:warehouse:query')")
    @GetMapping(value = "/{warehouseId}")
    public AjaxResult getInfo(@PathVariable("warehouseId") Long warehouseId)
    {
        return success(bizWarehouseService.selectBizWarehouseByWarehouseId(warehouseId));
    }

    /**
     * 新增仓库信息
     */
    @PreAuthorize("@ss.hasPermi('biz:warehouse:add')")
    @Log(title = "仓库信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizWarehouse bizWarehouse)
    {
        return toAjax(bizWarehouseService.insertBizWarehouse(bizWarehouse));
    }

    /**
     * 修改仓库信息
     */
    @PreAuthorize("@ss.hasPermi('biz:warehouse:edit')")
    @Log(title = "仓库信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizWarehouse bizWarehouse)
    {
        return toAjax(bizWarehouseService.updateBizWarehouse(bizWarehouse));
    }

    /**
     * 删除仓库信息
     */
    @PreAuthorize("@ss.hasPermi('biz:warehouse:remove')")
    @Log(title = "仓库信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{warehouseIds}")
    public AjaxResult remove(@PathVariable Long[] warehouseIds)
    {
        return toAjax(bizWarehouseService.deleteBizWarehouseByWarehouseIds(warehouseIds));
    }
}
