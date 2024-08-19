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
	public void createResume(Model model) {// �α��� �� ȸ��id�� �����ͼ� �̷¼� �ҷ�����
		log.info("createResume()");
		model.addAttribute("productList");
	}
}
