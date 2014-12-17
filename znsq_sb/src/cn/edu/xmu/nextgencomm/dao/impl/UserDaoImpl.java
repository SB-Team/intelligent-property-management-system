package cn.edu.xmu.nextgencomm.dao.impl;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

import com.mysql.jdbc.log.Log;

import cn.edu.xmu.nextgencomm.action.HibernateSessionFactory;
import cn.edu.xmu.nextgencomm.dao.UserDao;
import cn.edu.xmu.nextgencomm.entity.Owner;
import cn.edu.xmu.nextgencomm.entity.User;

public class UserDaoImpl implements UserDao {
	public User getLogin(String username,String password)
	{
		Session session = null;
		System.out.print(username+password);
		
	      String hql = "from User u where u.username='" + username + "' and u.password='"+password+"'";
	      User user = null;
	      try {
	    	  session = HibernateSessionFactory.getSession();
	          Query query = session.createQuery(hql);
	          user = (User) query.uniqueResult();
	      } catch (Exception e) {
	          System.out.println(e.getMessage());
	      }
	      HibernateSessionFactory.closeSession();
	      return user;
	}

	@Override
	public boolean isExistUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getUserid(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectUserInfo(int id) {
		Session session = null;
		String hql = "from User u where u.id='" + id + "'";
	      User userinfo = null;
	      try {
	    	  session = HibernateSessionFactory.getSession();
	          Query query = session.createQuery(hql);
	          userinfo = (User)query.uniqueResult();
	      } catch (Exception e) {
	          System.out.println(e.getMessage());
	      }
	      HibernateSessionFactory.closeSession();
	      return userinfo;
	}

	@Override
	public void updateUser(User user) {
		Session session = null;
	       Transaction tx = null;
	       try {
	    	   session=HibernateSessionFactory.getSession();
	           tx = session.beginTransaction();  
	           session.update(user);//修改数据
	           tx.commit();
	       } catch (Exception e) {
	           System.err.println("修改信息出错!："+e);
	       } finally {
	           HibernateSessionFactory.closeSession();
	       }
	}

	//保存用户
	@Override
	public int saveUser(User user) {
		int num=0;  //记录是否保存成功
		Session session=null;
		Transaction transaction=null;
		try{
			session=HibernateSessionFactory.getSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(user).toString());
			transaction.commit();
		}catch(Exception e){
			num=0;
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return num;
		
	}

	//查询所用用户信息
	@Override
	public List<User> getUsers() {
		List<User> users=new ArrayList<User>();
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			users=session.createQuery("from User order by id").list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return users;
	}
}
