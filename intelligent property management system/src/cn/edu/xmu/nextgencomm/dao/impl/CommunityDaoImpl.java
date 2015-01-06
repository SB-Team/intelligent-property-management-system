package cn.edu.xmu.nextgencomm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.edu.xmu.nextgencomm.dao.CommunityDao;
import cn.edu.xmu.nextgencomm.model.Community;

public class CommunityDaoImpl extends HibernateDaoSupport implements CommunityDao{

	@Override
	public Community get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Community.class, id);
	}

	@Override
	public Integer save(Community community) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(community);
	}

	@Override
	public void update(Community community) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(community);
	}

	@Override
	public void delete(Community community) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(community);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Community> findAll() {
		// TODO Auto-generated method stub
		return (List<Community>)getHibernateTemplate().find("from Community c order by c.id");
	}

}
