package cn.edu.xmu.nextgencomm.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.xmu.nextgencomm.model.ElecDebt;
import cn.edu.xmu.nextgencomm.model.ElecDegree;
import cn.edu.xmu.nextgencomm.model.ElecPayment;
import cn.edu.xmu.nextgencomm.model.User;
import cn.edu.xmu.nextgencomm.service.ManagerService;

public class ElecAction {
	private ElecDegree enteringElecDegree;
	private ElecDegree lastEnteringElecDegree;
	private ManagerService managerService;
	private User user;
	private ElecPayment ownerViewThisElecBill;
	private ElecDegree ownerCommunityElecDegree;
	private ElecDegree ownerBuildingElecDegree;
	private ElecDegree ownerFloorElecDegree;
	private ElecDebt ownerDebt;
	private double elecTotalWithDebt;
	
	//录入电表度数
	public String execute()
	{
		System.out.print(enteringElecDegree.getThisEnteringTime());
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//
		try {
			//将传回来的String格式化成"yyyy-MM-dd"
			enteringElecDegree.setThisEnteringTime(format.format(format.parse(enteringElecDegree.getThisEnteringTime())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将上次录入记录中的度数和时间加入本次记录
		 lastEnteringElecDegree = managerService.findLastElecDegree(enteringElecDegree.getCommunity().getId(),enteringElecDegree.getBuildingNum(),enteringElecDegree.getFloorNum(),enteringElecDegree.getRoomNum());
		managerService.calWaterPayment();
		if(lastEnteringElecDegree!=null)//找到这个表上次的录入的度数
		{
			enteringElecDegree.setLastEnteringDegree(lastEnteringElecDegree.getThisEnteringDegree());
			enteringElecDegree.setLastEnteringTime(lastEnteringElecDegree.getThisEnteringTime());
			//计算本次花费度数
			enteringElecDegree.setDegree(enteringElecDegree.getThisEnteringDegree()-enteringElecDegree.getLastEnteringDegree());
			managerService.saveEnteringElecDegree(enteringElecDegree);
			//
		}
		else//不存在上次记录
		{
			enteringElecDegree.setLastEnteringDegree(0);
			enteringElecDegree.setLastEnteringTime(null);
			enteringElecDegree.setDegree(enteringElecDegree.getThisEnteringDegree());
			managerService.saveEnteringElecDegree(enteringElecDegree);
			
		}
		return "success";
		
	}

	public String createElecBill()
	{
		managerService.calElecPayment();
		return "creatElecBill";
	}
	
	//管理员点击催缴
	public String createElecDebt()
	{
		managerService.managerMakeElecDebt();
		return "createElecDebt";
	}
	
	public String ownerViewElecBill()
	{
		ActionContext ctx = ActionContext.getContext();
		user = (User)ctx.getSession().get("user");
		System.out.print(user.getName());
		ownerViewThisElecBill = managerService.viewThisElecBill(user.getRoom());
		ctx.getSession().put("ownerViewThisElecBill",ownerViewThisElecBill);
		ownerCommunityElecDegree = managerService.findLastElecDegree(user.getRoom().getFloor().getBuilding().getCommunity().getId(),0, 0, 0);
		ctx.getSession().put("ownerCommunityElecDegree",ownerCommunityElecDegree);
		ownerBuildingElecDegree = managerService.findLastElecDegree(user.getRoom().getFloor().getBuilding().getCommunity().getId(),user.getRoom().getFloor().getBuilding().getNum(), 0, 0);
		ctx.getSession().put("ownerBuildingElecDegree",ownerBuildingElecDegree);
		ownerFloorElecDegree = managerService.findLastElecDegree(user.getRoom().getFloor().getBuilding().getCommunity().getId(),user.getRoom().getFloor().getBuilding().getNum(),user.getRoom().getFloor().getNum(), 0);
		ctx.getSession().put("ownerFloorElecDegree",ownerFloorElecDegree);
		ownerDebt = managerService.viewMyElecDebt(user.getRoom());
		ctx.getSession().put("ownerDebt",ownerDebt);
		elecTotalWithDebt = ownerViewThisElecBill.getTotal()+ ownerDebt.getElecDebt();
		ctx.getSession().put("elecTotalWithDebt",elecTotalWithDebt);
		if(ownerViewThisElecBill != null)
			return "ownerViewElecBill";
		return "notFindOwnerViewElecBill";
	}
	
	//业主点击确认支付电费账单
	public String ownerMakeElecPayment()
	{
		ActionContext ctx = ActionContext.getContext();
		user = (User)ctx.getSession().get("user");
		managerService.ownerMakeElecPayment(user.getRoom());
		return "ownerMakeElecPayment";
	}
	
	public ElecDegree getEnteringElecDegree() {
		return enteringElecDegree;
	}

	public void setEnteringElecDegree(ElecDegree enteringElecDegree) {
		this.enteringElecDegree = enteringElecDegree;
	}

	public ElecDegree getLastEnteringElecDegree() {
		return lastEnteringElecDegree;
	}

	public void setLastEnteringElecDegree(ElecDegree lastEnteringElecDegree) {
		this.lastEnteringElecDegree = lastEnteringElecDegree;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ElecPayment getOwnerViewThisElecBill() {
		return ownerViewThisElecBill;
	}

	public void setOwnerViewThisElecBill(ElecPayment ownerViewThisElecBill) {
		this.ownerViewThisElecBill = ownerViewThisElecBill;
	}

	public ElecDegree getOwnerCommunityElecDegree() {
		return ownerCommunityElecDegree;
	}

	public void setOwnerCommunityElecDegree(ElecDegree ownerCommunityElecDegree) {
		this.ownerCommunityElecDegree = ownerCommunityElecDegree;
	}

	public ElecDegree getOwnerBuildingElecDegree() {
		return ownerBuildingElecDegree;
	}

	public void setOwnerBuildingElecDegree(ElecDegree ownerBuildingElecDegree) {
		this.ownerBuildingElecDegree = ownerBuildingElecDegree;
	}

	public ElecDegree getOwnerFloorElecDegree() {
		return ownerFloorElecDegree;
	}

	public void setOwnerFloorElecDegree(ElecDegree ownerFloorElecDegree) {
		this.ownerFloorElecDegree = ownerFloorElecDegree;
	}

	public ElecDebt getOwnerDebt() {
		return ownerDebt;
	}

	public void setOwnerDebt(ElecDebt ownerDebt) {
		this.ownerDebt = ownerDebt;
	}

	public double getElecTotalWithDebt() {
		return elecTotalWithDebt;
	}

	public void setElecTotalWithDebt(double elecTotalWithDebt) {
		this.elecTotalWithDebt = elecTotalWithDebt;
	}
	
	

}
