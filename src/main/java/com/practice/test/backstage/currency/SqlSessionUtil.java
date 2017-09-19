package com.practice.test.backstage.currency;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 获取sqlSession实例
 * @author Scott
 *
 */
public class SqlSessionUtil {

	private static SqlSessionFactory sqlSessionFactory;
	private static String resources = "applicationContext.xml";
	
	
	@SuppressWarnings("resource")
	public static synchronized SqlSessionFactory getInstance() {
		
		if(sqlSessionFactory == null) {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext(resources);
			return (SqlSessionFactory)applicationContext.getBean("sqlSessionFactory");
		}
		return sqlSessionFactory;
	}
}
