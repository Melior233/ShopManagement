package com.shopmanagement.biz.service;

import java.util.List;
import com.shopmanagement.biz.domain.BizWarehouseInventory;

/**
 * 商铺仓库商品库存Service接口
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
public interface IBizWarehouseInventoryService 
{
    /**
     * 查询商铺仓库商品库存
     * 
     * @param id 商铺仓库商品库存主键
     * @return 商铺仓库商品库存
     */
    public BizWarehouseInventory selectBizWarehouseInventoryById(Long id);

    /**
     * 查询商铺仓库商品库存列表
     * 
     * @param bizWarehouseInventory 商铺仓库商品库存
     * @return 商铺仓库商品库存集合
     */
    public List<BizWarehouseInventory> selectBizWarehouseInventoryList(BizWarehouseInventory bizWarehouseInventory);

    /**
     * 新增商铺仓库商品库存
     * 
     * @param bizWarehouseInventory 商铺仓库商品库存
     * @return 结果
     */
    public int insertBizWarehouseInventory(BizWarehouseInventory bizWarehouseInventory);

    /**
     * 修改商铺仓库商品库存
     * 
     * @param bizWarehouseInventory 商铺仓库商品库存
     * @return 结果
     */
    public int updateBizWarehouseInventory(BizWarehouseInventory bizWarehouseInventory);

    /**
     * 批量删除商铺仓库商品库存
     * 
     * @param ids 需要删除的商铺仓库商品库存主键集合
     * @return 结果
     */
    public int deleteBizWarehouseInventoryByIds(Long[] ids);

    /**
     * 删除商铺仓库商品库存信息
     * 
     * @param id 商铺仓库商品库存主键
     * @return 结果
     */
    public int deleteBizWarehouseInventoryById(Long id);
}
