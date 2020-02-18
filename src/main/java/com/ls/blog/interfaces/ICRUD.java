package com.ls.blog.interfaces;

public interface ICRUD<T> {
	public T save(T object);
	public void update(T object);
	public void delete(String id);
}
