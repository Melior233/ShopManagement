package com.shopmanagement.biz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopmanagement.biz.mapper.BizInboundListMapper;
import com.shopmanagement.biz.domain.BizInboundList;
import com.shopmanagement.biz.service.IBizInboundListService;

/**
 * 入库清单管理Service业务层处理
 * 
 * @author zr
 * @date 2024-01-19
 */
@Service
public class BizInboundListServiceImpl implements IBizInboundListService 
{
    @Autowired
    private BizInboundListMapper bizInboundListMapper;

    /**
     * 查询入库清单管理
     * 
     * @param inboundListId 入库清单管理主键
     * @return 入库清单管理
     */
    @Override
    public BizInboundList selectBizInboundListByInboundListId(Long inboundListId)
    {
        return bizInboundListMapper.selectBizInboundListByInboundListId(inboundListId);
    }

    /**
     * 查询入库清单管理列表
     * 
     * @param bizInboundList 入库清单管理
     * @return 入库清单管理
     */
    @Override
    public List<BizInboundList> selectBizInboundListList(BizInboundList bizInboundList)
    {
        return bizInboundListMapper.selectBizInboundListList(bizInboundList);
    }

    /**
     * 新增入库清单管理
     * 
     * @param bizInboundList 入库清单管理
     * @return 结果
     */
    @Override
    public int insertBizInboundList(BizInboundList bizInboundList)
    {
        return bizInboundListMapper.insertBizInboundList(bizInboundList);
    }

    /**
     * 修改入库清单管理
     * 
     * @param bizInboundList 入库清单管理
     * @return 结果
     */
    @Override
    public int updateBizInboundList(BizInboundList bizInboundList)
    {
        return bizInboundListMapper.updateBizInboundList(bizInboundList);
    }

    /**
     * 批量删除入库清单管理
     * 
     * @param inboundListIds 需要删除的入库清单管理主键
     * @return 结果
     */
    @Override
    public int deleteBizInboundListByInboundListIds(Long[] inboundListIds)
    {
        return bizInboundListMapper.deleteBizInboundListByInboundListIds(inboundListIds);
    }

    /**
     * 删除入库清单管理信息
     * 
     * @param inboundListId 入库清单管理主键
     * @return 结果
     */
    @Override
    public int deleteBizInboundListByInboundListId(Long inboundListId)
    {
        return bizInboundListMapper.deleteBizInboundListByInboundListId(inboundListId);
    }
}
