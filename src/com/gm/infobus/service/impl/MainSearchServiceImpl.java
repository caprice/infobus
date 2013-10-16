package com.gm.infobus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gm.infobus.entity.ZoneArea;
import com.gm.infobus.entity.ZoneJsonEntity;
import com.gm.infobus.repository.MainSearchDAO;
import com.gm.infobus.service.MainSearchService;

@Transactional
@Service
public class MainSearchServiceImpl implements MainSearchService {
	@Autowired
	private MainSearchDAO mainSearchDAO;

	@Override
	public List<ZoneArea> getAllZoneAreas() {
		return this.mainSearchDAO.getAllZoneAreas();
	}

	@Override
	public List<ZoneJsonEntity> getAllCemeteryZoneByZoneId(int zoneId) {
		return this.mainSearchDAO.getAllCemeteryZoneByZoneId(zoneId);
	}


}
