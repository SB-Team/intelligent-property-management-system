package cn.edu.xmu.nextgencomm.service;

import java.util.List;

import cn.edu.xmu.nextgencomm.model.Building;
import cn.edu.xmu.nextgencomm.model.Community;
import cn.edu.xmu.nextgencomm.model.ElecDebt;
import cn.edu.xmu.nextgencomm.model.ElecDegree;
import cn.edu.xmu.nextgencomm.model.ElecPayment;
import cn.edu.xmu.nextgencomm.model.Floor;
import cn.edu.xmu.nextgencomm.model.Parking;
import cn.edu.xmu.nextgencomm.model.Room;
import cn.edu.xmu.nextgencomm.model.TempBill;
import cn.edu.xmu.nextgencomm.model.User;
import cn.edu.xmu.nextgencomm.model.WaterDebt;
import cn.edu.xmu.nextgencomm.model.WaterDegree;
import cn.edu.xmu.nextgencomm.model.WaterPayment;



public interface ManagerService {
	public List<Parking> getParkings(); //查看所有车位
	public void deleteParking(Parking parking);
	public void updateParking(Parking parking);
	public List<Parking> getTempParkings();  //找空闲临时车位  
	public List<Parking> getRentParkings();  //找空闲租用车位  
	public List<Parking> getAllRentParkings(); //查看所有租用车位
	public List<Parking> getAllTempParkings(); //查所有临时空闲车位
	public void saveTempBill(TempBill tempBill);
	public boolean checkCarNum(String carNum); //查车牌号
	public User checkOwner(String name,String phone); //临时停车时查业主
	
	public void saveEnteringWaterDegree(WaterDegree waterDegree); //保存录入的水表数据
	//查询上次录入水表数据
	public WaterDegree findLastWaterDegree(int communityId, int buildingNum, int floorNum,int roomNum);
	//生成本期水费账单
	public void calWaterPayment();
	//计算每户水费
	public double calRoomWaterPayment(Room room);
	//计算层公摊水费
	public double calFloorWaterPayment(Floor floor);
	//计算楼公摊水费
	public double calBuildingWaterPayment(Building building);
	//计算小区公摊水费
	public double calCommunityWaterPayment(Community community);
	//业主查看当月水费账单
	public WaterPayment viewThisWaterBill(Room room);
	//查看水费欠费
	public WaterDebt viewMyWaterDebt(Room room);
	//业主付费后将欠费置零，账单is_pay置一
	public void ownerMakeWaterPayment(Room room);
	//管理员点击水费催缴
	public void managerMakeWaterDebt();
	//计算水费滞纳金
	public double calWaterTax(WaterPayment waterPayment);
	//保留一位小数方法
	public double changeDouble(double d);
	//查询上次录入电表数据
	public ElecDegree findLastElecDegree(int communityId, int buildingNum, int floorNum,int roomNum);
	//保存录入的电表数据
	public void saveEnteringElecDegree(ElecDegree elecDegree);
	//生成本期电费账单
	public void calElecPayment();
	//计算每户电费
	public double calRoomElecPayment(Room room);
	//计算层公摊电费
	public double calFloorElecPayment(Floor floor);
	//计算楼公摊电费
	public double calBuildingElecPayment(Building building);
	//计算小区公摊电费
	public double calCommunityElecPayment(Community community);
	//管理员点击电费催缴
	public void managerMakeElecDebt();
	//计算水费滞纳金
	public double calElecTax(ElecPayment elecPayment);
	//业主查看当月水费账单
	public ElecPayment viewThisElecBill(Room room);
	//查看水费欠费
	public ElecDebt viewMyElecDebt(Room room);
	//业主付费后将欠费置零，账单is_pay置一
	public void ownerMakeElecPayment(Room room);
	//获取当前时间
	public String getRentTime();
}
