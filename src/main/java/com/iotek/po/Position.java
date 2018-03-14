package com.iotek.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class Position implements Serializable {

	private Integer id;
	private Integer departmentId;
	private String positionName;
	private Integer positionIsDeleted;
	private Timestamp positionCreateTime;
	private Timestamp positionModifiedTime;

	public Position() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Integer getPositionIsDeleted() {
		return positionIsDeleted;
	}

	public void setPositionIsDeleted(Integer positionIsDeleted) {
		this.positionIsDeleted = positionIsDeleted;
	}

	public Timestamp getPositionCreateTime() {
		return positionCreateTime;
	}

	public void setPositionCreateTime(Timestamp positionCreateTime) {
		this.positionCreateTime = positionCreateTime;
	}

	public Timestamp getPositionModifiedTime() {
		return positionModifiedTime;
	}

	public void setPositionModifiedTime(Timestamp positionModifiedTime) {
		this.positionModifiedTime = positionModifiedTime;
	}

	@Override
	public String toString() {
		return "Position{" +
				"id=" + id +
				"departmentId=" + departmentId +
				"positionName=" + positionName +
				"positionIsDeleted=" + positionIsDeleted +
				"positionCreateTime=" + positionCreateTime +
				"positionModifiedTime=" + positionModifiedTime +
				"}";
	}
}