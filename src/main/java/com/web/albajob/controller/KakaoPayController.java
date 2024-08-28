package com.web.albajob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.albajob.domain.KakaoPayReadyResponse;
import com.web.albajob.service.KakaoPayService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class KakaoPayController {

	@Autowired
	private KakaoPayService kakaoPayService;
	
	@GetMapping("/ready")
	public String ready() {
		log.info("ready()");
		KakaoPayReadyResponse readyResponse = kakaoPayService.ready();
		return "redirect : " + readyResponse.getNext_redirect_pc_url();
	}
	
	@GetMapping("/approve")
	public String approve(@RequestParam("pg_token") String pgToken, Model model) {
		log.info("approve()");
		
		return "redirect:/kakaoPay/success";
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		log.info("kakaoPayCancel()");
		
		return "redirect:/kakaoPay/cancel";
	}
	
	@GetMapping("/fail")
	public String fail() {
		log.info("kakaoPayFail()");
		
		return "redirect:/kakaoPay/fail";
	}
}
