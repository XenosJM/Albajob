package com.web.albajob.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CompanyMemberVO {
	private int userId; // 인덱스 고유값
	private String userName; // id
	private String userPassword; // 비밀번호
	private int userPhone; // 전화번호
	private String userMail; // 이메일
	private String companyNumber; // 사업자등록번호
	private String companyName; // 회사/점포이름
	private String path; // 가입경로
	private String membership; // 멤버쉽
	
}
