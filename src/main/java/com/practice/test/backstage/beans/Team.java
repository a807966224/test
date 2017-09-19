package com.practice.test.backstage.beans;

import com.practice.test.backstage.currency.BaseBean;

/**
 * 班组   包含人员     此处多对多类型
 * @author Scott
 *
 */
@SuppressWarnings({ "serial" })
public class Team extends BaseBean{

	private String name;//班组名称

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
