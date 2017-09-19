package com.niit.collaborate.CollaborationBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborate.DAO.JobDAO;
import com.niit.collaborate.model.Job;

public class JobDAOTestCase {
	
              static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.collaborate");
		annotationConfigAppContext.refresh();
		
		jobDAO=(JobDAO)annotationConfigAppContext.getBean("jobDAO");
	}
	@Test
	public void createJobTest() {
		Job job=new Job();
		job.setJobId(1001);
		job.setJobProfile("Cognizant");
		job.setJobDescription("Software Engineer");
		job.setQualification("B.Tech");
		job.setStatus("NA");
		job.setPostDate(new java.util.Date());
		assertTrue("Problem in Friend creation",jobDAO.createJob(job));
	}

   @Ignore
	@Test
	public void approveFriendTest() {
	   Job job=new Job();
		job.setJobId(1001);
		job.setJobProfile("Call E");
		job.setJobDescription("B.P.O");
		job.setQualification("BSC");
		job.setStatus("NA");
		job.setPostDate(new java.util.Date());
		assertTrue("Problem in Approving Job",jobDAO.approveJob(job));
	}
   @Test
   public void getAllApprovedJobTest()
   {
	   List<Job> listJob=jobDAO.getJobs();
	   assertTrue("No Approved Jobs",listJob.size()>0);
   }
   @Ignore
   @Test
   public void deleteJobTest()
   {
	   assertTrue("Problem in Deleting",jobDAO.deleteJob(1001));
   }
   @Test
   public void getJobByJobId()
   {
	   assertNotNull("Problem getting job",jobDAO.getJob(1002));
   }
  

}