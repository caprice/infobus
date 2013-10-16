package com.gm.infobus.repository;

import java.util.List;

import com.gm.infobus.entity.ZoneArea;
import com.gm.infobus.entity.ZoneJsonEntity;
import com.gm.infobus.mapper.SqlMapper;

public interface MainSearchDAO  extends SqlMapper{


	/**
	 * 取得所有墓大区信息
	 * @return
	 */
	public List<ZoneArea> getAllZoneAreas();
	
	/**
	 * 取得一个墓大区下所属所有墓区
	 * @param zoneAreaId(墓大区id)
	 * @return
	 */
	public List<ZoneJsonEntity> getAllCemeteryZoneByZoneId(int zoneAreaId);
}
