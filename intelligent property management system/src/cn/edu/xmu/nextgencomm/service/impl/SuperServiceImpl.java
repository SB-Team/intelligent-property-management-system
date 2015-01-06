package cn.edu.xmu.nextgencomm.service.impl;

import java.util.List;

import cn.edu.xmu.nextgencomm.dao.BuildingDao;
import cn.edu.xmu.nextgencomm.dao.CommunityDao;
import cn.edu.xmu.nextgencomm.dao.FloorDao;
import cn.edu.xmu.nextgencomm.dao.RoomDao;
import cn.edu.xmu.nextgencomm.model.Building;
import cn.edu.xmu.nextgencomm.model.Community;
import cn.edu.xmu.nextgencomm.model.Floor;
import cn.edu.xmu.nextgencomm.model.Room;
import cn.edu.xmu.nextgencomm.service.SuperService;

public class SuperServiceImpl implements SuperService{

	private CommunityDao communityDao;
	private BuildingDao buildingDao;
	private FloorDao floorDao;
	private RoomDao roomDao;
	private List<Community> allCommunities;
	private List<Building> allBuildings;
	private List<Room> allRooms;
	
	
	public void setCommunityDao(CommunityDao communityDao) {
		this.communityDao = communityDao;
	}

	public void setBuildingDao(BuildingDao buildingDao) {
		this.buildingDao = buildingDao;
	}

	public void setFloorDao(FloorDao floorDao) {
		this.floorDao = floorDao;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Override
	public void addCommunity(Community community) {
		// TODO Auto-generated method stub
		communityDao.save(community);
	}

	@Override
	public List<Community> viewAllCommunities() {
		// TODO Auto-generated method stub
		allCommunities = communityDao.findAll();
		return allCommunities;
	}

	@Override
	public void deleteCommunity(Community deleteCommunity) {
		// TODO Auto-generated method stub
		communityDao.delete(deleteCommunity);
	}

	@Override
	public void addBuilding(Building building) {
		// TODO Auto-generated method stub
		buildingDao.save(building);
	}

	@Override
	public void addFloor(Floor floor) {
		// TODO Auto-generated method stub
		floorDao.save(floor);
	}

	@Override
	public void deleteBuilding(Building building) {
		// TODO Auto-generated method stub
		buildingDao.delete(building);
	}

	@Override
	public List<Building> viewAllBuildingAfterDelete(Community community) {
		// TODO Auto-generated method stub
		allBuildings = buildingDao.findByCommunity(community);
		return allBuildings;
	}

	@Override
	public void addRoom(Room room) {
		// TODO Auto-generated method stub
		roomDao.save(room);
	}

	@Override
	public List<Room> viewAllRoomAfterAdd(Floor floor) {
		// TODO Auto-generated method stub
		allRooms = roomDao.findByFloor(floor);
		return allRooms;
	}

}
