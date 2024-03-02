package com.shopmanagement.biz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopmanagement.biz.mapper.BizProductMapper;
import com.shopmanagement.biz.domain.BizProduct;
import com.shopmanagement.biz.service.IBizProductService;

/**
 * 商品信息管理Service业务层处理
 * 
 * @author zr
 * @date 2024-03-02
 */
@Service
public class BizProductServiceImpl implements IBizProductService 
{
    @Autowired
    private BizProductMapper bizProductMapper;

    /**
     * 查询商品信息管理
     * 
     * @param productId 商品信息管理主键
     * @return 商品信息管理
     */
    @Override
    public BizProduct selectBizProductByProductId(Long productId)
    {
        return bizProductMapper.selectBizProductByProductId(productId);
    }

    /**
     * 查询商品信息管理列表
     * 
     * @param bizProduct 商品信息管理
     * @return 商品信息管理
     */
    @Override
    public List<BizProduct> selectBizProductList(BizProduct bizProduct)
    {
        return bizProductMapper.selectBizProductList(bizProduct);
    }

    /**
     * 新增商品信息管理
     * 
     * @param bizProduct 商品信息管理
     * @return 结果
     */
    @Override
    public int insertBizProduct(BizProduct bizProduct)
    {
        return bizProductMapper.insertBizProduct(bizProduct);
    }

    /**
     * 修改商品信息管理
     * 
     * @param bizProduct 商品信息管理
     * @return 结果
     */
    @Override
    public int updateBizProduct(BizProduct bizProduct)
    {
        return bizProductMapper.updateBizProduct(bizProduct);
    }

    /**
     * 批量删除商品信息管理
     * 
     * @param productIds 需要删除的商品信息管理主键
     * @return 结果
     */
    @Override
    public int deleteBizProductByProductIds(Long[] productIds)
    {
        return bizProductMapper.deleteBizProductByProductIds(productIds);
    }

    /**
     * 删除商品信息管理信息
     * 
     * @param productId 商品信息管理主键
     * @return 结果
     */
    @Override
    public int deleteBizProductByProductId(Long productId)
    {
        return bizProductMapper.deleteBizProductByProductId(productId);
    }
}
