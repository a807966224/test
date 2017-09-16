package com.practice.test.backstage.service;

import java.util.List;

import com.practice.test.backstage.beans.Emp;
import com.practice.test.backstage.currency.PagerList;

public interface EmpService {

	public PagerList<Emp> getEmpForPage(Integer skip,Integer size,String prefixUrl);
}
