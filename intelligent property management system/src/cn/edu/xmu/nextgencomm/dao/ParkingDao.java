package cn.edu.xmu.nextgencomm.dao;

import java.util.List;

import cn.edu.xmu.nextgencomm.model.Parking;
import cn.edu.xmu.nextgencomm.model.TempBill;

public interface ParkingDao {
	Parking get(Integer id);
	Integer save(Parking parking);
	void update(Parking parking);
	void delete(Parking parking);
	void delete(Integer id);
	List<Parking> findAll();
	List<Parking> findAllTemp(); //找所有空闲车位
	List<Parking> findAllRent(); //找所有租用车位
	List<Parking> findTemp();//找空闲临时车位
	List<Parking> findRent();//找空闲租用车位
	Integer save(TempBill tempBill); //保存临时停车记录
	Parking findCarNum(String checkCarNum); //通过车牌找车

}
