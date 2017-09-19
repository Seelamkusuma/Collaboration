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
	@Test
	public void createUserTest() {
		User user=new User();
		user.setUserId(1001);
		user.setEmailId("kusuma@gmail.com");
		user.setFirstName("kusuma");
		user.setLastName("seelam");
		user.setPassword("5678");
		user.setRole("User");
		user.setIsOnline("Online");
		user.setStatus("NA");
		assertTrue("Problem in User creation",userDAO.createUser(user));
	}

   @Ignore
	@Test
	public void approveFriendTest() {
	   User user=new User();
		user.setUserId(1001);
		user.setEmailId("vikky@gmail.com");
		user.setFirstName("vikram");
		user.setLastName("Badam");
		user.setPassword("1434");
		user.setRole("Admin");
		user.setIsOnline("Online");
		user.setStatus("NA");
		assertTrue("Problem in Approving User",userDAO.approveUser(user));
	}
   @Ignore
   @Test
   public void getAllApprovedUserTest()
   {
	   List<User> listUser=userDAO.getUsers();
	   assertTrue("No Approved Users",listUser.size()>0);
   }
   @Ignore
   @Test
   public void deleteUserTest()
   {
	   assertTrue("Problem in Deleting",userDAO.deleteUser(1001));
   }
   @Ignore
   @Test
   public void getUserByUserId()
   {
	   assertNotNull("Problem getting user",userDAO.getUser(1002));
   }
  

}