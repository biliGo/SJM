package com.huoqiu.entity;

import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import com.google.common.base.MoreObjects;

@Table
public class Test {

	@Id
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private Date time;
	
	public void setId(Integer id) {
		this.id = id;
	}
	 
	public Integer getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
	public String getName() {
		return this.name;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	 
	public Date getTime() {
		return this.time;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("name", name)
			.add("time", time).toString();
	}
}
