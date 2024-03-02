package com.shopmanagement.biz.mapper;

import java.util.List;
import com.shopmanagement.biz.domain.BizSaleProduct;

/**
 * 商品收银Mapper接口
 * 
 * @author zr
 * @date 2024-03-02
 */
public interface BizSaleProductMapper 
{
    /**
     * 查询商品收银
     * 
     * @param productId 商品收银主键
     * @return 商品收银
     */
    public BizSaleProduct selectBizSaleProductByProductId(Long productId);

    /**
     * 查询商品收银列表
     * 
     * @param bizSaleProduct 商品收银
     * @return 商品收银集合
     */
    public List<BizSaleProduct> selectBizSaleProductList(BizSaleProduct bizSaleProduct);

    /**
     * 新增商品收银
     * 
     * @param bizSaleProduct 商品收银
     * @return 结果
     */
    public int insertBizSaleProduct(BizSaleProduct bizSaleProduct);

    /**
     * 修改商品收银
     * 
     * @param bizSaleProduct 商品收银
     * @return 结果
     */
    public int updateBizSaleProduct(BizSaleProduct bizSaleProduct);

    /**
     * 删除商品收银
     * 
     * @param productId 商品收银主键
     * @return 结果
     */
    public int deleteBizSaleProductByProductId(Long productId);

    /**
     * 批量删除商品收银
     * 
     * @param productIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizSaleProductByProductIds(Long[] productIds);
}
