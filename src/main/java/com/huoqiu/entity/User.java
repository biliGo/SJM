package com.huoqiu.entity;


import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import javax.validation.constraints.NotNull;

import com.google.common.base.MoreObjects;

@Table
public class User {

	@Id
	private Integer id;
	
	@Column
	@NotNull
	private Integer deptno;
	
	@Column
	@NotNull
	private String username;
	
	@Column
	@NotNull
	private Double sal;
	
	public void setId(Integer id) {
		this.id = id;
	}
	 
	public Integer getId() {
		return this.id;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	 
	public Integer getDeptno() {
		return this.deptno;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	 
	public String getUsername() {
		return this.username;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}
	 
	public Double getSal() {
		return this.sal;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("deptno", deptno)
			.add("username", username).add("sal", sal)
			.toString();
	}
}
