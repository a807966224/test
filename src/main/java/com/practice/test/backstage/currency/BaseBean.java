package com.practice.test.backstage.currency;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import com.practice.test.backstage.utils.DateUtil;

/**
 * 
 * @author Scott
 *
 */
@SuppressWarnings("serial")
public class BaseBean implements Serializable{
	
	
	private Long id;
	
	private Date create_date;
	
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

	public Date getCreate_date() {
		return new Date();
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

}
