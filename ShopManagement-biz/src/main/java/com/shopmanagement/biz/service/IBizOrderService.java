package com.shopmanagement.biz.service;

import java.util.List;
import java.util.Set;

import com.shopmanagement.biz.domain.BizOrder;
import com.shopmanagement.biz.service.dto.BizOrderDetailDto;

/**
 * 销售订单Service接口
 * 
 * @author zr
 * @date 2024-02-27
 */
public interface IBizOrderService 
{
    /**
     * 查询销售订单
     * 
     * @param orderId 销售订单主键
     * @return 销售订单
     */
    public BizOrder selectBizOrderByOrderId(Long orderId);

    /**
     * 查询销售订单列表
     * 
     * @param bizOrder 销售订单
     * @return 销售订单集合
     */
    public List<BizOrder> selectBizOrderList(BizOrder bizOrder);

    /**
     * 新增销售订单
     * 
     * @param bizOrder 销售订单
     * @return 结果
     */
    public int insertBizOrder(BizOrder bizOrder);

    /**
     * 修改销售订单
     * 
     * @param bizOrder 销售订单
     * @return 结果
     */
    public int updateBizOrder(BizOrder bizOrder);

    /**
     * 批量删除销售订单
     * 
     * @param orderIds 需要删除的销售订单主键集合
     * @return 结果
     */
    public int deleteBizOrderByOrderIds(Long[] orderIds);

    /**
     * 删除销售订单信息
     * 
     * @param orderId 销售订单主键
     * @return 结果
     */
    public int deleteBizOrderByOrderId(Long orderId);

    /**
     * 获取销售订单详细信息
     *
     * @param orderId
     * @return
     */
    public List<BizOrderDetailDto> selectBizOrderDetailListByOrderId(Long orderId);
}
