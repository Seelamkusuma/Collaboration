package com.niit.collaborate.CollaborationBackend;


import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborate.DAO.FriendDAO;

public class FriendDAOTestCase {
	
              static FriendDAO friendDAO;
	
	@BeforeClass
	public static void initialize()
	{

		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.collaborate");
		annotationConfigAppContext.refresh();
		
		friendDAO=(FriendDAO)annotationConfigAppContext.getBean("friendDAO");
	}
	
  

}