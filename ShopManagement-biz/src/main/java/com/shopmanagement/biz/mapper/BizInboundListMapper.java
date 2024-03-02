package com.shopmanagement.biz.mapper;

import java.util.List;
import com.shopmanagement.biz.domain.BizInboundList;

/**
 * 入库清单管理Mapper接口
 * 
 * @author zr
 * @date 2024-02-27
 */
public interface BizInboundListMapper 
{
    /**
     * 查询入库清单管理
     * 
     * @param inboundListId 入库清单管理主键
     * @return 入库清单管理
     */
    public BizInboundList selectBizInboundListByInboundListId(Long inboundListId);

    /**
     * 查询入库清单管理列表
     * 
     * @param bizInboundList 入库清单管理
     * @return 入库清单管理集合
     */
    public List<BizInboundList> selectBizInboundListList(BizInboundList bizInboundList);

    /**
     * 新增入库清单管理
     * 
     * @param bizInboundList 入库清单管理
     * @return 结果
     */
    public int insertBizInboundList(BizInboundList bizInboundList);

    /**
     * 修改入库清单管理
     * 
     * @param bizInboundList 入库清单管理
     * @return 结果
     */
    public int updateBizInboundList(BizInboundList bizInboundList);

    /**
     * 删除入库清单管理
     * 
     * @param inboundListId 入库清单管理主键
     * @return 结果
     */
    public int deleteBizInboundListByInboundListId(Long inboundListId);

    /**
     * 批量删除入库清单管理
     * 
     * @param inboundListIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizInboundListByInboundListIds(Long[] inboundListIds);
}
