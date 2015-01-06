package cn.edu.xmu.nextgencomm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.nextgencomm.dao.FloorDao;
import cn.edu.xmu.nextgencomm.model.Floor;

public class FloorDaoImpl extends HibernateDaoSupport implements FloorDao{

	@Override
	public Floor get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Floor.class, id);
	}

	@Override
	public Integer save(Floor floor) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(floor);
	}

	@Override
	public void update(Floor floor) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(floor);
	}

	@Override
	public void delete(Floor floor) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(floor);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Floor> findAll() {
		// TODO Auto-generated method stub
		return (List<Floor>)getHibernateTemplate().find("from Floor f order by f.id");
	}

}
