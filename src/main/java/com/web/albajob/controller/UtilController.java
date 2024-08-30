package com.web.albajob.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.albajob.domain.CompanyMemberVO;
import com.web.albajob.service.CompanyMemberService;
import com.web.albajob.service.UtilService;
import com.web.albajob.util.AuthCodeGenerator;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/util")
@Log4j
public class UtilController {
	
	@Autowired
	AuthCodeGenerator AuthCodeGenerator;
	
	@Autowired
	JavaMailSender MailSender;
	
	@Autowired
	UtilService utilService;	
	

	@Autowired
	CompanyMemberService companyMemberService;
	

	@GetMapping("/authCodeSend")
	public ResponseEntity<Map<String, Integer>> AuthCodeSend(@RequestParam("userMail") String userMail) {
		int result = 0;
		String authCode = null;
		authCode = AuthCodeGenerator.generateAuthCode();
		String setFrom = "wjdalsqaa123@gmail.com"; // config에 입력한 자신의 이메일 주소를 입력
		String toMail = userMail;
		String title = "안녕하세요. Gain 입니다."; // 이메일 제목
		String content = "이메일 인증번호를 발송하였습니다." + "<br><br>" + "인증 번호는 " + authCode + " 입니다." + "<br>"
				+ "인증번호를 제대로 입력해주세요"; // 이메일 내용 삽입
		// mailSender 객체에 세팅된 값을 이용한 메일 객체 생성
		MimeMessage mail = MailSender.createMimeMessage();
		Map<String, Integer> res = new HashMap<>();
		try {
			// 이메일 관련된 설정(메일 보내기)를 수행할 helper 객체 생성.
			// true를 전달하여 multipart 형식의 메시지를 지원하고, "utf-8"을 전달하여 문자 인코딩을 설정
			MimeMessageHelper helper = new MimeMessageHelper(mail, true, "UTF-8");
			helper.setFrom(setFrom); // 발신자 설정
			helper.setTo(toMail); // 수신자 설정
			helper.setSubject(title); // 제목 설정
			helper.setText(content, true); // 내용 설정, html 설정
			// TODO 파일 업로드 추가도 가능

			MailSender.send(mail);
			result = Integer.parseInt(authCode); // 문자열로 만들어진 인증코드를 숫자로 파싱해서 전달
			res.put("result", 1);
			res.put("authCode", result);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = 0;
			res.put("result", 0);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PostMapping("/authCodeId")
	public ResponseEntity<Integer> AuthIdSend(@RequestParam("userMail") String userMail) {
		int result = 0;
		String memberId = utilService.companyCheckMail(userMail);
		if (memberId == null) {
			result = 0;
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		}
		String sealedId = memberId.substring(0, memberId.length() - 3);
		String setFrom = "wjdalsqaa123@gmail.com"; // config에 입력한 자신의 이메일 주소를 입력
		String toMail = userMail;
		String title = "안녕하세요. Gain 입니다."; // 이메일 제목
		String content = "요청하신 회원님의 아이디입니다. 보안상 끝에 3자리를 가려서 알려드립니다." + "<br><br>" + "회원님의 아이디는 " + sealedId + "***"
				+ " 입니다." + "<br>" + "이용해 주셔서 감사합니다."; // 이메일 내용 삽입
		// mailSender 객체에 세팅된 값을 이용한 메일 객체 생성
		MimeMessage mail = MailSender.createMimeMessage();
		try {
			// 이메일 관련된 설정(메일 보내기)를 수행할 helper 객체 생성.
			// true를 전달하여 multipart 형식의 메시지를 지원하고, "utf-8"을 전달하여 문자 인코딩을 설정
			MimeMessageHelper helper = new MimeMessageHelper(mail, true, "UTF-8");
			helper.setFrom(setFrom); // 발신자 설정
			helper.setTo(toMail); // 수신자 설정
			helper.setSubject(title); // 제목 설정
			helper.setText(content, true); // 내용 설정, html 설정
			// TODO 파일 업로드 추가도 가능

			MailSender.send(mail);
			result = 1;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = 0;
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@GetMapping("/companyCheckId/{userName}")
	public ResponseEntity<Integer> companyCheckId(@PathVariable("userName")String userName){
		log.info("companycheckId");
		log.info(userName);
		int result=(utilService.companyCheckId(userName)!=null)?1:0;
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	@GetMapping("/companyCheckMail")
	public ResponseEntity<Integer> companyCheckMail(@RequestParam("userMail")String userMail){
		log.info("companycheckMail");
		log.info(userMail);
		int result=(utilService.companyCheckMail(userMail)!=null)?1:0;
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}

}
