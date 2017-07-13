package com.huoqiu.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.huoqiu.base.db.DB;
import cn.huoqiu.base.db.Pagination;
import cn.huoqiu.base.db.Query;
import com.huoqiu.entity.Stu;
import cn.huoqiu.base.web.QueryForm;

@Service
public class StuService {
	private Logger logger = LoggerFactory.getLogger(StuService.class);

	@Inject
	private DB db;

	@Transactional
	public Pagination<Stu> search(QueryForm qf) {
		Query q = db.from("stu");
		return q.orderBy(qf.getOrderBy()).paginate(Stu.class, qf.getPage());
	}

	@Transactional
	public Stu findById(Long id) {
		return db.find(Stu.class, id);
	}

	@Transactional
	public void create(Stu stu) {
		db.insert(stu);
		logger.info("created a new stu: " + stu);
	}

	@Transactional
	public void update(Stu stu) {
		db.update(stu);
	}

	@Transactional
	public Stu delete(Long id) {
		Stu stu = db.find(Stu.class, id);
		db.delete(stu);
		return stu;
	}

	@Transactional
	public void destroy(Stu stu) {
		db.delete(stu);
	}
	
}
