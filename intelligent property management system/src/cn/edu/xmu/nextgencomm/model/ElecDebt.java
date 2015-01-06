package cn.edu.xmu.nextgencomm.model;

public class ElecDebt {
	private int id;
	private Room elecDebtRoom;
	private double elecDebt;
	
	public ElecDebt()
	{}

	public ElecDebt(int id, Room elecDebtRoom, double elecDebt) {
		super();
		this.id = id;
		this.elecDebtRoom = elecDebtRoom;
		this.elecDebt = elecDebt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Room getElecDebtRoom() {
		return elecDebtRoom;
	}

	public void setElecDebtRoom(Room elecDebtRoom) {
		this.elecDebtRoom = elecDebtRoom;
	}

	public double getElecDebt() {
		return elecDebt;
	}

	public void setElecDebt(double elecDebt) {
		this.elecDebt = elecDebt;
	}
	
	
}
