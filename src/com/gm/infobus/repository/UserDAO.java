package com.gm.infobus.repository;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.gm.infobus.entity.User;
import com.gm.infobus.mapper.SqlMapper;
import com.gm.infobus.repository.pagination.page.Page;

public interface UserDAO extends SqlMapper{
	void addUser(User user) throws DataAccessException;

	public List<User> findAllUsers() throws DataAccessException;
	
	public List<User> findAllUsersWithPagination(RowBounds rowBounds) throws DataAccessException;
}
