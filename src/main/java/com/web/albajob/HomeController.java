package com.web.albajob;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;


/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
public class HomeController {
	
	@GetMapping("/")
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		log.info("로그인 페이지");
		return "login";
	}
	
	
	
	
	
}
