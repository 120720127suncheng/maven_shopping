package com.iotek.po;

import java.io.Serializable;
import java.sql.Timestamp;
/*游客的基本信息表*/
public class VisitorBaseMessage implements Serializable {

	private Integer id;
	private Integer visitorId;
	private String visitorName;
	private Integer visitorAge;
	private String visitorSex;
	private String visitorNational;/*游客的民族*/
	private Timestamp visitorCreateTime;
	private Timestamp visitorModifiedTime;
	private Integer visitorIsDeleted;
	private String province;
	private String city;
	private String country;
	private String street;
	private String photo;

	public VisitorBaseMessage() {

	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(Integer visitorId) {
		this.visitorId = visitorId;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public Integer getVisitorAge() {
		return visitorAge;
	}

	public void setVisitorAge(Integer visitorAge) {
		this.visitorAge = visitorAge;
	}

	public String getVisitorSex() {
		return visitorSex;
	}

	public void setVisitorSex(String visitorSex) {
		this.visitorSex = visitorSex;
	}

	public String getVisitorNational() {
		return visitorNational;
	}

	public void setVisitorNational(String visitorNational) {
		this.visitorNational = visitorNational;
	}

	public Timestamp getVisitorCreateTime() {
		return visitorCreateTime;
	}

	public void setVisitorCreateTime(Timestamp visitorCreateTime) {
		this.visitorCreateTime = visitorCreateTime;
	}

	public Timestamp getVisitorModifiedTime() {
		return visitorModifiedTime;
	}

	public void setVisitorModifiedTime(Timestamp visitorModifiedTime) {
		this.visitorModifiedTime = visitorModifiedTime;
	}

	public Integer getVisitorIsDeleted() {
		return visitorIsDeleted;
	}

	public void setVisitorIsDeleted(Integer visitorIsDeleted) {
		this.visitorIsDeleted = visitorIsDeleted;
	}

	@Override
	public String toString() {
		return "VisitorBaseMessage{" +
				"id=" + id +
				", visitorId=" + visitorId +
				", visitorName='" + visitorName + '\'' +
				", visitorAge=" + visitorAge +
				", visitorSex='" + visitorSex + '\'' +
				", visitorNational='" + visitorNational + '\'' +
				", visitorCreateTime=" + visitorCreateTime +
				", visitorModifiedTime=" + visitorModifiedTime +
				", visitorIsDeleted=" + visitorIsDeleted +
				", province='" + province + '\'' +
				", city='" + city + '\'' +
				", country='" + country + '\'' +
				", street='" + street + '\'' +
				", photo='" + photo + '\'' +
				'}';
	}
}