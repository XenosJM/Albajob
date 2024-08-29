package com.web.albajob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.web.albajob.persistence.CompanyMemberMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class UtilServiceImple implements UtilService {
	
	@Autowired
	private CompanyMemberMapper companyMemberMapper;
	
	@Override
	public String checkId(String memberId) {
		log.info("checkId()");
		return companyMemberMapper.checkId(memberId);
	}

	@Override
	public String checkEmail(String memberEmail) {
		log.info("checkEmail()");
		return companyMemberMapper.checkEmail(memberEmail);
	}  // end checkEmail
}
