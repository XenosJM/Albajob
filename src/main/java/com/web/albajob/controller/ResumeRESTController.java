package com.web.albajob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.albajob.domain.ResumeVO;
import com.web.albajob.service.ResumeService;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/resumeREST")
@Log4j
public class ResumeRESTController {
	
	@Autowired
	private ResumeService resumeService;
		
	
	// 유저의 모든 이력서 검색
	@GetMapping("/list")
	public ResponseEntity<List> readAllResume(
			@PathVariable("userName") String userName){
		log.info("readAllResume()");
		List<ResumeVO> resumeVO = resumeService.getAllResume(userName);
		log.info("resumeVO : " + resumeVO);
		return new ResponseEntity<List>(resumeVO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delet")
	public ResponseEntity<Integer> deleteResume(
		@PathVariable("resumeId") int resumeId, 
		@PathVariable("userName") String userName) {
		log.info("deleteResume()");
		
		int result = resumeService.deleteReview(resumeId, userName);
		
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	
	
}
