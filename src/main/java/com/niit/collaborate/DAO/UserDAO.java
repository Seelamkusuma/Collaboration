package com.niit.collaborate.DAO;

import java.util.List;

import com.niit.collaborate.model.User;

public interface UserDAO {
	public boolean createUser(User user);
	public User getUser(int userId);
	public List<User> getUsers();
	public boolean approveUser(User user);
	public boolean updateUser(int userId);
	public boolean deleteUser(int userId);
}