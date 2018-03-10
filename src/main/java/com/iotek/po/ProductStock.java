package com.iotek.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by xiaohuang on 2018/1/31.
 */
public class ProductStock implements Serializable {
    private  Integer id;
    private  Integer   productId;
    private  Integer  stockNumber;
    private Timestamp  stockCreateTime;
    private Timestamp  stockModifiedTime;

    public ProductStock() {
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

    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    public Timestamp getStockCreateTime() {
        return stockCreateTime;
    }

    public void setStockCreateTime(Timestamp stockCreateTime) {
        this.stockCreateTime = stockCreateTime;
    }

    public Timestamp getStockModifiedTime() {
        return stockModifiedTime;
    }

    public void setStockModifiedTime(Timestamp stockModifiedTime) {
        this.stockModifiedTime = stockModifiedTime;
    }

    @Override
    public String toString() {
        return "ProductStock{" +
                "id=" + id +
                ", productId=" + productId +
                ", stockNumber=" + stockNumber +
                ", stockCreateTime=" + stockCreateTime +
                ", stockModifiedTime=" + stockModifiedTime +
                '}';
    }
}
