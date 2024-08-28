package com.web.albajob.service;


import com.web.albajob.domain.CompanyMemberVO;

public interface CompanyMemberService {
	int insertCompanymember(CompanyMemberVO vo);

	String findUserNameByPhone(int userPhone);

	String findUserNameByMail(String userMail);

	String updatePW(CompanyMemberVO vo);

	int updateMember(CompanyMemberVO vo);

	int deleteMember(int userId);
	
	int memberCheck(String userName, String userPW);

}
