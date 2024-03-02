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
import com.shopmanagement.biz.domain.BizVipCustomer;
import com.shopmanagement.biz.service.IBizVipCustomerService;
import com.shopmanagement.common.utils.poi.ExcelUtil;
import com.shopmanagement.common.core.page.TableDataInfo;

/**
 * VIP客户信息Controller
 * 
 * @author zr
 * @date 2024-02-27
 */
@RestController
@RequestMapping("/biz/customer")
public class BizVipCustomerController extends BaseController
{
    private final IBizVipCustomerService bizVipCustomerService;

    public BizVipCustomerController(IBizVipCustomerService bizVipCustomerService) {
        this.bizVipCustomerService = bizVipCustomerService;
    }

    /**
     * 查询VIP客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('biz:customer:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizVipCustomer bizVipCustomer)
    {
        startPage();
        List<BizVipCustomer> list = bizVipCustomerService.selectBizVipCustomerList(bizVipCustomer);
        return getDataTable(list);
    }

    /**
     * 导出VIP客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('biz:customer:export')")
    @Log(title = "VIP客户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizVipCustomer bizVipCustomer)
    {
        List<BizVipCustomer> list = bizVipCustomerService.selectBizVipCustomerList(bizVipCustomer);
        ExcelUtil<BizVipCustomer> util = new ExcelUtil<BizVipCustomer>(BizVipCustomer.class);
        util.exportExcel(response, list, "VIP客户信息数据");
    }

    /**
     * 获取VIP客户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:customer:query')")
    @GetMapping(value = "/{vipCustomerId}")
    public AjaxResult getInfo(@PathVariable("vipCustomerId") Long vipCustomerId)
    {
        return success(bizVipCustomerService.selectBizVipCustomerByVipCustomerId(vipCustomerId));
    }

    /**
     * 新增VIP客户信息
     */
    @PreAuthorize("@ss.hasPermi('biz:customer:add')")
    @Log(title = "VIP客户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizVipCustomer bizVipCustomer)
    {
        return toAjax(bizVipCustomerService.insertBizVipCustomer(bizVipCustomer));
    }

    /**
     * 修改VIP客户信息
     */
    @PreAuthorize("@ss.hasPermi('biz:customer:edit')")
    @Log(title = "VIP客户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizVipCustomer bizVipCustomer)
    {
        return toAjax(bizVipCustomerService.updateBizVipCustomer(bizVipCustomer));
    }

    /**
     * 删除VIP客户信息
     */
    @PreAuthorize("@ss.hasPermi('biz:customer:remove')")
    @Log(title = "VIP客户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{vipCustomerIds}")
    public AjaxResult remove(@PathVariable Long[] vipCustomerIds)
    {
        return toAjax(bizVipCustomerService.deleteBizVipCustomerByVipCustomerIds(vipCustomerIds));
    }
}
