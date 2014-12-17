package cn.edu.xmu.nextgencomm.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.edu.xmu.nextgencomm.dao.impl.UserDaoImpl;
import cn.edu.xmu.nextgencomm.dao.UserDao;

import cn.edu.xmu.nextgencomm.entity.Owner;
import cn.edu.xmu.nextgencomm.entity.User;

public class UserScanAction extends ActionSupport {
	private User user;
	private UserDao ud=new UserDaoImpl();
	public String execute()
	{
		//获取登录用户
		HttpServletRequest request = ServletActionContext.getRequest();
		user=(User)request.getSession().getAttribute("user");
		return "success";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}






}
