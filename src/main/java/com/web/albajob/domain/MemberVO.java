package com.web.albajob.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class MemberVO {
	private int userId; // 인덱스로 증가함 pk
	private String userName; // 입력할때 아이디
	private String userPassword; // 비번
	private int userPhone; // 전화번호
	private String userMail; // 이메일
	private String path; // 가입경로
}
