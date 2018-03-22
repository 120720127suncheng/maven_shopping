package com.iotek.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class StaffNews implements Serializable {

	private Integer id;
	private Integer newsCreater;
	private Integer newsAccepter;
	private Timestamp newsCreateTime;
	private Integer newsIsRead;
	private Integer newsIsImportant;
	private Integer newsIsDeleted;
	private String newsSubject;
	private String newsContent;

	public StaffNews() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNewsCreater() {
		return newsCreater;
	}

	public void setNewsCreater(Integer newsCreater) {
		this.newsCreater = newsCreater;
	}

	public Integer getNewsAccepter() {
		return newsAccepter;
	}

	public void setNewsAccepter(Integer newsAccepter) {
		this.newsAccepter = newsAccepter;
	}

	public Timestamp getNewsCreateTime() {
		return newsCreateTime;
	}

	public void setNewsCreateTime(Timestamp newsCreateTime) {
		this.newsCreateTime = newsCreateTime;
	}

	public Integer getNewsIsRead() {
		return newsIsRead;
	}

	public void setNewsIsRead(Integer newsIsRead) {
		this.newsIsRead = newsIsRead;
	}

	public Integer getNewsIsImportant() {
		return newsIsImportant;
	}

	public void setNewsIsImportant(Integer newsIsImportant) {
		this.newsIsImportant = newsIsImportant;
	}

	public Integer getNewsIsDeleted() {
		return newsIsDeleted;
	}

	public void setNewsIsDeleted(Integer newsIsDeleted) {
		this.newsIsDeleted = newsIsDeleted;
	}

	public String getNewsSubject() {
		return newsSubject;
	}

	public void setNewsSubject(String newsSubject) {
		this.newsSubject = newsSubject;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	@Override
	public String toString() {
		return "StaffNews{" +
				"id=" + id +
				"newsCreater=" + newsCreater +
				"newsAccepter=" + newsAccepter +
				"newsCreateTime=" + newsCreateTime +
				"newsIsRead=" + newsIsRead +
				"newsIsImportant=" + newsIsImportant +
				"newsIsDeleted=" + newsIsDeleted +
				"newsSubject=" + newsSubject +
				"newsContent=" + newsContent +
				"}";
	}
}