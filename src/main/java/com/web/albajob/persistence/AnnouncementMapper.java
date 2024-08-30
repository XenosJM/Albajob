package com.web.albajob.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.albajob.domain.AnnouncementVO;

@Mapper
public interface AnnouncementMapper {
	int create(AnnouncementVO announcementVO);
	List<AnnouncementVO> selectAll();
	List<AnnouncementVO> selectByJob(int jobId);
	AnnouncementVO selectOne(int announcementId);
	int update(AnnouncementVO announcementVO);
	int delete(int announcementId);
}
