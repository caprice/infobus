package com.gm.infobus.service;

import java.util.List;

import com.gm.infobus.entity.User;
import com.gm.infobus.repository.pagination.page.Pagination;

public interface UserService {
	public List<User> findAllUsers();

	public List<User> findAllUsers(Pagination pagination);
	
	public void addUser(User user);
}
