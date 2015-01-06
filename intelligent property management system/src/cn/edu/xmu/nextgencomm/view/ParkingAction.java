package cn.edu.xmu.nextgencomm.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.xmu.nextgencomm.model.Parking;
import cn.edu.xmu.nextgencomm.model.TempBill;
import cn.edu.xmu.nextgencomm.model.User;
import cn.edu.xmu.nextgencomm.service.ManagerService;

public class ParkingAction {
	private User user;
	private Set<Parking> myParkings; //用户查看我的车位
	private List<Parking> MParkings; //管理员查看所有车位
	private List<Parking> GParkings; //保安查看所有临时车位
	private Parking deleParking;    //管理员删除车位
	private Parking updateParking;//管理员修改车位
	private List<Parking> tempParkings;//管理员查找空闲车位
	private Parking settendParking;//管理员设置结束收费时间（开始时间在更新里直接设置）
	private ManagerService managerService;
	private String carnum; //临时停车车牌号
	private String begintime; //临时停车开始时间
	private String endtime; //临时停车结束时间
	private int hour; //临时停车时长
	private int bill; //临时停车收费
	private int gid; //选中行的index值
	private String checkcarnum; //查车牌号输入的车牌号
	private String checkownername; //临时停车查业主姓名
	private String checkownerphone;//临时停车查业主电话
	private User checkOwner;//查看临时停车对应业主信息
	private int day;//租车释放最后一次费用天数
	private String lastpaytime; //租车释放时上次收费时间
	private static String s1 = "临时占用";
	private static String s2 = "租赁占用";
	//private TempBill tempBill; //临时停车记录
	
	public String execute()
	{
		ActionContext ctx = ActionContext.getContext();
		user=(User)ctx.getSession().get("user");
		myParkings=user.getParkings();
		ctx.getSession().put("myParkings",myParkings);
		//System.out.print(myParkings);
		return "viewMyParkings";
	}
	//管理员查看所有车位
	public String getAllParkings()
	{
		ActionContext ctx = ActionContext.getContext();
		MParkings = managerService.getParkings();
		ctx.getSession().put("MParkings",MParkings);
		System.out.print(MParkings);
		return "viewAllParkings";
	}
	//管理员查看所有租用车位
		public String getAllRentParkings()
		{
			ActionContext ctx = ActionContext.getContext();
			MParkings = managerService.getAllRentParkings();
			ctx.getSession().put("MParkings",MParkings);
			System.out.print(MParkings);
			return "viewAllRentParkings";
		}
	//保安查看所有临时车位
	public String getAllTempParkings()
	{
		ActionContext ctx = ActionContext.getContext();
		GParkings = managerService.getAllTempParkings();
		ctx.getSession().put("GParkings",GParkings);
		System.out.print(GParkings);
		return "viewAllTempParkings";
	}
	
	@SuppressWarnings("unchecked")
	public String deleteParking()
	{
		ActionContext ctx = ActionContext.getContext();
		MParkings = (List<Parking>)ctx.getSession().get("MParkings");
		deleParking = MParkings.get(gid);
		System.out.print("--------========="+gid);
		
		managerService.deleteParking(deleParking);
		MParkings = managerService.getParkings();
		ctx.getSession().put("MParkings",MParkings);
		System.out.print(MParkings);
		return "deleteParking";
	}
	//保安点击开始
	@SuppressWarnings("unchecked")
	public String gettUpdateParking()
	{
		ActionContext ctx = ActionContext.getContext();
		GParkings = (List<Parking>)ctx.getSession().get("GParkings");
		updateParking = GParkings.get(gid);
		System.out.print("--------========="+gid);
        updateParking.setPbegintime(getTempTime());
        updateParking.setPstatus(s1);
		ctx.getSession().put("updateParking",updateParking);
		//System.out.print(MParkings);
		return "getUpdateParking";
	}
	
	
	//管理员点击租用
		@SuppressWarnings("unchecked")
		public String clickRentParking()
		{
			ActionContext ctx = ActionContext.getContext();
			MParkings = (List<Parking>)ctx.getSession().get("MParkings");
			updateParking = MParkings.get(gid);
			
			System.out.print("--------========="+gid);
	        updateParking.setPbegintime(getRentTime());
	        updateParking.setPstatus(s2);
			ctx.getSession().put("updateParking",updateParking);
			//System.out.print(MParkings);
			return "clickRentParking";
		}
	
	public String updateParking()
	{
		ActionContext ctx = ActionContext.getContext();
		//updateParking = (Parking)ctx.getSession().get("updateParking");
		System.out.print("--------========="+updateParking);
		System.out.print("-----------"+gid);
		System.out.print("-----------"+updateParking.getUser().getId());
		if(updateParking.getUser().getId()==0)
			updateParking.setUser(null);
		managerService.updateParking(updateParking);
		GParkings = managerService.getAllTempParkings();
		ctx.getSession().put("GParkings",GParkings);
		System.out.print(GParkings);
		//System.out.print(MParkings);
		return "updateParking";
	}
	
	public String updateRentParking()
	{
		ActionContext ctx = ActionContext.getContext();
		//updateParking = (Parking)ctx.getSession().get("updateParking");
		System.out.print("--------========="+updateParking);
		System.out.print("-----------"+gid);
		System.out.print("-----------"+updateParking.getUser().getId());
		if(updateParking.getUser().getId()==0)
			updateParking.setUser(null);
		updateParking.setPlasttime(updateParking.getPbegintime());
		managerService.updateParking(updateParking);
		MParkings = managerService.getAllRentParkings();
		ctx.getSession().put("MParkings",MParkings);
		
		return "updateRentParking";
	}
	
	//保安找空闲临时车位
	public String findTempParkings()
	{
		ActionContext ctx = ActionContext.getContext();
		GParkings = managerService.getTempParkings();
		ctx.getSession().put("GParkings",GParkings);
		System.out.print(GParkings);
		return "findTempParkings";
	}
	
	//管理员找空闲租用车位
		public String findRentParkings()
		{
			ActionContext ctx = ActionContext.getContext();
			MParkings = managerService.getRentParkings();
			ctx.getSession().put("MParkings",MParkings);
			System.out.print(MParkings);
			return "findRentParkings";
		}
	
	//保安点击结束
	@SuppressWarnings("unchecked")
	public String settendParking()
	{
		ActionContext ctx = ActionContext.getContext();
		GParkings = (List<Parking>)ctx.getSession().get("GParkings");
		settendParking = GParkings.get(gid);
		settendParking.setPendtime(getTempTime());
		hour = calTempHour(settendParking.getPbegintime(),settendParking.getPendtime());
		bill = hour * 5;//每小时收费5元
		begintime = settendParking.getPbegintime();
		endtime = settendParking.getPendtime();
		carnum = settendParking.getPcarnum();
		ctx.getSession().put("settendParking",settendParking);
		ctx.getSession().put("carnum",carnum);
		ctx.getSession().put("begintime",begintime);
		ctx.getSession().put("endtime",endtime);
		ctx.getSession().put("bill",bill);
		
		//新建一条记录
		TempBill tempBill = new TempBill();
		tempBill.setPcarnum(settendParking.getPcarnum());
		tempBill.setPhename(settendParking.getPphename());
		tempBill.setPbegintime(settendParking.getPbegintime());
		tempBill.setPendtime(settendParking.getPendtime());
		tempBill.setPhour(hour);
		tempBill.setPbill(bill);
		managerService.saveTempBill(tempBill);
		//将parking表的begintime\endtime\等清空
		settendParking.setPbegintime(null);
		settendParking.setPendtime(null);
		settendParking.setPcarnum(null);
		settendParking.setUser(null);
		settendParking.setPstatus("空");
		settendParking.setPcarnum("空");
		managerService.updateParking(settendParking);
		//MParkings.clear();
		//MParkings.add(settendParking);
		return "settendParking";
	}
	
	
	//管理员点击释放，收取最后一次费用
	@SuppressWarnings("unchecked")
	public String releaseRentParking()
	{
		ActionContext ctx = ActionContext.getContext();
		MParkings = (List<Parking>)ctx.getSession().get("MParkings");
		settendParking = MParkings.get(gid);
		settendParking.setPendtime(getRentTime());
		day = calRentDay(settendParking.getPlasttime(),settendParking.getPendtime());
		bill = day * 10;//每天收费10元
		begintime = settendParking.getPbegintime();
		endtime = settendParking.getPendtime();
		lastpaytime = settendParking.getPlasttime();
		carnum = settendParking.getPcarnum();
		ctx.getSession().put("settendParking",settendParking);
		ctx.getSession().put("carnum",carnum);
		ctx.getSession().put("begintime",begintime);
		ctx.getSession().put("endtime",endtime);
		ctx.getSession().put("lastpaytime",lastpaytime);
		ctx.getSession().put("bill",bill);
		
		//新建一条记录
		TempBill tempBill = new TempBill();
		tempBill.setPcarnum(settendParking.getPcarnum());
		tempBill.setPhename(settendParking.getPphename());
		tempBill.setPbegintime(settendParking.getPbegintime());
		tempBill.setPendtime(settendParking.getPendtime());
		tempBill.setPlasttime(settendParking.getPlasttime());
		tempBill.setPday(day);
		tempBill.setPbill(bill);
		managerService.saveTempBill(tempBill);
		//将parking表的begintime\endtime\等清空
		settendParking.setPbegintime(null);
		settendParking.setPendtime(null);
		settendParking.setPlasttime(null);
		settendParking.setPcarnum(null);
		settendParking.setUser(null);
		settendParking.setPstatus("空");
		settendParking.setPcarnum("空");
		managerService.updateParking(settendParking);
		//MParkings.clear();
		//MParkings.add(settendParking);
		return "releaseRentParking";
	}
	
	public String getTempTime()
	{
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
	
	public String getRentTime()
	{
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	//计算收费小时数
	public int calTempHour(String beginTime, String endTime)
	{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date1 = format.parse(beginTime);
			Date date2 = format.parse(endTime);
			Long iLong = date2.getTime()-date1.getTime();
			//按小时收费，不满一小时按一小时收费，每小时5元
			int tempHour = (int)(iLong%(1000*60*60)==0?iLong/(1000*60*60):iLong/(1000*60*60)+1);
			return tempHour;
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	//计算释放租用车位时最后一次的租车费用
	public int calRentDay(String beginTime, String endTime)
	{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = format.parse(beginTime);
			
			Date date2 = format.parse(endTime);
			
			int day = (int) ((date2.getTime()-date1.getTime())/(1000*3600*24));
			System.out.print(date1);
			System.out.print(date2);
			System.out.print(day);
			
			return day;
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	//查车牌
	public String checkCarNum()
	{
	
	    boolean flag = managerService.checkCarNum(checkcarnum);
	   	if(flag == true)
	   		return "checkSuccess";
	   	else
	   		return"checkFail";
	    
	}
	//临时停车查业主
	public String checkOwner()
	{
		System.out.print("----"+checkownername+checkownerphone);
		checkOwner = managerService.checkOwner(checkownername, checkownerphone);
		if(checkOwner==null)
			return "checkOwnerFail";
		else 
		{
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("checkOwner",checkOwner);
			return "checkOwnerSuccess";
		}
			
	}
	
	//管理员租车位查业主
	public String managercheckOwner()
	{
		
		checkOwner = managerService.checkOwner(checkownername, checkownerphone);
		if(checkOwner==null)
			return "managerCheckOwnerFail";
		else 
		{
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("checkOwner",checkOwner);
			return "managerCheckOwnerSuccess";
		}
			
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Parking> getMyParkings() {
		return myParkings;
	}

	public void setMyParkings(Set<Parking> myParkings) {
		this.myParkings = myParkings;
	}

	public List<Parking> getMParkings() {
		return MParkings;
	}

	public void setMParkings(List<Parking> mParkings) {
		MParkings = mParkings;
	}
	
	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public Parking getDeleParking() {
		return deleParking;
	}

	public void setDeleParking(Parking deleParking) {
		this.deleParking = deleParking;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setUpdateParking(Parking updateParking) {
		this.updateParking = updateParking;
	}
	public Parking getUpdateParking() {
		return updateParking;
	}

	public List<Parking> getTempParkings() {
		return tempParkings;
	}

	public void setTempParkings(List<Parking> tempParkings) {
		this.tempParkings = tempParkings;
	}

	public Parking getSettendParking() {
		return settendParking;
	}

	public void setSettendParking(Parking settendParking) {
		this.settendParking = settendParking;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}

	public String getCarnum() {
		return carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getCheckcarnum() {
		return checkcarnum;
	}

	public void setCheckcarnum(String checkcarnum) {
		this.checkcarnum = checkcarnum;
	}

	public String getCheckownername() {
		return checkownername;
	}

	public void setCheckownername(String checkownername) {
		this.checkownername = checkownername;
	}

	public String getCheckownerphone() {
		return checkownerphone;
	}

	public void setCheckownerphone(String checkownerphone) {
		this.checkownerphone = checkownerphone;
	}

	public User getCheckOwner() {
		return checkOwner;
	}

	public void setCheckOwner(User checkOwner) {
		this.checkOwner = checkOwner;
	}
	
	public List<Parking> getGParkings() {
		return GParkings;
	}
	public void setGParkings(List<Parking> gParkings) {
		GParkings = gParkings;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getLastpaytime() {
		return lastpaytime;
	}
	public void setLastpaytime(String lastpaytime) {
		this.lastpaytime = lastpaytime;
	}

	
	
	/*public TempBill getTempBill() {
		return tempBill;
	}

	public void setTempBill(TempBill tempBill) {
		this.tempBill = tempBill;
	}*/

	
	
	

}
