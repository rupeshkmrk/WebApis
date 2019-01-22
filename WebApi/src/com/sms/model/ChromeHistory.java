package com.sms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=("web_records"))
public class ChromeHistory {

	@Id
	private String id;
	private String url;
	private String title;
	private String visitedTime;
	private String user;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVisitedTime() {
		return visitedTime;
	}
	public void setVisitedTime(String visitedTime) {
		this.visitedTime = visitedTime;
	}
	public String getUser() {
		// TODO Auto-generated method stub
		return user;
	} 
	
	
}
