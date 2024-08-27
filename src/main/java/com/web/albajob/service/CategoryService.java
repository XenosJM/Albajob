package com.web.albajob.service;

import java.util.List;

import com.web.albajob.domain.CategoryVO;
import com.web.albajob.domain.JobVO;

public interface CategoryService {
	List<CategoryVO> getAllCategory(); // 대분류 검색
	List<JobVO> getAllJob(int categoryId); // 업직종 검색(대분류 선택에 따른)
}
