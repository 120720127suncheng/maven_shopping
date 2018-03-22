package com.iotek.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class VisitorResume implements Serializable {

	private Integer id;
	private Integer visitorId;
	private String visitorJobObjective;//�ο͵�����ְλ
	private String visitorResumeName;//��������
	private String visitorSpeciality;//רҵ
	private String visitorEducationBackground;//��������
	private String vistorEducationDescription;//��������
	private Integer visitorWorkingYears;//��������
	private String visitorWorkingDescription;//��������
	private Integer visitorExpectedSalary;//����н��
	private String visitorResumeAttachment;//��������
	private Integer visitorResumeIsDeleted;
	private Timestamp visitorResumeCreateTime;
	private Timestamp visitorResumeModifiedTime;

	public VisitorResume() {

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

	public String getVisitorJobObjective() {
		return visitorJobObjective;
	}

	public void setVisitorJobObjective(String visitorJobObjective) {
		this.visitorJobObjective = visitorJobObjective;
	}

	public String getVisitorResumeName() {
		return visitorResumeName;
	}

	public void setVisitorResumeName(String visitorResumeName) {
		this.visitorResumeName = visitorResumeName;
	}

	public String getVisitorSpeciality() {
		return visitorSpeciality;
	}

	public void setVisitorSpeciality(String visitorSpeciality) {
		this.visitorSpeciality = visitorSpeciality;
	}

	public String getVisitorEducationBackground() {
		return visitorEducationBackground;
	}

	public void setVisitorEducationBackground(String visitorEducationBackground) {
		this.visitorEducationBackground = visitorEducationBackground;
	}

	public String getVistorEducationDescription() {
		return vistorEducationDescription;
	}

	public void setVistorEducationDescription(String vistorEducationDescription) {
		this.vistorEducationDescription = vistorEducationDescription;
	}

	public Integer getVisitorWorkingYears() {
		return visitorWorkingYears;
	}

	public void setVisitorWorkingYears(Integer visitorWorkingYears) {
		this.visitorWorkingYears = visitorWorkingYears;
	}

	public String getVisitorWorkingDescription() {
		return visitorWorkingDescription;
	}

	public void setVisitorWorkingDescription(String visitorWorkingDescription) {
		this.visitorWorkingDescription = visitorWorkingDescription;
	}

	public Integer getVisitorExpectedSalary() {
		return visitorExpectedSalary;
	}

	public void setVisitorExpectedSalary(Integer visitorExpectedSalary) {
		this.visitorExpectedSalary = visitorExpectedSalary;
	}

	public String getVisitorResumeAttachment() {
		return visitorResumeAttachment;
	}

	public void setVisitorResumeAttachment(String visitorResumeAttachment) {
		this.visitorResumeAttachment = visitorResumeAttachment;
	}

	public Integer getVisitorResumeIsDeleted() {
		return visitorResumeIsDeleted;
	}

	public void setVisitorResumeIsDeleted(Integer visitorResumeIsDeleted) {
		this.visitorResumeIsDeleted = visitorResumeIsDeleted;
	}

	public Timestamp getVisitorResumeCreateTime() {
		return visitorResumeCreateTime;
	}

	public void setVisitorResumeCreateTime(Timestamp visitorResumeCreateTime) {
		this.visitorResumeCreateTime = visitorResumeCreateTime;
	}

	public Timestamp getVisitorResumeModifiedTime() {
		return visitorResumeModifiedTime;
	}

	public void setVisitorResumeModifiedTime(Timestamp visitorResumeModifiedTime) {
		this.visitorResumeModifiedTime = visitorResumeModifiedTime;
	}

	@Override
	public String toString() {
		return "VisitorResumeMapper{" +
				"id=" + id +
				"visitorId=" + visitorId +
				"visitorJobObjective=" + visitorJobObjective +
				"visitorResumeName=" + visitorResumeName +
				"visitorSpeciality=" + visitorSpeciality +
				"visitorEducationBackground=" + visitorEducationBackground +
				"vistorEducationDescription=" + vistorEducationDescription +
				"visitorWorkingYears=" + visitorWorkingYears +
				"visitorWorkingDescription=" + visitorWorkingDescription +
				"visitorExpectedSalary=" + visitorExpectedSalary +
				"visitorResumeAttachment=" + visitorResumeAttachment +
				"visitorResumeIsDeleted=" + visitorResumeIsDeleted +
				"visitorResumeCreateTime=" + visitorResumeCreateTime +
				"visitorResumeModifiedTime=" + visitorResumeModifiedTime +
				"}";
	}
}