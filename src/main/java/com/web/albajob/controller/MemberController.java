package com.web.albajob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.albajob.domain.CompanyMemberVO;
import com.web.albajob.domain.MemberVO;
import com.web.albajob.service.MemberService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@Log4j
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/registerMember")
	public void companyRegistGet() {
		log.info("joinGet()");
	}	
	
	@PostMapping("/registerMember")
	public String companyRegistPOST(MemberVO vo) {
		log.info(vo);
		int result = memberService.insertMember(vo);
		log.info(result+"행 삽입");
		return "redirect:/login";
	}
}
