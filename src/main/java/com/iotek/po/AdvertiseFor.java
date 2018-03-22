package com.iotek.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class AdvertiseFor implements Serializable {

	private Integer id;
	private Integer positionId;
	private String location;
	private String salary;
	private String positionDescribe;
	private String positionAbility;
	private Integer staffId;
	private Timestamp advertiseModifiedTime;
	private Timestamp advertiseCreateTime;
	private Integer advertiseIsDeleted;
	private Integer advertiseForPerson;

	public AdvertiseFor() {

	}

	public Integer getAdvertiseForPerson() {
		return advertiseForPerson;
	}

	public void setAdvertiseForPerson(Integer advertiseForPerson) {
		this.advertiseForPerson = advertiseForPerson;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Timestamp getAdvertiseModifiedTime() {
		return advertiseModifiedTime;
	}

	public void setAdvertiseModifiedTime(Timestamp advertiseModifiedTime) {
		this.advertiseModifiedTime = advertiseModifiedTime;
	}

	public Timestamp getAdvertiseCreateTime() {
		return advertiseCreateTime;
	}

	public void setAdvertiseCreateTime(Timestamp advertiseCreateTime) {
		this.advertiseCreateTime = advertiseCreateTime;
	}

	public Integer getAdvertiseIsDeleted() {
		return advertiseIsDeleted;
	}

	public void setAdvertiseIsDeleted(Integer advertiseIsDeleted) {
		this.advertiseIsDeleted = advertiseIsDeleted;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getPositionDescribe() {
		return positionDescribe;
	}

	public void setPositionDescribe(String positionDescribe) {
		this.positionDescribe = positionDescribe;
	}

	public String getPositionAbility() {
		return positionAbility;
	}

	public void setPositionAbility(String positionAbility) {
		this.positionAbility = positionAbility;
	}

	@Override
	public String toString() {
		return "AdvertiseFor{" +
				"id=" + id +
				", positionId=" + positionId +
				", location='" + location + '\'' +
				", salary='" + salary + '\'' +
				", positionDescribe='" + positionDescribe + '\'' +
				", positionAbility='" + positionAbility + '\'' +
				", staffId=" + staffId +
				", advertiseModifiedTime=" + advertiseModifiedTime +
				", advertiseCreateTime=" + advertiseCreateTime +
				", advertiseIsDeleted=" + advertiseIsDeleted +
				", advertiseForPerson=" + advertiseForPerson +
				'}';
	}
}