package cn.edu.xmu.nextgencomm.view;

//import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ExitAction extends ActionSupport{
	public String execute(){
		//HttpServletRequest request = ServletActionContext.getRequest();
		//request.getSession().removeAttribute("user");
		//request.getSession().invalidate();
		return SUCCESS;
	}
}
