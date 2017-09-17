package com.practice.test.backstage.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 根据属性名称调用响应类的getter/setter方法
 * @author Scott
 *
 */
public class ObjectUtils {


	/**
	 * 负责调用指定类的getter方法
	 * @param wrapObject   表示调用方法的所在类对象
	 * @param attribute	表示属性名称
	 * @return	调用对象的结果
	 */
	public static Object getObject(Object wrapObject,String attribute) throws Exception{
		
		String methodName = "get" + StringUtils.initcap(attribute); //定义了getter方法
		
		//调用指定属性field对象，目的是取得对象类型，如果没有此属性也就意味着操作无法继续了
		Field field = wrapObject.getClass().getDeclaredField(attribute);
		
		if(field == null) {//给你第二次取得对象的机会，万一某些属性需要父类的成员变量获取
		
			field = wrapObject.getClass().getField(attribute);
			
		}
		
		if(field == null) {//两次取得都没有取得  
			return null;//该属性不存在
		}
		
		Method method = wrapObject.getClass().getMethod(methodName);
		
		return method.invoke(wrapObject);
	}
	
	private ObjectUtils() {}
}
