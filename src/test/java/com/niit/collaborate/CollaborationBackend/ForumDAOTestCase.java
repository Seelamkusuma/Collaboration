package com.niit.collaborate.CollaborationBackend;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborate.DAO.ForumDAO;
import com.niit.collaborate.model.Forum;

public class ForumDAOTestCase {
	
              static ForumDAO forumDAO;
	
	@BeforeClass
	public static void initialize()
	{
		
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.collaborate");
		annotationConfigAppContext.refresh();
		
		forumDAO=(ForumDAO)annotationConfigAppContext.getBean("forumDAO");
	}
	@Ignore
	@Test
	public void createForumTest() {
		Forum forum=new Forum();
		forum.setForumId(1002);
		forum.setForumName("StackOverflow");
		forum.setForumContent("StackOverflow is a forum");
		forum.setUserId(123);
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("NA");
		assertTrue("Problem in Blog creation",forumDAO.createForum(forum));
	}

}