package com.web.albajob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.albajob.domain.AnnouncementVO;
import com.web.albajob.persistence.AnnouncementMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class AnnouncementServiceImple implements AnnouncementService {

	@Autowired
	private AnnouncementMapper announcementMapper;
	
	@Override
	public int insert(AnnouncementVO announcementVO) {
		log.info("insert()");
		int result = announcementMapper.create(announcementVO);
		return result;
	}

	@Override
	public List<AnnouncementVO> findAll(String userName) {
		log.info("findAll()");
		return announcementMapper.selectAll(userName);
	}
	
	@Override
	public List<AnnouncementVO> findByJob(int jobId) {
		log.info("findByJob()");
		return announcementMapper.selectByJob(jobId);
	}
	
	@Override
	public AnnouncementVO findOne(int announcementId) {
		log.info("findOne()");
		return announcementMapper.selectOne(announcementId);
	}

	@Override
	public int updateAnnouncement(AnnouncementVO announcementVO) {
		log.info("update()");
		return announcementMapper.update(announcementVO);
	}

	@Override
	public int deleteAnnouncement(int announcementId) {
		log.info("delete()");
		return announcementMapper.delete(announcementId);
	}
}
