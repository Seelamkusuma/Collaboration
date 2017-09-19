package com.niit.collaborate.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborate.model.Forum;

@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public ForumDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
@Transactional
	public boolean createForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			System.out.println("Insertion Successful");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		return false;
	}
	
    public Forum getForum(int forumId) 
	{
	  Session session=sessionFactory.openSession();
	  Forum forum=(Forum)session.get(Forum.class,forumId);
	  session.close();
		return forum;
	}
	
    public List<Forum> getForums() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog where status='A'");
		List<Forum> listForum=query.list();
		session.close();
		return listForum;
		}
@Transactional

    public boolean approveForum(Forum forum) {
		try
		{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception Arised:"+e);
		}
		return false;
	}
   
	public boolean updateForum(int forumId) {
		Session session=sessionFactory.openSession();
		   
		 Transaction tx=session.getTransaction();
				tx.begin();
				Forum forum=(Forum)session.get(Forum.class,forumId);
				
				forum.setForumName(forum.getForumName());
						
				forum.setForumContent(forum.getForumContent());
				session.update(forum);
				
				tx.commit();
				session.close();
		return false;
	}
   @Transactional
 
    public boolean deleteForum(int forumId) 
   {
	   try
	   {
		   Session session=sessionFactory.openSession();
		   Forum forum=(Forum)session.get(Forum.class,forumId);
		   session.delete(forum);
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