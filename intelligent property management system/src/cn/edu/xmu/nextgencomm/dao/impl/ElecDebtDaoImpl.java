package cn.edu.xmu.nextgencomm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.nextgencomm.dao.ElecDebtDao;
import cn.edu.xmu.nextgencomm.model.ElecDebt;
import cn.edu.xmu.nextgencomm.model.Room;

public class ElecDebtDaoImpl extends HibernateDaoSupport implements ElecDebtDao{

	@Override
	public ElecDebt get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(ElecDebt.class, id);
	}

	@Override
	public Integer save(ElecDebt elecDebt) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(elecDebt);
	}

	@Override
	public void update(ElecDebt elecDebt) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(elecDebt);
	}

	@Override
	public void delete(ElecDebt elecDebt) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(elecDebt);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ElecDebt> findAll() {
		// TODO Auto-generated method stub
		return (List<ElecDebt>)getHibernateTemplate().find("from ElecDebt");
	}

	@Override
	public ElecDebt findByRoom(Room room) {
		// TODO Auto-generated method stub
		try
		{
			@SuppressWarnings("unchecked")
			List<ElecDebt> list = (List<ElecDebt>)getHibernateTemplate().find("from ElecDebt as e where e.elecDebtRoom=?",room);
			if(!list.isEmpty()){
				ElecDebt my = list.get(0);
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
	public void updateMyElecDebtAfterPay(Room room) {
		// TODO Auto-generated method stub
		try
		{
			@SuppressWarnings("unchecked")
			List<ElecDebt> list = (List<ElecDebt>)getHibernateTemplate().find("from ElecDebt as e where e.elecDebtRoom=?",room);
			if(!list.isEmpty()){
				for(ElecDebt value: list)
				{
					value.setElecDebt(0);
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
