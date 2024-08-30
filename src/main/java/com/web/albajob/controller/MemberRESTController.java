package com.web.albajob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.albajob.domain.MemberVO;
import com.web.albajob.service.MemberService;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/memberRest")
@Log4j
public class MemberRESTController {
	
	@Autowired 
	private MemberService memberService;
	
	@GetMapping("/list")
	public ResponseEntity<List<MemberVO>> readAllResum(
			@PathVariable("userName") String userName){

		log.info("readAllResum()");
		List<MemberVO> memberVO = memberService.getAllMember(userName);
		log.info("memberVO : " + memberVO);
		return new ResponseEntity<List<MemberVO>>(memberVO, HttpStatus.OK);
	}
}
