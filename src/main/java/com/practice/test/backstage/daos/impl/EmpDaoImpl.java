package com.practice.test.backstage.daos.impl;

public class EmpDaoImpl {
	
	//Integer skip,Integer size
	public String getEmpForPage() {
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		stringBuffer.append("select id,name,sex,age from emp ");
		stringBuffer.append(" order by id desc ");
//		stringBuffer.append(" limit "+skip+","+size);
		
		return stringBuffer.toString();
	}

}
