package com.web.albajob.service;

import org.springframework.stereotype.Service;

import com.web.albajob.domain.CompanyMemberVO;
import com.web.albajob.persistence.CompanyMemberMapper;

@Service
public class CompanyMemberServiceImple implements CompanyMemberService {
	
	CompanyMemberMapper companyMemberMapper;
	
	@Override
	public int insertMember(CompanyMemberVO vo) {
		return companyMemberMapper.insertMember(vo);
	}

	@Override
	public String findUserNameByPhone(int userPhone) {
		return companyMemberMapper.findUserNameByPhone(userPhone);
	}

	@Override
	public String findUserNameByMail(String userMail) {
		return companyMemberMapper.findUserNameByMail(userMail);
	}

	@Override
	public String findUserPW(String userName) {
		return companyMemberMapper.findUserPW(userName);
	}

	@Override
	public int updateMember(CompanyMemberVO vo) {
		return companyMemberMapper.updateMember(vo);
	}

	@Override
	public int deleteMember(int userId) {
		return companyMemberMapper.deleteMember(userId);
	}

}
