package com.practice.test.backstage.service;


import com.practice.test.backstage.beans.Emp;
import com.practice.test.backstage.currency.PagerList;

public interface EmpService {

	public PagerList<Emp> getEmpForPage(Emp emp,Integer skip,Integer size,String prefixUrl);
	
	public Emp get(Emp emp);
	
	public void insert(Emp emp);
	
	public void update(Emp emp);
	
	public void delete(Long[] ids,String[] delPhotoSrcs);
}
