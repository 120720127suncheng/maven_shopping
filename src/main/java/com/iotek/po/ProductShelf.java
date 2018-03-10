package com.iotek.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProductShelf implements Serializable {
    public static final Integer PRODUCT_IS_IN_SHELF=1;
    public static final Integer PRODUCT_IS_NOT_IN_SHELF=0;
    private Integer id;
    private Integer productId;
    private Integer productShelfState;
    private Timestamp shelfCreateTime;
    private Timestamp shelfModifiedTime;

    public ProductShelf() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductShelfState() {
        return productShelfState;
    }

    public void setProductShelfState(Integer productShelfState) {
        this.productShelfState = productShelfState;
    }

    public Timestamp getShelfCreateTime() {
        return shelfCreateTime;
    }

    public void setShelfCreateTime(Timestamp shelfCreateTime) {
        this.shelfCreateTime = shelfCreateTime;
    }

    public Timestamp getShelfModifiedTime() {
        return shelfModifiedTime;
    }

    public void setShelfModifiedTime(Timestamp shelfModifiedTime) {
        this.shelfModifiedTime = shelfModifiedTime;
    }

    @Override
    public String toString() {
        return "ProductShelf{" +
                "id=" + id +
                ", productId=" + productId +
                ", productShelfState=" + productShelfState +
                ", shelfCreateTime=" + shelfCreateTime +
                ", shelfModifiedTime=" + shelfModifiedTime +
                '}';
    }
}