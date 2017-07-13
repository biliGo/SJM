package com.huoqiu.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.huoqiu.base.db.DB;
import cn.huoqiu.base.db.Pagination;
import cn.huoqiu.base.db.Query;
import com.huoqiu.entity.Dept;
import cn.huoqiu.base.web.QueryForm;

@Service
public class DeptService {
	private Logger logger = LoggerFactory.getLogger(DeptService.class);

	@Inject
	private DB db;

	@Transactional
	public Pagination<Dept> search(QueryForm qf) {
		Query q = db.from("dept");
		return q.orderBy(qf.getOrderBy()).paginate(Dept.class, qf.getPage());
	}

	@Transactional
	public Dept findById(Long id) {
		return db.find(Dept.class, id);
	}

	@Transactional
	public void create(Dept dept) {
		db.insert(dept);
		logger.info("created a new dept: " + dept);
	}

	@Transactional
	public void update(Dept dept) {
		db.update(dept);
	}

	@Transactional
	public Dept delete(Long id) {
		Dept dept = db.find(Dept.class, id);
		db.delete(dept);
		return dept;
	}

	@Transactional
	public void destroy(Dept dept) {
		db.delete(dept);
	}
	
}
