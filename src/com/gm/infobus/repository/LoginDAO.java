package com.gm.infobus.repository;

import java.util.List;

import com.gm.infobus.entity.Coordinate;
import com.gm.infobus.entity.Equipment;
import com.gm.infobus.mapper.SqlMapper;

public interface LoginDAO  extends SqlMapper{
	/**
	 * 根据机器名和密码查找机器，list.size()>0表明用户登录成功
	 * @param name
	 * @param password
	 * @return
	 */
	public List<Equipment> getEquipmentByNameAndPwd(Equipment e);

	/**
	 * 根据已登录机器采样点获得机器坐标
	 * @param coordinateId
	 * @return
	 */
	public Coordinate getLoginEquipmentCoordinate(int coordinateId);

	/**
	 * 获得所有 id及其对应机器名
	 * @return
	 */
	public List<Equipment> getAllEquipmentNames();
}
