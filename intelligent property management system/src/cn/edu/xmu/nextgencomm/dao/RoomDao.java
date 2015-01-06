package cn.edu.xmu.nextgencomm.dao;

import java.util.List;

import cn.edu.xmu.nextgencomm.model.Floor;
import cn.edu.xmu.nextgencomm.model.Room;

public interface RoomDao {
	public Room get(Integer id);
	public Integer save(Room room);
	public void update(Room room);
	public void delete(Room room);
	public void delete(Integer id);
	public List<Room> findAll();
	public List<Room> findByFloor(Floor floor); 
}
