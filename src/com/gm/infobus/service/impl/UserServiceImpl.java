package com.gm.infobus.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gm.infobus.entity.User;
import com.gm.infobus.repository.UserDAO;
import com.gm.infobus.repository.pagination.page.Pagination;
import com.gm.infobus.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> findAllUsers() {
		return this.userDAO.findAllUsers();
	}

	@Override
	public int addUser(User user) {
		return userDAO.addUser(user);
	}

	@Override
	public List<User> findAllUsers(Pagination pagination) {
		RowBounds rowBounds = new RowBounds(pagination.getCurrentPage(),
				pagination.getPageSize());
		return this.userDAO.findAllUsersWithPagination(rowBounds);
	}

	@Override
	public boolean isUserRegistered(User user) {
		int rows = userDAO.isUserRegistered(user);
		return rows > 0 ? true : false;
	}

}
