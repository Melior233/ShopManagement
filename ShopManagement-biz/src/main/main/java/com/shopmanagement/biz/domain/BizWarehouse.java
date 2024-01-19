package com.shopmanagement.biz.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shopmanagement.common.annotation.Excel;
import com.shopmanagement.common.core.domain.BaseEntity;

/**
 * 仓库信息对象 biz_warehouse
 * 
 * @author zr
 * @date 2024-01-19
 */
public class BizWarehouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 仓库ID */
    private Long warehouseId;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String warehouseName;

    /** 仓库负责人 */
    @Excel(name = "仓库负责人")
    private String warehouseManager;

    /** 仓库电话 */
    @Excel(name = "仓库电话")
    private String warehousePhone;

    /** 仓库地址 */
    @Excel(name = "仓库地址")
    private String warehouseAddress;

    /** 仓库总货架 */
    @Excel(name = "仓库总货架")
    private Long totalShelves;

    /** 仓库空闲货架 */
    @Excel(name = "仓库空闲货架")
    private Long freeShelves;

    /** 仓库状态 */
    @Excel(name = "仓库状态")
    private String warehouseStatus;

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

    public void setWarehouseId(Long warehouseId) 
    {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() 
    {
        return warehouseId;
    }
    public void setWarehouseName(String warehouseName) 
    {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseName() 
    {
        return warehouseName;
    }
    public void setWarehouseManager(String warehouseManager) 
    {
        this.warehouseManager = warehouseManager;
    }

    public String getWarehouseManager() 
    {
        return warehouseManager;
    }
    public void setWarehousePhone(String warehousePhone) 
    {
        this.warehousePhone = warehousePhone;
    }

    public String getWarehousePhone() 
    {
        return warehousePhone;
    }
    public void setWarehouseAddress(String warehouseAddress) 
    {
        this.warehouseAddress = warehouseAddress;
    }

    public String getWarehouseAddress() 
    {
        return warehouseAddress;
    }
    public void setTotalShelves(Long totalShelves) 
    {
        this.totalShelves = totalShelves;
    }

    public Long getTotalShelves() 
    {
        return totalShelves;
    }
    public void setFreeShelves(Long freeShelves) 
    {
        this.freeShelves = freeShelves;
    }

    public Long getFreeShelves() 
    {
        return freeShelves;
    }
    public void setWarehouseStatus(String warehouseStatus) 
    {
        this.warehouseStatus = warehouseStatus;
    }

    public String getWarehouseStatus() 
    {
        return warehouseStatus;
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
            .append("warehouseId", getWarehouseId())
            .append("warehouseName", getWarehouseName())
            .append("warehouseManager", getWarehouseManager())
            .append("warehousePhone", getWarehousePhone())
            .append("warehouseAddress", getWarehouseAddress())
            .append("totalShelves", getTotalShelves())
            .append("freeShelves", getFreeShelves())
            .append("warehouseStatus", getWarehouseStatus())
            .append("tenantId", getTenantId())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("lastModifiedBy", getLastModifiedBy())
            .append("lastModifiedTime", getLastModifiedTime())
            .toString();
    }
}
