package com.practice.test.backstage.currency;

import java.util.List;
import java.util.Map;

public abstract class AbstractBaseService<T> implements BaseService<T> {

	public abstract BaseDao<T> getDao();

	@Override
	public List<T> selectAll(T t) {
		return getDao().selectAll(t);
	}

	@Override
	public Integer selectCount() {
		return getDao().selectCount();
	}

	@Override
	public Integer insert(T t) {
		return getDao().insert(t);
	}

	@Override
	public Integer update(T t) {
		return getDao().update(t);
	}

	@Override
	public Integer delete(Long id) {
		return getDao().delete(id);
	}

	@Override
	public Integer deleteBatch(Map map) {
		return getDao().deleteBatch(map);
	}

	@Override
	public T get(Long id) {
		return getDao().get(id);
	}
	
	
	
}
