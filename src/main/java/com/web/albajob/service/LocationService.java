package com.web.albajob.service;

import java.util.List;

import com.web.albajob.domain.CityVO;
import com.web.albajob.domain.TownVO;
import com.web.albajob.domain.VillageVO;

public interface LocationService {
	List<CityVO> getAllCity(); // 시.도 선택
	List<TownVO> getAllTown(int cityId); // 시.구.군 선택(시.도 선택에 따른)
	List<VillageVO> getAllVillage(int townId); // 동.읍.면 선택(시.구.군 선택에 따른)
}
