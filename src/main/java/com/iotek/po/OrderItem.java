package com.iotek.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by 3 on 2018/1/15.
 */
public class OrderItem implements Serializable {
    private Integer id;
    private Integer orderListId;
    private Integer productId;
    private Integer productNumber;
    private Timestamp itemCreateTime;
    private Timestamp itemModifiedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(Integer orderListId) {
        this.orderListId = orderListId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public Timestamp getItemCreateTime() {
        return itemCreateTime;
    }

    public void setItemCreateTime(Timestamp itemCreateTime) {
        this.itemCreateTime = itemCreateTime;
    }

    public Timestamp getItemModifiedTime() {
        return itemModifiedTime;
    }

    public void setItemModifiedTime(Timestamp itemModifiedTime) {
        this.itemModifiedTime = itemModifiedTime;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderListId=" + orderListId +
                ", productId=" + productId +
                ", productNumber=" + productNumber +
                ", itemCreateTime=" + itemCreateTime +
                ", itemModifiedTime=" + itemModifiedTime +
                '}';
    }
}
