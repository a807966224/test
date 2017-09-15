package com.practice.test.backstage.beans;

import com.practice.test.backstage.currency.BaseBean;

/**
 * 人员类
 * @author Scott
 *
 */
@SuppressWarnings("serial")
public class Emp extends BaseBean {
	
	private String name;//姓名
	private Integer sex;//性别  1男2女
	private Integer age;//年龄
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Emp [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
}
