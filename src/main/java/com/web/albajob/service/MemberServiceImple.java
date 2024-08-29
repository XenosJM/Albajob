package com.web.albajob.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.albajob.domain.CompanyMemberVO;
import com.web.albajob.domain.MemberVO;
import com.web.albajob.persistence.MemberMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberServiceImple implements MemberService{

	MemberMapper memberMapper;
	
	private PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Override
	public int insertMember(MemberVO vo) {
		String encodedPassword = encoder.encode(vo.getUserPassword());
		vo.setUserPassword(encodedPassword);
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
	
	// userName의로 회원 모든 정보 검색(우제영)
	@Override
	public List<MemberVO> getAllMember(String userName) {
		log.info("getAllMember()");
		List<MemberVO> memberVO = memberMapper.selectByResume(userName);
		log.info("memberVO : " + memberVO);
		return memberVO;
	}

	@Override
	public int memberCheck(String userName, String userPW) {
		MemberVO vo = memberMapper.memberCheck(userName);
		if(vo != null&&encoder.matches(vo.getUserPassword(), userPW)) {
			return 1;
		}else {
			return 0;
			
		}		
	}
	
	@Override
	public String updatePW(MemberVO vo) {
		String encodedPW = encoder.encode(vo.getUserPassword());
		vo.setUserPassword(encodedPW);
		return memberMapper.updatePW(vo);
	}

}
