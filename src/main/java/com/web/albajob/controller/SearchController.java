package com.web.albajob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.albajob.util.SPagination;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value = "/search")
@Log4j
public class SearchController {
	
	@GetMapping("/searchList")
	public void searchList(Model model, SPagination sPagination) {
		log.info("searchList()");
	}
	
}
