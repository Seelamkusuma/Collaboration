package com.niit.collaborate.DAO;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborate.model.ProfilePicture;

@Repository("profilePictureDAO")
@Transactional
public class ProfilePicutreDAOImpl implements ProfilePictureDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public void save(ProfilePicture profilePicture) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(profilePicture);// TODO Auto-generated method stub
		
	}

	public ProfilePicture getProfilePic(String userId) {
		Session session=sessionFactory.getCurrentSession();
	
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class, userId);
		return profilePicture;// TODO Auto-generated method stub
		
	}

	

}



