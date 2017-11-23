package com.niit.collaborate.DAO;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborate.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

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
	
    public User getUser(String userId) 
	{
	  Session session=sessionFactory.openSession();
	  User user=(User)session.get(User.class,userId);
	  session.close();
		return user;
	}
	
    
	
  
 
   

public boolean ValidEmailId(String emailId) {
	Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from User where emailId=?");
	query.setString(0, emailId);
	User user=(User)query.uniqueResult();
	if(user==null)
		return true;
	else
	return false;
}
public boolean isUserIdValid(String userId) {
	Session session=sessionFactory.getCurrentSession();
	User user =(User)session.get(User.class, userId);
	if(user==null)
		return true;
	else
	return false;
}

public User Login(User user) {
	Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from User where userId=? and password=?");
	query.setString(0,user.getUserId());
	query.setString(1,user.getPassword());
	user=(User)query.uniqueResult();
	return user;
}

public void update(User user) {
Session session=sessionFactory.getCurrentSession();
session.update(user);
	
}

public boolean isUpdatedEmailIdValid(String emailId, String userId) {
	Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from User where emailId=? and userid!=?");
	query.setString(0,emailId);
	query.setString(1,userId);
	User user=(User)query.uniqueResult();
	if(user==null)
		return true;
	else
	return false;
}


}