package com.niit.collaborate.DAO;

import java.util.List;



import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborate.model.Job;

@Repository("jobDAO")
public class JobDAOImpl implements JobDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public JobDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
@Transactional
	public boolean createJob(Job job) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			System.out.println("Insertion Successful");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		return false;
	}
	
    public Job getJob(int jobId) 
	{
	  Session session=sessionFactory.openSession();
	  Job job=(Job)session.get(Job.class,jobId);
	  session.close();
		return job;
	}
	
    public List<Job> getJobs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job where status='A'");
		List<Job> listJob=query.list();
		session.close();
		return listJob;
		}
@Transactional

    public boolean approveJob(Job job) {
		try
		{
			job.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception Arised:"+e);
		}
		return false;
	}
   
	public boolean updateJob(int jobId) {
		Session session=sessionFactory.openSession();
		   
		 Transaction tx=session.getTransaction();
				tx.begin();
			Job job=(Job)session.get(Job.class,jobId);
				
				job.setJobProfile(job.getJobProfile());
						
				job.setJobDescription(job.getJobDescription());
				//session.update(Job);
				
				tx.commit();
				session.close();
		return false;
	}
   @Transactional
 
    public boolean deleteJob(int jobId) 
   {
	   try
	   {
		   Session session=sessionFactory.openSession();
		   Job job=(Job)session.get(Job.class,jobId);
		   session.delete(job);
		   session.flush();
		   return true ;
	   }
	   
	   catch(Exception e)
	   {
		System.out.println("Exception Arised:"+e);
		return false ;
		
	}

}
}