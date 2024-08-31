package com.web.albajob.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.albajob.domain.AnnouncementVO;
import com.web.albajob.domain.SearchDTO;
import com.web.albajob.service.CategoryService;
import com.web.albajob.service.LocationService;
import com.web.albajob.util.SPagination;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value = "/search")
@Log4j
public class SearchController {
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/searchList")
	public ResponseEntity<List<AnnouncementVO>> searchList(Model model, SPagination sPagination, SearchDTO searchDTO) {
		log.info("searchList()");
		List<AnnouncementVO> list = new ArrayList<AnnouncementVO>();
		AnnouncementVO announcementVO = new AnnouncementVO();
		
		return new ResponseEntity<List<AnnouncementVO>>(list, HttpStatus.OK);
	}
	
	// 키워드 값으로 검색 진행
	
}
