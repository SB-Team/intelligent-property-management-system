package cn.edu.xmu.nextgencomm.service.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import cn.edu.xmu.nextgencomm.dao.ElecDao;
import cn.edu.xmu.nextgencomm.dao.ElecDebtDao;
import cn.edu.xmu.nextgencomm.dao.ElecPaymentDao;
import cn.edu.xmu.nextgencomm.dao.ParkingDao;
import cn.edu.xmu.nextgencomm.dao.RoomDao;
import cn.edu.xmu.nextgencomm.dao.UserDao;
import cn.edu.xmu.nextgencomm.dao.WaterDao;
import cn.edu.xmu.nextgencomm.dao.WaterDebtDao;
import cn.edu.xmu.nextgencomm.dao.WaterPaymentDao;
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
import cn.edu.xmu.nextgencomm.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	private ParkingDao parkingDao;
	private UserDao userDao;
	private WaterDao waterDao;
	private ElecDao elecDao;
	private ElecDebtDao elecDebtDao;
	private RoomDao roomDao;
	private WaterPaymentDao waterPaymentDao;
	private ElecPaymentDao elecPaymentDao;
	private WaterDebtDao waterDebtDao;
	private List<Parking> parkingList;
	private List<Parking> tempList;
	private List<Parking> rentList;
	private List<Parking> allTempList;
	private List<Parking> allRentList;
	private Parking checkCar; //查车牌号
	private User checkOwner; //临时停车查看业主
	private WaterDegree lastWaterDegree;
	private List<Room> roomList;
    private WaterPayment ownerViewWaterPayment; //业主查看水费当月账单
    private WaterDebt myWaterDebt;
    private ElecDegree lastElecDegree;
    private ElecPayment ownerViewElecPayment; //业主查看当月电费账单
    private ElecDebt myElecDebt;
    
	
	public void setParkingDao(ParkingDao parkingDao) {
		this.parkingDao = parkingDao;
	}

	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	
	public void setWaterDao(WaterDao waterDao) {
		this.waterDao = waterDao;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	public void setWaterPaymentDao(WaterPaymentDao waterPaymentDao) {
		this.waterPaymentDao = waterPaymentDao;
	}
	public void setElecPaymentDao(ElecPaymentDao elecPaymentDao) {
		this.elecPaymentDao = elecPaymentDao;
	}

	public void setWaterDebtDao(WaterDebtDao waterDebtDao) {
		this.waterDebtDao = waterDebtDao;
	}
	
	public void setElecDebtDao(ElecDebtDao elecDebtDao) {
		this.elecDebtDao = elecDebtDao;
	}
	
	public void setElecDao(ElecDao elecDao) {
		this.elecDao = elecDao;
	}
	
	@Override
	public List<Parking> getParkings() {
		parkingList=parkingDao.findAll();
		return parkingList;
	}

	@Override
	public void deleteParking(Parking parking) {
		parkingDao.delete(parking);
		
	}

	@Override
	public void updateParking(Parking parking) {
		parkingDao.update(parking);
		
	}

	@Override
	public List<Parking> getTempParkings() {
		tempList=parkingDao.findTemp();
		return tempList;
	}
 
	@Override
	public List<Parking> getRentParkings() {
		rentList=parkingDao.findRent();
		return rentList;
	}
	
	@Override
	public void saveTempBill(TempBill tempBill) {
		parkingDao.save(tempBill);
		
	}

	//查车牌号
	@Override
	public boolean checkCarNum(String carNum) {
		checkCar = parkingDao.findCarNum(carNum);
		if(checkCar == null)
			return false;
		else
			return true;

	}

	//临时停车查业主
	@Override
	public User checkOwner(String name, String phone) {
		System.out.print("----"+name+phone);

		checkOwner = userDao.findByNameAndPhone(name, phone);
		if(checkOwner == null)
			return null;
		else
			return checkOwner;
	}

	@Override
	public List<Parking> getAllTempParkings() {
		allTempList=parkingDao.findAllTemp();
		return allTempList;
	}

	@Override
	public List<Parking> getAllRentParkings() {
		allRentList = parkingDao.findAllRent();
		return allRentList;
	}

	@Override
	public void saveEnteringWaterDegree(WaterDegree waterDegree) {
		// TODO Auto-generated method stub
		waterDao.save(waterDegree);
	}

	@Override
	public WaterDegree findLastWaterDegree(int communityId, int buildingNum,
			int floorNum, int roomNum) {
		// TODO Auto-generated method stub
		lastWaterDegree = waterDao.findLastByPosition(communityId,buildingNum,floorNum,roomNum);
		return lastWaterDegree;
	}


	@Override
	public void calWaterPayment() {
		roomList = roomDao.findAll();
		WaterPayment waterPayment = new WaterPayment();
		
		for(Room value : roomList){  
			if(value.getUser()!=null)//有人入住的
			{
				
				
				waterPayment.setRoomPayment(calRoomWaterPayment(value));//每户水费
				waterPayment.setRoom(value);
				WaterDegree waterDegree = waterDao.findLastByPosition(value.getFloor().getBuilding().getCommunity().getId(), value.getFloor().getBuilding().getNum(), value.getFloor().getNum(), value.getRoomnum());
				waterPayment.setRoomDegree(waterDegree); 
				waterPayment.setIsPay(0);//未付费
				waterPayment.setFloorPayment(calFloorWaterPayment(value.getFloor()));//层水费公摊
				waterPayment.setBuildingPayment(calBuildingWaterPayment(value.getFloor().getBuilding()));//楼公摊水费
				waterPayment.setCommunityPayment(calCommunityWaterPayment(value.getFloor().getBuilding().getCommunity()));//小区公摊水费
				waterPayment.setTotal(waterPayment.getCommunityPayment()+waterPayment.getBuildingPayment()+waterPayment.getFloorPayment()+waterPayment.getRoomPayment());//
				waterPayment.setDay(getRentTime());
				if(waterPaymentDao.findByRoomDegree(waterPayment.getRoomDegree()) == null)
					waterPaymentDao.save(waterPayment);//该期没有生成过账单才存进数据库
				

			}
            
            
        } 
		
	}
	
	public String getRentTime()
	{
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	@Override
	public double calRoomWaterPayment(Room room) {
		// TODO Auto-generated method stub
		WaterDegree waterDegree = waterDao.findLastByPosition(room.getFloor().getBuilding().getCommunity().getId(), room.getFloor().getBuilding().getNum(), room.getFloor().getNum(), room.getRoomnum());
		
		if(waterDegree!=null)
		{
			int degree = waterDegree.getDegree();
			//按阶梯计算水费，没超过15吨部分按2.5元计算，超过15吨按3.3元计算
			if(degree<=15)
				return (degree*2.5);
			else
				return (15*2.5+(degree-15)*3.3);
			
		}
		else
			return 0;
	}
	
	public double calFloorWaterPayment(Floor floor)
	{
		WaterDegree waterDegree = waterDao.findLastByPosition(floor.getBuilding().getCommunity().getId(),floor.getBuilding().getNum(),floor.getNum(),0);
		WaterDegree roomWaterDegree = null; //记录该层每户水表本次所用度数
		if(waterDegree!=null)
		{
			int degree = waterDegree.getDegree();
			//层水费按每层户均摊，公摊水费每吨3.3元	
			Set<Room> set = floor.getRooms();
			int number = 0; //记录每层入住户数
			for(Room value : set)
			{
				if(value.getUser()!=null) 
				{
					number++; //分摊户数加一
					roomWaterDegree = waterDao.findLastByPosition(value.getFloor().getBuilding().getCommunity().getId(), value.getFloor().getBuilding().getNum(), value.getFloor().getNum(), value.getRoomnum());
					if(roomWaterDegree!=null)
						degree -= roomWaterDegree.getDegree(); //层总表减去每户表算层分摊
				}
					
			}
			
			double i = (degree*3.3/(number*1.0));
			System.out.print("----------"+i);
			return i;
			
		}
		return 0;
	}
	
	public double calBuildingWaterPayment(Building building)
	{
		WaterDegree waterDegree = waterDao.findLastByPosition(building.getCommunity().getId(),building.getNum(),0,0);
		WaterDegree floorWaterDegree = null; //记录该楼每层所用度数
		if(waterDegree!=null)
		{
			int degree = waterDegree.getDegree();
			//楼水费按每楼每户户均摊，公摊水费每吨3.3元
			Set<Floor> set = building.getFloors();
			int number = 0; //记录该楼已入住户数
			for(Floor value : set)
			{
				floorWaterDegree = waterDao.findLastByPosition(value.getBuilding().getCommunity().getId(),value.getBuilding().getNum(),value.getNum(),0);
				if(floorWaterDegree!=null)
					degree -= floorWaterDegree.getDegree();//楼总表减去每层表算楼分摊
				Set<Room> roomSet = value.getRooms();
				for(Room roomValue : roomSet)
				{
					if(roomValue.getUser()!= null) 
						number++;
				}
			}
			double i = (degree*3.3/(number*1.0));
			//System.out.print("----------"+i);
			return i;
		}
		return 0;
	}
	
	public double calCommunityWaterPayment(Community community)
	{
		WaterDegree waterDegree = waterDao.findLastByPosition(community.getId(),0,0,0);
		WaterDegree buildingWaterDegree = null; //记录该小区每栋楼所用度数
		if(waterDegree!=null)
		{
			int degree = waterDegree.getDegree();
			//小区水费按每楼每户户均摊，公摊水费每吨3.3元
			Set<Building> set = community.getBuildings();
			int number = 0; //记录该小区已入住户数
			for(Building value : set)
			{
				buildingWaterDegree = waterDao.findLastByPosition(value.getCommunity().getId(),value.getNum(),0,0);
				if(buildingWaterDegree!=null)
					degree -= buildingWaterDegree.getDegree();//小区总表减去每楼表算小区分摊
				Set<Floor> floorSet = value.getFloors();
				for(Floor floorValue : floorSet)
				{
					Set<Room> roomSet = floorValue.getRooms();
					for(Room roomValue : roomSet)
					{
						if(roomValue.getUser()!= null) 
							number++;
					}
				}
			}
			double i = (degree*3.3/(number*1.0));
			//System.out.print("----------"+i);
			return i;
		}
		return 0;
	}
	
	public double changeDouble(double d)
	{
		BigDecimal bg = new BigDecimal(d);  
        double d1 = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();  
        return d1;
	}

	@Override
	public WaterPayment viewThisWaterBill(Room room) {
		ownerViewWaterPayment = waterPaymentDao.findMyLastBill(room);
		return ownerViewWaterPayment;
	}

	@Override
	public WaterDebt viewMyWaterDebt(Room room) {
		myWaterDebt = waterDebtDao.findByRoom(room);
		return myWaterDebt;
	}

	@Override
	public void ownerMakeWaterPayment(Room room) {
		// TODO Auto-generated method stub
		waterPaymentDao.updateIsPay(room); 
		waterDebtDao.updateMyWaterDebtAfterPay(room);
	}
	//管理员催缴水费
	@Override
	public void managerMakeWaterDebt() {
		// TODO Auto-generated method stub
		roomList = roomDao.findAll();
		
		WaterDebt waterDebt = new WaterDebt();
		WaterDebt newWaterDebt = new WaterDebt();
		double newDebt = 0; //本次添加的欠费数目
		
		for(Room value : roomList){  
			if(value.getUser()!=null)//有人入住的
			{
				List<WaterPayment> paymentList = waterPaymentDao.findMyAllBill(value);
				waterDebt = waterDebtDao.findByRoom(value);
				if(waterDebt != null)
				{
					for(WaterPayment payment : paymentList)
					{
						if(payment!=null && payment.getIsPay() == 0)
						{
							//计算滞纳金
							double tax = calWaterTax(payment);
							newDebt += (payment.getTotal() + tax);
							
						}
					}
					newDebt += waterDebt.getWaterDebt();
					System.out.println("newDebt="+newDebt);
					waterDebt.setWaterDebt(newDebt);
					waterDebtDao.update(waterDebt);
					newDebt = 0;
				}
				else
				{
					for(WaterPayment payment : paymentList)
					{
						if(payment!=null && payment.getIsPay() == 0)
						{
							//计算滞纳金
							double tax = calWaterTax(payment);
							newDebt += (payment.getTotal() + tax);
							
						}
					}
					System.out.println("newDebt="+newDebt);
					newWaterDebt.setWaterDebt(newDebt);
					newWaterDebt.setWaterDebtRoom(value);
					waterDebtDao.save(newWaterDebt);
					newDebt = 0;
				}
			}
		}
	}
	
	//计算水费滞纳金,账单生成5天后收滞纳金，从滞纳之日起每天加收所欠金额3%滞纳金
	public double calWaterTax(WaterPayment waterPayment)
	{
		if(waterPayment != null)
		{
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date1 = format.parse(waterPayment.getDay());
				
				Date date2 = new Date();
				
				int day = (int) ((date2.getTime()-date1.getTime())/(1000*3600*24));
				System.out.print(date1);
				System.out.print(date2);
				System.out.print(day);
				double tax = waterPayment.getTotal() * (day - 5) * 0.03;
				return tax;
			} 
			catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return 0;
	}

	@Override
	public ElecDegree findLastElecDegree(int communityId, int buildingNum,
			int floorNum, int roomNum) {
		// TODO Auto-generated method stub
		lastElecDegree = elecDao.findLastByPosition(communityId,buildingNum,floorNum,roomNum);
		return lastElecDegree;
	}

	@Override
	public void saveEnteringElecDegree(ElecDegree elecDegree) {
		// TODO Auto-generated method stub
		elecDao.save(elecDegree);
	}

	@Override
	public void calElecPayment() {
		// TODO Auto-generated method stub
		roomList = roomDao.findAll();
		ElecPayment elecPayment = new ElecPayment();
		
		for(Room value : roomList){  
			if(value.getUser()!=null)//有人入住的
			{
				elecPayment.setRoomPayment(calRoomElecPayment(value));//每户水费
				elecPayment.setRoom(value);
				ElecDegree elecDegree = elecDao.findLastByPosition(value.getFloor().getBuilding().getCommunity().getId(), value.getFloor().getBuilding().getNum(), value.getFloor().getNum(), value.getRoomnum());
				elecPayment.setRoomElecDegree(elecDegree); 
				elecPayment.setIsPay(0);//未付费
				elecPayment.setFloorPayment(calFloorElecPayment(value.getFloor()));//层水费公摊
				elecPayment.setBuildingPayment(calBuildingElecPayment(value.getFloor().getBuilding()));//楼公摊水费
				elecPayment.setCommunityPayment(calCommunityElecPayment(value.getFloor().getBuilding().getCommunity()));//小区公摊水费
				elecPayment.setTotal(elecPayment.getCommunityPayment()+elecPayment.getBuildingPayment()+elecPayment.getFloorPayment()+elecPayment.getRoomPayment());//
				elecPayment.setDay(getRentTime());
				if(elecPaymentDao.findByRoomElecDegree(elecPayment.getRoomElecDegree()) == null)
					elecPaymentDao.save(elecPayment);//该期没有生成过账单才存进数据库
				

			}
            
            
        } 
		
	}

	@Override
	public double calRoomElecPayment(Room room) {
		// TODO Auto-generated method stub
		ElecDegree elecDegree = elecDao.findLastByPosition(room.getFloor().getBuilding().getCommunity().getId(), room.getFloor().getBuilding().getNum(), room.getFloor().getNum(), room.getRoomnum());
		
		if(elecDegree!=null)
		{
			int degree = elecDegree.getDegree();
			//按阶梯计算电费，没超过200度部分按0.5元计算，超过200度按0.6元计算
			if(degree<=200)
				return (degree*0.5);
			else
				return (200*0.5+(degree-200)*0.6);
			
		}
		else
			return 0;
	}

	@Override
	public double calFloorElecPayment(Floor floor) {
		// TODO Auto-generated method stub
		ElecDegree elecDegree = elecDao.findLastByPosition(floor.getBuilding().getCommunity().getId(),floor.getBuilding().getNum(),floor.getNum(),0);
		ElecDegree roomElecDegree = null; //记录该层每户水表本次所用度数
		if(elecDegree!=null)
		{
			int degree = elecDegree.getDegree();
			//层水费按每层户均摊，公摊水费每吨3.3元	
			Set<Room> set = floor.getRooms();
			int number = 0; //记录每层入住户数
			for(Room value : set)
			{
				if(value.getUser()!=null) 
				{
					number++; //分摊户数加一
					roomElecDegree = elecDao.findLastByPosition(value.getFloor().getBuilding().getCommunity().getId(), value.getFloor().getBuilding().getNum(), value.getFloor().getNum(), value.getRoomnum());
					if(roomElecDegree!=null)
						degree -= roomElecDegree.getDegree(); //层总表减去每户表算层分摊
				}
					
			}
			
			double i = (degree*0.5/(number*1.0));
			System.out.print("----------"+i);
			return i;
		}
		return 0;
	}

	@Override
	public double calBuildingElecPayment(Building building) {
		// TODO Auto-generated method stub
		ElecDegree elecDegree = elecDao.findLastByPosition(building.getCommunity().getId(),building.getNum(),0,0);
		ElecDegree floorElecDegree = null; //记录该楼每层所用度数
		if(elecDegree!=null)
		{
			int degree = elecDegree.getDegree();
			//楼水费按每楼每户户均摊，公摊水费每吨3.3元
			Set<Floor> set = building.getFloors();
			int number = 0; //记录该楼已入住户数
			for(Floor value : set)
			{
				floorElecDegree = elecDao.findLastByPosition(value.getBuilding().getCommunity().getId(),value.getBuilding().getNum(),value.getNum(),0);
				if(floorElecDegree!=null)
					degree -= floorElecDegree.getDegree();//楼总表减去每层表算楼分摊
				Set<Room> roomSet = value.getRooms();
				for(Room roomValue : roomSet)
				{
					if(roomValue.getUser()!= null) 
						number++;
				}
			}
			double i = (degree*0.5/(number*1.0));//公用电费0.5元每度
			//System.out.print("----------"+i);
			return i;	
		}
		return 0;
	}

	@Override
	public double calCommunityElecPayment(Community community) {
		// TODO Auto-generated method stub
		ElecDegree elecDegree = elecDao.findLastByPosition(community.getId(),0,0,0);
		ElecDegree buildingElecDegree = null; //记录该小区每栋楼所用度数
		if(elecDegree!=null)
		{
			int degree = elecDegree.getDegree();
			//小区水费按每楼每户户均摊，公摊水费每吨3.3元
			Set<Building> set = community.getBuildings();
			int number = 0; //记录该小区已入住户数
			for(Building value : set)
			{
				buildingElecDegree = elecDao.findLastByPosition(value.getCommunity().getId(),value.getNum(),0,0);
				if(buildingElecDegree!=null)
					degree -= buildingElecDegree.getDegree();//小区总表减去每楼表算小区分摊
				Set<Floor> floorSet = value.getFloors();
				for(Floor floorValue : floorSet)
				{
					Set<Room> roomSet = floorValue.getRooms();
					for(Room roomValue : roomSet)
					{
						if(roomValue.getUser()!= null) 
							number++;
					}
				}
			}
			double i = (degree*0.5/(number*1.0)); //公用电费0.5元每度
			//System.out.print("----------"+i);
			return i;
		}
		return 0;
	}

	@Override
	public void managerMakeElecDebt() {
		// TODO Auto-generated method stub
		roomList = roomDao.findAll();
		
		ElecDebt elecDebt = new ElecDebt();
		ElecDebt newElecDebt = new ElecDebt();
		double newDebt = 0; //本次添加的欠费数目
		
		for(Room value : roomList){  
			if(value.getUser()!=null)//有人入住的
			{
				List<ElecPayment> paymentList = elecPaymentDao.findMyAllBill(value);
				elecDebt = elecDebtDao.findByRoom(value);
				if(elecDebt != null)
				{
					for(ElecPayment payment : paymentList)
					{
						if(payment!=null && payment.getIsPay() == 0)
						{
							//计算滞纳金
							double tax = calElecTax(payment);
							newDebt += (payment.getTotal() + tax);
							
						}
					}
					newDebt += elecDebt.getElecDebt();
					System.out.println("newDebt="+newDebt);
					elecDebt.setElecDebt(newDebt);
					elecDebtDao.update(elecDebt);
					newDebt = 0;
				}
				else
				{
					for(ElecPayment payment : paymentList)
					{
						if(payment!=null && payment.getIsPay() == 0)
						{
							//计算滞纳金
							double tax = calElecTax(payment);
							newDebt += (payment.getTotal() + tax);
							
						}
					}
					System.out.println("newDebt="+newDebt);
					newElecDebt.setElecDebt(newDebt);
					newElecDebt.setElecDebtRoom(value);
					elecDebtDao.save(newElecDebt);
					newDebt = 0;
				}
			}
		}
	}

	@Override
	public double calElecTax(ElecPayment elecPayment) {
		if(elecPayment != null)
		{
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date1 = format.parse(elecPayment.getDay());
				
				Date date2 = new Date();
				
				int day = (int) ((date2.getTime()-date1.getTime())/(1000*3600*24));
				System.out.print(date1);
				System.out.print(date2);
				System.out.print(day);
				double tax = elecPayment.getTotal() * (day - 5) * 0.03;
				return tax;
			} 
			catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return 0;
	}

	@Override
	public ElecPayment viewThisElecBill(Room room) {
		// TODO Auto-generated method stub
		ownerViewElecPayment = elecPaymentDao.findMyLastBill(room);
		return ownerViewElecPayment;
	}

	@Override
	public ElecDebt viewMyElecDebt(Room room) {
		// TODO Auto-generated method stub
		myElecDebt = elecDebtDao.findByRoom(room);
		return myElecDebt;
	}

	@Override
	public void ownerMakeElecPayment(Room room) {
		// TODO Auto-generated method stub
		elecPaymentDao.updateIsPay(room); 
		elecDebtDao.updateMyElecDebtAfterPay(room);
	}


}
