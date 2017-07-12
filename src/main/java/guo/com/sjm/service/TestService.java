package guo.com.sjm.service;

import cn.huoqiu.base.db.DB;
import cn.huoqiu.base.db.Pagination;
import cn.huoqiu.base.db.Query;
import cn.huoqiu.base.web.QueryForm;
import guo.com.sjm.entity.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
public class TestService {
    private Logger logger = LoggerFactory.getLogger(TestService.class);

    @Inject
    private DB db;

    @Transactional
    public Pagination<Test> search(QueryForm qf) {
        Query q = db.from("test");
        return q.orderBy(qf.getOrderBy()).paginate(Test.class, qf.getPage());
    }

    @Transactional
    public Test findById(Long id) {
        return db.find(Test.class, id);
    }

    @Transactional
    public void create(Test test) {
        db.insert(test);
        logger.info("created a new test: " + test);
    }

    @Transactional
    public void update(Test test) {
        db.update(test);
    }

    @Transactional
    public Test delete(Long id) {
        Test test = db.find(Test.class, id);
        db.delete(test);
        return test;
    }

    @Transactional
    public void destroy(Test test) {
        db.delete(test);
    }

}
