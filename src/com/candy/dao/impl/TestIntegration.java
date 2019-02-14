package com.candy.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.candy.dao.UserDao;
import com.candy.domain.User;
import com.candy.service.UserService;

//测试hibernate框架
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestIntegration {
	@Resource(name="sessionFactory")
	private SessionFactory sf; 
	
	@Test
	//测试c3p0连接
	public void testHibernate() {
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		User u = new User();
		
		u.setUser_name("Susie");
		u.setUser_age(29);
		
		session.save(u);
		
		tx.commit();
		
		session.close();
	}
	
	@Resource(name="userDao")
	private UserDao ud;
	@Test
	//测试Dao， Hibernate模版
	public void testGetbyUserCode() {
		
		User u = ud.getByUserCode(5+"");
		
		System.out.println(u);
	}
	
	@Resource(name="userService")
	private UserService us;
	@Test
	//测试aop事务
	public void testSaveUser() {
		
		User u = new User();
		
		u.setUser_name("Reg");
		u.setUser_age(29);
		
		us.save(u);
	}
	
	
}
