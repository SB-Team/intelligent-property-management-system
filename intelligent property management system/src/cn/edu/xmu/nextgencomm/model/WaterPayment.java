package cn.edu.xmu.nextgencomm.model;

public class WaterPayment {
	private int id;
	//private WaterDegree communityDegree; //对应社区分摊水费表
	private double communityPayment; //社区分摊水费
	//private WaterDegree buildingDegree; //对应楼分摊水费表
	private double buildingPayment; //楼分摊水费
	//private WaterDegree floorDegree; //对应层分摊水费表
	private double floorPayment; //层分摊水费
	private WaterDegree roomDegree; //对应房间分摊水费表
	private double roomPayment; //房间水费
	private int isPay; //是否付费，1代表已付费，0代表未付费
	private Room room; //对应所属房间
	private double total; //水费总价
	private String day; //生成账单日期
	
	public WaterPayment()
	{}


	public WaterPayment(int id, double communityPayment,
			double buildingPayment, double floorPayment,
			WaterDegree roomDegree, double roomPayment, int isPay, Room room,
			double total, String day) {
		super();
		this.id = id;
		this.communityPayment = communityPayment;
		this.buildingPayment = buildingPayment;
		this.floorPayment = floorPayment;
		this.roomDegree = roomDegree;
		this.roomPayment = roomPayment;
		this.isPay = isPay;
		this.room = room;
		this.total = total;
		this.day = day;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getCommunityPayment() {
		return communityPayment;
	}


	public void setCommunityPayment(double communityPayment) {
		this.communityPayment = communityPayment;
	}


	public double getBuildingPayment() {
		return buildingPayment;
	}


	public void setBuildingPayment(double buildingPayment) {
		this.buildingPayment = buildingPayment;
	}


	public double getFloorPayment() {
		return floorPayment;
	}


	public void setFloorPayment(double floorPayment) {
		this.floorPayment = floorPayment;
	}


	public WaterDegree getRoomDegree() {
		return roomDegree;
	}


	public void setRoomDegree(WaterDegree roomDegree) {
		this.roomDegree = roomDegree;
	}


	public double getRoomPayment() {
		return roomPayment;
	}


	public void setRoomPayment(double roomPayment) {
		this.roomPayment = roomPayment;
	}


	public int getIsPay() {
		return isPay;
	}


	public void setIsPay(int isPay) {
		this.isPay = isPay;
	}


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}

}
