package com.web.albajob.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ResumeVO {
	private int resumeId;
	private String userName;
	private String resumeTitle;
	private String education; // 학력
	private String educationForm; // 학력 상태	private String experience;\
	private String experience; // 경력
	private String townName; // 도 이름
	private String cityName; // 도시
	private String jobName; // 직무
	private String workForm; //근무 형태
	private String periodName; // 근무 기간
	private String dayName; // 근무 일시
	private String parttimeName; // 파트근무 형태
	private int salary; // 급여
	private String salaryForm;// 급여 형태
	private String skill ;// 기술
	private String intro; // 자기소개
	private String resumeDateCreated; // 생성 날짜
}
