package com.niit.collaborate.CollaborationBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import com.niit.collaborate.DAO.JobDAO;
import com.niit.collaborate.model.Job;

public class JobDAOTestCase {
	
             // static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.collaborate");
		annotationConfigAppContext.refresh();
		
		//jobDAO=(JobDAO)annotationConfigAppContext.getBean("jobDAO");
	}
	

	

}