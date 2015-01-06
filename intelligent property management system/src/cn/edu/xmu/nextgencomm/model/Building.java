package cn.edu.xmu.nextgencomm.model;

import java.util.HashSet;
import java.util.Set;

public class Building {
	private int id;
	private int num; //楼号
	private Community community; //关联实体小区
	private Set<Floor> floors = new HashSet<Floor>(); //保存关联实体Floor
	//private Set<WaterDegree> waterDegrees = new HashSet<WaterDegree>(); //关联水度数表
	
	public Building(){}

	public Building(int id, int num, Community community, Set<Floor> floors) {
		super();
		this.id = id;
		this.num = num;
		this.community = community;
		this.floors = floors;
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



	public Community getCommunity() {
		return community;
	}



	public void setCommunity(Community community) {
		this.community = community;
	}

	public Set<Floor> getFloors() {
		return floors;
	}

	public void setFloors(Set<Floor> floors) {
		this.floors = floors;
	}
	
	
}
