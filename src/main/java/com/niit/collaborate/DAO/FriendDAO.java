package com.niit.collaborate.DAO;

import java.util.List;

import com.niit.collaborate.model.Friend;

public interface FriendDAO {
	public boolean createFriend(Friend friend);
	public Friend getFriend(int friendId);
	public List<Friend> getFriends();
	public boolean approveFriend(Friend friend);
	public boolean updateFriend(int friendId);
	public boolean deleteFriend(int friendId);
}