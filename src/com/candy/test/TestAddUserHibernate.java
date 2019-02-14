package com.candy.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.candy.domain.User;
import com.candy.utils.HibernateUtils;

public class TestAddUserHibernate {

	@Test
	public void addUser() {
		Session session = HibernateUtils.openSession();
		
		Transaction tx = session.beginTransaction();
		
		User u = new User();
		u.setUser_name("Candy");
		u.setUser_age(26);
		
		session.save(u);
		
		tx.commit();
		
		session.close();
		
	}
	
}
