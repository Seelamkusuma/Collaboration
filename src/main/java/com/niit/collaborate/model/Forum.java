package com.niit.collaborate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Forum {

	
	@Id
	private int forumId;
	private int userId;
	private String forumName,forumContent,Status;
	private Date CreateDate;
    public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getForumName() {
		return forumName;
	}
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}
	public String getForumContent() {
		return forumContent;
	}
	public void setForumContent(String forumContent) {
		this.forumContent = forumContent;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
	
}
