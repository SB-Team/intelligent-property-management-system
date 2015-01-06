package cn.edu.xmu.nextgencomm.view;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.edu.xmu.nextgencomm.model.User;
import cn.edu.xmu.nextgencomm.service.UserService;

public class LoginAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UserService userService;
	private static String OWNER = "业主";
	private static String MANAGER = "办公室管理人员";
	private static String GUARD = "保安";
	private static String SUPER = "超级管理员";
	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	
	public String execute() {
		//获取登录用户
		System.out.print(user.getUsername()+user.getPassword());
		user=userService.getLogin(user.getUsername(), user.getPassword());
		//创建ActionContext实例
		
		if(user != null){
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("user", user);//将登录信息存至Session中
			
			if(user.getRole().equals(OWNER))
				return "owner";
			else if(user.getRole().equals(MANAGER))
				return "manager";
			else if(user.getRole().equals(GUARD))
				return "guard";
			else if(user.getRole().equals(SUPER))
				return "super";
			
		}
		
		this.addFieldError("error", "用户名或密码不正确，请重新输入！");
		return INPUT;
		
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
