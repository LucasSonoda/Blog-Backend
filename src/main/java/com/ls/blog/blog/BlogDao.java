package com.ls.blog.blog;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ls.blog.interfaces.ICRUD;

@Repository
public class BlogDao implements ICRUD<Blog> {

	
	private final MongoOperations mongoOperations;
	
	@Autowired
	public BlogDao(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}
	
	@Override
	public Blog save(Blog object) {
		this.mongoOperations.save(object);
		return FindOne(object.getId()).get();
	}

	@Override
	public void update(Blog object) {
		this.mongoOperations.save(object);
	}

	@Override
	public void delete(String id) {
		this.mongoOperations.findAndRemove(new Query(Criteria.where("id").is(id)), Blog.class);
	}
	
	
	public Optional<Blog> FindOne(String id) {
	    Blog blog = this.mongoOperations.findOne(new Query(Criteria.where("id").is(id)), Blog.class);
        Optional<Blog> resultado = Optional.ofNullable(blog);
        return resultado;
	}
	public Optional<List<Blog>> FindAll(){
		List<Blog> blogs = this.mongoOperations.find(new Query(),Blog.class);	
		Optional<List<Blog>> resultado = Optional.ofNullable(blogs);	
		return resultado;
	}

}
