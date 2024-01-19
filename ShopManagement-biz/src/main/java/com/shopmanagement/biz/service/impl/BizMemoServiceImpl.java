package com.shopmanagement.biz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopmanagement.biz.mapper.BizMemoMapper;
import com.shopmanagement.biz.domain.BizMemo;
import com.shopmanagement.biz.service.IBizMemoService;

/**
 * 备忘录信息Service业务层处理
 * 
 * @author zr
 * @date 2024-01-19
 */
@Service
public class BizMemoServiceImpl implements IBizMemoService 
{
    @Autowired
    private BizMemoMapper bizMemoMapper;

    /**
     * 查询备忘录信息
     * 
     * @param memoId 备忘录信息主键
     * @return 备忘录信息
     */
    @Override
    public BizMemo selectBizMemoByMemoId(Long memoId)
    {
        return bizMemoMapper.selectBizMemoByMemoId(memoId);
    }

    /**
     * 查询备忘录信息列表
     * 
     * @param bizMemo 备忘录信息
     * @return 备忘录信息
     */
    @Override
    public List<BizMemo> selectBizMemoList(BizMemo bizMemo)
    {
        return bizMemoMapper.selectBizMemoList(bizMemo);
    }

    /**
     * 新增备忘录信息
     * 
     * @param bizMemo 备忘录信息
     * @return 结果
     */
    @Override
    public int insertBizMemo(BizMemo bizMemo)
    {
        return bizMemoMapper.insertBizMemo(bizMemo);
    }

    /**
     * 修改备忘录信息
     * 
     * @param bizMemo 备忘录信息
     * @return 结果
     */
    @Override
    public int updateBizMemo(BizMemo bizMemo)
    {
        return bizMemoMapper.updateBizMemo(bizMemo);
    }

    /**
     * 批量删除备忘录信息
     * 
     * @param memoIds 需要删除的备忘录信息主键
     * @return 结果
     */
    @Override
    public int deleteBizMemoByMemoIds(Long[] memoIds)
    {
        return bizMemoMapper.deleteBizMemoByMemoIds(memoIds);
    }

    /**
     * 删除备忘录信息信息
     * 
     * @param memoId 备忘录信息主键
     * @return 结果
     */
    @Override
    public int deleteBizMemoByMemoId(Long memoId)
    {
        return bizMemoMapper.deleteBizMemoByMemoId(memoId);
    }
}
