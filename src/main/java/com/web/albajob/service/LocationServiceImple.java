package com.web.albajob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.albajob.domain.CityVO;
import com.web.albajob.domain.TownVO;
import com.web.albajob.domain.VillageVO;
import com.web.albajob.persistence.LocationMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class LocationServiceImple implements LocationService {
	
	@Autowired
	private LocationMapper locationMapper;
	
	@Override
	public List<CityVO> getAllCity() {
		log.info("getAllCity()");
		List<CityVO> list = locationMapper.selectCity();
		return list;
	}

	@Override
	public List<TownVO> getAllTown(int cityId) {
		log.info("getAllTown()");
		List<TownVO> list = locationMapper.selectTown(cityId);
		return list;
	}

	@Override
	public List<VillageVO> getAllVillage(int townId) {
		log.info("getAllVillage()");
		List<VillageVO> list = locationMapper.selectVillage(townId);
		return list;
	}

}
