	package cn.edu.xmu.nextgencomm.dao.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.edu.xmu.nextgencomm.dao.UserDao;
import cn.edu.xmu.nextgencomm.model.User;


public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	public User getLogin(String username,String password)
	{
//		Session session = null;
//		System.out.print(username+password);
//		
//	      String hql = "from User u where u.username='" + username + "' and u.password='"+password+"'";
	      User user = null;
//	      try {
//	    	  session = HibernateSessionFactory.getSession();
//	          Query query = session.createQuery(hql);
//	          user = (User) query.uniqueResult();
//	      } catch (Exception e) {
//	          System.out.println(e.getMessage());
//	      }
//	      HibernateSessionFactory.closeSession();
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
	
	      User userinfo = null;
//	      try {
//	    	  session = HibernateSessionFactory.getSession();
//	          Query query = session.createQuery(hql);
//	          userinfo = (User)query.uniqueResult();
//	      } catch (Exception e) {
//	          System.out.println(e.getMessage());
//	      }
//	      HibernateSessionFactory.closeSession();
	      return userinfo;
	}

	@Override
	public void updateUser(User user) {
//		Session session = null;
//	       Transaction tx = null;
//	       try {
//	    	   session=HibernateSessionFactory.getSession();
//	           tx = session.beginTransaction();  
//	           session.update(user);//修改数据
//	           tx.commit();
//	       } catch (Exception e) {
//	           System.err.println("修改信息出错!："+e);
//	       } finally {
//	           HibernateSessionFactory.closeSession();
//	       }
	}

	//保存用户
	@Override
	public int saveUser(User user) {
		int num=0;  //记录是否保存成功
//		Session session=null;
//		Transaction transaction=null;
//		try{
//			session=HibernateSessionFactory.getSession();
//			transaction=session.beginTransaction();
//			num=Integer.parseInt(session.save(user).toString());
//			transaction.commit();
//		}catch(Exception e){
//			num=0;
//			e.printStackTrace();
//		}finally{
//			HibernateSessionFactory.closeSession();
//		}
		return num;
		
	}

	//查询所用用户信息
	@Override
	public List<User> getUsers() {
		List<User> users=new ArrayList<User>();
//		Session session=null;
//		try{
//			session=HibernateSessionFactory.getSession();
//			users=session.createQuery("from User order by id").list();
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			HibernateSessionFactory.closeSession();
//		}
		return users;
	}

	public User get(Integer id)
	{
		return getHibernateTemplate().get(User.class, id);
	}
	
	public Integer save(User user)
	{
		return (Integer)getHibernateTemplate().save(user);
	}
	
	public void update(User user)
	{
		getHibernateTemplate().update(user);
	}
	
	public void delete(User user)
	{
		getHibernateTemplate().delete(user);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAll()
	{
		return (List<User>)getHibernateTemplate().find("from User");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}


	@Override
	public User get(String username,String password) {
		User u = null;
		try{
			u = (User)getHibernateTemplate().find("from User as u where u.username=? and u.password=?",new Object[]{username,password}).get(0);
			return u;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public User findByNameAndPhone(String name, String phone) {
		User u = null;
		try{
			u = (User)getHibernateTemplate().find("from User as u where u.name=? and u.phone=? and role=?",new Object[]{name,phone,"业主"}).get(0);
			return u;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}
	
}
