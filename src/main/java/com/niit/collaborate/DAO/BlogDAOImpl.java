package com.niit.collaborate.DAO;

import java.util.List;



import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborate.model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public BlogDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional

	public boolean createBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			System.out.println("Insertion Successful");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		return false;
	}
	
    public Blog getBlog(int blogId) 
	{
	  Session session=sessionFactory.openSession();
	  Blog blog=(Blog)session.get(Blog.class,blogId);
	  session.close();
		return blog;
	}
	
    public List<Blog> getBlogs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog where status='A'");
		List<Blog> listBlog=query.list();
		session.close();
		return listBlog;
		}
@Transactional

    public boolean approveBlog(Blog blog) {
		try
		{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception Arised:"+e);
		}
		return false;
	}
   
	public boolean updateBlog(int blogId) {
		Session session=sessionFactory.openSession();
		   
		 Transaction tx=session.getTransaction();
				tx.begin();
			Blog blog=(Blog)session.get(Blog.class,blogId);
				
				blog.setBlogName(blog.getBlogName());
						
				blog.setBlogContent(blog.getBlogContent());
				session.update(blog);
				
				tx.commit();
				session.close();
		return false;
	}
   @Transactional
 
    public boolean deleteBlog(int blogId) 
   {
	   try
	   {
		   Session session=sessionFactory.openSession();
		   Blog blog=(Blog)session.get(Blog.class,blogId);
		   session.delete(blog);
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