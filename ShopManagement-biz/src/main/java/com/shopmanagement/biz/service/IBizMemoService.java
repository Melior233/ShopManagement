package com.shopmanagement.biz.service;

import java.util.List;
import com.shopmanagement.biz.domain.BizMemo;

/**
 * 备忘录信息Service接口
 * 
 * @author zr
 * @date 2024-01-19
 */
public interface IBizMemoService 
{
    /**
     * 查询备忘录信息
     * 
     * @param memoId 备忘录信息主键
     * @return 备忘录信息
     */
    public BizMemo selectBizMemoByMemoId(Long memoId);

    /**
     * 查询备忘录信息列表
     * 
     * @param bizMemo 备忘录信息
     * @return 备忘录信息集合
     */
    public List<BizMemo> selectBizMemoList(BizMemo bizMemo);

    /**
     * 新增备忘录信息
     * 
     * @param bizMemo 备忘录信息
     * @return 结果
     */
    public int insertBizMemo(BizMemo bizMemo);

    /**
     * 修改备忘录信息
     * 
     * @param bizMemo 备忘录信息
     * @return 结果
     */
    public int updateBizMemo(BizMemo bizMemo);

    /**
     * 批量删除备忘录信息
     * 
     * @param memoIds 需要删除的备忘录信息主键集合
     * @return 结果
     */
    public int deleteBizMemoByMemoIds(Long[] memoIds);

    /**
     * 删除备忘录信息信息
     * 
     * @param memoId 备忘录信息主键
     * @return 结果
     */
    public int deleteBizMemoByMemoId(Long memoId);
}
