package com.shopmanagement.biz.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.shopmanagement.biz.mapper.BizSupplierMapper;
import com.shopmanagement.biz.domain.BizSupplier;
import com.shopmanagement.biz.service.IBizSupplierService;

/**
 * 供应商信息Service业务层处理
 * 
 * @author zr
 * @date 2024-02-27
 */
@Service
public class BizSupplierServiceImpl implements IBizSupplierService 
{
    private final BizSupplierMapper bizSupplierMapper;

    public BizSupplierServiceImpl(BizSupplierMapper bizSupplierMapper) {
        this.bizSupplierMapper = bizSupplierMapper;
    }

    /**
     * 查询供应商信息
     * 
     * @param id 供应商信息主键
     * @return 供应商信息
     */
    @Override
    public BizSupplier selectBizSupplierById(Long id)
    {
        return bizSupplierMapper.selectBizSupplierById(id);
    }

    /**
     * 查询供应商信息列表
     * 
     * @param bizSupplier 供应商信息
     * @return 供应商信息
     */
    @Override
    public List<BizSupplier> selectBizSupplierList(BizSupplier bizSupplier)
    {
        return bizSupplierMapper.selectBizSupplierList(bizSupplier);
    }

    /**
     * 新增供应商信息
     * 
     * @param bizSupplier 供应商信息
     * @return 结果
     */
    @Override
    public int insertBizSupplier(BizSupplier bizSupplier)
    {
        return bizSupplierMapper.insertBizSupplier(bizSupplier);
    }

    /**
     * 修改供应商信息
     * 
     * @param bizSupplier 供应商信息
     * @return 结果
     */
    @Override
    public int updateBizSupplier(BizSupplier bizSupplier)
    {
        return bizSupplierMapper.updateBizSupplier(bizSupplier);
    }

    /**
     * 批量删除供应商信息
     * 
     * @param ids 需要删除的供应商信息主键
     * @return 结果
     */
    @Override
    public int deleteBizSupplierByIds(Long[] ids)
    {
        return bizSupplierMapper.deleteBizSupplierByIds(ids);
    }

    /**
     * 删除供应商信息信息
     * 
     * @param id 供应商信息主键
     * @return 结果
     */
    @Override
    public int deleteBizSupplierById(Long id)
    {
        return bizSupplierMapper.deleteBizSupplierById(id);
    }
}
