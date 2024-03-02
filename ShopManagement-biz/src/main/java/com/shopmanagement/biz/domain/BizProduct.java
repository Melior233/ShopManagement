package com.shopmanagement.biz.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shopmanagement.common.annotation.Excel;
import com.shopmanagement.common.core.domain.BaseEntity;

/**
 * 商品信息管理对象 biz_product
 * 
 * @author zr
 * @date 2024-03-02
 */
public class BizProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private Long productId;

    /** 商品编号 */
    @Excel(name = "商品编号")
    private String productNumber;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productName;

    /** 商品单位 */
    @Excel(name = "商品单位")
    private String productUnit;

    /** 商品类别 */
    @Excel(name = "商品类别")
    private String productCategory;

    /** 商品库存 */
    @Excel(name = "商品库存")
    private Long productStock;

    /** 商品所属仓库ID */
    @Excel(name = "商品所属仓库ID")
    private Long warehouseId;

    /** 商品单价 */
    @Excel(name = "商品单价")
    private BigDecimal unitPrice;

    /** 商品进货价 */
    @Excel(name = "商品进货价")
    private BigDecimal purchasePrice;

    /** 告警阈值 */
    @Excel(name = "告警阈值")
    private Long alarmThreshold;

    /** 是否告警 */
    @Excel(name = "是否告警")
    private Integer isalarm;

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

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setProductNumber(String productNumber) 
    {
        this.productNumber = productNumber;
    }

    public String getProductNumber() 
    {
        return productNumber;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setProductUnit(String productUnit) 
    {
        this.productUnit = productUnit;
    }

    public String getProductUnit() 
    {
        return productUnit;
    }
    public void setProductCategory(String productCategory) 
    {
        this.productCategory = productCategory;
    }

    public String getProductCategory() 
    {
        return productCategory;
    }
    public void setProductStock(Long productStock) 
    {
        this.productStock = productStock;
    }

    public Long getProductStock() 
    {
        return productStock;
    }
    public void setWarehouseId(Long warehouseId) 
    {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() 
    {
        return warehouseId;
    }
    public void setUnitPrice(BigDecimal unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() 
    {
        return unitPrice;
    }
    public void setPurchasePrice(BigDecimal purchasePrice) 
    {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getPurchasePrice() 
    {
        return purchasePrice;
    }
    public void setAlarmThreshold(Long alarmThreshold) 
    {
        this.alarmThreshold = alarmThreshold;
    }

    public Long getAlarmThreshold() 
    {
        return alarmThreshold;
    }
    public void setIsalarm(Integer isalarm) 
    {
        this.isalarm = isalarm;
    }

    public Integer getIsalarm() 
    {
        return isalarm;
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
            .append("productId", getProductId())
            .append("productNumber", getProductNumber())
            .append("productName", getProductName())
            .append("productUnit", getProductUnit())
            .append("productCategory", getProductCategory())
            .append("productStock", getProductStock())
            .append("warehouseId", getWarehouseId())
            .append("unitPrice", getUnitPrice())
            .append("purchasePrice", getPurchasePrice())
            .append("alarmThreshold", getAlarmThreshold())
            .append("isalarm", getIsalarm())
            .append("tenantId", getTenantId())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("lastModifiedBy", getLastModifiedBy())
            .append("lastModifiedTime", getLastModifiedTime())
            .toString();
    }
}
