package com.practice.test.backstage.service;

import java.util.List;

import com.practice.test.backstage.beans.Emp;

public interface EmpService {

	public List<Emp> getEmpForPage(Integer skip,Integer size);
}
