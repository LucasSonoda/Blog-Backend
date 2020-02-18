package com.ls.blog.blog;

import java.util.List;
import java.util.Optional;

import com.ls.blog.interfaces.ICRUD;

public interface IBlogService extends ICRUD<Blog> {
	public List<Blog> findAll();
	public Blog findOne(String id) throws Exception;
}
