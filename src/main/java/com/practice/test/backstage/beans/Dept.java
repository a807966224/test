package com.practice.test.backstage.beans;

import java.util.List;

import com.practice.test.backstage.currency.BaseBean;

@SuppressWarnings("serial")
public class Dept extends BaseBean{


	private String name;
	private String location;
	
	private List<Emp> empList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Emp> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	
}
