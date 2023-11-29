package com.shopmanagement.biz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopmanagement.biz.mapper.BizEmployeeAttendanceMapper;
import com.shopmanagement.biz.domain.BizEmployeeAttendance;
import com.shopmanagement.biz.service.IBizEmployeeAttendanceService;

/**
 * 商铺员工考勤记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
@Service
public class BizEmployeeAttendanceServiceImpl implements IBizEmployeeAttendanceService 
{
    @Autowired
    private BizEmployeeAttendanceMapper bizEmployeeAttendanceMapper;

    /**
     * 查询商铺员工考勤记录
     * 
     * @param id 商铺员工考勤记录主键
     * @return 商铺员工考勤记录
     */
    @Override
    public BizEmployeeAttendance selectBizEmployeeAttendanceById(Long id)
    {
        return bizEmployeeAttendanceMapper.selectBizEmployeeAttendanceById(id);
    }

    /**
     * 查询商铺员工考勤记录列表
     * 
     * @param bizEmployeeAttendance 商铺员工考勤记录
     * @return 商铺员工考勤记录
     */
    @Override
    public List<BizEmployeeAttendance> selectBizEmployeeAttendanceList(BizEmployeeAttendance bizEmployeeAttendance)
    {
        return bizEmployeeAttendanceMapper.selectBizEmployeeAttendanceList(bizEmployeeAttendance);
    }

    /**
     * 新增商铺员工考勤记录
     * 
     * @param bizEmployeeAttendance 商铺员工考勤记录
     * @return 结果
     */
    @Override
    public int insertBizEmployeeAttendance(BizEmployeeAttendance bizEmployeeAttendance)
    {
        return bizEmployeeAttendanceMapper.insertBizEmployeeAttendance(bizEmployeeAttendance);
    }

    /**
     * 修改商铺员工考勤记录
     * 
     * @param bizEmployeeAttendance 商铺员工考勤记录
     * @return 结果
     */
    @Override
    public int updateBizEmployeeAttendance(BizEmployeeAttendance bizEmployeeAttendance)
    {
        return bizEmployeeAttendanceMapper.updateBizEmployeeAttendance(bizEmployeeAttendance);
    }

    /**
     * 批量删除商铺员工考勤记录
     * 
     * @param ids 需要删除的商铺员工考勤记录主键
     * @return 结果
     */
    @Override
    public int deleteBizEmployeeAttendanceByIds(Long[] ids)
    {
        return bizEmployeeAttendanceMapper.deleteBizEmployeeAttendanceByIds(ids);
    }

    /**
     * 删除商铺员工考勤记录信息
     * 
     * @param id 商铺员工考勤记录主键
     * @return 结果
     */
    @Override
    public int deleteBizEmployeeAttendanceById(Long id)
    {
        return bizEmployeeAttendanceMapper.deleteBizEmployeeAttendanceById(id);
    }
}
