package com.gm.infobus.service;

import java.util.List;

import com.gm.infobus.entity.ZoneArea;
import com.gm.infobus.entity.ZoneJsonEntity;

public interface MainSearchService {

	/**
	 * 取得所有墓大区信息
	 * @return
	 */
	public List<ZoneArea> getAllZoneAreas();
	
	/**
	 * 取得一个墓大区下所属所有墓区
	 * @param zoneId
	 * @return
	 */
	public List<ZoneJsonEntity> getAllCemeteryZoneByZoneId(int zoneId);
}
