package cn.edu.xmu.nextgencomm.dao;

import java.util.List;

import cn.edu.xmu.nextgencomm.model.Room;
import cn.edu.xmu.nextgencomm.model.WaterDegree;
import cn.edu.xmu.nextgencomm.model.WaterPayment;

public interface WaterPaymentDao {
	public WaterPayment get(Integer id);
	public Integer save(WaterPayment waterPayment);
	public void update(WaterPayment waterPayment);
	public void delete(WaterPayment waterPayment);
	public void delete(Integer id);
	public List<WaterPayment> findAll();
	public WaterPayment findMyLastBill(Room room);
	public List<WaterPayment> findMyAllBill(Room room);
	public WaterPayment findByRoomDegree(WaterDegree roomDegree);
	public void updateIsPay(Room room);
}
