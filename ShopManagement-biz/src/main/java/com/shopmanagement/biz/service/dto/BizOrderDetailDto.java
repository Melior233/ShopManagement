package com.shopmanagement.biz.service.dto;

import com.shopmanagement.common.annotation.Excel;
import com.shopmanagement.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单明细对象 biz_order_detail
 * 
 * @author zr
 * @date 2024-02-27
 */
public class BizOrderDetailDto extends BaseEntity
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
            .toString();
    }
}
