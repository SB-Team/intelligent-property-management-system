package cn.edu.xmu.nextgencomm.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.xmu.nextgencomm.model.Building;
import cn.edu.xmu.nextgencomm.model.Community;
import cn.edu.xmu.nextgencomm.model.Floor;
import cn.edu.xmu.nextgencomm.model.Room;
import cn.edu.xmu.nextgencomm.service.SuperService;

public class CommunityAction {
	private Community newCommunity;
	private Community deleteCommunity;
	private Community addBuildingCommunity;
	private List<Community> allCommunities;
	private List<Building> allBuildings = new ArrayList<Building>();
	private Set<Building> allMyBuildings;
	private SuperService superService;
	private Building newBuilding;
	private Building deleteBuilding = new Building();
	private Floor newFloor=new Floor();
	private Set<Floor> allMyFloors;
	private List<Floor> allFloors = new ArrayList<Floor>();
	private Set<Room> allMyRooms;
	private List<Room> allRooms = new ArrayList<Room>();
	private Room newRoom = new Room();
	private int floorNum; //新添加楼的楼层数
	private int gid; //选中行的index值
	
	public String execute()
	{
		return "success";
	}

	//添加小区
	public String addCommunity()
	{
		superService.addCommunity(newCommunity);
		return "addCommunity";
	}
	
	//查看所有小区
	public String viewAllCommunities()
	{
		allCommunities = superService.viewAllCommunities();
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put("allCommunities",allCommunities);
		return "viewAllCommunities";
	}

	//删除小区
	@SuppressWarnings("unchecked")
	public String deleteCommunity()
	{
		ActionContext ctx = ActionContext.getContext();
		allCommunities = (List<Community>)ctx.getSession().get("allCommunities");
		deleteCommunity = allCommunities.get(gid);
		superService.deleteCommunity(deleteCommunity);
		allCommunities = superService.viewAllCommunities();
		ctx.getSession().put("allCommunities",allCommunities);
		return "deleteCommunity";
	}
	
	@SuppressWarnings("unchecked")
	public String viewAllBuildings()
	{
		ActionContext ctx = ActionContext.getContext();
		allCommunities = (List<Community>)ctx.getSession().get("allCommunities");
		addBuildingCommunity = allCommunities.get(gid);
		allMyBuildings = addBuildingCommunity.getBuildings();
		ctx.getSession().put("allMyBuildings",allMyBuildings);
		ctx.getSession().put("addBuildingCommunity",addBuildingCommunity);
		return "viewAllBuildings";
	}
	
	@SuppressWarnings("unchecked")
	public String addBuilding()
	{
		ActionContext ctx = ActionContext.getContext();
		addBuildingCommunity = (Community)ctx.getSession().get("addBuildingCommunity");
		newBuilding.setCommunity(addBuildingCommunity);
		superService.addBuilding(newBuilding);
		for(int i=1;i<=floorNum;i++)
		{
			newFloor.setNum(i);
			newFloor.setBuilding(newBuilding);
			superService.addFloor(newFloor);
		}
		allBuildings = superService.viewAllBuildingAfterDelete(addBuildingCommunity);
		allMyBuildings = (Set<Building>)ctx.getSession().get("allMyBuildings");
		allMyBuildings.clear();
		for(Building value : allBuildings)
		{
			allMyBuildings.add(value);
		}
		ctx.getSession().put("allMyBuildings",allMyBuildings);
		
		return "addBuilding";
	}
	
	@SuppressWarnings("unchecked")
	public String deleteBuilding()
	{
		ActionContext ctx = ActionContext.getContext();
		allMyBuildings = (Set<Building>)ctx.getSession().get("allMyBuildings");
		for(Building value : allMyBuildings)
		{
			allBuildings.add(value);
		}
		deleteBuilding = allBuildings.get(gid);
		superService.deleteBuilding(deleteBuilding);
		addBuildingCommunity = (Community)ctx.getSession().get("addBuildingCommunity");
		allBuildings = superService.viewAllBuildingAfterDelete(addBuildingCommunity);
		allMyBuildings.clear();
		for(Building value : allBuildings)
		{
			allMyBuildings.add(value);
		}
		ctx.getSession().put("allMyBuildings",allMyBuildings);
		ctx.getSession().put("addBuildingCommunity",addBuildingCommunity);
		return "deleteBuilding";
	}
	
	@SuppressWarnings("unchecked")
	public String viewAllFloors()
	{
		ActionContext ctx = ActionContext.getContext();
		allMyBuildings = (Set<Building>)ctx.getSession().get("allMyBuildings");
		allBuildings.clear();
		for(Building value : allMyBuildings)
		{
			allBuildings.add(value);
		}
		newBuilding = allBuildings.get(gid);
		allMyFloors = newBuilding.getFloors();
		ctx.getSession().put("allMyFloors",allMyFloors);
		return "viewAllFloors";
	}
	
	@SuppressWarnings("unchecked")
	public String viewAllRooms()
	{
		ActionContext ctx = ActionContext.getContext();
		allMyFloors = (Set<Floor>)ctx.getSession().get("allMyFloors");
		allFloors.clear();
		for(Floor value : allMyFloors)
		{
			allFloors.add(value);
		}
		newFloor = allFloors.get(gid);
		allMyRooms = newFloor.getRooms();
		ctx.getSession().put("allMyRooms", allMyRooms);
		ctx.getSession().put("newFloor", newFloor);
		return "viewAllRooms";
	}
	
	@SuppressWarnings("unchecked")
	public String addRoom()
	{
		ActionContext ctx = ActionContext.getContext();
		newFloor = (Floor)ctx.getSession().get("newFloor");
		newRoom.setFloor(newFloor);
		newRoom.setUser(null);
		superService.addRoom(newRoom);
		allRooms = superService.viewAllRoomAfterAdd(newFloor);
		allMyRooms = (Set<Room>)ctx.getSession().get("allMyRooms");
		allMyRooms.clear();
		for(Room value : allRooms)
		{
			allMyRooms.add(value);
		}
		ctx.getSession().put("allMyRooms",allMyRooms);
		return "addRoom";
	}
	
	public List<Building> getAllBuildings() {
		return allBuildings;
	}

	public void setAllBuildings(List<Building> allBuildings) {
		this.allBuildings = allBuildings;
	}

	public Building getDeleteBuilding() {
		return deleteBuilding;
	}

	public void setDeleteBuilding(Building deleteBuilding) {
		this.deleteBuilding = deleteBuilding;
	}

	public Set<Floor> getAllMyFloors() {
		return allMyFloors;
	}

	public void setAllMyFloors(Set<Floor> allMyFloors) {
		this.allMyFloors = allMyFloors;
	}

	public List<Floor> getAllFloors() {
		return allFloors;
	}

	public void setAllFloors(List<Floor> allFloors) {
		this.allFloors = allFloors;
	}

	public Set<Room> getAllMyRooms() {
		return allMyRooms;
	}

	public void setAllMyRooms(Set<Room> allMyRooms) {
		this.allMyRooms = allMyRooms;
	}

	public List<Room> getAllRooms() {
		return allRooms;
	}

	public void setAllRooms(List<Room> allRooms) {
		this.allRooms = allRooms;
	}

	public Room getNewRoom() {
		return newRoom;
	}

	public void setNewRoom(Room newRoom) {
		this.newRoom = newRoom;
	}

	public Community getNewCommunity() {
		return newCommunity;
	}

	public void setNewCommunity(Community newCommunity) {
		this.newCommunity = newCommunity;
	}

	public SuperService getSuperService() {
		return superService;
	}

	public void setSuperService(SuperService superService) {
		this.superService = superService;
	}
	public Community getDeleteCommunity() {
		return deleteCommunity;
	}
	public void setDeleteCommunity(Community deleteCommunity) {
		this.deleteCommunity = deleteCommunity;
	}
	public List<Community> getAllCommunities() {
		return allCommunities;
	}
	public void setAllCommunities(List<Community> allCommunities) {
		this.allCommunities = allCommunities;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}

	public Community getAddBuildingCommunity() {
		return addBuildingCommunity;
	}

	public void setAddBuildingCommunity(Community addBuildingCommunity) {
		this.addBuildingCommunity = addBuildingCommunity;
	}

	public Set<Building> getAllMyBuildings() {
		return allMyBuildings;
	}

	public void setAllMyBuildings(Set<Building> allMyBuildings) {
		this.allMyBuildings = allMyBuildings;
	}

	public Building getNewBuilding() {
		return newBuilding;
	}

	public void setNewBuilding(Building newBuilding) {
		this.newBuilding = newBuilding;
	}

	public Floor getNewFloor() {
		return newFloor;
	}

	public void setNewFloor(Floor newFloor) {
		this.newFloor = newFloor;
	}

	public int getFloorNum() {
		return floorNum;
	}

	public void setFloorNum(int floorNum) {
		this.floorNum = floorNum;
	}
	
}
