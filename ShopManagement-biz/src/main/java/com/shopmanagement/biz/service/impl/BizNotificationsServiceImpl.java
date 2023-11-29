package com.shopmanagement.biz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopmanagement.biz.mapper.BizNotificationsMapper;
import com.shopmanagement.biz.domain.BizNotifications;
import com.shopmanagement.biz.service.IBizNotificationsService;

/**
 * 商铺通知Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
@Service
public class BizNotificationsServiceImpl implements IBizNotificationsService 
{
    @Autowired
    private BizNotificationsMapper bizNotificationsMapper;

    /**
     * 查询商铺通知
     * 
     * @param id 商铺通知主键
     * @return 商铺通知
     */
    @Override
    public BizNotifications selectBizNotificationsById(Long id)
    {
        return bizNotificationsMapper.selectBizNotificationsById(id);
    }

    /**
     * 查询商铺通知列表
     * 
     * @param bizNotifications 商铺通知
     * @return 商铺通知
     */
    @Override
    public List<BizNotifications> selectBizNotificationsList(BizNotifications bizNotifications)
    {
        return bizNotificationsMapper.selectBizNotificationsList(bizNotifications);
    }

    /**
     * 新增商铺通知
     * 
     * @param bizNotifications 商铺通知
     * @return 结果
     */
    @Override
    public int insertBizNotifications(BizNotifications bizNotifications)
    {
        return bizNotificationsMapper.insertBizNotifications(bizNotifications);
    }

    /**
     * 修改商铺通知
     * 
     * @param bizNotifications 商铺通知
     * @return 结果
     */
    @Override
    public int updateBizNotifications(BizNotifications bizNotifications)
    {
        return bizNotificationsMapper.updateBizNotifications(bizNotifications);
    }

    /**
     * 批量删除商铺通知
     * 
     * @param ids 需要删除的商铺通知主键
     * @return 结果
     */
    @Override
    public int deleteBizNotificationsByIds(Long[] ids)
    {
        return bizNotificationsMapper.deleteBizNotificationsByIds(ids);
    }

    /**
     * 删除商铺通知信息
     * 
     * @param id 商铺通知主键
     * @return 结果
     */
    @Override
    public int deleteBizNotificationsById(Long id)
    {
        return bizNotificationsMapper.deleteBizNotificationsById(id);
    }
}
