package com.ls.blog.blog;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BlogServiceImpl implements IBlogService {

	
	private BlogDao blogDao;
	
	@Autowired
	public BlogServiceImpl(BlogDao blogDao) {
		this.blogDao = blogDao;
	}
	
	@Override
	public Blog save(Blog object) {
		return blogDao.save(object);
	}

	@Override
	public void update(Blog object) {
		blogDao.update(object);
	}

	@Override
	public void delete(String id) {
		blogDao.delete(id);
	}

	@Override
	public List<Blog> findAll() {
		return blogDao.FindAll().get();
	}

	@Override
	public Blog findOne(String id){
		Optional<Blog> blog = blogDao.FindOne(id);
		if(blog.isPresent())
			return blog.get();
		
		return null;
	}

}
