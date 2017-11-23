package com.niit.collaborate.DAO;

import com.niit.collaborate.model.User;

public interface UserDAO {
	public boolean createUser(User user);
	public User getUser(String userid);//dz z equals to UserByUserid

	public boolean ValidEmailId(String emailId);
	public boolean isUpdatedEmailIdValid(String emailId,String userId);
	public boolean isUserIdValid(String userId);
	public User Login(User user);
	void update(User user);
}