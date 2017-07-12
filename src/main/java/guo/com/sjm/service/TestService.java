package guo.com.sjm.service;


import guo.com.sjm.entity.Test;

import java.util.List;

/**
 * 
 * @author Administrator
 *
 */
public interface TestService {
	List<Test> getList();//显示所有信息
	void addList(Test te);//添加信息
	void updateList(Test te);//修改信息
	void deleteList(Integer id);//删除信息
	//Test getListById(Integer id);//根据编号查找 信息
}
