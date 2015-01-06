package cn.edu.xmu.nextgencomm.dao;

import java.util.List;
import cn.edu.xmu.nextgencomm.model.Community;

public interface CommunityDao {
	public Community get(Integer id);
	public Integer save(Community community);
	public void update(Community community);
	public void delete(Community community);
	public void delete(Integer id);
	public List<Community> findAll();
	//public List<Building> findAllBuildings(Community community); //找小区对应的所有楼
}
