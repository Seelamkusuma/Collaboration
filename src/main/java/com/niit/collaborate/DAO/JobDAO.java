package com.niit.collaborate.DAO;

import java.util.List;

import com.niit.collaborate.model.Job;

public interface JobDAO {
	public boolean createJob(Job job);
	public Job getJob(int jobId);
	public List<Job> getJobs();
	public boolean approveJob(Job job);
	public boolean updateJob(int jobId);
	public boolean deleteJob(int jobId);
}