package com.huoqiu.entity;


import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import javax.validation.constraints.NotNull;

import com.google.common.base.MoreObjects;

@Table
public class Stu {

	@Id
	private Integer id;
	
	@Column
	@NotNull
	private String pwd;
	
	public void setId(Integer id) {
		this.id = id;
	}
	 
	public Integer getId() {
		return this.id;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	 
	public String getPwd() {
		return this.pwd;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("pwd", pwd)
			.toString();
	}
}
