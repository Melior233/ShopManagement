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
import com.shopmanagement.biz.domain.BizNotifications;
import com.shopmanagement.biz.service.IBizNotificationsService;
import com.shopmanagement.common.utils.poi.ExcelUtil;
import com.shopmanagement.common.core.page.TableDataInfo;

/**
 * 商铺通知Controller
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
@RestController
@RequestMapping("/system/notifications")
public class BizNotificationsController extends BaseController
{
    @Autowired
    private IBizNotificationsService bizNotificationsService;

    /**
     * 查询商铺通知列表
     */
    @PreAuthorize("@ss.hasPermi('system:notifications:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizNotifications bizNotifications)
    {
        startPage();
        List<BizNotifications> list = bizNotificationsService.selectBizNotificationsList(bizNotifications);
        return getDataTable(list);
    }

    /**
     * 导出商铺通知列表
     */
    @PreAuthorize("@ss.hasPermi('system:notifications:export')")
    @Log(title = "商铺通知", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizNotifications bizNotifications)
    {
        List<BizNotifications> list = bizNotificationsService.selectBizNotificationsList(bizNotifications);
        ExcelUtil<BizNotifications> util = new ExcelUtil<BizNotifications>(BizNotifications.class);
        util.exportExcel(response, list, "商铺通知数据");
    }

    /**
     * 获取商铺通知详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:notifications:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizNotificationsService.selectBizNotificationsById(id));
    }

    /**
     * 新增商铺通知
     */
    @PreAuthorize("@ss.hasPermi('system:notifications:add')")
    @Log(title = "商铺通知", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizNotifications bizNotifications)
    {
        return toAjax(bizNotificationsService.insertBizNotifications(bizNotifications));
    }

    /**
     * 修改商铺通知
     */
    @PreAuthorize("@ss.hasPermi('system:notifications:edit')")
    @Log(title = "商铺通知", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizNotifications bizNotifications)
    {
        return toAjax(bizNotificationsService.updateBizNotifications(bizNotifications));
    }

    /**
     * 删除商铺通知
     */
    @PreAuthorize("@ss.hasPermi('system:notifications:remove')")
    @Log(title = "商铺通知", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizNotificationsService.deleteBizNotificationsByIds(ids));
    }
}
