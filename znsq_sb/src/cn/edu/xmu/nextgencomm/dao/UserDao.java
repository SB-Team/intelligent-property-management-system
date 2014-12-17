package cn.edu.xmu.nextgencomm.dao;

import java.util.List;

import cn.edu.xmu.nextgencomm.entity.Owner;
import cn.edu.xmu.nextgencomm.entity.User;

public interface UserDao {
	public User getLogin(String username,String password); //所有用户—--登录
	boolean isExistUsername(String username);
	int getUserid(String username,String password);
	public User selectUserInfo(int id);
	public void updateUser(User user);//修改业主个人信息
	public int saveUser(User user);//添加用户————管理员
	public List<User> getUsers();//获取所用用户————管理员
}
