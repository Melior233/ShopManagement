package com.shopmanagement.biz.service;

import java.util.List;
import com.shopmanagement.biz.domain.BizWarehouse;

/**
 * 仓库信息Service接口
 * 
 * @author zr
 * @date 2024-01-19
 */
public interface IBizWarehouseService 
{
    /**
     * 查询仓库信息
     * 
     * @param warehouseId 仓库信息主键
     * @return 仓库信息
     */
    public BizWarehouse selectBizWarehouseByWarehouseId(Long warehouseId);

    /**
     * 查询仓库信息列表
     * 
     * @param bizWarehouse 仓库信息
     * @return 仓库信息集合
     */
    public List<BizWarehouse> selectBizWarehouseList(BizWarehouse bizWarehouse);

    /**
     * 新增仓库信息
     * 
     * @param bizWarehouse 仓库信息
     * @return 结果
     */
    public int insertBizWarehouse(BizWarehouse bizWarehouse);

    /**
     * 修改仓库信息
     * 
     * @param bizWarehouse 仓库信息
     * @return 结果
     */
    public int updateBizWarehouse(BizWarehouse bizWarehouse);

    /**
     * 批量删除仓库信息
     * 
     * @param warehouseIds 需要删除的仓库信息主键集合
     * @return 结果
     */
    public int deleteBizWarehouseByWarehouseIds(Long[] warehouseIds);

    /**
     * 删除仓库信息信息
     * 
     * @param warehouseId 仓库信息主键
     * @return 结果
     */
    public int deleteBizWarehouseByWarehouseId(Long warehouseId);
}
