package cn.edu.xmu.nextgencomm.dao;

import java.util.List;

import cn.edu.xmu.nextgencomm.model.Room;
import cn.edu.xmu.nextgencomm.model.WaterDebt;

public interface WaterDebtDao {
	public WaterDebt get(Integer id);
	public Integer save(WaterDebt waterDebt);
	public void update(WaterDebt waterDebt);
	public void delete(WaterDebt waterDebt);
	public void delete(Integer id);
	public List<WaterDebt> findAll();
	
	public WaterDebt findByRoom(Room room); //根据房间查水费欠费
	public void updateMyWaterDebtAfterPay(Room room); //付款后更新水费欠费
}
