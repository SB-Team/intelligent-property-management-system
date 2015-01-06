package cn.edu.xmu.nextgencomm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.nextgencomm.dao.ParkingDao;
import cn.edu.xmu.nextgencomm.model.Parking;
import cn.edu.xmu.nextgencomm.model.TempBill;

public class ParkingDaoImpl extends HibernateDaoSupport implements ParkingDao{

	@Override
	public Parking get(Integer id) {
		return getHibernateTemplate().get(Parking.class, id);
	}

	@Override
	public Integer save(Parking parking) {
		return (Integer)getHibernateTemplate().save(parking);
	}

	@Override
	public void update(Parking parking) {
		getHibernateTemplate().update(parking);
		
	}

	@Override
	public void delete(Parking parking) {
		getHibernateTemplate().delete(parking);
		
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parking> findAll() {
		return (List<Parking>)getHibernateTemplate().find("from Parking");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parking> findTemp() {
		return (List<Parking>)getHibernateTemplate().find("from Parking as p where p.pstatus=? and p.ptype!=?",new Object[]{"空","租用车位"});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Parking> findRent() {
		return (List<Parking>)getHibernateTemplate().find("from Parking as p where p.pstatus=? and p.ptype!=?",new Object[]{"空","临时车位"});
	}

	@Override
	public Integer save(TempBill tempBill) {
		return (Integer)getHibernateTemplate().save(tempBill);
	}

	@Override
	public Parking findCarNum(String checkCarNum) {
		// TODO Auto-generated method stub
		Parking car = null;
		try
		{
			@SuppressWarnings("unchecked")
			List<Parking> list=(List<Parking>)getHibernateTemplate().find("from Parking as p where p.pcarnum=? and p.pstatus=?",new Object[]{checkCarNum,"租赁占用"});
			if(!list.isEmpty()) {  //判断有数据时执行
				 car = list.get(0);}
				return car;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}

		

		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parking> findAllTemp() {
		return (List<Parking>)getHibernateTemplate().find("from Parking as p where p.ptype!=? and p.pstatus!=?",new Object[]{"租用车位","租赁占用"});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parking> findAllRent() {
		return (List<Parking>)getHibernateTemplate().find("from Parking as p where p.ptype!=? and p.pstatus!=?",new Object[]{"临时车位","临时占用"});
	}



}
