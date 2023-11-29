package com.shopmanagement.biz.service;

import java.util.List;
import com.shopmanagement.biz.domain.BizEmployees;

/**
 * 商铺员工Service接口
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
public interface IBizEmployeesService 
{
    /**
     * 查询商铺员工
     * 
     * @param id 商铺员工主键
     * @return 商铺员工
     */
    public BizEmployees selectBizEmployeesById(Long id);

    /**
     * 查询商铺员工列表
     * 
     * @param bizEmployees 商铺员工
     * @return 商铺员工集合
     */
    public List<BizEmployees> selectBizEmployeesList(BizEmployees bizEmployees);

    /**
     * 新增商铺员工
     * 
     * @param bizEmployees 商铺员工
     * @return 结果
     */
    public int insertBizEmployees(BizEmployees bizEmployees);

    /**
     * 修改商铺员工
     * 
     * @param bizEmployees 商铺员工
     * @return 结果
     */
    public int updateBizEmployees(BizEmployees bizEmployees);

    /**
     * 批量删除商铺员工
     * 
     * @param ids 需要删除的商铺员工主键集合
     * @return 结果
     */
    public int deleteBizEmployeesByIds(Long[] ids);

    /**
     * 删除商铺员工信息
     * 
     * @param id 商铺员工主键
     * @return 结果
     */
    public int deleteBizEmployeesById(Long id);
}
