package com.web.albajob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.albajob.domain.CityVO;
import com.web.albajob.domain.TownVO;
import com.web.albajob.domain.VillageVO;
import com.web.albajob.service.LocationService;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/location")
@Log4j
public class LocationRESTController {
	
	@Autowired
	private LocationService locationService;
	
	// 시.도 선택목록 호출
	@GetMapping("/city")
	public ResponseEntity<List<CityVO>> cityList() {
		log.info("cityList()");
		List<CityVO> list = locationService.getAllCity();
		log.info("list : " + list);
		return new ResponseEntity<List<CityVO>>(list, HttpStatus.OK);
	}
	
	// 시.구.군 선택목록 호출
	@PostMapping("/city/{cityId}")
	public ResponseEntity<List<TownVO>> townList(@PathVariable("cityId") int cityId) {
		log.info("townList()");
		List<TownVO> list = locationService.getAllTown(cityId);
		log.info("list : " + list);
		return new ResponseEntity<List<TownVO>>(list, HttpStatus.OK);
	}
	
	// 동.읍.면 선택목록 호출
	@PostMapping("/city/town/{townId}")
	public ResponseEntity<List<VillageVO>> villageList(@PathVariable("townId") int townId) {
		log.info("townList()");
		List<VillageVO> list = locationService.getAllVillage(townId);
		log.info("list : " + list);
		return new ResponseEntity<List<VillageVO>>(list, HttpStatus.OK);
	}
 }
