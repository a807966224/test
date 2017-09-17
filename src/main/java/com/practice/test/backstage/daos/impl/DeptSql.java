package com.practice.test.backstage.daos.impl;

/**
 * 操作数据库的sql语句
 * @author Scott
 *
 */
public class DeptSql {
	
	private static final String prefixSql = "select id,name,location from dept";
	
	public String getDeptForPage() {
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append(prefixSql);
		stringBuffer.append(" order by id desc ");
		//从第几条开始  往后进行每页几条分页查询
		stringBuffer.append(" limit #{skip},#{size} ");
		
		return stringBuffer.toString();
	}
	
	public String getDeptForCount() {
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append("select count(id) from dept ");
		
		return stringBuffer.toString();
	}
	
	public String get() {
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append(prefixSql);
		
		stringBuffer.append(" where dept.id = #{dept.id}");
		
		return stringBuffer.toString();
	}
	
	public String insert() {
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append("insert into dept (name,location) ");
		
		stringBuffer.append(" values (#{dept.name},#{dept.location}) ");
		
		return stringBuffer.toString();
	}
	
	public String update() {
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append("update dept set dept.name = #{dept.name}, dept.location = #{dept.location} ");
		
		stringBuffer.append("  where dept.id = #{dept.id} ");
		
		return stringBuffer.toString();
	}
	
	public String delete() {
		
		StringBuffer stringBuffer = new StringBuffer("delete from dept where dept.id = #{id} ");
		
		return stringBuffer.toString();
	}

}
