package com.shopmanagement.biz.service;

import java.util.List;
import com.shopmanagement.biz.domain.BizWarehouses;

/**
 * 商铺仓库Service接口
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
public interface IBizWarehousesService 
{
    /**
     * 查询商铺仓库
     * 
     * @param id 商铺仓库主键
     * @return 商铺仓库
     */
    public BizWarehouses selectBizWarehousesById(Long id);

    /**
     * 查询商铺仓库列表
     * 
     * @param bizWarehouses 商铺仓库
     * @return 商铺仓库集合
     */
    public List<BizWarehouses> selectBizWarehousesList(BizWarehouses bizWarehouses);

    /**
     * 新增商铺仓库
     * 
     * @param bizWarehouses 商铺仓库
     * @return 结果
     */
    public int insertBizWarehouses(BizWarehouses bizWarehouses);

    /**
     * 修改商铺仓库
     * 
     * @param bizWarehouses 商铺仓库
     * @return 结果
     */
    public int updateBizWarehouses(BizWarehouses bizWarehouses);

    /**
     * 批量删除商铺仓库
     * 
     * @param ids 需要删除的商铺仓库主键集合
     * @return 结果
     */
    public int deleteBizWarehousesByIds(Long[] ids);

    /**
     * 删除商铺仓库信息
     * 
     * @param id 商铺仓库主键
     * @return 结果
     */
    public int deleteBizWarehousesById(Long id);
}
