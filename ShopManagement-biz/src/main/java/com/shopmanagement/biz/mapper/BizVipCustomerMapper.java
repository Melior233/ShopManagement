package com.shopmanagement.biz.mapper;

import java.util.List;
import com.shopmanagement.biz.domain.BizVipCustomer;

/**
 * VIP客户信息Mapper接口
 * 
 * @author zr
 * @date 2024-02-27
 */
public interface BizVipCustomerMapper 
{
    /**
     * 查询VIP客户信息
     * 
     * @param vipCustomerId VIP客户信息主键
     * @return VIP客户信息
     */
    public BizVipCustomer selectBizVipCustomerByVipCustomerId(Long vipCustomerId);

    /**
     * 查询VIP客户信息列表
     * 
     * @param bizVipCustomer VIP客户信息
     * @return VIP客户信息集合
     */
    public List<BizVipCustomer> selectBizVipCustomerList(BizVipCustomer bizVipCustomer);

    /**
     * 新增VIP客户信息
     * 
     * @param bizVipCustomer VIP客户信息
     * @return 结果
     */
    public int insertBizVipCustomer(BizVipCustomer bizVipCustomer);

    /**
     * 修改VIP客户信息
     * 
     * @param bizVipCustomer VIP客户信息
     * @return 结果
     */
    public int updateBizVipCustomer(BizVipCustomer bizVipCustomer);

    /**
     * 删除VIP客户信息
     * 
     * @param vipCustomerId VIP客户信息主键
     * @return 结果
     */
    public int deleteBizVipCustomerByVipCustomerId(Long vipCustomerId);

    /**
     * 批量删除VIP客户信息
     * 
     * @param vipCustomerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizVipCustomerByVipCustomerIds(Long[] vipCustomerIds);
}
