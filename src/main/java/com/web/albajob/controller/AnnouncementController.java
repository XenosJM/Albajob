package com.web.albajob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/announcement")
@Log4j
public class AnnouncementController {
	
	@GetMapping("/estimate")
	public String estimateGet() {
		log.info("estimateGET");
		return "announcement/estimate";
	}
	
	@PostMapping("/estimage")
	public void estimatePost() {
		log.info("");
	}
}
