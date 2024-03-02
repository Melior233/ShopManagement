package com.shopmanagement.biz.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.shopmanagement.biz.service.dto.BizOrderDetailDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import com.shopmanagement.biz.domain.BizOrder;
import com.shopmanagement.biz.service.IBizOrderService;
import com.shopmanagement.common.utils.poi.ExcelUtil;
import com.shopmanagement.common.core.page.TableDataInfo;

/**
 * 销售订单Controller
 * 
 * @author zr
 * @date 2024-02-27
 */
@RestController
@RequestMapping("/biz/order")
public class BizOrderController extends BaseController
{
    private final IBizOrderService bizOrderService;

    public BizOrderController(IBizOrderService bizOrderService) {
        this.bizOrderService = bizOrderService;
    }

    /**
     * 查询销售订单列表
     */
    @ApiOperation("查询销售订单列表")
    @PreAuthorize("@ss.hasPermi('biz:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizOrder bizOrder)
    {
        startPage();
        List<BizOrder> list = bizOrderService.selectBizOrderList(bizOrder);
        return getDataTable(list);
    }

    /**
     * 导出销售订单列表
     */
    @PreAuthorize("@ss.hasPermi('biz:order:export')")
    @Log(title = "销售订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizOrder bizOrder)
    {
        List<BizOrder> list = bizOrderService.selectBizOrderList(bizOrder);
        ExcelUtil<BizOrder> util = new ExcelUtil<BizOrder>(BizOrder.class);
        util.exportExcel(response, list, "销售订单数据");
    }

    /**
     * 获取销售订单详细信息
     */
    @ApiOperation("获取销售订单详细信息")
    @PreAuthorize("@ss.hasPermi('biz:order:query')")
    @GetMapping(value = "/{orderId}")
    public TableDataInfo getInfo(@PathVariable("orderId") Long orderId)
    {
        List<BizOrderDetailDto> list = bizOrderService.selectBizOrderDetailListByOrderId(orderId);
        return getDataTable(list);
    }

    /**
     * 新增销售订单
     */
    @PreAuthorize("@ss.hasPermi('biz:order:add')")
    @Log(title = "销售订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizOrder bizOrder)
    {
        return toAjax(bizOrderService.insertBizOrder(bizOrder));
    }

    /**
     * 修改销售订单
     */
    @PreAuthorize("@ss.hasPermi('biz:order:edit')")
    @Log(title = "销售订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizOrder bizOrder)
    {
        return toAjax(bizOrderService.updateBizOrder(bizOrder));
    }

    /**
     * 删除销售订单
     */
    @PreAuthorize("@ss.hasPermi('biz:order:remove')")
    @Log(title = "销售订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(bizOrderService.deleteBizOrderByOrderIds(orderIds));
    }
}
