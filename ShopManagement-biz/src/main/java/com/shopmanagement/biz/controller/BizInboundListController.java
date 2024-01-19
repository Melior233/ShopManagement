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
import com.shopmanagement.biz.domain.BizInboundList;
import com.shopmanagement.biz.service.IBizInboundListService;
import com.shopmanagement.common.utils.poi.ExcelUtil;
import com.shopmanagement.common.core.page.TableDataInfo;

/**
 * 入库清单管理Controller
 * 
 * @author zr
 * @date 2024-01-19
 */
@RestController
@RequestMapping("/biz/list")
public class BizInboundListController extends BaseController
{
    @Autowired
    private IBizInboundListService bizInboundListService;

    /**
     * 查询入库清单管理列表
     */
    @PreAuthorize("@ss.hasPermi('biz:list:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizInboundList bizInboundList)
    {
        startPage();
        List<BizInboundList> list = bizInboundListService.selectBizInboundListList(bizInboundList);
        return getDataTable(list);
    }

    /**
     * 导出入库清单管理列表
     */
    @PreAuthorize("@ss.hasPermi('biz:list:export')")
    @Log(title = "入库清单管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizInboundList bizInboundList)
    {
        List<BizInboundList> list = bizInboundListService.selectBizInboundListList(bizInboundList);
        ExcelUtil<BizInboundList> util = new ExcelUtil<BizInboundList>(BizInboundList.class);
        util.exportExcel(response, list, "入库清单管理数据");
    }

    /**
     * 获取入库清单管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:list:query')")
    @GetMapping(value = "/{inboundListId}")
    public AjaxResult getInfo(@PathVariable("inboundListId") Long inboundListId)
    {
        return success(bizInboundListService.selectBizInboundListByInboundListId(inboundListId));
    }

    /**
     * 新增入库清单管理
     */
    @PreAuthorize("@ss.hasPermi('biz:list:add')")
    @Log(title = "入库清单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizInboundList bizInboundList)
    {
        return toAjax(bizInboundListService.insertBizInboundList(bizInboundList));
    }

    /**
     * 修改入库清单管理
     */
    @PreAuthorize("@ss.hasPermi('biz:list:edit')")
    @Log(title = "入库清单管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizInboundList bizInboundList)
    {
        return toAjax(bizInboundListService.updateBizInboundList(bizInboundList));
    }

    /**
     * 删除入库清单管理
     */
    @PreAuthorize("@ss.hasPermi('biz:list:remove')")
    @Log(title = "入库清单管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{inboundListIds}")
    public AjaxResult remove(@PathVariable Long[] inboundListIds)
    {
        return toAjax(bizInboundListService.deleteBizInboundListByInboundListIds(inboundListIds));
    }
}
