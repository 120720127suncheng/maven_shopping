package com.iotek.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by xiaohuang on 2018/1/17.
 */
public class Discuss implements Serializable {
    public  static  final   int  DISCUSS_IS_DELETED=1;
    public  static  final   int  DISCUSS_IS_NOT_DELETED=1;
    private  Integer  id;
    private  Integer  customerId;
    private  Integer  orderItemId;
    private  Integer  productId;
    private  Integer  discussScore;
    private  Integer  discussIsDeleted;
    private Timestamp  discussCreateTime;
    private Timestamp  discussModifiedTime;

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

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getDiscussScore() {
        return discussScore;
    }

    public void setDiscussScore(Integer discussScore) {
        this.discussScore = discussScore;
    }

    public Integer getDiscussIsDeleted() {
        return discussIsDeleted;
    }

    public void setDiscussIsDeleted(Integer discussIsDeleted) {
        this.discussIsDeleted = discussIsDeleted;
    }

    public Timestamp getDiscussCreateTime() {
        return discussCreateTime;
    }

    public void setDiscussCreateTime(Timestamp discussCreateTime) {
        this.discussCreateTime = discussCreateTime;
    }

    public Timestamp getDiscussModifiedTime() {
        return discussModifiedTime;
    }

    public void setDiscussModifiedTime(Timestamp discussModifiedTime) {
        this.discussModifiedTime = discussModifiedTime;
    }

    @Override
    public String toString() {
        return "Discuss{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", orderItemId=" + orderItemId +
                ", productId=" + productId +
                ", discussScore=" + discussScore +
                ", discussIsDeleted=" + discussIsDeleted +
                ", discussCreateTime=" + discussCreateTime +
                ", discussModifiedTime=" + discussModifiedTime +
                '}';
    }
}
