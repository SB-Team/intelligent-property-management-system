package cn.edu.xmu.nextgencomm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.nextgencomm.dao.WaterDebtDao;
import cn.edu.xmu.nextgencomm.model.Room;
import cn.edu.xmu.nextgencomm.model.WaterDebt;

public class WaterDebtDaoImpl extends HibernateDaoSupport implements WaterDebtDao {

	@Override
	public WaterDebt get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(WaterDebt.class, id);
	}

	@Override
	public Integer save(WaterDebt waterDebt) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(waterDebt);
	}

	@Override
	public void update(WaterDebt waterDebt) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(waterDebt);
	}

	@Override
	public void delete(WaterDebt waterDebt) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(waterDebt);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WaterDebt> findAll() {
		// TODO Auto-generated method stub
		return (List<WaterDebt>)getHibernateTemplate().find("from WaterDebt");
	}

	@Override
	public WaterDebt findByRoom(Room room) {
		try
		{
			@SuppressWarnings("unchecked")
			List<WaterDebt> list = (List<WaterDebt>)getHibernateTemplate().find("from WaterDebt as w where w.waterDebtRoom=?",room);
			if(!list.isEmpty()){
				WaterDebt my = list.get(0);
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
	public void updateMyWaterDebtAfterPay(Room room) {
		// TODO Auto-generated method stub
		try
		{
			@SuppressWarnings("unchecked")
			List<WaterDebt> list = (List<WaterDebt>)getHibernateTemplate().find("from WaterDebt as w where w.waterDebtRoom=?",room);
			if(!list.isEmpty()){
				for(WaterDebt value: list)
				{
					value.setWaterDebt(0);
					update(value);
				}
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}

}
