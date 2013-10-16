package com.gm.infobus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gm.infobus.entity.Coordinate;
import com.gm.infobus.entity.Equipment;
import com.gm.infobus.repository.LoginDAO;
import com.gm.infobus.service.LoginService;

@Transactional
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO loginDAO;

	@Override
	public List<Equipment> getEquipmentByLoginInfo(Equipment e) {
		return this.loginDAO.getEquipmentByNameAndPwd(e);
	}

	@Override
	public Coordinate getLoginEquipmentCoordinate(int coordinateId) {
		return this.loginDAO.getLoginEquipmentCoordinate(coordinateId);
	}

	@Override
	public List<Equipment> getAllEquipmentNames() {
		// TODO Auto-generated method stub
		return this.loginDAO.getAllEquipmentNames();
	}

}
