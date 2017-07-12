package guo.com.sjm.service;


import guo.com.sjm.dao.TestDao;
import guo.com.sjm.entity.Test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestDao sd;

	@Override
	public List<Test> getList() {
		// TODO Auto-generated method stub
		return sd.getList();
	}

	@Override
	public void addList(Test te) {
		// TODO Auto-generated method stub
		sd.addList(te);
	}

	@Override
	public void updateList(Test te) {
		// TODO Auto-generated method stub
		sd.updateList(te);
	}

	@Override
	public void deleteList(Integer id) {
		// TODO Auto-generated method stub
		sd.deleteList(id);
	}

}
