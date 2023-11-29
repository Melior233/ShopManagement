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
import com.shopmanagement.biz.domain.BizEmployeeAttendance;
import com.shopmanagement.biz.service.IBizEmployeeAttendanceService;
import com.shopmanagement.common.utils.poi.ExcelUtil;
import com.shopmanagement.common.core.page.TableDataInfo;

/**
 * 商铺员工考勤记录Controller
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
@RestController
@RequestMapping("/system/attendance")
public class BizEmployeeAttendanceController extends BaseController
{
    @Autowired
    private IBizEmployeeAttendanceService bizEmployeeAttendanceService;

    /**
     * 查询商铺员工考勤记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:attendance:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizEmployeeAttendance bizEmployeeAttendance)
    {
        startPage();
        List<BizEmployeeAttendance> list = bizEmployeeAttendanceService.selectBizEmployeeAttendanceList(bizEmployeeAttendance);
        return getDataTable(list);
    }

    /**
     * 导出商铺员工考勤记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:attendance:export')")
    @Log(title = "商铺员工考勤记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizEmployeeAttendance bizEmployeeAttendance)
    {
        List<BizEmployeeAttendance> list = bizEmployeeAttendanceService.selectBizEmployeeAttendanceList(bizEmployeeAttendance);
        ExcelUtil<BizEmployeeAttendance> util = new ExcelUtil<BizEmployeeAttendance>(BizEmployeeAttendance.class);
        util.exportExcel(response, list, "商铺员工考勤记录数据");
    }

    /**
     * 获取商铺员工考勤记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:attendance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizEmployeeAttendanceService.selectBizEmployeeAttendanceById(id));
    }

    /**
     * 新增商铺员工考勤记录
     */
    @PreAuthorize("@ss.hasPermi('system:attendance:add')")
    @Log(title = "商铺员工考勤记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizEmployeeAttendance bizEmployeeAttendance)
    {
        return toAjax(bizEmployeeAttendanceService.insertBizEmployeeAttendance(bizEmployeeAttendance));
    }

    /**
     * 修改商铺员工考勤记录
     */
    @PreAuthorize("@ss.hasPermi('system:attendance:edit')")
    @Log(title = "商铺员工考勤记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizEmployeeAttendance bizEmployeeAttendance)
    {
        return toAjax(bizEmployeeAttendanceService.updateBizEmployeeAttendance(bizEmployeeAttendance));
    }

    /**
     * 删除商铺员工考勤记录
     */
    @PreAuthorize("@ss.hasPermi('system:attendance:remove')")
    @Log(title = "商铺员工考勤记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizEmployeeAttendanceService.deleteBizEmployeeAttendanceByIds(ids));
    }
}
