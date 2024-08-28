package com.web.albajob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.albajob.domain.CompanyMemberVO;
import com.web.albajob.service.CompanyMemberService;

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
		log.info(result+"행 삽입");
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
	
	@GetMapping("/updatePW")
	public void updatePWGET() {
		log.info("updatePWCompany");
	}
	
	@PostMapping("/updatePW")
	public String updatePW() {
		
		return "redirect:/login";
	}
	
	@GetMapping("/companyUpdate")
	public void companyUpdateGET() {
		log.info("companyUpdateGET()");
	}
	
	@PostMapping("/companyUpdate")
	public String companyUpdate(CompanyMemberVO vo) {
		int result = companyMemberService.updateMember(vo);
		log.info(result+"행 수정 완료");
		return "redirect:/member/info";
	}
	
	@PostMapping("/deleteCompany")
	public String deleteCompany(CompanyMemberVO vo) {
		int result = companyMemberService.deleteMember(vo.getUserId());
		log.info(result+"행 삭제 완료");
		return "redirect:/main";
	}
	

}
