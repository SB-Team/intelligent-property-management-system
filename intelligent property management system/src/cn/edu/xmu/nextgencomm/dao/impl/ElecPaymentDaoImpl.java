package cn.edu.xmu.nextgencomm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.nextgencomm.dao.ElecPaymentDao;
import cn.edu.xmu.nextgencomm.model.ElecDegree;
import cn.edu.xmu.nextgencomm.model.ElecPayment;
import cn.edu.xmu.nextgencomm.model.Room;

public class ElecPaymentDaoImpl extends HibernateDaoSupport implements ElecPaymentDao {

	@Override
	public ElecPayment get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(ElecPayment.class, id);
	}

	@Override
	public Integer save(ElecPayment elecPayment) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(elecPayment);
	}

	@Override
	public void update(ElecPayment elecPayment) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(elecPayment);
	}

	@Override
	public void delete(ElecPayment elecPayment) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(elecPayment);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ElecPayment> findAll() {
		// TODO Auto-generated method stub
		return (List<ElecPayment>)getHibernateTemplate().find("from ElecPayment");
	}

	@Override
	public ElecPayment findMyLastBill(Room room) {
		// TODO Auto-generated method stub
		try
		{
			@SuppressWarnings("unchecked")
			List<ElecPayment> list = (List<ElecPayment>)getHibernateTemplate().find("from ElecPayment as e where e.room=?",room);
			if(!list.isEmpty()){
				ElecPayment my = list.get(list.size()-1);
				return my;
			}
			return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	

	}

	@Override
	public ElecPayment findByRoomElecDegree(ElecDegree roomElecDegree) {
		// TODO Auto-generated method stub
		try
		{
			@SuppressWarnings("unchecked")
			List<ElecPayment> list = (List<ElecPayment>)getHibernateTemplate().find("from ElecPayment as e where e.roomElecDegree=?",roomElecDegree);
			if(!list.isEmpty()){
				ElecPayment my = list.get(0);
				return my;
			}
			return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void updateIsPay(Room room) {
		// TODO Auto-generated method stub
		try{
			@SuppressWarnings("unchecked")
			List<ElecPayment> list = (List<ElecPayment>)getHibernateTemplate().find("from ElecPayment as e where e.room=?",room);
			if(!list.isEmpty()){
				for(ElecPayment value:list)
				{
					value.setIsPay(1);
					update(value);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ElecPayment> findMyAllBill(Room room) {
		// TODO Auto-generated method stub
		return (List<ElecPayment>)getHibernateTemplate().find("from ElecPayment as e where e.room=?",room);
	}
}
