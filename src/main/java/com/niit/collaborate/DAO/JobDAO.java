package com.niit.collaborate.DAO;

import java.util.List;

import com.niit.collaborate.model.Job;

public interface JobDAO {
public void createJob(Job job);
public Job getJob(int jobId);
public List<Job> getJobs();
}