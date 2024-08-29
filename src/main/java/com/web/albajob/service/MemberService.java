package com.web.albajob.service;

import com.web.albajob.domain.CompanyMemberVO;
import com.web.albajob.domain.MemberVO;

public interface MemberService {
	int insertMember(MemberVO vo);

	String findUserNameByPhone(int userPhone);

	String findUserNameByMail(String userMail);

	String findUserPW(String userName);

	int updateMember(MemberVO vo);

	int deleteMember(int userId);
	
	int memberCheck(String userName, String userPW);
	
	String updatePW(MemberVO vo);
}
