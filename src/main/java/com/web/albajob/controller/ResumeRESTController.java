package com.web.albajob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.albajob.service.ResumeService;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/resumeREST")
@Log4j
public class ResumeRESTController {
	
	@Autowired
	private ResumeService resumeService;
			
}
