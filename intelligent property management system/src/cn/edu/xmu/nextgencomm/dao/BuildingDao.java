package cn.edu.xmu.nextgencomm.dao;

import java.util.List;
import cn.edu.xmu.nextgencomm.model.Building;
import cn.edu.xmu.nextgencomm.model.Community;

public interface BuildingDao {
	public Building get(Integer id);
	public Integer save(Building building);
	public void update(Building building);
	public void delete(Building building);
	public void delete(Integer id);
	public List<Building> findAll();
	public List<Building> findByCommunity(Community community);
}
