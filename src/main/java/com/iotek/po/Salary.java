package com.iotek.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Salary implements Serializable {

	private Integer id;
	private Integer staffId;
	private BigDecimal baseSalary;//��������
	private BigDecimal performanceBonus;//��Ч����
	private BigDecimal attendanceBonus;//�Ӱ๤��
	private BigDecimal punishAndAward;//�����ܶ�
	private BigDecimal socialInsurance;//�籣
	private Timestamp salaryCreateTime;
	private Timestamp salaryProvideTime;
	private Timestamp salaryModifiedTime;
	private Integer salaryIsDeleted;

	public Salary() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public BigDecimal getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(BigDecimal baseSalary) {
		this.baseSalary = baseSalary;
	}

	public BigDecimal getPerformanceBonus() {
		return performanceBonus;
	}

	public void setPerformanceBonus(BigDecimal performanceBonus) {
		this.performanceBonus = performanceBonus;
	}

	public BigDecimal getAttendanceBonus() {
		return attendanceBonus;
	}

	public void setAttendanceBonus(BigDecimal attendanceBonus) {
		this.attendanceBonus = attendanceBonus;
	}

	public BigDecimal getPunishAndAward() {
		return punishAndAward;
	}

	public void setPunishAndAward(BigDecimal punishAndAward) {
		this.punishAndAward = punishAndAward;
	}

	public BigDecimal getSocialInsurance() {
		return socialInsurance;
	}

	public void setSocialInsurance(BigDecimal socialInsurance) {
		this.socialInsurance = socialInsurance;
	}

	public Timestamp getSalaryCreateTime() {
		return salaryCreateTime;
	}

	public void setSalaryCreateTime(Timestamp salaryCreateTime) {
		this.salaryCreateTime = salaryCreateTime;
	}

	public Timestamp getSalaryProvideTime() {
		return salaryProvideTime;
	}

	public void setSalaryProvideTime(Timestamp salaryProvideTime) {
		this.salaryProvideTime = salaryProvideTime;
	}

	public Timestamp getSalaryModifiedTime() {
		return salaryModifiedTime;
	}

	public void setSalaryModifiedTime(Timestamp salaryModifiedTime) {
		this.salaryModifiedTime = salaryModifiedTime;
	}

	public Integer getSalaryIsDeleted() {
		return salaryIsDeleted;
	}

	public void setSalaryIsDeleted(Integer salaryIsDeleted) {
		this.salaryIsDeleted = salaryIsDeleted;
	}

	@Override
	public String toString() {
		return "Salary{" +
				"id=" + id +
				"staffId=" + staffId +
				"baseSalary=" + baseSalary +
				"performanceBonus=" + performanceBonus +
				"attendanceBonus=" + attendanceBonus +
				"punishAndAward=" + punishAndAward +
				"socialInsurance=" + socialInsurance +
				"salaryCreateTime=" + salaryCreateTime +
				"salaryProvideTime=" + salaryProvideTime +
				"salaryModifiedTime=" + salaryModifiedTime +
				"salaryIsDeleted=" + salaryIsDeleted +
				"}";
	}
}