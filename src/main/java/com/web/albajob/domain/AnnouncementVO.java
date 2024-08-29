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
	private int announcementId; // (PK)
	private int pay; // 급여
	private int jobId; // 업직종 (FK)
	private String workPeriod; // 근무기간
	private String workDay; // 근무요일
	private String workTime; // 근무시간
	private int recruitNumber; // 모집인원
	private int cityId; // 근무지역 (FK)
	private String managerName; // 담당자 이름
	private String managerPhone; // 담당자 전화
}
