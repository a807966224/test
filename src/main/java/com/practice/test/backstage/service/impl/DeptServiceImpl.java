package com.practice.test.backstage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.test.backstage.beans.Dept;
import com.practice.test.backstage.currency.PagerList;
import com.practice.test.backstage.daos.DeptDao;
import com.practice.test.backstage.service.DeptService;


/**
 * 部门业务实现类
 * @author Scott
 *
 */
//加载至spring 容器中
@Transactional
@Service
public class DeptServiceImpl implements DeptService{

	//自动获取容器中的对象至当前类中
	@Resource
	private DeptDao deptDao;
	
	@Override
	public PagerList<Dept> getDeptForPage(Integer skip, Integer size, String prefixUrl) {
		List<Dept> depts = deptDao.getDeptForPage(skip,size);
		PagerList<Dept> pagerList = new PagerList<Dept>(skip, size, prefixUrl,depts,deptDao.getDeptForCount());
		return pagerList;
	}

	public DeptDao getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public Dept get(Dept dept) {
		return deptDao.get(dept.getId());
	}

	@Override
	public void insert(Dept dept) {
		deptDao.insert(dept);
	}

	@Override
	public void update(Dept dept) {
		deptDao.update(dept);		
	}

	@Override
	public void delete(Long[] ids) {
		for(Long id : ids) {
			deptDao.delete(id);		
		}
	}

	@Override
	public List<Dept> getList() {
		return deptDao.getList();
	}

}
