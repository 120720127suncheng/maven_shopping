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
	private String visitorAddress;

	public VisitorBaseMessage() {

	}

	public String getVisitorAddress() {
		return visitorAddress;
	}

	public void setVisitorAddress(String visitorAddress) {
		this.visitorAddress = visitorAddress;
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
				", visitorAddress='" + visitorAddress + '\'' +
				'}';
	}
}