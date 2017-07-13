package com.huoqiu.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.huoqiu.base.db.DB;
import cn.huoqiu.base.db.Pagination;
import cn.huoqiu.base.db.Query;
import com.huoqiu.entity.UserContact;
import cn.huoqiu.base.web.QueryForm;

@Service
public class UserContactService {
	private Logger logger = LoggerFactory.getLogger(UserContactService.class);

	@Inject
	private DB db;

	@Transactional
	public Pagination<UserContact> search(QueryForm qf) {
		Query q = db.from("user_contact");
		return q.orderBy(qf.getOrderBy()).paginate(UserContact.class, qf.getPage());
	}

	@Transactional
	public UserContact findById(Long id) {
		return db.find(UserContact.class, id);
	}

	@Transactional
	public void create(UserContact userContact) {
		db.insert(userContact);
		logger.info("created a new userContact: " + userContact);
	}

	@Transactional
	public void update(UserContact userContact) {
		db.update(userContact);
	}

	@Transactional
	public UserContact delete(Long id) {
		UserContact userContact = db.find(UserContact.class, id);
		db.delete(userContact);
		return userContact;
	}

	@Transactional
	public void destroy(UserContact userContact) {
		db.delete(userContact);
	}
	
}
