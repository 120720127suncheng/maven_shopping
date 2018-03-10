package com.iotek.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by xiaohuang on 2018/1/30.
 */
public class Message implements Serializable {
    public   static   final  int   MSG_IS_READ=1;
    public   static   final  int   MSG_IS_NOT_READ=0;
    public   static   final  int   MSG_IS_TAG=2;

    private   int id;
    private  MsgType  msgType;
    private  String msgTheme;
    private   String msgInfo;
    private  Integer  createMsgId;
    private  Integer  msgIsRead=MSG_IS_NOT_READ;
    private Timestamp   msgCreateTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MsgType getMsgType() {
        return msgType;
    }

    public void setMsgType(MsgType msgType) {
        this.msgType = msgType;
    }

    public String getMsgTheme() {
        return msgTheme;
    }

    public void setMsgTheme(String msgTheme) {
        this.msgTheme = msgTheme;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

    public Integer getCreateMsgId() {
        return createMsgId;
    }

    public void setCreateMsgId(Integer createMsgId) {
        this.createMsgId = createMsgId;
    }

    public Integer getMsgIsRead() {
        return msgIsRead;
    }

    public void setMsgIsRead(Integer msgIsRead) {
        this.msgIsRead = msgIsRead;
    }

    public Timestamp getMsgCreateTime() {
        return msgCreateTime;
    }

    public void setMsgCreateTime(Timestamp msgCreateTime) {
        this.msgCreateTime = msgCreateTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", msgType=" + msgType +
                ", msgTheme='" + msgTheme + '\'' +
                ", msgInfo='" + msgInfo + '\'' +
                ", createMsgId=" + createMsgId +
                ", msgIsRead=" + msgIsRead +
                ", msgCreateTime=" + msgCreateTime +
                '}';
    }
}
