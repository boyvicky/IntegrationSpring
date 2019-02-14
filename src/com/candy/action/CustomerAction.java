package com.candy.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.candy.domain.Customer;
import com.candy.service.CustomerService;
import com.candy.service.impl.CustomerServiceImpl;
import com.candy.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	//未使用spring容器
	private CustomerService cs = new CustomerServiceImpl();
	
	public String addCustomerTest() {
		cs.save(customer);
		return "success";
	}
	
	//使用spring容器
	private Customer customer = new Customer();
	private CustomerService customerService;
	private Integer currentPage;
	private Integer pageSize;
	

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	//添加客户
	public String addCustomer() {
		customerService.save(customer);
		return "success";
	}
	
	//查询客户列表
	public String list() {
		//封装离线查询对象，使方法可以通用
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//判断并封装参数
		if(StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("customer_name", "%"+customer.getCust_name()+"%"));
		}
		
		//1. 直接调用service 查询分页数据（PageBean）
		PageBean pb = customerService.getPageBean(dc, currentPage, pageSize );
		
		//2. 将PageBean放入request域中，转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	

}
