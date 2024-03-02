package com.shopmanagement.biz.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.shopmanagement.biz.mapper.BizVipCustomerMapper;
import com.shopmanagement.biz.domain.BizVipCustomer;
import com.shopmanagement.biz.service.IBizVipCustomerService;

/**
 * VIP客户信息Service业务层处理
 * 
 * @author zr
 * @date 2024-02-27
 */
@Service
public class BizVipCustomerServiceImpl implements IBizVipCustomerService 
{
    private final BizVipCustomerMapper bizVipCustomerMapper;

    public BizVipCustomerServiceImpl(BizVipCustomerMapper bizVipCustomerMapper) {
        this.bizVipCustomerMapper = bizVipCustomerMapper;
    }

    /**
     * 查询VIP客户信息
     * 
     * @param vipCustomerId VIP客户信息主键
     * @return VIP客户信息
     */
    @Override
    public BizVipCustomer selectBizVipCustomerByVipCustomerId(Long vipCustomerId)
    {
        return bizVipCustomerMapper.selectBizVipCustomerByVipCustomerId(vipCustomerId);
    }

    /**
     * 查询VIP客户信息列表
     * 
     * @param bizVipCustomer VIP客户信息
     * @return VIP客户信息
     */
    @Override
    public List<BizVipCustomer> selectBizVipCustomerList(BizVipCustomer bizVipCustomer)
    {
        return bizVipCustomerMapper.selectBizVipCustomerList(bizVipCustomer);
    }

    /**
     * 新增VIP客户信息
     * 
     * @param bizVipCustomer VIP客户信息
     * @return 结果
     */
    @Override
    public int insertBizVipCustomer(BizVipCustomer bizVipCustomer)
    {
        return bizVipCustomerMapper.insertBizVipCustomer(bizVipCustomer);
    }

    /**
     * 修改VIP客户信息
     * 
     * @param bizVipCustomer VIP客户信息
     * @return 结果
     */
    @Override
    public int updateBizVipCustomer(BizVipCustomer bizVipCustomer)
    {
        return bizVipCustomerMapper.updateBizVipCustomer(bizVipCustomer);
    }

    /**
     * 批量删除VIP客户信息
     * 
     * @param vipCustomerIds 需要删除的VIP客户信息主键
     * @return 结果
     */
    @Override
    public int deleteBizVipCustomerByVipCustomerIds(Long[] vipCustomerIds)
    {
        return bizVipCustomerMapper.deleteBizVipCustomerByVipCustomerIds(vipCustomerIds);
    }

    /**
     * 删除VIP客户信息信息
     * 
     * @param vipCustomerId VIP客户信息主键
     * @return 结果
     */
    @Override
    public int deleteBizVipCustomerByVipCustomerId(Long vipCustomerId)
    {
        return bizVipCustomerMapper.deleteBizVipCustomerByVipCustomerId(vipCustomerId);
    }
}
