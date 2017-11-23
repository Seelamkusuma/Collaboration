package com.niit.collaborate.DAO;

import java.util.List;



import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborate.model.Friend;
import com.niit.collaborate.model.User;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO
{
	@Autowired
	SessionFactory sessionFactory;
	 public FriendDAOImpl(SessionFactory sessionFactory){
		 this.sessionFactory=sessionFactory;
	 }
       
	 public List<User> listOfSuggestedUsers(String userId) {
		Session session=sessionFactory.getCurrentSession();
	SQLQuery query=	session.createSQLQuery("select * from user_table where userId in" 
				+"(select userId from user_table where userId!=? minus"
				+"(select fromId from friend where toId=?"
				+"union select toId from friend where fromId=?)"
				+")");
		query.setString(0, userId);
		query.setString(1, userId);
		query.setString(2, userId);
		query.addEntity(User.class);
		List<User> suggestedUsers=query.list();	
				return suggestedUsers;
		
		
       }
       public void friendRequest(Friend friend){
    	   Session session=sessionFactory.getCurrentSession();
    	   session.save(friend);
       }
       public List<Friend> pendingRequests(String toId){
    	   Session session=sessionFactory.getCurrentSession();
    	   Query query=session.createQuery("from Friend where toId=? and status='P'");
    	   query.setString(0, toId);
    	   return query.list();
       }
       public void updatePendingRequest(Friend friend){
    	   Session session=sessionFactory.getCurrentSession();
    	   if(friend.getStatus()=='A')
    		   session.update(friend);
    	   else
    		   session.delete(friend);
       }

	public List<String> listOfFriends(String userId) {
		Session session=sessionFactory.getCurrentSession();
		SQLQuery sqlQuery1=session.createSQLQuery("select fromId from Friend where toId=? and status='A'")
				.addScalar("fromId",StandardBasicTypes.STRING);
		sqlQuery1.setString(0,userId);
		List<String> list1=sqlQuery1.list();
		System.out.println("RESULT OF 1st QUERY" +list1);
		SQLQuery sqlQuery2=session.createSQLQuery("select toId from Friend where fromId=? and status='A'")
				.addScalar("toId",StandardBasicTypes.STRING);
		sqlQuery2.setString(0, userId);
		List<String> list2=sqlQuery2.list();
		System.out.println("RESULT OF 2nd QUERY" +list2);
		list1.addAll(list2);
		System.out.println("RESULT OF list1 + list2" +list1);
		return list1;
	}
}