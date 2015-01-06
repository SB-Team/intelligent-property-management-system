package cn.edu.xmu.nextgencomm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xmu.nextgencomm.dao.RoomDao;
import cn.edu.xmu.nextgencomm.model.Floor;
import cn.edu.xmu.nextgencomm.model.Room;

public class RoomDaoImpl extends HibernateDaoSupport implements RoomDao{

	@Override
	public Room get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Room.class, id);
	}

	@Override
	public Integer save(Room room) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(room);
	}

	@Override
	public void update(Room room) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(room);
	}

	@Override
	public void delete(Room room) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(room);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> findAll() {
		// TODO Auto-generated method stub
		return (List<Room>)getHibernateTemplate().find("from Room");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> findByFloor(Floor floor) {
		// TODO Auto-generated method stub
		return (List<Room>)getHibernateTemplate().find("from Room r where r.floor=?",floor);
	}

}
