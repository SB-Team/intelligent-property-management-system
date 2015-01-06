package cn.edu.xmu.nextgencomm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.edu.xmu.nextgencomm.dao.WaterDao;
import cn.edu.xmu.nextgencomm.model.WaterDegree;

public class WaterDaoImpl extends HibernateDaoSupport implements WaterDao{

	@Override
	public WaterDegree get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(WaterDegree.class, id);
	}

	@Override
	public Integer save(WaterDegree waterDegree) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(waterDegree);
	}

	@Override
	public void update(WaterDegree waterDegree) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(waterDegree);
	}

	@Override
	public void delete(WaterDegree waterDegree) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(waterDegree);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WaterDegree> findAll() {
		// TODO Auto-generated method stub
		return (List<WaterDegree>)getHibernateTemplate().find("from WaterDegree");
	}

	@Override
	public WaterDegree findLastByPosition(int communityId, int buildingNum,
			int floorNum, int roomNum) {
		WaterDegree last = null;
		try{
			@SuppressWarnings("unchecked")
			List<WaterDegree> list = (List<WaterDegree>)getHibernateTemplate().find("from WaterDegree as w where w.community.id=? and w.buildingNum=? and w.floorNum=? and w.roomNum=?",new Object[]{communityId, buildingNum,
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
