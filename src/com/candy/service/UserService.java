package com.candy.service;

import com.candy.domain.User;

public interface UserService {

	void save(User u);
	//登陆方法
	User getUserByCodePassword(User u);

	User getByUserCode(Integer user_id);
	//注册方法
	//void saveUser(User u);
}
