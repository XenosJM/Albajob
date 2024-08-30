package com.web.albajob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.albajob.domain.AnnouncementVO;
import com.web.albajob.domain.SearchDTO;
import com.web.albajob.persistence.AnnouncementMapper;

public class SearchServiceImple implements SearchService {
	
	@Autowired
	private AnnouncementMapper announcement;
	
	@Override
	public List<AnnouncementVO> searchKeyword(SearchDTO searchDTO) {
		
		return null;
	}

}
