package com.shopmanagement.biz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.shopmanagement.biz.domain.BizOrderDetail;
import com.shopmanagement.biz.mapper.BizOrderDetailMapper;
import com.shopmanagement.biz.service.dto.BizOrderDetailDto;
import com.shopmanagement.common.utils.bean.BeanUtils;
import org.springframework.stereotype.Service;
import com.shopmanagement.biz.mapper.BizOrderMapper;
import com.shopmanagement.biz.domain.BizOrder;
import com.shopmanagement.biz.service.IBizOrderService;

import static jdk.nashorn.internal.objects.NativeRegExp.source;

/**
 * 销售订单Service业务层处理
 * 
 * @author zr
 * @date 2024-02-27
 */
@Service
public class BizOrderServiceImpl implements IBizOrderService 
{

    private final  BizOrderMapper bizOrderMapper;

    private final  BizOrderDetailMapper bizOrderDetailMapper;

    public BizOrderServiceImpl(BizOrderMapper bizOrderMapper, BizOrderDetailMapper bizOrderDetailMapper) {
        this.bizOrderMapper = bizOrderMapper;
        this.bizOrderDetailMapper = bizOrderDetailMapper;
    }

    /**
     * 查询销售订单
     * 
     * @param orderId 销售订单主键
     * @return 销售订单
     */
    @Override
    public BizOrder selectBizOrderByOrderId(Long orderId)
    {
        return bizOrderMapper.selectBizOrderByOrderId(orderId);
    }

    /**
     * 查询销售订单列表
     * 
     * @param bizOrder 销售订单
     * @return 销售订单
     */
    @Override
    public List<BizOrder> selectBizOrderList(BizOrder bizOrder)
    {
        return bizOrderMapper.selectBizOrderList(bizOrder);
    }

    /**
     * 新增销售订单
     * 
     * @param bizOrder 销售订单
     * @return 结果
     */
    @Override
    public int insertBizOrder(BizOrder bizOrder)
    {
        return bizOrderMapper.insertBizOrder(bizOrder);
    }

    /**
     * 修改销售订单
     * 
     * @param bizOrder 销售订单
     * @return 结果
     */
    @Override
    public int updateBizOrder(BizOrder bizOrder)
    {
        return bizOrderMapper.updateBizOrder(bizOrder);
    }

    /**
     * 批量删除销售订单
     * 
     * @param orderIds 需要删除的销售订单主键
     * @return 结果
     */
    @Override
    public int deleteBizOrderByOrderIds(Long[] orderIds)
    {
        return bizOrderMapper.deleteBizOrderByOrderIds(orderIds);
    }

    /**
     * 删除销售订单信息
     * 
     * @param orderId 销售订单主键
     * @return 结果
     */
    @Override
    public int deleteBizOrderByOrderId(Long orderId)
    {
        return bizOrderMapper.deleteBizOrderByOrderId(orderId);
    }

    /**
     * 根据销售订单主键查询销售订单明细
     * @param orderId 销售订单主键
     * @return 结果
     */
    @Override
    public List<BizOrderDetailDto> selectBizOrderDetailListByOrderId(Long orderId) {
        return bizOrderDetailMapper.selectBizOrderDetailListByOrderId(orderId).stream()
                .map(bizOrderDetail -> {
                    System.out.println(bizOrderDetail.getQuantity());
                    BizOrderDetailDto bizOrderDetailDto = new BizOrderDetailDto();
                    bizOrderDetailDto.setOrderDetailId(bizOrderDetail.getOrderDetailId());
                    bizOrderDetailDto.setOrderId(bizOrderDetail.getOrderId());
                    bizOrderDetailDto.setProductName(bizOrderDetail.getProductName());
                    bizOrderDetailDto.setWarehouseName(bizOrderDetail.getWarehouseName());
                    bizOrderDetailDto.setQuantity(Long.valueOf(bizOrderDetail.getQuantity()));
                    bizOrderDetailDto.setUnitPrice(bizOrderDetail.getUnitPrice());
                    bizOrderDetailDto.setSubtotal(bizOrderDetail.getSubtotal());
                    bizOrderDetailDto.setIsReturned(bizOrderDetail.getIsReturned());
                    bizOrderDetailDto.setRemark(bizOrderDetail.getRemark());
                    System.out.println(bizOrderDetailDto.getQuantity());
                    return bizOrderDetailDto;
                })
                .collect(Collectors.toList());
    }
}
