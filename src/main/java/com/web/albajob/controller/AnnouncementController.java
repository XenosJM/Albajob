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
	
	@GetMapping("insert")
	public String announcementInsertGET() {
		log.info("insertGET()");
		return "announcement/insert";
	}
	
	@PostMapping("insert")
	public String announcementInsertPOST() {
		log.info("insertPOST()");
		return "redirect:/announcement/list";
	}
	
	@GetMapping("list")
	public String announcementList() {
		log.info("listGET()");
		return "announcement/list";
	}
}
