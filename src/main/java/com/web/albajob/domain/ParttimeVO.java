package com.web.albajob.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ParttimeVO {
	private int parttimeId; // 시간 인덱스
	private String parttimeName; // 시간
}
