package com.iotek.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class VisitorNews implements Serializable {

	private Integer id;
	private String newsSubject;
	private String newsContent;
	private Integer newsIsRead;
	private Integer newsIsDeleted;
	private Integer newsIsImportant;
	private Integer newsCreater;
	private Integer newsAccepter;
	private Timestamp newsCreateTime;

	public VisitorNews() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getNewsIsRead() {
		return newsIsRead;
	}

	public void setNewsIsRead(Integer newsIsRead) {
		this.newsIsRead = newsIsRead;
	}

	public Integer getNewsIsDeleted() {
		return newsIsDeleted;
	}

	public void setNewsIsDeleted(Integer newsIsDeleted) {
		this.newsIsDeleted = newsIsDeleted;
	}

	public Integer getNewsIsImportant() {
		return newsIsImportant;
	}

	public void setNewsIsImportant(Integer newsIsImportant) {
		this.newsIsImportant = newsIsImportant;
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

	@Override
	public String toString() {
		return "VisitorNews{" +
				"id=" + id +
				"newsSubject=" + newsSubject +
				"newsContent=" + newsContent +
				"newsIsRead=" + newsIsRead +
				"newsIsDeleted=" + newsIsDeleted +
				"newsIsImportant=" + newsIsImportant +
				"newsCreater=" + newsCreater +
				"newsAccepter=" + newsAccepter +
				"newsCreateTime=" + newsCreateTime +
				"}";
	}
}