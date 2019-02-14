package com.candy.action;

import com.candy.domain.User;
import com.candy.service.UserService;
import com.candy.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	//Spring 管理Service
	private UserService userService;
	
	private User user = new User();
	
	public String addUser() {
		System.out.println(user);
		userService.save(user);
		return "success";
	}
	
	//用户登陆
	public String login() throws Exception {
		//1 调用Service执行登陆逻辑
		System.out.println(user);
		User u = userService.getUserByCodePassword(user);
		//2 将返回的User对象放入session域
		ActionContext.getContext().getSession().put("user", u);
		//3 重定向到项目首页
		return "toHome";
	}
	
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	
	public String getByUserCode(Integer user_id) {
		
		User u1 = userService.getByUserCode(user_id);
		System.out.println(u1);
		return "success";
	}
	
	
}
