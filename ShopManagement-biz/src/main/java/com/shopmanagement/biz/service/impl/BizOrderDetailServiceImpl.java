package com.shopmanagement.biz.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.shopmanagement.biz.mapper.BizOrderDetailMapper;
import com.shopmanagement.biz.domain.BizOrderDetail;
import com.shopmanagement.biz.service.IBizOrderDetailService;

/**
 * 订单明细Service业务层处理
 * 
 * @author zr
 * @date 2024-02-27
 */
@Service
public class BizOrderDetailServiceImpl implements IBizOrderDetailService 
{
    private final BizOrderDetailMapper bizOrderDetailMapper;

    public BizOrderDetailServiceImpl(BizOrderDetailMapper bizOrderDetailMapper) {
        this.bizOrderDetailMapper = bizOrderDetailMapper;
    }

    /**
     * 查询订单明细
     * 
     * @param orderDetailId 订单明细主键
     * @return 订单明细
     */
    @Override
    public BizOrderDetail selectBizOrderDetailByOrderDetailId(Long orderDetailId)
    {
        return bizOrderDetailMapper.selectBizOrderDetailByOrderDetailId(orderDetailId);
    }

    /**
     * 查询订单明细列表
     * 
     * @param bizOrderDetail 订单明细
     * @return 订单明细
     */
    @Override
    public List<BizOrderDetail> selectBizOrderDetailList(BizOrderDetail bizOrderDetail)
    {
        return bizOrderDetailMapper.selectBizOrderDetailList(bizOrderDetail);
    }

    /**
     * 新增订单明细
     * 
     * @param bizOrderDetail 订单明细
     * @return 结果
     */
    @Override
    public int insertBizOrderDetail(BizOrderDetail bizOrderDetail)
    {
        return bizOrderDetailMapper.insertBizOrderDetail(bizOrderDetail);
    }

    /**
     * 修改订单明细
     * 
     * @param bizOrderDetail 订单明细
     * @return 结果
     */
    @Override
    public int updateBizOrderDetail(BizOrderDetail bizOrderDetail)
    {
        return bizOrderDetailMapper.updateBizOrderDetail(bizOrderDetail);
    }

    /**
     * 批量删除订单明细
     * 
     * @param orderDetailIds 需要删除的订单明细主键
     * @return 结果
     */
    @Override
    public int deleteBizOrderDetailByOrderDetailIds(Long[] orderDetailIds)
    {
        return bizOrderDetailMapper.deleteBizOrderDetailByOrderDetailIds(orderDetailIds);
    }

    /**
     * 删除订单明细信息
     * 
     * @param orderDetailId 订单明细主键
     * @return 结果
     */
    @Override
    public int deleteBizOrderDetailByOrderDetailId(Long orderDetailId)
    {
        return bizOrderDetailMapper.deleteBizOrderDetailByOrderDetailId(orderDetailId);
    }
}
