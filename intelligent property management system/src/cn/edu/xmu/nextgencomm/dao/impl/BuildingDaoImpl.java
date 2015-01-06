package cn.edu.xmu.nextgencomm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.nextgencomm.dao.BuildingDao;
import cn.edu.xmu.nextgencomm.model.Building;
import cn.edu.xmu.nextgencomm.model.Community;

public class BuildingDaoImpl extends HibernateDaoSupport implements BuildingDao{

	@Override
	public Building get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Building.class, id);
	}

	@Override
	public Integer save(Building building) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(building);
	}

	@Override
	public void update(Building building) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(building);
	}

	@Override
	public void delete(Building building) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(building);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Building> findAll() {
		// TODO Auto-generated method stub
		return (List<Building>)getHibernateTemplate().find("from Building b order by b.id");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Building> findByCommunity(Community community) {
		// TODO Auto-generated method stub
		return (List<Building>)getHibernateTemplate().find("from Building b where b.community=?",community);
	}

}
