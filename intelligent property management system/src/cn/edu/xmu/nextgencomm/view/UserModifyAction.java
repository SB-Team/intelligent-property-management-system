package cn.edu.xmu.nextgencomm.view;
//import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.nextgencomm.dao.UserDao;
import cn.edu.xmu.nextgencomm.dao.impl.UserDaoImpl;

import cn.edu.xmu.nextgencomm.model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserModifyAction extends ActionSupport{
	private User user;
	private UserDao ud=new UserDaoImpl();
	public String execute()
	{
		ud.updateUser(user);
		
		//HttpServletRequest request = ServletActionContext.getRequest();
		//request.getSession().setAttribute("user", user);//将登录信息存至Session中
	    	return "success";
	}
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
