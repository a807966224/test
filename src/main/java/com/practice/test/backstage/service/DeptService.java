package com.practice.test.backstage.service;

import java.util.List;

import com.practice.test.backstage.beans.Dept;
import com.practice.test.backstage.currency.PagerList;

public interface DeptService {

	public PagerList<Dept> getDeptForPage(Integer skip,Integer size,String prefixUrl);
	
	public Dept get(Dept dept);
	
	public void insert(Dept dept);
	
	public void update(Dept dept);
	
	public void delete(Long[] ids);
}
