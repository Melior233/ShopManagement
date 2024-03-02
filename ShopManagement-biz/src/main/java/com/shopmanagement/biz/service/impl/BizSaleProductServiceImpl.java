package com.shopmanagement.biz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopmanagement.biz.mapper.BizSaleProductMapper;
import com.shopmanagement.biz.domain.BizSaleProduct;
import com.shopmanagement.biz.service.IBizSaleProductService;

/**
 * 商品收银Service业务层处理
 * 
 * @author zr
 * @date 2024-03-02
 */
@Service
public class BizSaleProductServiceImpl implements IBizSaleProductService 
{
    @Autowired
    private BizSaleProductMapper bizSaleProductMapper;

    /**
     * 查询商品收银
     * 
     * @param productId 商品收银主键
     * @return 商品收银
     */
    @Override
    public BizSaleProduct selectBizSaleProductByProductId(Long productId)
    {
        return bizSaleProductMapper.selectBizSaleProductByProductId(productId);
    }

    /**
     * 查询商品收银列表
     * 
     * @param bizSaleProduct 商品收银
     * @return 商品收银
     */
    @Override
    public List<BizSaleProduct> selectBizSaleProductList(BizSaleProduct bizSaleProduct)
    {
        return bizSaleProductMapper.selectBizSaleProductList(bizSaleProduct);
    }

    /**
     * 新增商品收银
     * 
     * @param bizSaleProduct 商品收银
     * @return 结果
     */
    @Override
    public int insertBizSaleProduct(BizSaleProduct bizSaleProduct)
    {
        return bizSaleProductMapper.insertBizSaleProduct(bizSaleProduct);
    }

    /**
     * 修改商品收银
     * 
     * @param bizSaleProduct 商品收银
     * @return 结果
     */
    @Override
    public int updateBizSaleProduct(BizSaleProduct bizSaleProduct)
    {
        return bizSaleProductMapper.updateBizSaleProduct(bizSaleProduct);
    }

    /**
     * 批量删除商品收银
     * 
     * @param productIds 需要删除的商品收银主键
     * @return 结果
     */
    @Override
    public int deleteBizSaleProductByProductIds(Long[] productIds)
    {
        return bizSaleProductMapper.deleteBizSaleProductByProductIds(productIds);
    }

    /**
     * 删除商品收银信息
     * 
     * @param productId 商品收银主键
     * @return 结果
     */
    @Override
    public int deleteBizSaleProductByProductId(Long productId)
    {
        return bizSaleProductMapper.deleteBizSaleProductByProductId(productId);
    }
}
