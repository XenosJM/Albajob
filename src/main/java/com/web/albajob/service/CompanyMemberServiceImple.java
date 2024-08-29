package com.web.albajob.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.albajob.domain.CompanyMemberVO;
import com.web.albajob.persistence.CompanyMemberMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class CompanyMemberServiceImple implements CompanyMemberService {
	
	@Autowired
	CompanyMemberMapper companyMemberMapper;
	
	@Autowired
	JavaMailSender sender;
	
	private PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Override
	public int insertCompanymember(CompanyMemberVO vo) {
		log.info(vo);
		String encodedPassword = encoder.encode(vo.getUserPassword());
		vo.setUserPassword(encodedPassword);
		return companyMemberMapper.insertCompanymember(vo);
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
	public int updateMember(CompanyMemberVO vo) {
		return companyMemberMapper.updateMember(vo);
	}

	@Override
	public int deleteMember(int userId) {
		return companyMemberMapper.deleteMember(userId);
	}

	@Override
	public String updatePW(CompanyMemberVO vo) {
		String encodedPW = encoder.encode(vo.getUserPassword());
		vo.setUserPassword(encodedPW);
		return companyMemberMapper.updatePW(vo);
	}

	@Override
	public int memberCheck(String userName,String userPW) {
		CompanyMemberVO vo = companyMemberMapper.memberCheck(userName);
		if(vo != null&&encoder.matches(vo.getUserPassword(), userPW)) {
			return 1;
		}else {
			return 0;
			
		}		
	}

	@Override
	public String checkId(String memberId) {
		log.info("checkId");
		return companyMemberMapper.checkId(memberId);
	}

	@Override
	public String chekcEmail(String memberEmail) {
		log.info("checkEmail");
		return companyMemberMapper.checkEmail(memberEmail);
	}
	
	
	
	

}
