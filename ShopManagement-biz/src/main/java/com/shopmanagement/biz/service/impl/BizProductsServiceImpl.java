package com.shopmanagement.biz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopmanagement.biz.mapper.BizProductsMapper;
import com.shopmanagement.biz.domain.BizProducts;
import com.shopmanagement.biz.service.IBizProductsService;

/**
 * 商铺商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
@Service
public class BizProductsServiceImpl implements IBizProductsService 
{
    @Autowired
    private BizProductsMapper bizProductsMapper;

    /**
     * 查询商铺商品
     * 
     * @param id 商铺商品主键
     * @return 商铺商品
     */
    @Override
    public BizProducts selectBizProductsById(Long id)
    {
        return bizProductsMapper.selectBizProductsById(id);
    }

    /**
     * 查询商铺商品列表
     * 
     * @param bizProducts 商铺商品
     * @return 商铺商品
     */
    @Override
    public List<BizProducts> selectBizProductsList(BizProducts bizProducts)
    {
        return bizProductsMapper.selectBizProductsList(bizProducts);
    }

    /**
     * 新增商铺商品
     * 
     * @param bizProducts 商铺商品
     * @return 结果
     */
    @Override
    public int insertBizProducts(BizProducts bizProducts)
    {
        return bizProductsMapper.insertBizProducts(bizProducts);
    }

    /**
     * 修改商铺商品
     * 
     * @param bizProducts 商铺商品
     * @return 结果
     */
    @Override
    public int updateBizProducts(BizProducts bizProducts)
    {
        return bizProductsMapper.updateBizProducts(bizProducts);
    }

    /**
     * 批量删除商铺商品
     * 
     * @param ids 需要删除的商铺商品主键
     * @return 结果
     */
    @Override
    public int deleteBizProductsByIds(Long[] ids)
    {
        return bizProductsMapper.deleteBizProductsByIds(ids);
    }

    /**
     * 删除商铺商品信息
     * 
     * @param id 商铺商品主键
     * @return 结果
     */
    @Override
    public int deleteBizProductsById(Long id)
    {
        return bizProductsMapper.deleteBizProductsById(id);
    }
}
