package cn.edu.xmu.nextgencomm.model;

import java.util.HashSet;
import java.util.Set;

public class User {
	private int id;//用户id
	private String username;//用户账号
	private String password;//用户密码
	private String role;//角色
	private String name;
	private String sex;
	private int age;
	private String phone;
	private String email;
	private String address; //地址
	private String houseStatus; //房间状态
	private Community community; //关联实体Community
	private Set<Parking> parkings = new HashSet<Parking>(); //保存关联实体Parking
	private Room room; //关联实体-Room
	

	public User() 
	{
		
	}

	public User(int id, String username, String password, String role,
			String name, String sex, int age, String phone, String email,
			String address, String houseStatus, Community community,
			Set<Parking> parkings, Room room) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.houseStatus = houseStatus;
		this.community = community;
		this.parkings = parkings;
		this.room = room;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHouseStatus() {
		return houseStatus;
	}
	public void setHouseStatus(String houseStatus) {
		this.houseStatus = houseStatus;
	}
	public Set<Parking> getParkings() {
		return parkings;
	}
	public void setParkings(Set<Parking> parkings) {
		this.parkings = parkings;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}
	

}
