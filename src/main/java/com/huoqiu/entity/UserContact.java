package com.huoqiu.entity;

import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import com.google.common.base.MoreObjects;

@Table
public class UserContact {

	@Id
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String cell;
	
	@Column
	private Date createdAt;
	
	@Column
	private Date updatedAt;
	
	public void setId(Long id) {
		this.id = id;
	}
	 
	public Long getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
	public String getName() {
		return this.name;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}
	 
	public String getCell() {
		return this.cell;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	 
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	 
	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("name", name)
			.add("cell", cell).add("createdAt", createdAt)
			.add("updatedAt", updatedAt).toString();
	}
}
