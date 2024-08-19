package com.web.albajob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/resume")
@Log4j
public class ResumeController {
	
	@GetMapping
	public void createResume(Model model) {// 로그인 한 회원id를 가져와서 이력서 불려오기
		log.info("createResume()");
		model.addAttribute("productList");
	}
}
