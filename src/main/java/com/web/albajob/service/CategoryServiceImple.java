package com.web.albajob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.albajob.domain.CategoryVO;
import com.web.albajob.domain.JobVO;
import com.web.albajob.persistence.CategoryMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class CategoryServiceImple implements CategoryService {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public List<CategoryVO> getAllCategory() {
		log.info("getAllCategory()");
		List<CategoryVO> list = categoryMapper.selectCategory();
		return list;
	}

	@Override
	public List<JobVO> getAllJob(int categoryId) {
		log.info("getAllJob()");
		List<JobVO> list = categoryMapper.selectJob(categoryId);
		return list;
	}

}
