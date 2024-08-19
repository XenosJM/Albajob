package com.web.albajob.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.albajob.domain.CategoryVO;
import com.web.albajob.domain.JobVO;

@Mapper
public interface CategoryMapper {
	List<CategoryVO> selectCategory(); // 대분류 검색
	List<JobVO> selectJob(int categoryId); // 업직종 검색(대분류 선택에 따른)
}
