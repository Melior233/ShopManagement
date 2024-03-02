package com.shopmanagement.biz.service;

import java.util.List;
import com.shopmanagement.biz.domain.BizProduct;

/**
 * 商品信息管理Service接口
 * 
 * @author zr
 * @date 2024-03-02
 */
public interface IBizProductService 
{
    /**
     * 查询商品信息管理
     * 
     * @param productId 商品信息管理主键
     * @return 商品信息管理
     */
    public BizProduct selectBizProductByProductId(Long productId);

    /**
     * 查询商品信息管理列表
     * 
     * @param bizProduct 商品信息管理
     * @return 商品信息管理集合
     */
    public List<BizProduct> selectBizProductList(BizProduct bizProduct);

    /**
     * 新增商品信息管理
     * 
     * @param bizProduct 商品信息管理
     * @return 结果
     */
    public int insertBizProduct(BizProduct bizProduct);

    /**
     * 修改商品信息管理
     * 
     * @param bizProduct 商品信息管理
     * @return 结果
     */
    public int updateBizProduct(BizProduct bizProduct);

    /**
     * 批量删除商品信息管理
     * 
     * @param productIds 需要删除的商品信息管理主键集合
     * @return 结果
     */
    public int deleteBizProductByProductIds(Long[] productIds);

    /**
     * 删除商品信息管理信息
     * 
     * @param productId 商品信息管理主键
     * @return 结果
     */
    public int deleteBizProductByProductId(Long productId);

    /**
     * 开启库存告警
     * @param bizProduct
     * @return
     */
    public int updateBizProductAlarm(BizProduct bizProduct);

    /**
     * 同步仓库商品信息
     * @return
     */
    public int synchronizeProduct();
}
