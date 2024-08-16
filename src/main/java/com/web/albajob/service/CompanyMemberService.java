package com.web.albajob.service;

import org.springframework.stereotype.Service;

import com.web.albajob.domain.CompanyMemberVO;

public interface CompanyMemberService {
	int insertMember(CompanyMemberVO vo);

	String findUserNameByPhone(int userPhone);

	String findUserNameByMail(String userMail);

	String findUserPW(String userName);

	int updateMember(CompanyMemberVO vo);

	int deleteMember(int userId);

}
