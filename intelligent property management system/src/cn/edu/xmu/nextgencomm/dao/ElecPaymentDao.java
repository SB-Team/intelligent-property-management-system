package cn.edu.xmu.nextgencomm.dao;

import java.util.List;

import cn.edu.xmu.nextgencomm.model.ElecDegree;
import cn.edu.xmu.nextgencomm.model.Room;
import cn.edu.xmu.nextgencomm.model.ElecPayment;

public interface ElecPaymentDao {
	public ElecPayment get(Integer id);
	public Integer save(ElecPayment elecPayment);
	public void update(ElecPayment elecPayment);
	public void delete(ElecPayment elecPayment);
	public void delete(Integer id);
	public List<ElecPayment> findAll();
	public List<ElecPayment> findMyAllBill(Room room);
	public ElecPayment findMyLastBill(Room room);
	public ElecPayment findByRoomElecDegree(ElecDegree roomElecDegree);
	public void updateIsPay(Room room);
}
