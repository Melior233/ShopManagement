package com.shopmanagement.biz.mapper;

import java.util.List;
import com.shopmanagement.biz.domain.BizNotifications;

/**
 * 商铺通知Mapper接口
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
public interface BizNotificationsMapper 
{
    /**
     * 查询商铺通知
     * 
     * @param id 商铺通知主键
     * @return 商铺通知
     */
    public BizNotifications selectBizNotificationsById(Long id);

    /**
     * 查询商铺通知列表
     * 
     * @param bizNotifications 商铺通知
     * @return 商铺通知集合
     */
    public List<BizNotifications> selectBizNotificationsList(BizNotifications bizNotifications);

    /**
     * 新增商铺通知
     * 
     * @param bizNotifications 商铺通知
     * @return 结果
     */
    public int insertBizNotifications(BizNotifications bizNotifications);

    /**
     * 修改商铺通知
     * 
     * @param bizNotifications 商铺通知
     * @return 结果
     */
    public int updateBizNotifications(BizNotifications bizNotifications);

    /**
     * 删除商铺通知
     * 
     * @param id 商铺通知主键
     * @return 结果
     */
    public int deleteBizNotificationsById(Long id);

    /**
     * 批量删除商铺通知
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizNotificationsByIds(Long[] ids);
}
