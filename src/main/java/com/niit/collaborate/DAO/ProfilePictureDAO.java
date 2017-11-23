package com.niit.collaborate.DAO;

import com.niit.collaborate.model.ProfilePicture;

public interface ProfilePictureDAO {
	
	void save(ProfilePicture profilePicture);
	
	ProfilePicture getProfilePic(String userId);

	
	
}

