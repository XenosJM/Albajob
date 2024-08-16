package com.web.albajob.service;

import org.springframework.stereotype.Service;

import com.web.albajob.domain.MemberVO;
import com.web.albajob.persistence.MemberMapper;

@Service
public class MemberServiceImple implements MemberService{

	MemberMapper memberMapper;
	
	@Override
	public int insertMember(MemberVO vo) {
		
		return memberMapper.insertMember(vo);
	}

	@Override
	public String findUserNameByPhone(int userPhone) {

		return memberMapper.findUserNameByPhone(userPhone);
	}

	@Override
	public String findUserNameByMail(String userMail) {

		return memberMapper.findUserNameByMail(userMail);
	}

	@Override
	public String findUserPW(String userName) {

		return memberMapper.findUserPW(userName);
	}

	@Override
	public int updateMember(MemberVO vo) {

		return memberMapper.updateMember(vo);
	}

	@Override
	public int deleteMember(int userId) {

		return memberMapper.deleteMember(userId);
	}

}
