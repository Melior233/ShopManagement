package com.shopmanagement.biz.service;

import java.util.List;
import com.shopmanagement.biz.domain.BizProducts;

/**
 * 商铺商品Service接口
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
public interface IBizProductsService 
{
    /**
     * 查询商铺商品
     * 
     * @param id 商铺商品主键
     * @return 商铺商品
     */
    public BizProducts selectBizProductsById(Long id);

    /**
     * 查询商铺商品列表
     * 
     * @param bizProducts 商铺商品
     * @return 商铺商品集合
     */
    public List<BizProducts> selectBizProductsList(BizProducts bizProducts);

    /**
     * 新增商铺商品
     * 
     * @param bizProducts 商铺商品
     * @return 结果
     */
    public int insertBizProducts(BizProducts bizProducts);

    /**
     * 修改商铺商品
     * 
     * @param bizProducts 商铺商品
     * @return 结果
     */
    public int updateBizProducts(BizProducts bizProducts);

    /**
     * 批量删除商铺商品
     * 
     * @param ids 需要删除的商铺商品主键集合
     * @return 结果
     */
    public int deleteBizProductsByIds(Long[] ids);

    /**
     * 删除商铺商品信息
     * 
     * @param id 商铺商品主键
     * @return 结果
     */
    public int deleteBizProductsById(Long id);
}
