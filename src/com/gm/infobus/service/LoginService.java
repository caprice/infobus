package com.gm.infobus.service;

import java.util.List;

import com.gm.infobus.entity.Coordinate;
import com.gm.infobus.entity.Equipment;

public interface LoginService {

	public List<Equipment> getEquipmentByLoginInfo(Equipment e);

	public Coordinate getLoginEquipmentCoordinate(int coordinateId);

	public List<Equipment> getAllEquipmentNames();
}
