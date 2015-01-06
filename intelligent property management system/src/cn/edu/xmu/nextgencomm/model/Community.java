package cn.edu.xmu.nextgencomm.model;

import java.util.HashSet;
import java.util.Set;

public class Community {
	private int id;
	private String name;
	private String area;
	private Set<Building> buildings = new HashSet<Building>(); //保存关联实体Building
	private Set<WaterDegree> waterDegrees = new HashSet<WaterDegree>(); //关联水度数表
	private Set<User> users = new HashSet<User>(); //关联实体User
	
	
	public Community()
	{}

	public Community(int id, String name, String area, Set<Building> buildings,
			Set<WaterDegree> waterDegrees, Set<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.buildings = buildings;
		this.waterDegrees = waterDegrees;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public Set<Building> getBuildings() {
		return buildings;
	}



	public void setBuildings(Set<Building> buildings) {
		this.buildings = buildings;
	}


	public Set<WaterDegree> getWaterDegrees() {
		return waterDegrees;
	}


	public void setWaterDegrees(Set<WaterDegree> waterDegrees) {
		this.waterDegrees = waterDegrees;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
