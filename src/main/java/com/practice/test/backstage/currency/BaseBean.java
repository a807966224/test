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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
