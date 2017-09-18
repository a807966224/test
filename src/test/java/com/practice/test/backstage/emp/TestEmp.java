package com.practice.test.backstage.emp;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	
	
	@Test
	public void getPropertiesValue() throws IOException {
			
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Properties properties = (Properties)applicationContext.getBean("configProperties");
		System.out.println(properties.get("uploadImageUrl_windows"));
	}
	

}
