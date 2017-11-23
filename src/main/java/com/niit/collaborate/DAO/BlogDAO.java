package com.niit.collaborate.DAO;

import java.util.List;

import com.niit.collaborate.model.Blog;
import com.niit.collaborate.model.BlogComment;

public interface BlogDAO {
	public void createBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> getBlogs(int approved);
	public void updateBlog(Blog blog);
	public List<Blog> getNotification(String userId);
	public void addBlogComment(BlogComment blogComment);
	public  List<BlogComment>getBlogComments(int Id);
}