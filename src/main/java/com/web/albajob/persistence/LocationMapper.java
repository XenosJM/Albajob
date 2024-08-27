package com.web.albajob.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.albajob.domain.CityVO;
import com.web.albajob.domain.TownVO;
import com.web.albajob.domain.VillageVO;

@Mapper
public interface LocationMapper {
	List<CityVO> selectCity(); // 시.도 선택
	List<TownVO> selectTown(int cityId); // 시.구.군 선택(시.도 선택에 따른)
	List<VillageVO> selectVillage(int townId); // 동.읍.면 선택(시.구.군 선택에 따른)
	
}
