package com.candy.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.candy.domain.Customer;


public interface CustomerDao extends BaseDao<Customer>{

	//继承BaseDao即可
	//void save(Customer customer);

	//Integer getTotalCount(DetachedCriteria dc);

	//List<Customer> getPageList(DetachedCriteria dc, int start, Integer pageSize);

}
