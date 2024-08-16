package com.web.albajob.service;

import org.springframework.stereotype.Service;

import com.web.albajob.domain.MemberVO;

public interface MemberService {
	int insertMember(MemberVO vo);

	String findUserNameByPhone(int userPhone);

	String findUserNameByMail(String userMail);

	String findUserPW(String userName);

	int updateMember(MemberVO vo);

	int deleteMember(int userId);
}
