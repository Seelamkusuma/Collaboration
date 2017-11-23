package com.niit.collaborate.CollaborationBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborate.DAO.BlogDAO;
import com.niit.collaborate.model.Blog;

public class BlogDAOTestCase {
	
              static BlogDAO blogDAO;
	
	@BeforeClass
	public static void initialize()
	{
	
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.collaborate");
		annotationConfigAppContext.refresh();
		
		blogDAO=(BlogDAO)annotationConfigAppContext.getBean("blogDAO");
	}
	@Ignore
	@Test
	public void createBlogTest() {
		Blog blog=new Blog();
		//blog.setBlogId(1001);
		//blog.setBlogName("Selenium");
		blog.setBlogContent("Selenium is a Testing tool");
		//blog.setUserId("kusuma@gmail.com");
		//blog.setCreateDate(new java.util.Date());
		//blog.setStatus("NA");
		//blog.setLikes(0);
		
	}

	}