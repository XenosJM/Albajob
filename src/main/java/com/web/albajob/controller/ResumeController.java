package com.web.albajob.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.albajob.domain.MemberVO;
import com.web.albajob.domain.ResumeVO;
import com.web.albajob.service.MemberService;
import com.web.albajob.service.ResumeService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/resume")
@Log4j
public class ResumeController {
	
	@Autowired 
	private ResumeService resumeService;
	
	@Autowired 
	private MemberService memberService;
	
	// 회원의 모든 이력서 제목과 최종 시간 검색
	@GetMapping("/list")
	public void readAllResume(Model model, String userName) {
		log.info("readAllResume()");
		List<ResumeVO> resumeVO = resumeService.getAllResume(userName);
		log.info("resumeVO : " + resumeVO);
		model.addAttribute("resumeVO", resumeVO);
	}
	
	@GetMapping("/detail")
	public void readAllResumeUserName(Model model, int resumeId, String userName) {
		log.info("readAllResumeUserName()");
		
		List<ResumeVO> vo = resumeService.getAllResumeId(resumeId, userName);
		List<MemberVO> userVO = memberService.getAllMember(userName);
		model.addAttribute("vo", vo);
		model.addAttribute("userVO", userVO);
		
	}
	
	
	@PostMapping("/input")
	public int createResume(Model model, ResumeVO resumeVO) {
		log.info("createResume()");
		
		String userName = resumeVO.getUserName();
		log.info("userName : " + userName);	
		
		
		
		return 0;
		
	}
	
	
}
