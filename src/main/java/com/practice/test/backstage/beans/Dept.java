package com.practice.test.backstage.beans;

import com.practice.test.backstage.currency.BaseBean;

@SuppressWarnings("serial")
public class Dept extends BaseBean{


	private String name;
	private String location;
	
	
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
	
}
