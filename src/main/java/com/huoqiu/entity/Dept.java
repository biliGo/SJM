package com.huoqiu.entity;


import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import javax.validation.constraints.NotNull;

import com.google.common.base.MoreObjects;

@Table
public class Dept {

	@Id
	private Integer deptno;
	
	@Column
	@NotNull
	private String deptname;
	
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	 
	public Integer getDeptno() {
		return this.deptno;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	 
	public String getDeptname() {
		return this.deptname;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("deptno", deptno).add("deptname", deptname)
			.toString();
	}
}
