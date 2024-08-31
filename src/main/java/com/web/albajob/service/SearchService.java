package com.web.albajob.service;

import java.util.List;

import com.web.albajob.domain.AnnouncementVO;
import com.web.albajob.domain.SearchDTO;

public interface SearchService {
	
	// 단어만 검색 했을 경우
	List<AnnouncementVO> searchKeyword(SearchDTO searchDTO);
	
}
