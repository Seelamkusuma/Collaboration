package com.niit.collaborate.DAO;

import java.util.List;



import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborate.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
@Transactional
	public boolean createUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			System.out.println("Insertion Successful");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
		}
		return false;
	}
	
    public User getUser(int userId) 
	{
	  Session session=sessionFactory.openSession();
	  User user=(User)session.get(User.class,userId);
	  session.close();
		return user;
	}
	
    public List<User> getUsers() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User where status='A'");
		List<User> listUser=query.list();
		session.close();
		return listUser;
		}
@Transactional

    public boolean approveUser(User user) {
		try
		{
			user.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception Arised:"+e);
		}
		return false;
	}
   
	public boolean updateUser(int userId) {
		Session session=sessionFactory.openSession();
		   
		 Transaction tx=session.getTransaction();
				tx.begin();
			User user=(User)session.get(User.class,userId);
				
				user.setStatus(user.getStatus());
						
				user.setPassword(user.getPassword());
				//session.update(User);
				
				tx.commit();
				session.close();
		return false;
	}
   @Transactional
 
    public boolean deleteUser(int userId) 
   {
	   try
	   {
		   Session session=sessionFactory.openSession();
		   User user=(User)session.get(User.class,userId);
		   session.delete(user);
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