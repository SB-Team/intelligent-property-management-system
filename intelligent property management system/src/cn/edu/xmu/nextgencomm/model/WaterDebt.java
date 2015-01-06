package cn.edu.xmu.nextgencomm.model;

public class WaterDebt {
	private int id;
	private Room waterDebtRoom;
	private double waterDebt;
	
	public WaterDebt()
	{}

	public WaterDebt(int id, Room waterDebtRoom, double waterDebt) {
		super();
		this.id = id;
		this.waterDebtRoom = waterDebtRoom;
		this.waterDebt = waterDebt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Room getWaterDebtRoom() {
		return waterDebtRoom;
	}

	public void setWaterDebtRoom(Room waterDebtRoom) {
		this.waterDebtRoom = waterDebtRoom;
	}

	public double getWaterDebt() {
		return waterDebt;
	}

	public void setWaterDebt(double waterDebt) {
		this.waterDebt = waterDebt;
	}
	
	
}
