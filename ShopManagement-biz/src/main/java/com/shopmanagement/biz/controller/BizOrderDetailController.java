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
import com.shopmanagement.biz.domain.BizOrderDetail;
import com.shopmanagement.biz.service.IBizOrderDetailService;
import com.shopmanagement.common.utils.poi.ExcelUtil;
import com.shopmanagement.common.core.page.TableDataInfo;

/**
 * 订单明细Controller
 * 
 * @author zr
 * @date 2024-02-27
 */
@RestController
@RequestMapping("/biz/detail")
public class BizOrderDetailController extends BaseController
{
    private final IBizOrderDetailService bizOrderDetailService;

    public BizOrderDetailController(IBizOrderDetailService bizOrderDetailService) {
        this.bizOrderDetailService = bizOrderDetailService;
    }

    /**
     * 查询订单明细列表
     */
    @PreAuthorize("@ss.hasPermi('biz:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizOrderDetail bizOrderDetail)
    {
        startPage();
        List<BizOrderDetail> list = bizOrderDetailService.selectBizOrderDetailList(bizOrderDetail);
        return getDataTable(list);
    }

    /**
     * 导出订单明细列表
     */
    @PreAuthorize("@ss.hasPermi('biz:detail:export')")
    @Log(title = "订单明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizOrderDetail bizOrderDetail)
    {
        List<BizOrderDetail> list = bizOrderDetailService.selectBizOrderDetailList(bizOrderDetail);
        ExcelUtil<BizOrderDetail> util = new ExcelUtil<BizOrderDetail>(BizOrderDetail.class);
        util.exportExcel(response, list, "订单明细数据");
    }

    /**
     * 获取订单明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:detail:query')")
    @GetMapping(value = "/{orderDetailId}")
    public AjaxResult getInfo(@PathVariable("orderDetailId") Long orderDetailId)
    {
        return success(bizOrderDetailService.selectBizOrderDetailByOrderDetailId(orderDetailId));
    }

    /**
     * 新增订单明细
     */
    @PreAuthorize("@ss.hasPermi('biz:detail:add')")
    @Log(title = "订单明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizOrderDetail bizOrderDetail)
    {
        return toAjax(bizOrderDetailService.insertBizOrderDetail(bizOrderDetail));
    }

    /**
     * 修改订单明细
     */
    @PreAuthorize("@ss.hasPermi('biz:detail:edit')")
    @Log(title = "订单明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizOrderDetail bizOrderDetail)
    {
        return toAjax(bizOrderDetailService.updateBizOrderDetail(bizOrderDetail));
    }

    /**
     * 删除订单明细
     */
    @PreAuthorize("@ss.hasPermi('biz:detail:remove')")
    @Log(title = "订单明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderDetailIds}")
    public AjaxResult remove(@PathVariable Long[] orderDetailIds)
    {
        return toAjax(bizOrderDetailService.deleteBizOrderDetailByOrderDetailIds(orderDetailIds));
    }
}
