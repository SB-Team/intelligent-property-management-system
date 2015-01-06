package cn.edu.xmu.nextgencomm.view;

import java.util.List;

//import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.nextgencomm.dao.UserDao;
import cn.edu.xmu.nextgencomm.dao.impl.UserDaoImpl;
import cn.edu.xmu.nextgencomm.model.User;

import com.opensymphony.xwork2.ActionSupport;

public class ManageUserAction extends ActionSupport{
	private User newUser;
	UserDao ud=new UserDaoImpl();
	private List<User> userList;
	
	public String execute()throws Exception{
		ud.saveUser(newUser);
		return SUCCESS;
	}
	public String getUsers(){
		userList=ud.getUsers();
		//HttpServletRequest request = ServletActionContext.getRequest();
		//request.getSession().setAttribute("userList", userList);
		return "list";
	}
	public User getNewUser() {
		return newUser;
	}
	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
