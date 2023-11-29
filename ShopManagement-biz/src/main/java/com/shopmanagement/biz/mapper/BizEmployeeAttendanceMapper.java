package com.shopmanagement.biz.mapper;

import java.util.List;
import com.shopmanagement.biz.domain.BizEmployeeAttendance;

/**
 * 商铺员工考勤记录Mapper接口
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
public interface BizEmployeeAttendanceMapper 
{
    /**
     * 查询商铺员工考勤记录
     * 
     * @param id 商铺员工考勤记录主键
     * @return 商铺员工考勤记录
     */
    public BizEmployeeAttendance selectBizEmployeeAttendanceById(Long id);

    /**
     * 查询商铺员工考勤记录列表
     * 
     * @param bizEmployeeAttendance 商铺员工考勤记录
     * @return 商铺员工考勤记录集合
     */
    public List<BizEmployeeAttendance> selectBizEmployeeAttendanceList(BizEmployeeAttendance bizEmployeeAttendance);

    /**
     * 新增商铺员工考勤记录
     * 
     * @param bizEmployeeAttendance 商铺员工考勤记录
     * @return 结果
     */
    public int insertBizEmployeeAttendance(BizEmployeeAttendance bizEmployeeAttendance);

    /**
     * 修改商铺员工考勤记录
     * 
     * @param bizEmployeeAttendance 商铺员工考勤记录
     * @return 结果
     */
    public int updateBizEmployeeAttendance(BizEmployeeAttendance bizEmployeeAttendance);

    /**
     * 删除商铺员工考勤记录
     * 
     * @param id 商铺员工考勤记录主键
     * @return 结果
     */
    public int deleteBizEmployeeAttendanceById(Long id);

    /**
     * 批量删除商铺员工考勤记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizEmployeeAttendanceByIds(Long[] ids);
}
