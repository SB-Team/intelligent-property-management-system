package cn.edu.xmu.nextgencomm.model;
//水表度数只对应一个实体，例如是小区总表或楼总表或层表或房间表
public class WaterDegree {
	private int id;
	private String lastEnteringTime; //上次抄表时间
	private String thisEnteringTime; //本次抄表时间
	private int lastEnteringDegree; //上次抄表度数
	private int thisEnteringDegree; //本次抄表度数
	private int degree; //本期所用度数
	private Community community; //关联实体--小区
	private int buildingNum; //楼号
	private int floorNum; //层号
	private int roomNum; //房号
	private WaterPayment roomWaterPayment; //对应房间费用
	
	public WaterDegree()
	{}

	public WaterDegree(int id, String lastEnteringTime,
			String thisEnteringTime, int lastEnteringDegree,
			int thisEnteringDegree, int degree, Community community,
			int buildingNum, int floorNum, int roomNum,
			WaterPayment roomWaterPayment) {
		super();
		this.id = id;
		this.lastEnteringTime = lastEnteringTime;
		this.thisEnteringTime = thisEnteringTime;
		this.lastEnteringDegree = lastEnteringDegree;
		this.thisEnteringDegree = thisEnteringDegree;
		this.degree = degree;
		this.community = community;
		this.buildingNum = buildingNum;
		this.floorNum = floorNum;
		this.roomNum = roomNum;
		this.roomWaterPayment = roomWaterPayment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastEnteringTime() {
		return lastEnteringTime;
	}

	public void setLastEnteringTime(String lastEnteringTime) {
		this.lastEnteringTime = lastEnteringTime;
	}

	public String getThisEnteringTime() {
		return thisEnteringTime;
	}

	public void setThisEnteringTime(String thisEnteringTime) {
		this.thisEnteringTime = thisEnteringTime;
	}

	public int getLastEnteringDegree() {
		return lastEnteringDegree;
	}

	public void setLastEnteringDegree(int lastEnteringDegree) {
		this.lastEnteringDegree = lastEnteringDegree;
	}

	public int getThisEnteringDegree() {
		return thisEnteringDegree;
	}

	public void setThisEnteringDegree(int thisEnteringDegree) {
		this.thisEnteringDegree = thisEnteringDegree;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	public int getBuildingNum() {
		return buildingNum;
	}

	public void setBuildingNum(int buildingNum) {
		this.buildingNum = buildingNum;
	}

	public int getFloorNum() {
		return floorNum;
	}

	public void setFloorNum(int floorNum) {
		this.floorNum = floorNum;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public WaterPayment getRoomWaterPayment() {
		return roomWaterPayment;
	}

	public void setRoomWaterPayment(WaterPayment roomWaterPayment) {
		this.roomWaterPayment = roomWaterPayment;
	}

	
}
