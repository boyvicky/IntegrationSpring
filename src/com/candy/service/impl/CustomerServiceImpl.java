package com.candy.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.candy.dao.CustomerDao;
import com.candy.dao.impl.CustomerDaoImpl;
import com.candy.domain.Customer;
import com.candy.service.CustomerService;
import com.candy.utils.HibernateUtils;
import com.candy.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {

	/*
	
	//未使用spring 容器
	private CustomerDao cd = new CustomerDaoImpl();
	
	@Override
	public void save(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		cd.save(customer);
		tx.commit();
	}

	*/
	
	//使用spring 容器
	
	private CustomerDao customerDao;
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1. 调用dao查询总记录数
		Integer totalCount = customerDao.getTotalCount(dc);
		//2. 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3. 调用Dao查询分页列表数据
		List<Customer> list = customerDao.getPageList(dc, pb.getStart(), pb.getPageSize());
		//4. 列表数据放入pageBean中，并返回
		pb.setList(list);
		
		return pb;
	}
	
	@Override
	public void save(Customer customer) {
		//1 维护Customer与数据字典对象的关系，由于struts参数封装，会将参数封装到数据字典的id属性
		//那么我们无需手动维护关系
		//2 调用dao保存客户
		customerDao.save(customer);
	}
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}





}
