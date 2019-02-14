package com.candy.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.candy.dao.CustomerDao;
import com.candy.domain.Customer;
import com.candy.utils.HibernateUtils;


//类需要继承 HibernateDaoSupport
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {
	
	
	/* 继承BaseDaoImpl, 这些基本的方法即可继承过来
	//未使用spring 容器
	@Override
	public void save(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(customer);
	}

	//使用spring 容器
	
	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		
		//设置查询的聚合函数，总记录数
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//清空前面设置的聚合函数，防止影响后面dc的使用
		dc.setProjection(null);
		
		if(list!=null && list.size()>0) {
			Long count = list.get(0);
			return count.intValue();
		}else {
			return null;
		}
	}

	@Override
	public List<Customer> getPageList(DetachedCriteria dc, int start, Integer pageSize) {

		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return list;
	}
	*/
}
