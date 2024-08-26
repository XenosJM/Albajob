package com.web.albajob.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.web.albajob.domain.ResumeVO;

@Mapper
public interface ResumeMapper {
	
	// 이력서 등록
	int insertResume(ResumeVO resumeVO);
		 
	// 이력서 검색
	List<ResumeVO> selectByResumeTitle(String userName);
	
	// 상세 이력서 검색
	List<ResumeVO> selectByResumeUserId(@Param("userName")String userName, @Param("resumeId")int resumeId);
	
	// 이력서 수정
	int updateInquiry(ResumeVO resumeVO);
	
	// 이력서 삭제
	int deleteResume(@Param("userName")String userName, @Param("resumeId")int resumeId);
}
