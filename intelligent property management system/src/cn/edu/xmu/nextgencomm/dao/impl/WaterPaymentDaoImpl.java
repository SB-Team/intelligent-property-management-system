package cn.edu.xmu.nextgencomm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.nextgencomm.dao.WaterPaymentDao;
import cn.edu.xmu.nextgencomm.model.Room;
import cn.edu.xmu.nextgencomm.model.WaterDegree;
import cn.edu.xmu.nextgencomm.model.WaterPayment;

public class WaterPaymentDaoImpl extends HibernateDaoSupport implements WaterPaymentDao{

	@Override
	public WaterPayment get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(WaterPayment.class, id);
	}

	@Override
	public Integer save(WaterPayment waterPayment) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(waterPayment);
	}

	@Override
	public void update(WaterPayment waterPayment) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(waterPayment);
	}

	@Override
	public void delete(WaterPayment waterPayment) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(waterPayment);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WaterPayment> findAll() {
		// TODO Auto-generated method stub
		return (List<WaterPayment>)getHibernateTemplate().find("from WaterPayment");
	}

	@Override
	public WaterPayment findMyLastBill(Room room) {
		// TODO Auto-generated method stub
		try
		{
			@SuppressWarnings("unchecked")
			List<WaterPayment> list = (List<WaterPayment>)getHibernateTemplate().find("from WaterPayment as w where w.room=?",room);
			if(!list.isEmpty()){
				WaterPayment my = list.get(list.size()-1);
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
	public WaterPayment findByRoomDegree(WaterDegree roomDegree) {
		// TODO Auto-generated method stub
		try
		{
			@SuppressWarnings("unchecked")
			List<WaterPayment> list = (List<WaterPayment>)getHibernateTemplate().find("from WaterPayment as w where w.roomDegree=?",roomDegree);
			if(!list.isEmpty()){
				WaterPayment my = list.get(0);
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
			List<WaterPayment> list = (List<WaterPayment>)getHibernateTemplate().find("from WaterPayment as w where w.room=?",room);
			if(!list.isEmpty()){
				for(WaterPayment value:list)
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
	public List<WaterPayment> findMyAllBill(Room room) {
		// TODO Auto-generated method stub
		return (List<WaterPayment>)getHibernateTemplate().find("from WaterPayment as w where w.room=?",room);
	}

}
