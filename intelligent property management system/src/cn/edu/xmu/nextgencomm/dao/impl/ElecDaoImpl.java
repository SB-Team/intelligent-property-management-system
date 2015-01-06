package cn.edu.xmu.nextgencomm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.nextgencomm.dao.ElecDao;
import cn.edu.xmu.nextgencomm.model.ElecDegree;



public class ElecDaoImpl extends HibernateDaoSupport implements ElecDao{

	@Override
	public ElecDegree get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(ElecDegree.class, id);
	}

	@Override
	public Integer save(ElecDegree elecDegree) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(elecDegree);
	}

	@Override
	public void update(ElecDegree elecDegree) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(elecDegree);
	}

	@Override
	public void delete(ElecDegree elecDegree) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(elecDegree);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ElecDegree> findAll() {
		// TODO Auto-generated method stub
		return (List<ElecDegree>)getHibernateTemplate().find("from ElecDegree");
	}

	@Override
	public ElecDegree findLastByPosition(int communityId, int buildingNum,
			int floorNum, int roomNum) {
		ElecDegree last = null;
		try{
			@SuppressWarnings("unchecked")
			List<ElecDegree> list = (List<ElecDegree>)getHibernateTemplate().find("from ElecDegree as e where e.community.id=? and e.buildingNum=? and e.floorNum=? and e.roomNum=?",new Object[]{communityId, buildingNum,
					floorNum, roomNum});
			if(!list.isEmpty()){
				last = list.get(list.size()-1);
				return last;
			}
			return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}

	}
	

}
