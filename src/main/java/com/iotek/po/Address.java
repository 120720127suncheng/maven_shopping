package com.iotek.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by xiaohuang on 2018/1/17.
 */
public class Address implements Serializable {
    private Integer id;
    private Integer customerId;
    private String province;
    private String city;
    private String country;
    private String road;
    private String addressLable;
    private Timestamp addressCreateTime;
    private Timestamp addressModifiedTime;

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getAddressLable() {
        return addressLable;
    }

    public void setAddressLable(String addressLable) {
        this.addressLable = addressLable;
    }

    public Timestamp getAddressCreateTime() {
        return addressCreateTime;
    }

    public void setAddressCreateTime(Timestamp addressCreateTime) {
        this.addressCreateTime = addressCreateTime;
    }

    public Timestamp getAddressModifiedTime() {
        return addressModifiedTime;
    }

    public void setAddressModifiedTime(Timestamp addressModifiedTime) {
        this.addressModifiedTime = addressModifiedTime;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", road='" + road + '\'' +
                ", addressLable='" + addressLable + '\'' +
                ", addressCreateTime=" + addressCreateTime +
                ", addressModifiedTime=" + addressModifiedTime +
                '}';
    }
}
