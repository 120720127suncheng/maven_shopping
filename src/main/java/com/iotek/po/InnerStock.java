package com.iotek.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by xiaohuang on 2018/1/17.
 */
public class InnerStock implements Serializable {
    private Integer id;
    private Integer  productId;
    private Integer  innerStockNumber;
    private Timestamp innerCreateTime;
    private Timestamp innerModifiedTime;

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

    public Integer getInnerStockNumber() {
        return innerStockNumber;
    }

    public void setInnerStockNumber(Integer innerStockNumber) {
        this.innerStockNumber = innerStockNumber;
    }

    public Timestamp getInnerCreateTime() {
        return innerCreateTime;
    }

    public void setInnerCreateTime(Timestamp innerCreateTime) {
        this.innerCreateTime = innerCreateTime;
    }

    public Timestamp getInnerModifiedTime() {
        return innerModifiedTime;
    }

    public void setInnerModifiedTime(Timestamp innerModifiedTime) {
        this.innerModifiedTime = innerModifiedTime;
    }

    @Override
    public String toString() {
        return "InnerStock{" +
                "id=" + id +
                ", productId=" + productId +
                ", innerStockNumber=" + innerStockNumber +
                ", innerCreateTime=" + innerCreateTime +
                ", innerModifiedTime=" + innerModifiedTime +
                '}';
    }
}
