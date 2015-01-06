package cn.edu.xmu.nextgencomm.model;

import java.util.HashSet;
import java.util.Set;

public class Floor {
	private int id;
	private int num;
	private Building building; //关联实体——楼
	private Set<Room> rooms = new HashSet<Room>(); //保存关联实体--房间
	//private Set<WaterDegree> waterDegrees = new HashSet<WaterDegree>(); //关联水度数表
	
    public Floor()
    {}

	public Floor(int id, int num, Building building, Set<Room> rooms) {
		super();
		this.id = id;
		this.num = num;
		this.building = building;
		this.rooms = rooms;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

}
