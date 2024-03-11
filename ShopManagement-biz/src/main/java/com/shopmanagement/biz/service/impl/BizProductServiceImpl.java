package com.shopmanagement.biz.service.impl;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    /**
     * 开启库存告警
     *
     * @param bizProduct 商品信息管理
     * @return 结果
     */
    @Override
    public int updateBizProductAlarm(BizProduct bizProduct) {
        List<BizProduct> products=bizProductMapper.selectBizProductByWarehouseId(0);
        products.stream().forEach(product->{
            if(bizProduct.getAlarmThreshold()==0){
                product.setIsalarm(0);
                product.setAlarmThreshold(bizProduct.getAlarmThreshold());
            }else{
                product.setIsalarm(1);
                product.setAlarmThreshold(bizProduct.getAlarmThreshold());
            }
            bizProductMapper.updateBizProduct(product);
        });
        return products.size();
    }

    /**
     * 货架同步仓库商品信息
     * @return
     */
    @Override
    public int synchronizeProduct(String username) {
        List<BizProduct> bizProducts = bizProductMapper.selectBizProductByWarehouseId(0);
        List<BizProduct> collect = bizProductMapper.selectBizProductList(null).stream().filter(bizProduct -> {
            return !bizProduct.getWarehouseId().equals(0);
        }).collect(Collectors.toList());
        // 遍历collect列表
        for (BizProduct collectProduct : collect) {
            boolean isNameUnique = true;
            // 遍历bizProducts列表
            for (BizProduct bizProduct : bizProducts) {
                if (collectProduct.getProductName().equals(bizProduct.getProductName())) {
                    isNameUnique = false;
                    break;
                }
            }
            // 如果仓库货架名是货架没有的，则添加商品到货架
            if (isNameUnique) {
                BizProduct bizProduct = new BizProduct();
                bizProduct.setProductName(collectProduct.getProductName());
                bizProduct.setProductCategory(collectProduct.getProductCategory());
                bizProduct.setProductNumber(collectProduct.getProductNumber());
                bizProduct.setProductStock(0L);
                bizProduct.setIsalarm(bizProducts.get(0).getIsalarm());
                bizProduct.setUnitPrice(collectProduct.getUnitPrice());
                bizProduct.setPurchasePrice(collectProduct.getPurchasePrice());
                bizProduct.setProductUnit(collectProduct.getProductUnit());
                bizProduct.setWarehouseId(0L);
                bizProduct.setAlarmThreshold(bizProducts.get(0).getAlarmThreshold());
                bizProduct.setTenantId(1L);
                bizProduct.setParams(collectProduct.getParams());
                bizProduct.setLastModifiedTime(new java.util.Date());
                bizProduct.setLastModifiedBy(username);
                bizProduct.setCreateBy(username);
                bizProduct.setCreatedTime(new java.util.Date());
                bizProductMapper.insertBizProduct(bizProduct);
            }
        }
        return 1;
    }
}
