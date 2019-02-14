package com.candy.service.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.candy.dao.UserDao;
import com.candy.dao.impl.UserDaoImpl;
import com.candy.domain.User;
import com.candy.service.UserService;
import com.candy.utils.HibernateUtils;

public class UserServiceImpl implements UserService {
	
	private UserDao ud = new UserDaoImpl();
	
	private UserDao sud;
	
	//用户登陆
	public User getUserByCodePassword(User u) {
		//1 根据登陆名称查询登陆用户
		User existU = sud.getByUserCode(u.getUser_name());
		//2 判断用户是否存在，不存在=> 抛出异常提示用户不存在
		if(existU==null) {
			throw new RuntimeException("用户名不存在！");
		}
		//3 判断用户密码是否正确=>不正确=>抛出异常提示密码错误
		if(!existU.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("密码错误！");
		}
		//4 返回查询到的用户对象
		return existU;
	}

	
	
	public void setSud(UserDao sud) {
		this.sud = sud;
	}

	/* 未使用spring 框架
	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		ud.save(u);
		
		tx.commit();
		
		
	}
*/

	@Override
	public User getByUserCode(Integer user_id) {
		User u1 = sud.getByUserCode(user_id+"");
		return u1;
	}

	@Override
	public void save(User u) {
		sud.save(u);
	}



}
