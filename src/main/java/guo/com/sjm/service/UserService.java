package guo.com.sjm.service;

import cn.huoqiu.base.db.DB;
import cn.huoqiu.base.db.Pagination;
import cn.huoqiu.base.db.Query;
import cn.huoqiu.base.web.QueryForm;
import guo.com.sjm.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Inject
    private DB db;

    @Transactional
    public Pagination<User> search(QueryForm qf) {
        Query q = db.from("user");
        return q.orderBy(qf.getOrderBy()).paginate(User.class, qf.getPage());
    }

    @Transactional
    public User findById(Long id) {
        return db.find(User.class, id);
    }

    @Transactional
    public void create(User user) {
        db.insert(user);
        logger.info("created a new user: " + user);
    }

    @Transactional
    public void update(User user) {
        db.update(user);
    }

    @Transactional
    public User delete(Long id) {
        User user = db.find(User.class, id);
        db.delete(user);
        return user;
    }

    @Transactional
    public void destroy(User user) {
        db.delete(user);
    }

}
