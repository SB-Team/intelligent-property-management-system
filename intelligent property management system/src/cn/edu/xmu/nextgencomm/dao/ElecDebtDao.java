package cn.edu.xmu.nextgencomm.dao;

import java.util.List;

import cn.edu.xmu.nextgencomm.model.Room;
import cn.edu.xmu.nextgencomm.model.ElecDebt;

public interface ElecDebtDao {
	public ElecDebt get(Integer id);
	public Integer save(ElecDebt elecDebt);
	public void update(ElecDebt elecDebt);
	public void delete(ElecDebt elecDebt);
	public void delete(Integer id);
	public List<ElecDebt> findAll();
	
	public ElecDebt findByRoom(Room room); //根据房间查水费欠费
	public void updateMyElecDebtAfterPay(Room room); //付款后更新欠费
}
