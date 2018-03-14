package com.iotek.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Staff implements Serializable {

	private Integer id;
	private Integer positionId;
	private transient String staffPassword;
	private String staffName;
	private String staffSex;
	private String staffPhone;
	private String staffEmail;
	private Timestamp staffHiredate;//员工入职时间
	private Timestamp staffDimissionTime;//离职时间
	private Integer staffIsLeft;//是否离职
	private BigDecimal staffBaseSalary;//基本工资
	private Integer staffType;//员工类型/*员工类型 0-普通 1-经理 2-总经理 3-董事长*/
	private Timestamp staffModifiedTime;
	private Timestamp staffLoginTime;
	private Integer staffIsLogin;//员工账号是否登录

	public Staff() {

	}

	public String getStaffPassword() {
		return staffPassword;
	}

	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffSex() {
		return staffSex;
	}

	public void setStaffSex(String staffSex) {
		this.staffSex = staffSex;
	}

	public String getStaffPhone() {
		return staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}

	public String getStaffEmail() {
		return staffEmail;
	}

	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}

	public Timestamp getStaffHiredate() {
		return staffHiredate;
	}

	public void setStaffHiredate(Timestamp staffHiredate) {
		this.staffHiredate = staffHiredate;
	}

	public Timestamp getStaffDimissionTime() {
		return staffDimissionTime;
	}

	public void setStaffDimissionTime(Timestamp staffDimissionTime) {
		this.staffDimissionTime = staffDimissionTime;
	}

	public Integer getStaffIsLeft() {
		return staffIsLeft;
	}

	public void setStaffIsLeft(Integer staffIsLeft) {
		this.staffIsLeft = staffIsLeft;
	}

	public BigDecimal getStaffBaseSalary() {
		return staffBaseSalary;
	}

	public void setStaffBaseSalary(BigDecimal staffBaseSalary) {
		this.staffBaseSalary = staffBaseSalary;
	}

	public Integer getStaffType() {
		return staffType;
	}

	public void setStaffType(Integer staffType) {
		this.staffType = staffType;
	}

	public Timestamp getStaffModifiedTime() {
		return staffModifiedTime;
	}

	public void setStaffModifiedTime(Timestamp staffModifiedTime) {
		this.staffModifiedTime = staffModifiedTime;
	}

	public Timestamp getStaffLoginTime() {
		return staffLoginTime;
	}

	public void setStaffLoginTime(Timestamp staffLoginTime) {
		this.staffLoginTime = staffLoginTime;
	}

	public Integer getStaffIsLogin() {
		return staffIsLogin;
	}

	public void setStaffIsLogin(Integer staffIsLogin) {
		this.staffIsLogin = staffIsLogin;
	}

	@Override
	public String toString() {
		return "Staff{" +
				"id=" + id +
				", positionId=" + positionId +
				", staffPassword='" + staffPassword + '\'' +
				", staffName='" + staffName + '\'' +
				", staffSex='" + staffSex + '\'' +
				", staffPhone='" + staffPhone + '\'' +
				", staffEmail='" + staffEmail + '\'' +
				", staffHiredate=" + staffHiredate +
				", staffDimissionTime=" + staffDimissionTime +
				", staffIsLeft=" + staffIsLeft +
				", staffBaseSalary=" + staffBaseSalary +
				", staffType=" + staffType +
				", staffModifiedTime=" + staffModifiedTime +
				", staffLoginTime=" + staffLoginTime +
				", staffIsLogin=" + staffIsLogin +
				'}';
	}
}