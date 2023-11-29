package com.shopmanagement.biz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopmanagement.biz.mapper.BizPurchaseRecordsMapper;
import com.shopmanagement.biz.domain.BizPurchaseRecords;
import com.shopmanagement.biz.service.IBizPurchaseRecordsService;

/**
 * 商铺进货记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
@Service
public class BizPurchaseRecordsServiceImpl implements IBizPurchaseRecordsService 
{
    @Autowired
    private BizPurchaseRecordsMapper bizPurchaseRecordsMapper;

    /**
     * 查询商铺进货记录
     * 
     * @param id 商铺进货记录主键
     * @return 商铺进货记录
     */
    @Override
    public BizPurchaseRecords selectBizPurchaseRecordsById(Long id)
    {
        return bizPurchaseRecordsMapper.selectBizPurchaseRecordsById(id);
    }

    /**
     * 查询商铺进货记录列表
     * 
     * @param bizPurchaseRecords 商铺进货记录
     * @return 商铺进货记录
     */
    @Override
    public List<BizPurchaseRecords> selectBizPurchaseRecordsList(BizPurchaseRecords bizPurchaseRecords)
    {
        return bizPurchaseRecordsMapper.selectBizPurchaseRecordsList(bizPurchaseRecords);
    }

    /**
     * 新增商铺进货记录
     * 
     * @param bizPurchaseRecords 商铺进货记录
     * @return 结果
     */
    @Override
    public int insertBizPurchaseRecords(BizPurchaseRecords bizPurchaseRecords)
    {
        return bizPurchaseRecordsMapper.insertBizPurchaseRecords(bizPurchaseRecords);
    }

    /**
     * 修改商铺进货记录
     * 
     * @param bizPurchaseRecords 商铺进货记录
     * @return 结果
     */
    @Override
    public int updateBizPurchaseRecords(BizPurchaseRecords bizPurchaseRecords)
    {
        return bizPurchaseRecordsMapper.updateBizPurchaseRecords(bizPurchaseRecords);
    }

    /**
     * 批量删除商铺进货记录
     * 
     * @param ids 需要删除的商铺进货记录主键
     * @return 结果
     */
    @Override
    public int deleteBizPurchaseRecordsByIds(Long[] ids)
    {
        return bizPurchaseRecordsMapper.deleteBizPurchaseRecordsByIds(ids);
    }

    /**
     * 删除商铺进货记录信息
     * 
     * @param id 商铺进货记录主键
     * @return 结果
     */
    @Override
    public int deleteBizPurchaseRecordsById(Long id)
    {
        return bizPurchaseRecordsMapper.deleteBizPurchaseRecordsById(id);
    }
}
