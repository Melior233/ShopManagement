package com.shopmanagement.biz.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shopmanagement.common.annotation.Excel;
import com.shopmanagement.common.core.domain.BaseEntity;

/**
 * VIP客户信息对象 biz_vip_customer
 * 
 * @author zr
 * @date 2024-01-19
 */
public class BizVipCustomer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** VIP客户ID */
    private Long vipCustomerId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** VIP等级 */
    @Excel(name = "VIP等级")
    private Long vipLevel;

    /** 积分 */
    @Excel(name = "积分")
    private Long points;

    /** 租户ID */
    @Excel(name = "租户ID")
    private Long tenantId;

    /** 创建者 */
    @Excel(name = "创建者")
    private String createdBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 最后修改者 */
    @Excel(name = "最后修改者")
    private String lastModifiedBy;

    /** 最后修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastModifiedTime;

    public void setVipCustomerId(Long vipCustomerId) 
    {
        this.vipCustomerId = vipCustomerId;
    }

    public Long getVipCustomerId() 
    {
        return vipCustomerId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setVipLevel(Long vipLevel) 
    {
        this.vipLevel = vipLevel;
    }

    public Long getVipLevel() 
    {
        return vipLevel;
    }
    public void setPoints(Long points) 
    {
        this.points = points;
    }

    public Long getPoints() 
    {
        return points;
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
            .append("vipCustomerId", getVipCustomerId())
            .append("name", getName())
            .append("phone", getPhone())
            .append("vipLevel", getVipLevel())
            .append("points", getPoints())
            .append("tenantId", getTenantId())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("lastModifiedBy", getLastModifiedBy())
            .append("lastModifiedTime", getLastModifiedTime())
            .toString();
    }
}
