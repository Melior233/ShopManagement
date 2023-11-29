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
import com.shopmanagement.biz.domain.BizPurchaseRecords;
import com.shopmanagement.biz.service.IBizPurchaseRecordsService;
import com.shopmanagement.common.utils.poi.ExcelUtil;
import com.shopmanagement.common.core.page.TableDataInfo;

/**
 * 商铺进货记录Controller
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
@RestController
@RequestMapping("/system/records")
public class BizPurchaseRecordsController extends BaseController
{
    @Autowired
    private IBizPurchaseRecordsService bizPurchaseRecordsService;

    /**
     * 查询商铺进货记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:records:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizPurchaseRecords bizPurchaseRecords)
    {
        startPage();
        List<BizPurchaseRecords> list = bizPurchaseRecordsService.selectBizPurchaseRecordsList(bizPurchaseRecords);
        return getDataTable(list);
    }

    /**
     * 导出商铺进货记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:records:export')")
    @Log(title = "商铺进货记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizPurchaseRecords bizPurchaseRecords)
    {
        List<BizPurchaseRecords> list = bizPurchaseRecordsService.selectBizPurchaseRecordsList(bizPurchaseRecords);
        ExcelUtil<BizPurchaseRecords> util = new ExcelUtil<BizPurchaseRecords>(BizPurchaseRecords.class);
        util.exportExcel(response, list, "商铺进货记录数据");
    }

    /**
     * 获取商铺进货记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:records:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizPurchaseRecordsService.selectBizPurchaseRecordsById(id));
    }

    /**
     * 新增商铺进货记录
     */
    @PreAuthorize("@ss.hasPermi('system:records:add')")
    @Log(title = "商铺进货记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizPurchaseRecords bizPurchaseRecords)
    {
        return toAjax(bizPurchaseRecordsService.insertBizPurchaseRecords(bizPurchaseRecords));
    }

    /**
     * 修改商铺进货记录
     */
    @PreAuthorize("@ss.hasPermi('system:records:edit')")
    @Log(title = "商铺进货记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizPurchaseRecords bizPurchaseRecords)
    {
        return toAjax(bizPurchaseRecordsService.updateBizPurchaseRecords(bizPurchaseRecords));
    }

    /**
     * 删除商铺进货记录
     */
    @PreAuthorize("@ss.hasPermi('system:records:remove')")
    @Log(title = "商铺进货记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizPurchaseRecordsService.deleteBizPurchaseRecordsByIds(ids));
    }
}
