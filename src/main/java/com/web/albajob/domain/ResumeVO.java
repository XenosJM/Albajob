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
	private int userName;
	private String resumeTitle;
	private String education;
	private String experience;
	private String townName;
	private String cityName;
	private String jobName;
	private String workForm;
	private String periodName;
	private String dayName;
	private String parttimeName;
	private int salary;
	private String salaryForm;
	private String skill ;
	private String intro;
	private String resumeDateCreated;
}
