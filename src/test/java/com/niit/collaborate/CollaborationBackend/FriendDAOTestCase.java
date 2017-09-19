package com.niit.collaborate.CollaborationBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborate.DAO.FriendDAO;
import com.niit.collaborate.model.Friend;

public class FriendDAOTestCase {
	
              static FriendDAO friendDAO;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.collaborate");
		annotationConfigAppContext.refresh();
		
		friendDAO=(FriendDAO)annotationConfigAppContext.getBean("friendDAO");
	}
	@Test
	public void createFriendTest() {
		Friend friend=new Friend();
		friend.setFriendId(1001);
		friend.setUserId(1002);
		friend.setStatus("NA");
		assertTrue("Problem in Friend creation",friendDAO.createFriend(friend));
	}

   @Ignore
	@Test
	public void approveFriendTest() {
		Friend friend=new Friend();
		friend.setFriendId(1002);
		friend.setUserId(40);
		friend.setStatus("NA");
		assertTrue("Problem in Approving Friend",friendDAO.approveFriend(friend));
	}
   @Test
   public void getAllApprovedFriendTest()
   {
	   List<Friend> listFriend=friendDAO.getFriends();
	   assertTrue("No Approved Friends",listFriend.size()>0);
   }
   @Ignore
   @Test
   public void deleteFriendTest()
   {
	   assertTrue("Problem in Deleting",friendDAO.deleteFriend(1001));
   }
   @Test
   public void getFriendByFriendId()
   {
	   assertNotNull("Problem getting friend",friendDAO.getFriend(1002));
   }
  

}