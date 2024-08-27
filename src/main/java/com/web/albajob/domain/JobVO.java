package com.web.albajob.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class JobVO {
	private int categoryId; // 대분류 인덱스(FK)
	private int jobId; // 업직종 인덱스
	private String jobName; // 업직종 이름
}
