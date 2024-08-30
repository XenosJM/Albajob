package com.web.albajob.service;

import java.util.List;

import com.web.albajob.domain.AnnouncementVO;

public interface AnnouncementService {
	int insert(AnnouncementVO announcementVO);
	List<AnnouncementVO> findAll();
	List<AnnouncementVO> findByJob(int jobId);
	AnnouncementVO findOne(int announcementId);
	int updateAnnouncement(AnnouncementVO announcementVO);
	int deleteAnnouncement(int announcementId);
}
