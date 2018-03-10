package com.iotek.po;

/**
 * Created by xiaohuang on 2018/1/30.
 */
public enum MsgType {
    orderMsgType("order"), productMsgType("product"), customerMsgType("customer"),
    stockMsgType("stock"), shelfMsgType("shelf"), discussMsgType("discuss");

    private String info;

    MsgType(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "MsgType{" +
                "info='" + info + '\'' +
                '}';
    }

    public static MsgType getMsgType(String name) {
        switch (name) {
            case "order":

                return orderMsgType;
            case "product":
                return productMsgType;
            case "customer":
                return customerMsgType;
            case "stock":
                return stockMsgType;
            case "shelf":
                return shelfMsgType;
            case "discuss":
                return discussMsgType;

            default:
                return null;
        }
    }
}
