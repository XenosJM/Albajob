package com.web.albajob.service;

import com.web.albajob.domain.SearchDTO;

public interface SearchService {
	
	// 단어만 검색 했을 경우
	List<String> searchKeyword(SearchDTO searchDTO);
	
}
