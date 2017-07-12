package guo.com.sjm.dao;


import guo.com.sjm.entity.Test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


@Repository
public class TestDaoImpl implements TestDao {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Test> getList() {
		// TODO Auto-generated method stub
		try {
			Query query=em.createQuery("select t from Test t");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
		return null;
	}

	@Override
	public void addList(Test te) {
		// TODO Auto-generated method stub
		try {
			/*Query query=em.createQuery("insert into Test t where t.name=:name and t.time=:time").setParameter("name", te.getName()).setParameter("time", te.getTime());
			query.executeUpdate();*/
			em.persist(te);
			em.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
	}

	@Override
	public void updateList(Test te) {
		// TODO Auto-generated method stub
		try {
			/*Query query=em.createQuery("update Test t set t.name=:name and t.time=:time where t.id=:id").setParameter("name", te.getName()).setParameter("time", te.getTime()).setParameter("id", te.getId());
			query.executeUpdate();*/
			em.merge(te);
			em.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
	}

	@Override
	public void deleteList(Integer id) {
		// TODO Auto-generated method stub
		try {
			Query query=em.createQuery("delete from Test t where t.id=:id").setParameter("id", id);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();		
		}finally{
			em.close();
		}
	}

}
