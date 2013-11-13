package com.gm.infobus.repository;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.dao.DataAccessException;

import com.gm.infobus.entity.User;
import com.gm.infobus.mapper.SqlMapper;

public interface UserDAO extends SqlMapper{
	int addUser(User user) throws DataAccessException;

	public List<User> findAllUsers() throws DataAccessException;
	
	public List<User> findAllUsersWithPagination(RowBounds rowBounds) throws DataAccessException;
	
	
	public int isAccountNameExisted(String accountName);

	public int isPlateExisted(String plate);

	public User getLoginUser(User user);
}
