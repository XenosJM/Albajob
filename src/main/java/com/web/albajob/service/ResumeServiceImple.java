package com.web.albajob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.albajob.domain.ResumeVO;
import com.web.albajob.persistence.ResumeMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ResumeServiceImple implements ResumeService{
	
	@Autowired
	private ResumeMapper ResumeMapper;

	@Override
	public int createResume(ResumeVO resumeVO) {
		log.info("createResume()");
		int insertRes = ResumeMapper.insertResume(resumeVO);
		return insertRes;
	}

	@Override
	public List<ResumeVO> getAllResume(String userName) {
		log.info("getAllResume()");
		List<ResumeVO> result = ResumeMapper.selectByResumeTitle(userName);
		return result;
	}

	@Override
	public List<ResumeVO> getAllResumeId(int resumeId, String userName) {
		log.info("getAllResumeId()");
		List<ResumeVO> result = ResumeMapper.selectByResumeUserId(userName, resumeId);
		return result;
	}

	@Override
	public int updateReview(ResumeVO resumeVO) {
		log.info("updateReview()");
		int updateRes = ResumeMapper.updateInquiry(resumeVO);
		return updateRes;
	}

	@Override
	public int deleteReview(int resumeId, String userName) {
		log.info("deleteReview()");
		int updateRes = ResumeMapper.deleteResume(userName, resumeId);
		return updateRes;
	}
	
	
}
