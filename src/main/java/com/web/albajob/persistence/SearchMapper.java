package com.web.albajob.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.albajob.domain.CategoryVO;
import com.web.albajob.domain.CityVO;
import com.web.albajob.domain.JobVO;
import com.web.albajob.domain.TownVO;
import com.web.albajob.domain.VillageVO;

@Mapper
public interface SearchMapper {
	List<CityVO> selectCity();
	List<TownVO> selectTown(int cityId);
	List<VillageVO> selectVillage(int townId);
	List<CategoryVO> selectCategory();
	List<JobVO> selectJob(int categoryId);
}
