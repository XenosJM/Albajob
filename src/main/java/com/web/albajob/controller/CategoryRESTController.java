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

import com.web.albajob.domain.CategoryVO;
import com.web.albajob.domain.JobVO;
import com.web.albajob.service.CategoryService;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/category")
@Log4j
public class CategoryRESTController {
	
	@Autowired
	private CategoryService categoryService;
	
	// 대분류 선택목록 호출
	@GetMapping("/category")
	public ResponseEntity<List<CategoryVO>> categoryList() {
		log.info("categpryList()");
		List<CategoryVO> list = categoryService.getAllCategory();
		log.info("list : " + list);
		return new ResponseEntity<List<CategoryVO>>(list, HttpStatus.OK);
	}
	
	// 업직종 선택목록 호출
	@PostMapping("/category/{categoryId}")
	public ResponseEntity<List<JobVO>> jobList(@PathVariable("categoryId") int categoryId) {
		log.info("jobList()");
		List<JobVO> list = categoryService.getAllJob(categoryId);
		log.info("list : " + list);
		return new ResponseEntity<List<JobVO>>(list, HttpStatus.OK);
	}
}
