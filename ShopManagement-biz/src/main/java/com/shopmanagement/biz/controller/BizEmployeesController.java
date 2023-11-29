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
import com.shopmanagement.biz.domain.BizEmployees;
import com.shopmanagement.biz.service.IBizEmployeesService;
import com.shopmanagement.common.utils.poi.ExcelUtil;
import com.shopmanagement.common.core.page.TableDataInfo;

/**
 * 商铺员工Controller
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
@RestController
@RequestMapping("/system/employees")
public class BizEmployeesController extends BaseController
{
    @Autowired
    private IBizEmployeesService bizEmployeesService;

    /**
     * 查询商铺员工列表
     */
    @PreAuthorize("@ss.hasPermi('system:employees:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizEmployees bizEmployees)
    {
        startPage();
        List<BizEmployees> list = bizEmployeesService.selectBizEmployeesList(bizEmployees);
        return getDataTable(list);
    }

    /**
     * 导出商铺员工列表
     */
    @PreAuthorize("@ss.hasPermi('system:employees:export')")
    @Log(title = "商铺员工", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizEmployees bizEmployees)
    {
        List<BizEmployees> list = bizEmployeesService.selectBizEmployeesList(bizEmployees);
        ExcelUtil<BizEmployees> util = new ExcelUtil<BizEmployees>(BizEmployees.class);
        util.exportExcel(response, list, "商铺员工数据");
    }

    /**
     * 获取商铺员工详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:employees:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizEmployeesService.selectBizEmployeesById(id));
    }

    /**
     * 新增商铺员工
     */
    @PreAuthorize("@ss.hasPermi('system:employees:add')")
    @Log(title = "商铺员工", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizEmployees bizEmployees)
    {
        return toAjax(bizEmployeesService.insertBizEmployees(bizEmployees));
    }

    /**
     * 修改商铺员工
     */
    @PreAuthorize("@ss.hasPermi('system:employees:edit')")
    @Log(title = "商铺员工", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizEmployees bizEmployees)
    {
        return toAjax(bizEmployeesService.updateBizEmployees(bizEmployees));
    }

    /**
     * 删除商铺员工
     */
    @PreAuthorize("@ss.hasPermi('system:employees:remove')")
    @Log(title = "商铺员工", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizEmployeesService.deleteBizEmployeesByIds(ids));
    }
}
