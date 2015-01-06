package cn.edu.xmu.nextgencomm.service.impl;

import cn.edu.xmu.nextgencomm.dao.UserDao;
import cn.edu.xmu.nextgencomm.model.User;
import cn.edu.xmu.nextgencomm.service.UserService;

public class UserServiceImpl implements UserService {
	private User user;
	private UserDao userDao;

	public void setuserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public User getLogin(String username, String password) {
		user = userDao.get(username, password);
		
		if(user != null)
			return user;
		return null;
	}

}
