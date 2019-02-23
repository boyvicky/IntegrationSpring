package com.candy.service;


import org.hibernate.criterion.DetachedCriteria;

import com.candy.domain.Customer;
import com.candy.utils.PageBean;

public interface CustomerService {
	//未使用spring容器
	//void save(Customer customer);

	//使用spring容器
	void save(Customer customer);

	
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
