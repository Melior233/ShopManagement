package com.shopmanagement.biz.mapper;

import java.util.List;
import com.shopmanagement.biz.domain.BizProduct;

/**
 * 商品信息管理Mapper接口
 * 
 * @author zr
 * @date 2024-03-02
 */
public interface BizProductMapper 
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
     * 删除商品信息管理
     * 
     * @param productId 商品信息管理主键
     * @return 结果
     */
    public int deleteBizProductByProductId(Long productId);

    /**
     * 批量删除商品信息管理
     * 
     * @param productIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizProductByProductIds(Long[] productIds);

    /**
     * 根据仓库id查询商品信息
     * @param warehouseId
     * @return
     */
    List<BizProduct> selectBizProductByWarehouseId(int warehouseId);
}
