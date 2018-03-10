package com.iotek.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by xiaohuang on 2018/1/31.
 */
public class OuterStock implements Serializable{
    private Integer id;
    private Integer productId;
    private Integer  outerStockNumber;
    private Timestamp  outerCreateTime;
    private Timestamp  outerModifiedTime;

    public OuterStock() {
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

    public Integer getOuterStockNumber() {
        return outerStockNumber;
    }

    public void setOuterStockNumber(Integer outerStockNumber) {
        this.outerStockNumber = outerStockNumber;
    }

    public Timestamp getOuterCreateTime() {
        return outerCreateTime;
    }

    public void setOuterCreateTime(Timestamp outerCreateTime) {
        this.outerCreateTime = outerCreateTime;
    }

    public Timestamp getOuterModifiedTime() {
        return outerModifiedTime;
    }

    public void setOuterModifiedTime(Timestamp outerModifiedTime) {
        this.outerModifiedTime = outerModifiedTime;
    }

    @Override
    public String toString() {
        return "OuterStock{" +
                "id=" + id +
                ", productId=" + productId +
                ", outerStockNumber=" + outerStockNumber +
                ", outerCreateTime=" + outerCreateTime +
                ", outerModifiedTime=" + outerModifiedTime +
                '}';
    }
}
