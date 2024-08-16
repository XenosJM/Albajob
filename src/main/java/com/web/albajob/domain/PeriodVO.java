package com.web.albajob.domain;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class PeriodVO {
	private int periodId; // 기간 인덱스
	private String periodName; // 기간
}
