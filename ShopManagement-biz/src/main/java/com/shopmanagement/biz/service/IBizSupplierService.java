package com.shopmanagement.biz.service;

import java.util.List;
import com.shopmanagement.biz.domain.BizSupplier;

/**
 * 供应商信息Service接口
 * 
 * @author zr
 * @date 2024-02-27
 */
public interface IBizSupplierService 
{
    /**
     * 查询供应商信息
     * 
     * @param id 供应商信息主键
     * @return 供应商信息
     */
    public BizSupplier selectBizSupplierById(Long id);

    /**
     * 查询供应商信息列表
     * 
     * @param bizSupplier 供应商信息
     * @return 供应商信息集合
     */
    public List<BizSupplier> selectBizSupplierList(BizSupplier bizSupplier);

    /**
     * 新增供应商信息
     * 
     * @param bizSupplier 供应商信息
     * @return 结果
     */
    public int insertBizSupplier(BizSupplier bizSupplier);

    /**
     * 修改供应商信息
     * 
     * @param bizSupplier 供应商信息
     * @return 结果
     */
    public int updateBizSupplier(BizSupplier bizSupplier);

    /**
     * 批量删除供应商信息
     * 
     * @param ids 需要删除的供应商信息主键集合
     * @return 结果
     */
    public int deleteBizSupplierByIds(Long[] ids);

    /**
     * 删除供应商信息信息
     * 
     * @param id 供应商信息主键
     * @return 结果
     */
    public int deleteBizSupplierById(Long id);
}
