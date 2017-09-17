package com.practice.test.backstage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.practice.test.backstage.beans.Dept;
import com.practice.test.backstage.currency.PagerList;
import com.practice.test.backstage.daos.DeptDao;
import com.practice.test.backstage.service.DeptService;
import com.practice.test.backstage.utils.StringUtils;


/**
 * 部门业务实现类
 * @author Scott
 *
 */
//加载至spring 容器中
@Service
public class DeptServiceImpl implements DeptService{

	//自动获取容器中的对象至当前类中
	@Resource
	private DeptDao deptDao;
	
	@SuppressWarnings("rawtypes")
	@Override
	public PagerList<Dept> getDeptForPage(Integer skip, Integer size, String prefixUrl) {
		List<Dept> depts = deptDao.getDeptForPage((skip-1)*size,size);
		PagerList pagerList = new PagerList<>(skip, size, prefixUrl,depts,deptDao.getDeptForCount());
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
		return deptDao.get(dept);
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

}
