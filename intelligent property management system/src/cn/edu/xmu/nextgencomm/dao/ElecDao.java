package cn.edu.xmu.nextgencomm.dao;

import java.util.List;

import cn.edu.xmu.nextgencomm.model.ElecDegree;

public interface ElecDao {
	public ElecDegree get(Integer id);
	public Integer save(ElecDegree elecDegree);
	public void update(ElecDegree elecDegree);
	public void delete(ElecDegree elecDegree);
	public void delete(Integer id);
	public List<ElecDegree> findAll();
	public ElecDegree findLastByPosition(int communityId, int buildingNum, int floorNum, int roomNum);
}
