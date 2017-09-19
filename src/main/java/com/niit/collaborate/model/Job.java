package com.niit.collaborate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Job {
	@Id
	private int jobId;
	private String jobProfile,jobDescription,Qualification,status;
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	private Date postDate;
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobProfile() {
		return jobProfile;
	}
	public void setJobProfile(String jobProfile) {
		this.jobProfile = jobProfile;
	}
	
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		Qualification = qualification;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	

}
