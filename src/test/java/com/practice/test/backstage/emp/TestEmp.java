package com.practice.test.backstage.emp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.practice.test.backstage.beans.Emp;
import com.practice.test.backstage.currency.MyBatisUtil;
import com.practice.test.backstage.daos.EmpDao;

public class TestEmp {
	
	@Test
	public void getEmpForPage() {
		
		int skip=2;
        int size=1;
        
        SqlSession session=MyBatisUtil.getSession();
        
        try {
        	
        	EmpDao empDao=session.getMapper(EmpDao.class);
        	
//            List<Emp> emps=empDao.getEmpForPage(skip, size);
            
//            Assert.assertEquals(1, emps.size());
            
        } finally {
        	
            session.close();
            
        }
	}

}
