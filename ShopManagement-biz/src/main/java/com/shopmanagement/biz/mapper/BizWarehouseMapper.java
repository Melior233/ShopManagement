package com.shopmanagement.biz.mapper;

import java.util.List;
import com.shopmanagement.biz.domain.BizWarehouse;

/**
 * 仓库信息Mapper接口
 * 
 * @author zr
 * @date 2024-02-27
 */
public interface BizWarehouseMapper 
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
     * 删除仓库信息
     * 
     * @param warehouseId 仓库信息主键
     * @return 结果
     */
    public int deleteBizWarehouseByWarehouseId(Long warehouseId);

    /**
     * 批量删除仓库信息
     * 
     * @param warehouseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizWarehouseByWarehouseIds(Long[] warehouseIds);
}
