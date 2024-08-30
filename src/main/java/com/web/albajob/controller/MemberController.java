package com.web.albajob.controller;

import javax.servlet.http.HttpSession;

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
	MemberService MemberService;

	@GetMapping("/memberRegist")
	public void companyRegistGet() {
		log.info("joinGet()");
	}

	@PostMapping("/registerMember")
	public String companyRegistPOST(MemberVO vo) {
		log.info(vo);
		int result = MemberService.insertMember(vo);
		log.info(result + "행 삽입");
		return "redirect:/member/login";
	}

	@GetMapping("/findByPhone")
	public void findByPhoneGet() {
		log.info("findByPhoneGet()");
	}

	@PostMapping("/findByPhone")
	public String findByPhone(int userphone) {
		return MemberService.findUserNameByPhone(userphone);
	}

	@GetMapping("/findByMail")
	public void findByMailGet() {
		log.info("findByMailGet()");
	}

	@PostMapping("/findByMail")
	public String findByMail(String userMail) {
		return MemberService.findUserNameByMail(userMail);
	}

	@GetMapping("/memberUpdate")
	public void memberUpdateGET() {
		log.info("companyUpdateGET()");
	}

	@PostMapping("/memberUpdate")
	public String memberUpdate(MemberVO vo) {
		int result = MemberService.updateMember(vo);
		log.info(result + "행 수정 완료");
		return "redirect:/member/info";
	}

	@PostMapping("/deleteMember")
	public String deleteMember(MemberVO vo) {
		int result = MemberService.deleteMember(vo.getUserId());
		log.info(result + "행 삭제 완료");
		return "redirect:/main";
	}

	@GetMapping("/updatePW")
	public void updatePWGET() {
		log.info("updatePWmember");
	}

	@PostMapping("/updatePW")
	public String updatePW(MemberVO vo) {
		String result = MemberService.updatePW(vo);
		log.info(result);
		return "redirect:/login";
	}

	@GetMapping("/login")
	public void memberCheckGet() {
		log.info("membercheck get");
	}

	@PostMapping("/memberCheck")
	public String memberCheck(HttpSession session, String userName, String userPassword) {
	    log.info("Username: " + userName);
	    log.info("UserPassword: " + userPassword);
	    
	    int result = MemberService.memberCheck(userName, userPassword);
	    log.info("Result: " + result);
	    
	    if (result == 1) {
	        session.setAttribute("userName", userName);
	        log.info("Session attribute 'userName' set to: " + session.getAttribute("userName"));
	        return "redirect:/";
	    } else {
	        log.info("Login failed. Redirecting to login page.");
	        return "redirect:/companyMember/login";
	    }
	}
}
