package com.iotek.po;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by 3 on 2018/1/15.
 */
public class OrderList implements Serializable {
    public static final Integer ORDER_IS_PAY = 1;
    public static final Integer ORDER_IS_NOT_PAY = 0;
    public static final Integer ORDER_IS_TRANSPORT = 1;
    public static final Integer ORDER_IS_NOT_TRANSPORT = 0;
    public static final Integer ORDER_IS_DELETED = 1;
    public static final Integer ORDER_IS_NOT_DELETED = 0;
    private Integer id;
    private Integer customerId;
    private Integer totalMoney;
    private Integer addressId;
    private Integer orderIsPay;
    private Integer orderIsTransport;
    private Integer orderIsDeleted;
    private Timestamp orderCreateTime;
    private Timestamp orderModifiedTime;
    private List<OrderItem> orderItemList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getOrderIsPay() {
        return orderIsPay;
    }

    public void setOrderIsPay(Integer orderIsPay) {
        this.orderIsPay = orderIsPay;
    }

    public Integer getOrderIsDeleted() {
        return orderIsDeleted;
    }

    public void setOrderIsDeleted(Integer orderIsDeleted) {
        this.orderIsDeleted = orderIsDeleted;
    }

    public Integer getOrderIsTransport() {
        return orderIsTransport;
    }

    public void setOrderIsTransport(Integer orderIsTransport) {
        this.orderIsTransport = orderIsTransport;
    }

    public Timestamp getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Timestamp orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Timestamp getOrderModifiedTime() {
        return orderModifiedTime;
    }

    public void setOrderModifiedTime(Timestamp orderModifiedTime) {
        this.orderModifiedTime = orderModifiedTime;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "customerId=" + customerId +
                ", totalMoney=" + totalMoney +
                ", addressId=" + addressId +
                ", orderIsPay=" + orderIsPay +
                ", orderIsTransport=" + orderIsTransport +
                ", orderIsDeleted=" + orderIsDeleted +
                ", orderCreateTime=" + orderCreateTime +
                ", orderModifiedTime=" + orderModifiedTime +
                '}';
    }
}
