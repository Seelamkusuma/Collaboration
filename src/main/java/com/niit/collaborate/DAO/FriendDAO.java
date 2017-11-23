package com.niit.collaborate.DAO;

import java.util.List;

import com.niit.collaborate.model.Friend;
import com.niit.collaborate.model.User;

public interface FriendDAO {
	List<User> listOfSuggestedUsers(String userId);
	
	void friendRequest(Friend friend);
	
	List<Friend> pendingRequests(String toId);
	
	void updatePendingRequest(Friend friend);
	
	List<String> listOfFriends(String userId);
}