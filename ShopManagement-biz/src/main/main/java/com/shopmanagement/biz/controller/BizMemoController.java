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
import com.shopmanagement.biz.domain.BizMemo;
import com.shopmanagement.biz.service.IBizMemoService;
import com.shopmanagement.common.utils.poi.ExcelUtil;
import com.shopmanagement.common.core.page.TableDataInfo;

/**
 * 备忘录信息Controller
 * 
 * @author zr
 * @date 2024-01-19
 */
@RestController
@RequestMapping("/biz/memo")
public class BizMemoController extends BaseController
{
    @Autowired
    private IBizMemoService bizMemoService;

    /**
     * 查询备忘录信息列表
     */
    @PreAuthorize("@ss.hasPermi('biz:memo:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizMemo bizMemo)
    {
        startPage();
        List<BizMemo> list = bizMemoService.selectBizMemoList(bizMemo);
        return getDataTable(list);
    }

    /**
     * 导出备忘录信息列表
     */
    @PreAuthorize("@ss.hasPermi('biz:memo:export')")
    @Log(title = "备忘录信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizMemo bizMemo)
    {
        List<BizMemo> list = bizMemoService.selectBizMemoList(bizMemo);
        ExcelUtil<BizMemo> util = new ExcelUtil<BizMemo>(BizMemo.class);
        util.exportExcel(response, list, "备忘录信息数据");
    }

    /**
     * 获取备忘录信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:memo:query')")
    @GetMapping(value = "/{memoId}")
    public AjaxResult getInfo(@PathVariable("memoId") Long memoId)
    {
        return success(bizMemoService.selectBizMemoByMemoId(memoId));
    }

    /**
     * 新增备忘录信息
     */
    @PreAuthorize("@ss.hasPermi('biz:memo:add')")
    @Log(title = "备忘录信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizMemo bizMemo)
    {
        return toAjax(bizMemoService.insertBizMemo(bizMemo));
    }

    /**
     * 修改备忘录信息
     */
    @PreAuthorize("@ss.hasPermi('biz:memo:edit')")
    @Log(title = "备忘录信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizMemo bizMemo)
    {
        return toAjax(bizMemoService.updateBizMemo(bizMemo));
    }

    /**
     * 删除备忘录信息
     */
    @PreAuthorize("@ss.hasPermi('biz:memo:remove')")
    @Log(title = "备忘录信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{memoIds}")
    public AjaxResult remove(@PathVariable Long[] memoIds)
    {
        return toAjax(bizMemoService.deleteBizMemoByMemoIds(memoIds));
    }
}
