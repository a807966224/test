package com.practice.test.backstage.currency;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {

	List<T> selectAll(T t);
		
	Integer selectCount();
	
	Integer insert(T t);
	
	Integer update(T t);
	
	Integer delete(Long id);
	
	Integer deleteBatch(Map map);
	
	T get(Long id);
	
}
