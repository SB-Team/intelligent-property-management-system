package cn.edu.xmu.nextgencomm.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.ActionContext;
//import java.util.Date;
import cn.edu.xmu.nextgencomm.model.User;
import cn.edu.xmu.nextgencomm.model.WaterDebt;
import cn.edu.xmu.nextgencomm.model.WaterDegree;
import cn.edu.xmu.nextgencomm.model.WaterPayment;
import cn.edu.xmu.nextgencomm.service.ManagerService;

public class WaterAction {

	private WaterDegree enteringWaterDegree;
	private WaterDegree lastEnteringWaterDegree;
	private WaterPayment ownerViewThisWaterBill;
	private WaterDegree ownerCommunityWaterDegree;
	private WaterDegree ownerBuildingWaterDegree;
	private WaterDegree ownerFloorWaterDegree;
	private WaterDebt ownerDebt;
	private ManagerService managerService;
	private User user;
	private double waterTotalWithDebt;
	
	//录入水表度数
	public String execute()
	{
		System.out.print(enteringWaterDegree.getThisEnteringTime());
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//
		try {
			//将传回来的String格式化成"yyyy-MM-dd"
			enteringWaterDegree.setThisEnteringTime(format.format(format.parse(enteringWaterDegree.getThisEnteringTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将上次录入记录中的度数和时间加入本次记录
		lastEnteringWaterDegree = managerService.findLastWaterDegree(enteringWaterDegree.getCommunity().getId(),enteringWaterDegree.getBuildingNum(),enteringWaterDegree.getFloorNum(),enteringWaterDegree.getRoomNum());
		managerService.calWaterPayment();
		if(lastEnteringWaterDegree!=null)//找到这个表上次的录入的度数
		{
			enteringWaterDegree.setLastEnteringDegree(lastEnteringWaterDegree.getThisEnteringDegree());
			enteringWaterDegree.setLastEnteringTime(lastEnteringWaterDegree.getThisEnteringTime());
			//计算本次花费度数
			enteringWaterDegree.setDegree(enteringWaterDegree.getThisEnteringDegree()-enteringWaterDegree.getLastEnteringDegree());
			managerService.saveEnteringWaterDegree(enteringWaterDegree);
			//
			
		}
		else//记录表中不存在上次录入的记录
		{
			enteringWaterDegree.setLastEnteringDegree(0);
			enteringWaterDegree.setLastEnteringTime(null);
			enteringWaterDegree.setDegree(enteringWaterDegree.getThisEnteringDegree());
			managerService.saveEnteringWaterDegree(enteringWaterDegree);
		}
		return "success";	
		
	}

	public String createWaterBill()
	{
		managerService.calWaterPayment();
		return "creatWaterBill";
	}
	
	public String ownerViewWaterBill()
	{
		ActionContext ctx = ActionContext.getContext();
		user = (User)ctx.getSession().get("user");
		System.out.print(user.getName());
		ownerViewThisWaterBill = managerService.viewThisWaterBill(user.getRoom());
		ctx.getSession().put("ownerViewThisWaterBill",ownerViewThisWaterBill);
		ownerCommunityWaterDegree = managerService.findLastWaterDegree(user.getRoom().getFloor().getBuilding().getCommunity().getId(),0, 0, 0);
		ctx.getSession().put("ownerCommunityWaterDegree",ownerCommunityWaterDegree);
		ownerBuildingWaterDegree = managerService.findLastWaterDegree(user.getRoom().getFloor().getBuilding().getCommunity().getId(),user.getRoom().getFloor().getBuilding().getNum(), 0, 0);
		ctx.getSession().put("ownerBuildingWaterDegree",ownerBuildingWaterDegree);
		ownerFloorWaterDegree = managerService.findLastWaterDegree(user.getRoom().getFloor().getBuilding().getCommunity().getId(),user.getRoom().getFloor().getBuilding().getNum(),user.getRoom().getFloor().getNum(), 0);
		ctx.getSession().put("ownerFloorWaterDegree",ownerFloorWaterDegree);
		ownerDebt = managerService.viewMyWaterDebt(user.getRoom());
		ctx.getSession().put("ownerDebt",ownerDebt);
		waterTotalWithDebt = ownerViewThisWaterBill.getTotal()+ ownerDebt.getWaterDebt();
		ctx.getSession().put("waterTotalWithDebt",waterTotalWithDebt);
		if(ownerViewThisWaterBill != null)
			return "ownerViewWaterBill";
		return "notFindOwnerViewWaterBill";
	}

	//业主点击确认支付水费账单
	public String ownerMakeWaterPayment()
	{
		ActionContext ctx = ActionContext.getContext();
		user = (User)ctx.getSession().get("user");
		managerService.ownerMakeWaterPayment(user.getRoom());
		return "ownerMakeWaterPayment";
	}
	//管理员点击生成欠费
	public String createWaterDebt()
	{
		managerService.managerMakeWaterDebt();
		return "createWaterDebt";
	}
	
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}


	public WaterDegree getEnteringWaterDegree() {
		return enteringWaterDegree;
	}

	public void setEnteringWaterDegree(WaterDegree enteringWaterDegree) {
		this.enteringWaterDegree = enteringWaterDegree;
	}

	public WaterDegree getLastEnteringWaterDegree() {
		return lastEnteringWaterDegree;
	}

	public void setLastEnteringWaterDegree(WaterDegree lastEnteringWaterDegree) {
		this.lastEnteringWaterDegree = lastEnteringWaterDegree;
	}

	public WaterPayment getOwnerViewThisWaterBill() {
		return ownerViewThisWaterBill;
	}

	public void setOwnerViewThisWaterBill(WaterPayment ownerViewThisWaterBill) {
		this.ownerViewThisWaterBill = ownerViewThisWaterBill;
	}

	public WaterDegree getOwnerCommunityWaterDegree() {
		return ownerCommunityWaterDegree;
	}

	public void setOwnerCommunityWaterDegree(WaterDegree ownerCommunityWaterDegree) {
		this.ownerCommunityWaterDegree = ownerCommunityWaterDegree;
	}

	
	public WaterDegree getOwnerBuildingWaterDegree() {
		return ownerBuildingWaterDegree;
	}

	public void setOwnerBuildingWaterDegree(WaterDegree ownerBuildingWaterDegree) {
		this.ownerBuildingWaterDegree = ownerBuildingWaterDegree;
	}

	public WaterDegree getOwnerFloorWaterDegree() {
		return ownerFloorWaterDegree;
	}

	public void setOwnerFloorWaterDegree(WaterDegree ownerFloorWaterDegree) {
		this.ownerFloorWaterDegree = ownerFloorWaterDegree;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public WaterDebt getOwnerDebt() {
		return ownerDebt;
	}

	public void setOwnerDebt(WaterDebt ownerDebt) {
		this.ownerDebt = ownerDebt;
	}

	public double getWaterTotalWithDebt() {
		return waterTotalWithDebt;
	}

	public void setWaterTotalWithDebt(double waterTotalWithDebt) {
		this.waterTotalWithDebt = waterTotalWithDebt;
	}
	
	
}
