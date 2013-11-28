package com.gm.infobus.service;

import java.util.List;

import com.gm.infobus.entity.User;
import com.gm.infobus.entity.UserDetail;
import com.gm.infobus.repository.pagination.page.Pagination;

public interface UserService {
	public List<User> findAllUsers();

	public List<User> findAllUsers(Pagination pagination);

	public int addUser(User user);

	public boolean isUserNameExisted(String userName);

	public boolean isPlateExisted(String plate);

	public User getLoginUser(User user);
	
	int addUserDetail(UserDetail userDetail);

	int updateUserDetail(UserDetail userDetail);
}
