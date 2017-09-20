package com.practice.test.backstage.emp;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.test.backstage.daos.EmpDao;
import com.practice.test.backstage.utils.DateUtil;
import com.practice.test.backstage.utils.MyBatisUtil;
import com.practice.test.backstage.utils.SqlSessionUtil;

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
	
	
	@Test
	public void getSqlSession() {
//		SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getInstance();
//		System.out.println(sqlSessionFactory==null);
		
		
		try {
			Date date = DateUtil.parse(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss SSS"), "yyyy-MM-dd HH:mm:ss SSS");
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	

}
