package com.web.albajob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.web.albajob.service.CompanyMemberService;

@Controller
public class CompanyMemberController {
	@Autowired
	private CompanyMemberService companyMemberService;

}
