package com.shopmanagement.biz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopmanagement.biz.mapper.BizWarehouseInventoryMapper;
import com.shopmanagement.biz.domain.BizWarehouseInventory;
import com.shopmanagement.biz.service.IBizWarehouseInventoryService;

/**
 * 商铺仓库商品库存Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
@Service
public class BizWarehouseInventoryServiceImpl implements IBizWarehouseInventoryService 
{
    @Autowired
    private BizWarehouseInventoryMapper bizWarehouseInventoryMapper;

    /**
     * 查询商铺仓库商品库存
     * 
     * @param id 商铺仓库商品库存主键
     * @return 商铺仓库商品库存
     */
    @Override
    public BizWarehouseInventory selectBizWarehouseInventoryById(Long id)
    {
        return bizWarehouseInventoryMapper.selectBizWarehouseInventoryById(id);
    }

    /**
     * 查询商铺仓库商品库存列表
     * 
     * @param bizWarehouseInventory 商铺仓库商品库存
     * @return 商铺仓库商品库存
     */
    @Override
    public List<BizWarehouseInventory> selectBizWarehouseInventoryList(BizWarehouseInventory bizWarehouseInventory)
    {
        return bizWarehouseInventoryMapper.selectBizWarehouseInventoryList(bizWarehouseInventory);
    }

    /**
     * 新增商铺仓库商品库存
     * 
     * @param bizWarehouseInventory 商铺仓库商品库存
     * @return 结果
     */
    @Override
    public int insertBizWarehouseInventory(BizWarehouseInventory bizWarehouseInventory)
    {
        return bizWarehouseInventoryMapper.insertBizWarehouseInventory(bizWarehouseInventory);
    }

    /**
     * 修改商铺仓库商品库存
     * 
     * @param bizWarehouseInventory 商铺仓库商品库存
     * @return 结果
     */
    @Override
    public int updateBizWarehouseInventory(BizWarehouseInventory bizWarehouseInventory)
    {
        return bizWarehouseInventoryMapper.updateBizWarehouseInventory(bizWarehouseInventory);
    }

    /**
     * 批量删除商铺仓库商品库存
     * 
     * @param ids 需要删除的商铺仓库商品库存主键
     * @return 结果
     */
    @Override
    public int deleteBizWarehouseInventoryByIds(Long[] ids)
    {
        return bizWarehouseInventoryMapper.deleteBizWarehouseInventoryByIds(ids);
    }

    /**
     * 删除商铺仓库商品库存信息
     * 
     * @param id 商铺仓库商品库存主键
     * @return 结果
     */
    @Override
    public int deleteBizWarehouseInventoryById(Long id)
    {
        return bizWarehouseInventoryMapper.deleteBizWarehouseInventoryById(id);
    }
}
