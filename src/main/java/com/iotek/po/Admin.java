package com.iotek.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class Admin implements Serializable {

	private Integer id;
	private String adminName;
	private transient String adminPassword;
	private Integer adminIsDeleted;
	private Timestamp adminLoginTime;
	private Timestamp adminCreateTime;
	private Timestamp adminModifiedTime;
	private Integer adminIsLogin;
	public Admin() {

	}

	public Integer getAdminIsLogin() {
		return adminIsLogin;
	}

	public void setAdminIsLogin(Integer adminIsLogin) {
		this.adminIsLogin = adminIsLogin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Integer getAdminIsDeleted() {
		return adminIsDeleted;
	}

	public void setAdminIsDeleted(Integer adminIsDeleted) {
		this.adminIsDeleted = adminIsDeleted;
	}

	public Timestamp getAdminLoginTime() {
		return adminLoginTime;
	}

	public void setAdminLoginTime(Timestamp adminLoginTime) {
		this.adminLoginTime = adminLoginTime;
	}

	public Timestamp getAdminCreateTime() {
		return adminCreateTime;
	}

	public void setAdminCreateTime(Timestamp adminCreateTime) {
		this.adminCreateTime = adminCreateTime;
	}

	public Timestamp getAdminModifiedTime() {
		return adminModifiedTime;
	}

	public void setAdminModifiedTime(Timestamp adminModifiedTime) {
		this.adminModifiedTime = adminModifiedTime;
	}

	@Override
	public String toString() {
		return "Admin{" +
				"id=" + id +
				", adminName='" + adminName + '\'' +
				", adminPassword='" + adminPassword + '\'' +
				", adminIsDeleted=" + adminIsDeleted +
				", adminLoginTime=" + adminLoginTime +
				", adminCreateTime=" + adminCreateTime +
				", adminModifiedTime=" + adminModifiedTime +
				", adminIsLogin=" + adminIsLogin +
				'}';
	}
}