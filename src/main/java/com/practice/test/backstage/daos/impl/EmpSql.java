package com.practice.test.backstage.daos.impl;

public class EmpSql {
	
	public String getEmpForPage() {
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append("select id,name,sex,age from emp ");
		stringBuffer.append(" order by id desc ");
		stringBuffer.append(" limit #{skip},#{size} ");
		
		return stringBuffer.toString();
	}

}
