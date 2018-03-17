package com.iotek.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class Visitor implements Serializable {

	private Integer id;
	private transient String visitorPassword;
	private String visitorPhone;
	private String visitorEmail;
	private Timestamp visitorLoginTime;
	private Timestamp visitorCreateTime;
	private Timestamp visitorModifiedTime;
	private Integer visitorIsOn;//游客是否已登录
	private Integer visitorIsNormal;
	private VisitorBaseMessage visitorBaseMessage;

	public Visitor() {

	}

	public VisitorBaseMessage getVisitorBaseMessage() {
		return visitorBaseMessage;
	}

	public void setVisitorBaseMessage(VisitorBaseMessage visitorBaseMessage) {
		this.visitorBaseMessage = visitorBaseMessage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVisitorPassword() {
		return visitorPassword;
	}

	public void setVisitorPassword(String visitorPassword) {
		this.visitorPassword = visitorPassword;
	}

	public String getVisitorPhone() {
		return visitorPhone;
	}

	public void setVisitorPhone(String visitorPhone) {
		this.visitorPhone = visitorPhone;
	}

	public String getVisitorEmail() {
		return visitorEmail;
	}

	public void setVisitorEmail(String visitorEmail) {
		this.visitorEmail = visitorEmail;
	}

	public Timestamp getVisitorLoginTime() {
		return visitorLoginTime;
	}

	public void setVisitorLoginTime(Timestamp visitorLoginTime) {
		this.visitorLoginTime = visitorLoginTime;
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

	public Integer getVisitorIsOn() {
		return visitorIsOn;
	}

	public void setVisitorIsOn(Integer visitorIsOn) {
		this.visitorIsOn = visitorIsOn;
	}

	public Integer getVisitorIsNormal() {
		return visitorIsNormal;
	}

	public void setVisitorIsNormal(Integer visitorIsNormal) {
		this.visitorIsNormal = visitorIsNormal;
	}

	@Override
	public String toString() {
		return "Visitor{" +
				"id=" + id +
				"visitorPassword=" + visitorPassword +
				"visitorPhone=" + visitorPhone +
				"visitorEmail=" + visitorEmail +
				"visitorLoginTime=" + visitorLoginTime +
				"visitorCreateTime=" + visitorCreateTime +
				"visitorModifiedTime=" + visitorModifiedTime +
				"visitorIsOn=" + visitorIsOn +
				"visitorIsNormal=" + visitorIsNormal +
				"}";
	}
}