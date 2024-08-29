package com.web.albajob.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class AnnouncementVO {
	private int pay;
	private String occupation;
	private String workType;
	private String workPeriod;
	private String workDay;
	private String workTime;
	private String endTime;
	private int recruitNumber;
	private String workInfo;
	private String applyMethod;
	private String managerName;
	private String managerPhone;
	private String managerPage;
	private String enterpriseInfo;
}
