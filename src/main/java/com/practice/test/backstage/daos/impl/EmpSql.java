package com.practice.test.backstage.daos.impl;

public class EmpSql {
	
	public String getEmpForPage() {
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append("select id,name,sex,age from emp ");
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

}
