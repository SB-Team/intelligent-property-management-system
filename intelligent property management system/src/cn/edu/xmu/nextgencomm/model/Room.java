package cn.edu.xmu.nextgencomm.model;

import java.util.HashSet;
import java.util.Set;

public class Room {
	private int id; //自增id
	private int roomnum; //房间号
	private String roomarea; //面积
	private Floor floor; //关联实体FLOOR
	private User user; //关联实体User
	private WaterDebt waterDebt; //关联实体WaterDebt
	private ElecDebt elecDebt; //关联实体ElecDebt
	//private Set<WaterDegree> waterDegrees = new HashSet<WaterDegree>(); //关联水度数表 
	private Set<WaterPayment> waterPayments = new HashSet<WaterPayment>(); //关联水费用表
	private Set<ElecPayment> elecPayments = new HashSet<ElecPayment>(); //关联电费用表
	//private Community community; //关联实体Community
	
	public Room()
	{}


	public Room(int id, int roomnum, String roomarea,
			Floor floor, User user, WaterDebt waterDebt, ElecDebt elecDebt,
			Set<WaterPayment> waterPayments, Set<ElecPayment> elecPayments) {
		super();
		this.id = id;
		this.roomnum = roomnum;
		this.roomarea = roomarea;
		this.floor = floor;
		this.user = user;
		this.waterDebt = waterDebt;
		this.elecDebt = elecDebt;
		this.waterPayments = waterPayments;
		this.elecPayments = elecPayments;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}

	public String getRoomarea() {
		return roomarea;
	}


	public void setRoomarea(String roomarea) {
		this.roomarea = roomarea;
	}


	public Floor getFloor() {
		return floor;
	}


	public void setFloor(Floor floor) {
		this.floor = floor;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Set<WaterPayment> getWaterPayments() {
		return waterPayments;
	}



	public void setWaterPayments(Set<WaterPayment> waterPayments) {
		this.waterPayments = waterPayments;
	}

	public WaterDebt getWaterDebt() {
		return waterDebt;
	}

	public void setWaterDebt(WaterDebt waterDebt) {
		this.waterDebt = waterDebt;
	}


	public ElecDebt getElecDebt() {
		return elecDebt;
	}


	public void setElecDebt(ElecDebt elecDebt) {
		this.elecDebt = elecDebt;
	}


	public Set<ElecPayment> getElecPayments() {
		return elecPayments;
	}


	public void setElecPayments(Set<ElecPayment> elecPayments) {
		this.elecPayments = elecPayments;
	}

}
