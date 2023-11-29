package com.shopmanagement.biz.mapper;

import java.util.List;
import com.shopmanagement.biz.domain.BizProducts;

/**
 * 商铺商品Mapper接口
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
public interface BizProductsMapper 
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
     * 删除商铺商品
     * 
     * @param id 商铺商品主键
     * @return 结果
     */
    public int deleteBizProductsById(Long id);

    /**
     * 批量删除商铺商品
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizProductsByIds(Long[] ids);
}
