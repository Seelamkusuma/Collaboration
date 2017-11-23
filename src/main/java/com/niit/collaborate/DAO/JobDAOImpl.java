package com.niit.collaborate.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborate.model.Job;

@Repository("jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO {
	@Autowired
	SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	public void createJob(Job job) {
		Session session=sessionFactory.getCurrentSession();
		session.save(job);
		
	}

	public Job getJob(int jobId) {
		Session session=sessionFactory.getCurrentSession();
		Job job = (Job) session.get(Job.class, jobId);
		
		return job;
	}

	public List<Job> getJobs() {
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Job");
		
		return query.list();
	}
}
