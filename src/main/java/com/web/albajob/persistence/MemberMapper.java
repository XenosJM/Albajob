package com.web.albajob.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.albajob.domain.MemberVO;

@Mapper
public interface MemberMapper{
	int insertMember(MemberVO vo);
	String findUserNameByPhone(int userPhone);
	String findUserNameByMail(String userMail);
	String findUserPW(String userName);
	int updateMember(MemberVO vo);
	int deleteMember(int userId);
	List<MemberVO> selectByResume(String userName); // 우제영 제작
	String checkId(String memberId);
	String checkEmail(String memberEmail);
	MemberVO memberCheck(String userName);
	String updatePW(MemberVO vo);
}
