package com.web.albajob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.albajob.domain.AnnouncementVO;
import com.web.albajob.service.AnnouncementService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/announcement")
@Log4j
public class AnnouncementController {
	
	@Autowired
	private AnnouncementService announcementService;
	
	@GetMapping("insert")
	public String announcementInsertGET() {
		log.info("insertGET()");
		return "announcement/insert";
	}
	
	@PostMapping("insert")
	public String announcementInsertPOST(AnnouncementVO announcementVO) {
		log.info("insertPOST()");
		log.info("announcementVO = " + announcementVO.toString());
		int result = announcementService.insert(announcementVO);
		return "redirect:/announcement/list";
	}
	
	@GetMapping("list")
	public void announcementList(Model model, String userName) {
		log.info("listGET()");
		List<AnnouncementVO> announcementList = announcementService.findAll(userName);
		model.addAttribute("announcementList", announcementList);
	}
	
	@GetMapping("detail")
	public String announcementDatail(Model model, Integer announcementId) {
		log.info("detailGET()");
		AnnouncementVO announcementVO = announcementService.findOne(announcementId);
		model.addAttribute("announcementVO", announcementVO);
		return "redirect:/announcement/detail";
	}
}
