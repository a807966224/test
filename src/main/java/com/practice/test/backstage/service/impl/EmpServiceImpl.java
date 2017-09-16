package com.practice.test.backstage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.practice.test.backstage.beans.Emp;
import com.practice.test.backstage.currency.PagerList;
import com.practice.test.backstage.daos.EmpDao;
import com.practice.test.backstage.service.EmpService;


/**
 * 人员业务实现类
 * @author Scott
 *
 */
//加载至spring 容器中
@Service
public class EmpServiceImpl implements EmpService{

	//自动获取容器中的对象至当前类中
	@Resource
	private
	EmpDao empDao;
	
	@SuppressWarnings("rawtypes")
	@Override
	public PagerList<Emp> getEmpForPage(Integer skip, Integer size, String prefixUrl) {
		List<Emp> emps = empDao.getEmpForPage((skip-1)*size,size);
		PagerList pagerList = new PagerList<>(skip, size, prefixUrl,emps,empDao.getEmpForCount());
		return pagerList;
	}

	public EmpDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

}
