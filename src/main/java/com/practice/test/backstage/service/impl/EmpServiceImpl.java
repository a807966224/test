package com.practice.test.backstage.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.test.backstage.beans.Emp;
import com.practice.test.backstage.currency.PagerList;
import com.practice.test.backstage.daos.EmpDao;
import com.practice.test.backstage.service.EmpService;
import com.practice.test.backstage.utils.StringUtils;


/**
 * 人员业务实现类
 * @author Scott
 *
 */
//加载至spring 容器中
@Transactional
@Service
public class EmpServiceImpl implements EmpService{

	//自动获取容器中的对象至当前类中
	@Resource
	private EmpDao empDao;
	@Value("${uploadImageUrl_windows}")
	private String uploadImageUrl_windows;
	
	@Override
	public PagerList<Emp> getEmpForPage(Emp emp, Integer skip, Integer size, String prefixUrl) {
		List<Emp> emps = empDao.getEmpForPage(emp,(skip-1)*size,size);
		PagerList<Emp> pagerList = new PagerList<Emp>(skip, size, prefixUrl,emps,empDao.getEmpForCount(emp));
		return pagerList;
	}

	public EmpDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	@Override
	public Emp get(Emp emp) {
		return empDao.get(emp.getId());
	}

	@Override
	public void insert(Emp emp) {
		empDao.insert(emp);
	}

	@Override
	public void update(Emp emp) {
		empDao.update(emp);		
	}

	@Override
	public void delete(Long[] ids,String[] delPhotoSrcs) {
		for(int i=0,j=ids.length;i<j;i++) {
			
			
			if(delPhotoSrcs[i] != null && !delPhotoSrcs[i].equals("")) {
				File file = new File(uploadImageUrl_windows,delPhotoSrcs[i]);
				if(file.exists()) {
					file.delete();
				}	
			}
			
			empDao.delete(ids[i]);		
		}
	}

	public String getUploadImageUrl_windows() {
		return uploadImageUrl_windows;
	}

	public void setUploadImageUrl_windows(String uploadImageUrl_windows) {
		this.uploadImageUrl_windows = uploadImageUrl_windows;
	}

}
