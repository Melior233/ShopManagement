package com.shopmanagement.biz.service;

import java.util.List;
import com.shopmanagement.biz.domain.BizPurchaseRecords;

/**
 * 商铺进货记录Service接口
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
public interface IBizPurchaseRecordsService 
{
    /**
     * 查询商铺进货记录
     * 
     * @param id 商铺进货记录主键
     * @return 商铺进货记录
     */
    public BizPurchaseRecords selectBizPurchaseRecordsById(Long id);

    /**
     * 查询商铺进货记录列表
     * 
     * @param bizPurchaseRecords 商铺进货记录
     * @return 商铺进货记录集合
     */
    public List<BizPurchaseRecords> selectBizPurchaseRecordsList(BizPurchaseRecords bizPurchaseRecords);

    /**
     * 新增商铺进货记录
     * 
     * @param bizPurchaseRecords 商铺进货记录
     * @return 结果
     */
    public int insertBizPurchaseRecords(BizPurchaseRecords bizPurchaseRecords);

    /**
     * 修改商铺进货记录
     * 
     * @param bizPurchaseRecords 商铺进货记录
     * @return 结果
     */
    public int updateBizPurchaseRecords(BizPurchaseRecords bizPurchaseRecords);

    /**
     * 批量删除商铺进货记录
     * 
     * @param ids 需要删除的商铺进货记录主键集合
     * @return 结果
     */
    public int deleteBizPurchaseRecordsByIds(Long[] ids);

    /**
     * 删除商铺进货记录信息
     * 
     * @param id 商铺进货记录主键
     * @return 结果
     */
    public int deleteBizPurchaseRecordsById(Long id);
}
