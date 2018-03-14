package com.iotek.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Department implements Serializable {

	private Integer id;
	private String departmentName;
	private String departmentLocation;//部门地址
	private Integer departmentIsDeleted;
	private Timestamp departmentCreateTime;
	private Timestamp departmentModifiedTime;
	private BigDecimal departmentBudget;//部门一年的预算
	private BigDecimal departmentActualExpense;//部门今年实际的消费

	public Department() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}

	public Integer getDepartmentIsDeleted() {
		return departmentIsDeleted;
	}

	public void setDepartmentIsDeleted(Integer departmentIsDeleted) {
		this.departmentIsDeleted = departmentIsDeleted;
	}

	public Timestamp getDepartmentCreateTime() {
		return departmentCreateTime;
	}

	public void setDepartmentCreateTime(Timestamp departmentCreateTime) {
		this.departmentCreateTime = departmentCreateTime;
	}

	public Timestamp getDepartmentModifiedTime() {
		return departmentModifiedTime;
	}

	public void setDepartmentModifiedTime(Timestamp departmentModifiedTime) {
		this.departmentModifiedTime = departmentModifiedTime;
	}

	public BigDecimal getDepartmentBudget() {
		return departmentBudget;
	}

	public void setDepartmentBudget(BigDecimal departmentBudget) {
		this.departmentBudget = departmentBudget;
	}

	public BigDecimal getDepartmentActualExpense() {
		return departmentActualExpense;
	}

	public void setDepartmentActualExpense(BigDecimal departmentActualExpense) {
		this.departmentActualExpense = departmentActualExpense;
	}

	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				"departmentName=" + departmentName +
				"departmentLocation=" + departmentLocation +
				"departmentIsDeleted=" + departmentIsDeleted +
				"departmentCreateTime=" + departmentCreateTime +
				"departmentModifiedTime=" + departmentModifiedTime +
				"departmentBudget=" + departmentBudget +
				"departmentActualExpense=" + departmentActualExpense +
				"}";
	}
}