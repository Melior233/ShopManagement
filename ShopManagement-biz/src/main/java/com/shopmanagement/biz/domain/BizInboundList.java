package com.shopmanagement.biz.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shopmanagement.common.annotation.Excel;
import com.shopmanagement.common.core.domain.BaseEntity;

/**
 * 入库清单管理对象 biz_inbound_list
 * 
 * @author zr
 * @date 2024-01-19
 */
public class BizInboundList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 入库清单ID */
    private Long inboundListId;

    /** 仓库ID */
    @Excel(name = "仓库ID")
    private Long warehouseId;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String warehouseName;

    /** 入库商品名称 */
    @Excel(name = "入库商品名称")
    private String productName;

    /** 入库商品类别 */
    @Excel(name = "入库商品类别")
    private String productCategory;

    /** 入库商品数量 */
    @Excel(name = "入库商品数量")
    private Long productQuantity;

    /** 入库商品总价 */
    @Excel(name = "入库商品总价")
    private BigDecimal productTotalPrice;

    /** 入库规格 */
    @Excel(name = "入库规格")
    private String productSpecification;

    /** 入库姓名 */
    @Excel(name = "入库姓名")
    private String inboundPersonName;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 质检状态 */
    @Excel(name = "质检状态")
    private String qualityInspectionStatus;

    /** 是否入库 */
    @Excel(name = "是否入库")
    private Integer isInbound;

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

    public void setInboundListId(Long inboundListId) 
    {
        this.inboundListId = inboundListId;
    }

    public Long getInboundListId() 
    {
        return inboundListId;
    }
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
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setProductCategory(String productCategory) 
    {
        this.productCategory = productCategory;
    }

    public String getProductCategory() 
    {
        return productCategory;
    }
    public void setProductQuantity(Long productQuantity) 
    {
        this.productQuantity = productQuantity;
    }

    public Long getProductQuantity() 
    {
        return productQuantity;
    }
    public void setProductTotalPrice(BigDecimal productTotalPrice) 
    {
        this.productTotalPrice = productTotalPrice;
    }

    public BigDecimal getProductTotalPrice() 
    {
        return productTotalPrice;
    }
    public void setProductSpecification(String productSpecification) 
    {
        this.productSpecification = productSpecification;
    }

    public String getProductSpecification() 
    {
        return productSpecification;
    }
    public void setInboundPersonName(String inboundPersonName) 
    {
        this.inboundPersonName = inboundPersonName;
    }

    public String getInboundPersonName() 
    {
        return inboundPersonName;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setQualityInspectionStatus(String qualityInspectionStatus) 
    {
        this.qualityInspectionStatus = qualityInspectionStatus;
    }

    public String getQualityInspectionStatus() 
    {
        return qualityInspectionStatus;
    }
    public void setIsInbound(Integer isInbound) 
    {
        this.isInbound = isInbound;
    }

    public Integer getIsInbound() 
    {
        return isInbound;
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
            .append("inboundListId", getInboundListId())
            .append("warehouseId", getWarehouseId())
            .append("warehouseName", getWarehouseName())
            .append("productName", getProductName())
            .append("productCategory", getProductCategory())
            .append("productQuantity", getProductQuantity())
            .append("productTotalPrice", getProductTotalPrice())
            .append("productSpecification", getProductSpecification())
            .append("inboundPersonName", getInboundPersonName())
            .append("supplierName", getSupplierName())
            .append("qualityInspectionStatus", getQualityInspectionStatus())
            .append("isInbound", getIsInbound())
            .append("tenantId", getTenantId())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("lastModifiedBy", getLastModifiedBy())
            .append("lastModifiedTime", getLastModifiedTime())
            .toString();
    }
}
