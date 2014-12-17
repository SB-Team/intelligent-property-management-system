package cn.edu.xmu.nextgencomm.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.edu.xmu.nextgencomm.dao.impl.UserDaoImpl;
import cn.edu.xmu.nextgencomm.dao.UserDao;
import cn.edu.xmu.nextgencomm.entity.Owner;
import cn.edu.xmu.nextgencomm.entity.User;

public class LoginAction extends ActionSupport{
	private User user;
	private UserDao ud=new UserDaoImpl();
	private String signStr="";
	
	public String execute() {
		//获取登录用户
		System.out.print(user.getUsername()+user.getPassword());
		user=ud.getLogin(user.getUsername(), user.getPassword());
		
		if(user==null)
		{
			this.addFieldError("error", "用户名或密码不正确，请重新输入！");
			return INPUT;
		}
		else
		{
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("user", user);//将登录信息存至Session中
			return SUCCESS;
		}
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
