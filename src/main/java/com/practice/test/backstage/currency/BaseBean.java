package com.practice.test.backstage.currency;

import java.io.Serializable;

/**
 * 
 * @author Scott
 *
 */
@SuppressWarnings("serial")
public class BaseBean implements Serializable{
	
	
	private Long id;
	
	private Integer skip = 0;
	private Integer size = 2;//每页容量
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSkip() {
		return skip;
	}

	public void setSkip(Integer skip) {
		this.skip = skip;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}
