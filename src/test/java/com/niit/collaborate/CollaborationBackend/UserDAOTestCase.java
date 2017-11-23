package com.niit.collaborate.CollaborationBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborate.DAO.UserDAO;
import com.niit.collaborate.model.User;

public class UserDAOTestCase {
	
              static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.collaborate");
		annotationConfigAppContext.refresh();
		
		userDAO=(UserDAO)annotationConfigAppContext.getBean("userDAO");
	}
	@Ignore
	@Test
	public void createUserTest() {
		User user=new User();
		user.setUserId("kusuma");
		user.setEmailId("kusuma@gmail.com");
		user.setFirstName("kusuma");
		user.setLastName("seelam");
		user.setPassword("5678");
		user.setRole("Admin");
		user.setOnline(true);
		
		assertTrue("Problem in User creation",userDAO.createUser(user));
	}

	
   
  

}