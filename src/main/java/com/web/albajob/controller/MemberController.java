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
		return "redirect:/login";
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

	@GetMapping("/MemberCheck")
	public void memberCheckGet() {
		log.info("membercheck get");
	}

	@PostMapping("/MemberCheck")
	public int memberCheck(CompanyMemberVO vo, HttpSession session) {
		int result = MemberService.memberCheck(vo.getUserName(), vo.getUserPassword());
		if (result == 1) {
			session.setAttribute("userName", vo.getUserName());
			return 1;
		} else {
			return 0;
		}
	}
}
