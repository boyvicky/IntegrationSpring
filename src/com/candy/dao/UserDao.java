package com.candy.dao;

import com.candy.domain.User;

public interface UserDao extends BaseDao<User>{

	//void save(User u);
	
	User getByUserCode(String usercode);

	//void saveUser(User u);

}
