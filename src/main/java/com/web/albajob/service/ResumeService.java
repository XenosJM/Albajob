package com.web.albajob.service;

import java.util.List;

import com.web.albajob.domain.ResumeVO;

public interface ResumeService {
	
	// 이력서 등록
	int createResume(ResumeVO resumeVO);
	
	// 이력서 검색
	List<ResumeVO> getAllResume(String userName);
	
	// 이력서 검색
	List<ResumeVO> getAllResumeId(int resumeId, String userName);
	
	// 이력서 수정
	int updateReview(ResumeVO resumeVO);
	
	// 이력서 삭제
	int deleteReview(int resumeId, String userName);
	
}
