package cn.edu.xmu.nextgencomm.service;

import java.util.List;

import cn.edu.xmu.nextgencomm.model.Building;
import cn.edu.xmu.nextgencomm.model.Community;
import cn.edu.xmu.nextgencomm.model.Floor;
import cn.edu.xmu.nextgencomm.model.Room;

public interface SuperService {
	public void addCommunity(Community community);
	public void addBuilding(Building building);
	public void addFloor(Floor floor);
	public void addRoom(Room room);
	public List<Community> viewAllCommunities();
	public void deleteCommunity(Community deleteCommunity); 
	public void deleteBuilding(Building building);
	public List<Building> viewAllBuildingAfterDelete(Community community);
	public List<Room> viewAllRoomAfterAdd(Floor floor);
	//public List<Building> viewMyAllBuildings(Community community);
}
