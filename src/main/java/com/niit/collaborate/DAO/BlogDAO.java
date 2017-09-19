package com.niit.collaborate.DAO;

import java.util.List;

import com.niit.collaborate.model.Blog;

public interface BlogDAO {
	public boolean createBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> getBlogs();
	public boolean approveBlog(Blog blog);
	public boolean updateBlog(int blogId);
	public boolean deleteBlog(int blogId);
}