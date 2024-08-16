package com.web.albajob.persistence;

import org.apache.ibatis.annotations.Mapper;

import com.web.albajob.domain.CompanyMemberVO;
import com.web.albajob.domain.MemberVO;

@Mapper
public interface CompanyMemberMapper{
	int insertMember(CompanyMemberVO vo);
	String findUserNameByPhone(int userPhone);
	String findUserNameByMail(String userMail);
	String findUserPW(String userName);
	int updateMember(CompanyMemberVO vo);
	int deleteMember(int userId);
}
