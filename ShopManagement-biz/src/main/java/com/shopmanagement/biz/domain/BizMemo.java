package com.shopmanagement.biz.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shopmanagement.common.annotation.Excel;
import com.shopmanagement.common.core.domain.BaseEntity;

/**
 * 备忘录信息对象 biz_memo
 * 
 * @author zr
 * @date 2024-01-19
 */
public class BizMemo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 备忘录ID */
    private Long memoId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 租户ID */
    private Long tenantId;

    /** 创建者 */
    private String createdBy;

    /** 创建时间 */
    private Date createdTime;

    /** 最后修改者 */
    private String lastModifiedBy;

    /** 最后修改时间 */
    private Date lastModifiedTime;

    public void setMemoId(Long memoId) 
    {
        this.memoId = memoId;
    }

    public Long getMemoId() 
    {
        return memoId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setTenantId(Long tenantId) 
    {
        this.tenantId = tenantId;
    }

    public Long getTenantId() 
    {
        return tenantId;
    }
    public void setCreatedBy(String createdBy) 
    {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() 
    {
        return createdBy;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }
    public void setLastModifiedBy(String lastModifiedBy) 
    {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedBy() 
    {
        return lastModifiedBy;
    }
    public void setLastModifiedTime(Date lastModifiedTime) 
    {
        this.lastModifiedTime = lastModifiedTime;
    }

    public Date getLastModifiedTime() 
    {
        return lastModifiedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("memoId", getMemoId())
            .append("title", getTitle())
            .append("remark", getRemark())
            .append("content", getContent())
            .append("tenantId", getTenantId())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("lastModifiedBy", getLastModifiedBy())
            .append("lastModifiedTime", getLastModifiedTime())
            .toString();
    }
}
