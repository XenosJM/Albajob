package com.web.albajob.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.albajob.domain.CompanyMemberVO;
import com.web.albajob.service.CompanyMemberService;
import com.web.albajob.service.UtilService;
import com.web.albajob.util.AuthCodeGenerator;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value = "/companyMember")
@Log4j
public class CompanyMemberController {

	@Autowired
	private CompanyMemberService companyMemberService;
	
	
	@GetMapping("/companyRegist")
	public void companyRegistGet() {
		log.info("joinGet()");
	}

	@PostMapping("/registerCompanyMember")
	public String companyRegistPOST(CompanyMemberVO vo) {
		log.info(vo);
		int result = companyMemberService.insertCompanymember(vo);
		log.info(result + "행 삽입");
		return "redirect:/login";
	}

	@GetMapping("/findByPhone")
	public void findByPhoneGet() {
		log.info("findByPhoneGet()");
	}

	@PostMapping("/findByPhone")
	public String findByPhone(int userphone) {
		return companyMemberService.findUserNameByPhone(userphone);
	}

	@GetMapping("/findByMail")
	public void findByMailGet() {
		log.info("findByMailGet()");
	}

	@PostMapping("/findByMail")
	public String findByMail(String userMail) {
		return companyMemberService.findUserNameByMail(userMail);
	}

	@GetMapping("/companyUpdate")
	public void companyUpdateGET() {
		log.info("companyUpdateGET()");
	}

	@PostMapping("/companyUpdate")
	public String companyUpdate(CompanyMemberVO vo) {
		int result = companyMemberService.updateMember(vo);
		log.info(result + "행 수정 완료");
		return "redirect:/member/info";
	}

	@PostMapping("/deleteCompany")
	public String deleteCompany(CompanyMemberVO vo) {
		int result = companyMemberService.deleteMember(vo.getUserId());
		log.info(result + "행 삭제 완료");
		return "redirect:/main";
	}

	@GetMapping("/updatePW")
	public void updatePWGET() {
		log.info("updatePWCompany");
	}

	@PostMapping("/updatePW")
	public String updatePW(CompanyMemberVO vo) {
		String result = companyMemberService.updatePW(vo);
		log.info(result);
		return "redirect:/login";
	}

	@GetMapping("/companyMemberCheck")
	public void memberCheckGet() {
		log.info("membercheck get");
	}

	@PostMapping("/companyMemberCheck")
	public int memberCheck(CompanyMemberVO vo, HttpSession session) {
		int result = companyMemberService.memberCheck(vo.getUserName(), vo.getUserPassword());
		if (result == 1) {
			session.setAttribute("userName", vo.getUserName());
			return 1;
		} else {
			return 0;
		}
	}

	
}
