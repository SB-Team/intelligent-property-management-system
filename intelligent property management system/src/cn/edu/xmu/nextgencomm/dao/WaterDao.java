package cn.edu.xmu.nextgencomm.dao;

import java.util.List;

import cn.edu.xmu.nextgencomm.model.WaterDegree;


public interface WaterDao {
	public WaterDegree get(Integer id);
	public Integer save(WaterDegree waterDegree);
	public void update(WaterDegree waterDegree);
	public void delete(WaterDegree waterDegree);
	public void delete(Integer id);
	public List<WaterDegree> findAll();
	
	public WaterDegree findLastByPosition(int communityId, int buildingNum,
			int floorNum, int roomNum);
}
