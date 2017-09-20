package com.practice.test.backstage.daos.impl;

import java.util.Map;

import org.springframework.util.StringUtils;

import com.practice.test.backstage.beans.Emp;

/**
 * 操作数据库的sql语句
 * @author Scott
 *
 */
public class EmpSql {
	
	private static final String prefixSql = "select id,name,sex,age,deptId,photoSrc,"
			+ "(select name from dept where dept.id = emp.deptId) deptName from emp where 1 = 1";
	
	public String getEmpForPage(Map map) {
		
		Emp emp = (Emp)map.get("emp");
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append(prefixSql);
		
		if(!StringUtils.isEmpty(emp.getName())) {
			stringBuffer.append(" and emp.name like concat('%',#{emp.name},'%')");
		}
		
		if(emp.getDeptId() != null) {
			stringBuffer.append(" and emp.deptId = #{emp.deptId}");
		}
		
		stringBuffer.append(" order by id desc ");
		//从第几条开始  往后进行每页几条分页查询
		stringBuffer.append(" limit #{skip},#{size} ");
		
		return stringBuffer.toString();
	}
	
	public String getEmpForCount(Map map) {
		
		Emp emp = (Emp)map.get("emp");
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append("select count(id) from emp where 1 = 1");
		
		if(!StringUtils.isEmpty(emp.getName())) {
			stringBuffer.append(" and emp.name like concat('%',#{emp.name},'%')");
		}
		
		if(emp.getDeptId() != null) {
			stringBuffer.append(" and emp.deptId = #{emp.deptId}");
		}
		
		return stringBuffer.toString();
	}
	
	public String get() {
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append(prefixSql);
		
		stringBuffer.append(" and emp.id = #{id}");
		
		return stringBuffer.toString();
	}
	
	public String insert() {
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append("insert into emp (name,sex,age,deptId,photoSrc,create_date) ");
		
		stringBuffer.append(" values (#{emp.name},#{emp.sex},#{emp.age},#{emp.deptId},#{emp.photoSrc},#{emp.create_date}) ");
		
		return stringBuffer.toString();
	}
	
	public String update() {
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append("update emp set emp.name = #{emp.name}, emp.sex = #{emp.sex},emp.photoSrc = #{emp.photoSrc}, ");
		
		stringBuffer.append(" emp.age = #{emp.age},emp.deptId = #{emp.deptId} where emp.id = #{emp.id} ");
		
		return stringBuffer.toString();
	}
	
	public String delete() {
		
		StringBuffer stringBuffer = new StringBuffer("delete from emp where emp.id = #{id} ");
		
		return stringBuffer.toString();
	}
	
	public String getListByDeptId(Long id) {
		
		StringBuffer stringBuffer = new StringBuffer(prefixSql);
		
		stringBuffer.append(" and emp.deptId = " + id);
		
		return stringBuffer.toString();
		
	}

}
