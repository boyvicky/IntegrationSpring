package com.candy.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.candy.dao.UserDao;
import com.candy.domain.User;
import com.candy.utils.HibernateUtils;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	/* 未使用spring框架
	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		
		session.save(u);
		
	}
	*/

	public User getByUserCode(final String usercode) {
		//HQL  第一种方法
/*		return getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				String hql = "from MyUser where user_id = ?";
				Query query = session.createQuery(hql);
				query.setParameter(0, usercode);
				User user = (User) query.uniqueResult();
				return user;
			}	
		});*/
		
		//Criteria 第二种方法
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		
		dc.add(Restrictions.eq("user_name", usercode));
		
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
		
		if(list != null && list.size()> 0) {
			return list.get(0);
		}else {
			return null;
		}
	}


}
