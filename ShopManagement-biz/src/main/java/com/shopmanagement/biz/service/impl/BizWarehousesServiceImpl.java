package com.shopmanagement.biz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopmanagement.biz.mapper.BizWarehousesMapper;
import com.shopmanagement.biz.domain.BizWarehouses;
import com.shopmanagement.biz.service.IBizWarehousesService;

/**
 * 商铺仓库Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
@Service
public class BizWarehousesServiceImpl implements IBizWarehousesService 
{
    @Autowired
    private BizWarehousesMapper bizWarehousesMapper;

    /**
     * 查询商铺仓库
     * 
     * @param id 商铺仓库主键
     * @return 商铺仓库
     */
    @Override
    public BizWarehouses selectBizWarehousesById(Long id)
    {
        return bizWarehousesMapper.selectBizWarehousesById(id);
    }

    /**
     * 查询商铺仓库列表
     * 
     * @param bizWarehouses 商铺仓库
     * @return 商铺仓库
     */
    @Override
    public List<BizWarehouses> selectBizWarehousesList(BizWarehouses bizWarehouses)
    {
        return bizWarehousesMapper.selectBizWarehousesList(bizWarehouses);
    }

    /**
     * 新增商铺仓库
     * 
     * @param bizWarehouses 商铺仓库
     * @return 结果
     */
    @Override
    public int insertBizWarehouses(BizWarehouses bizWarehouses)
    {
        return bizWarehousesMapper.insertBizWarehouses(bizWarehouses);
    }

    /**
     * 修改商铺仓库
     * 
     * @param bizWarehouses 商铺仓库
     * @return 结果
     */
    @Override
    public int updateBizWarehouses(BizWarehouses bizWarehouses)
    {
        return bizWarehousesMapper.updateBizWarehouses(bizWarehouses);
    }

    /**
     * 批量删除商铺仓库
     * 
     * @param ids 需要删除的商铺仓库主键
     * @return 结果
     */
    @Override
    public int deleteBizWarehousesByIds(Long[] ids)
    {
        return bizWarehousesMapper.deleteBizWarehousesByIds(ids);
    }

    /**
     * 删除商铺仓库信息
     * 
     * @param id 商铺仓库主键
     * @return 结果
     */
    @Override
    public int deleteBizWarehousesById(Long id)
    {
        return bizWarehousesMapper.deleteBizWarehousesById(id);
    }
}
