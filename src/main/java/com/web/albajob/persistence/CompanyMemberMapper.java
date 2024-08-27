package com.web.albajob.persistence;

import org.apache.ibatis.annotations.Mapper;

import com.web.albajob.domain.CompanyMemberVO;
import com.web.albajob.domain.MemberVO;

@Mapper
public interface CompanyMemberMapper{
	int insertCompanymember(CompanyMemberVO vo);
	String findUserNameByPhone(int userPhone);
	String findUserNameByMail(String userMail);
	String updatePW(CompanyMemberVO vo);
	int updateMember(CompanyMemberVO vo);
	int deleteMember(int userId);
	CompanyMemberVO memberCheck(String userName);
}
