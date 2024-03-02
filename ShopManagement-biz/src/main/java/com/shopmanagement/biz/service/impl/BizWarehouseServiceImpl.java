package com.shopmanagement.biz.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.shopmanagement.biz.mapper.BizWarehouseMapper;
import com.shopmanagement.biz.domain.BizWarehouse;
import com.shopmanagement.biz.service.IBizWarehouseService;

/**
 * 仓库信息Service业务层处理
 * 
 * @author zr
 * @date 2024-02-27
 */
@Service
public class BizWarehouseServiceImpl implements IBizWarehouseService 
{
    private final BizWarehouseMapper bizWarehouseMapper;

    public BizWarehouseServiceImpl(BizWarehouseMapper bizWarehouseMapper) {
        this.bizWarehouseMapper = bizWarehouseMapper;
    }

    /**
     * 查询仓库信息
     * 
     * @param warehouseId 仓库信息主键
     * @return 仓库信息
     */
    @Override
    public BizWarehouse selectBizWarehouseByWarehouseId(Long warehouseId)
    {
        return bizWarehouseMapper.selectBizWarehouseByWarehouseId(warehouseId);
    }

    /**
     * 查询仓库信息列表
     * 
     * @param bizWarehouse 仓库信息
     * @return 仓库信息
     */
    @Override
    public List<BizWarehouse> selectBizWarehouseList(BizWarehouse bizWarehouse)
    {
        return bizWarehouseMapper.selectBizWarehouseList(bizWarehouse);
    }

    /**
     * 新增仓库信息
     * 
     * @param bizWarehouse 仓库信息
     * @return 结果
     */
    @Override
    public int insertBizWarehouse(BizWarehouse bizWarehouse)
    {
        return bizWarehouseMapper.insertBizWarehouse(bizWarehouse);
    }

    /**
     * 修改仓库信息
     * 
     * @param bizWarehouse 仓库信息
     * @return 结果
     */
    @Override
    public int updateBizWarehouse(BizWarehouse bizWarehouse)
    {
        return bizWarehouseMapper.updateBizWarehouse(bizWarehouse);
    }

    /**
     * 批量删除仓库信息
     * 
     * @param warehouseIds 需要删除的仓库信息主键
     * @return 结果
     */
    @Override
    public int deleteBizWarehouseByWarehouseIds(Long[] warehouseIds)
    {
        return bizWarehouseMapper.deleteBizWarehouseByWarehouseIds(warehouseIds);
    }

    /**
     * 删除仓库信息信息
     * 
     * @param warehouseId 仓库信息主键
     * @return 结果
     */
    @Override
    public int deleteBizWarehouseByWarehouseId(Long warehouseId)
    {
        return bizWarehouseMapper.deleteBizWarehouseByWarehouseId(warehouseId);
    }
}
