package com.web.albajob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.albajob.domain.ResumeVO;
import com.web.albajob.service.ResumeService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/resume")
@Log4j
public class ResumeController {
	
	@Autowired 
	private ResumeService resumeService;
	
	// 회원의 모든 이력서 제목과 최종 시간 검색
	@GetMapping("/list")
	public void createResume(Model model, String userName) {
		log.info("createResume()");
		List<ResumeVO> resumeVO = resumeService.getAllResume(userName);
		log.info("resumeVO : " + resumeVO);
		model.addAttribute("resumeVO", resumeVO);
	}
	
	
	
}
