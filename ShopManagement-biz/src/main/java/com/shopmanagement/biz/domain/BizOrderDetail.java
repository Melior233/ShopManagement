package com.shopmanagement.biz.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shopmanagement.common.annotation.Excel;
import com.shopmanagement.common.core.domain.BaseEntity;

/**
 * 订单明细对象 biz_order_detail
 * 
 * @author zr
 * @date 2024-02-27
 */
public class BizOrderDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单明细ID */
    private Long orderDetailId;

    /** 订单ID */
    @Excel(name = "订单ID")
    private Long orderId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productName;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String warehouseName;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Long quantity;

    /** 商品单价 */
    @Excel(name = "商品单价")
    private BigDecimal unitPrice;

    /** 小计 */
    @Excel(name = "小计")
    private BigDecimal subtotal;

    /** 是否退货 */
    @Excel(name = "是否退货")
    private Integer isReturned;

    /** 备注 */
    @Excel(name = "备注")
    private String remark;

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

    public void setOrderDetailId(Long orderDetailId) 
    {
        this.orderDetailId = orderDetailId;
    }

    public Long getOrderDetailId() 
    {
        return orderDetailId;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setWarehouseName(String warehouseName) 
    {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseName() 
    {
        return warehouseName;
    }
    public void setQuantity(Long quantity) 
    {
        this.quantity = quantity;
    }

    public Long getQuantity() 
    {
        return quantity;
    }
    public void setUnitPrice(BigDecimal unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() 
    {
        return unitPrice;
    }
    public void setSubtotal(BigDecimal subtotal) 
    {
        this.subtotal = subtotal;
    }

    public BigDecimal getSubtotal() 
    {
        return subtotal;
    }
    public void setIsReturned(Integer isReturned) 
    {
        this.isReturned = isReturned;
    }

    public Integer getIsReturned() 
    {
        return isReturned;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderDetailId", getOrderDetailId())
            .append("orderId", getOrderId())
            .append("productName", getProductName())
            .append("warehouseName", getWarehouseName())
            .append("quantity", getQuantity())
            .append("unitPrice", getUnitPrice())
            .append("subtotal", getSubtotal())
            .append("isReturned", getIsReturned())
            .append("remark", getRemark())
            .append("tenantId", getTenantId())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("lastModifiedBy", getLastModifiedBy())
            .append("lastModifiedTime", getLastModifiedTime())
            .toString();
    }
}
