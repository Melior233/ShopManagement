package com.shopmanagement.biz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopmanagement.biz.mapper.BizEmployeesMapper;
import com.shopmanagement.biz.domain.BizEmployees;
import com.shopmanagement.biz.service.IBizEmployeesService;

/**
 * 商铺员工Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-11-29
 */
@Service
public class BizEmployeesServiceImpl implements IBizEmployeesService 
{
    @Autowired
    private BizEmployeesMapper bizEmployeesMapper;

    /**
     * 查询商铺员工
     * 
     * @param id 商铺员工主键
     * @return 商铺员工
     */
    @Override
    public BizEmployees selectBizEmployeesById(Long id)
    {
        return bizEmployeesMapper.selectBizEmployeesById(id);
    }

    /**
     * 查询商铺员工列表
     * 
     * @param bizEmployees 商铺员工
     * @return 商铺员工
     */
    @Override
    public List<BizEmployees> selectBizEmployeesList(BizEmployees bizEmployees)
    {
        return bizEmployeesMapper.selectBizEmployeesList(bizEmployees);
    }

    /**
     * 新增商铺员工
     * 
     * @param bizEmployees 商铺员工
     * @return 结果
     */
    @Override
    public int insertBizEmployees(BizEmployees bizEmployees)
    {
        return bizEmployeesMapper.insertBizEmployees(bizEmployees);
    }

    /**
     * 修改商铺员工
     * 
     * @param bizEmployees 商铺员工
     * @return 结果
     */
    @Override
    public int updateBizEmployees(BizEmployees bizEmployees)
    {
        return bizEmployeesMapper.updateBizEmployees(bizEmployees);
    }

    /**
     * 批量删除商铺员工
     * 
     * @param ids 需要删除的商铺员工主键
     * @return 结果
     */
    @Override
    public int deleteBizEmployeesByIds(Long[] ids)
    {
        return bizEmployeesMapper.deleteBizEmployeesByIds(ids);
    }

    /**
     * 删除商铺员工信息
     * 
     * @param id 商铺员工主键
     * @return 结果
     */
    @Override
    public int deleteBizEmployeesById(Long id)
    {
        return bizEmployeesMapper.deleteBizEmployeesById(id);
    }
}
