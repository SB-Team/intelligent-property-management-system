package cn.edu.xmu.nextgencomm.dao;

import java.util.List;

import cn.edu.xmu.nextgencomm.model.Floor;

public interface FloorDao {
	public Floor get(Integer id);
	public Integer save(Floor floor);
	public void update(Floor floor);
	public void delete(Floor floor);
	public void delete(Integer id);
	public List<Floor> findAll();
}
