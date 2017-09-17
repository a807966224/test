package com.practice.test.backstage.daos.impl;

import java.util.Map;

/**
 * 操作数据库的sql语句
 * @author Scott
 *
 */
public class EmpSql {
	
	private static final String prefixSql = "select id,name,sex,age,deptId,"
			+ "(select name from dept where dept.id = emp.deptId) deptName from emp";
	
	public String getEmpForPage() {
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append(prefixSql);
		stringBuffer.append(" order by id desc ");
		//从第几条开始  往后进行每页几条分页查询
		stringBuffer.append(" limit #{skip},#{size} ");
		
		return stringBuffer.toString();
	}
	
	public String getEmpForCount() {
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append("select count(id) from emp ");
		stringBuffer.append(" order by id desc ");
		
		return stringBuffer.toString();
	}
	
	public String get() {
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append(prefixSql);
		
		stringBuffer.append(" where emp.id = #{id}");
		
		return stringBuffer.toString();
	}
	
	public String insert() {
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append("insert into emp (name,sex,age,deptId) ");
		
		stringBuffer.append(" values (#{emp.name},#{emp.sex},#{emp.age},#{emp.deptId}) ");
		
		return stringBuffer.toString();
	}
	
	public String update() {
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append("update emp set emp.name = #{emp.name}, emp.sex = #{emp.sex}, ");
		
		stringBuffer.append(" emp.age = #{emp.age},emp.deptId = #{emp.deptId} where emp.id = #{emp.id} ");
		
		return stringBuffer.toString();
	}
	
	public String delete() {
		
		StringBuffer stringBuffer = new StringBuffer("delete from emp where emp.id = #{id} ");
		
		return stringBuffer.toString();
	}
	
	public String getListByDeptId(Long id) {
		
		System.out.println(id);
		
		StringBuffer stringBuffer = new StringBuffer(prefixSql);
		
		stringBuffer.append(" where emp.deptId = " + id);
		
		return stringBuffer.toString();
		
	}

}
