package com.niit.collaborate.DAO;
import java.util.List;

import com.niit.collaborate.model.Forum;

public interface ForumDAO {
	public boolean createForum(Forum forum);
	public Forum getForum(int forumId);
	public List<Forum> getForums();
	public boolean approveForum(Forum forum);
	public boolean updateForum(int forumId);
	public boolean deleteForum(int forumId);
}

