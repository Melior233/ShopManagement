package com.shopmanagement.biz.mapper;

import java.util.List;
import java.util.Map;

import com.shopmanagement.biz.domain.BizOrderDetail;

/**
 * 订单明细Mapper接口
 * 
 * @author zr
 * @date 2024-02-27
 */
public interface BizOrderDetailMapper 
{
    /**
     * 查询订单明细
     * 
     * @param orderDetailId 订单明细主键
     * @return 订单明细
     */
    public BizOrderDetail selectBizOrderDetailByOrderDetailId(Long orderDetailId);

    /**
     * 查询订单明细列表
     * 
     * @param bizOrderDetail 订单明细
     * @return 订单明细集合
     */
    public List<BizOrderDetail> selectBizOrderDetailList(BizOrderDetail bizOrderDetail);

    /**
     * 新增订单明细
     * 
     * @param bizOrderDetail 订单明细
     * @return 结果
     */
    public int insertBizOrderDetail(BizOrderDetail bizOrderDetail);

    /**
     * 修改订单明细
     * 
     * @param bizOrderDetail 订单明细
     * @return 结果
     */
    public int updateBizOrderDetail(BizOrderDetail bizOrderDetail);

    /**
     * 删除订单明细
     * 
     * @param orderDetailId 订单明细主键
     * @return 结果
     */
    public int deleteBizOrderDetailByOrderDetailId(Long orderDetailId);

    /**
     * 批量删除订单明细
     * 
     * @param orderDetailIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizOrderDetailByOrderDetailIds(Long[] orderDetailIds);

    /**
     * 根据销售订单主键查询销售订单明细
     * @param orderId
     * @return
     */
    public List<BizOrderDetail> selectBizOrderDetailListByOrderId(Long orderId);

    /**
     * 查询产品销量
     * @param month
     * @return
     */
    public List findProductSummaries(String month);
}
