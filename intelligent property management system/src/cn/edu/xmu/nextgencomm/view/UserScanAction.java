package cn.edu.xmu.nextgencomm.view;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.edu.xmu.nextgencomm.model.User;
import cn.edu.xmu.nextgencomm.service.UserService;


public class UserScanAction extends ActionSupport {
	private User user;
	private static String OWNER = "业主";
	private static String MANAGER = "办公室管理人员";
	private static String GUARD = "保安";

	public String execute()
	{
		ActionContext ctx = ActionContext.getContext();
		user=(User)ctx.getSession().get("user");
		if(user.getRole().equals(OWNER))
			return "owner";
		else if(user.getRole().equals(MANAGER))
			return "manager";
		else if(user.getRole().equals(GUARD))
			return "guard";
		return "input";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}






}
