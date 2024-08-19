package com.web.albajob.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class TownVO {
	private int cityId; // 시.도 인덱스(FK)
	private int townId; // 시.구.군 인덱스
	private String townName; // 시.구.군 이름
}
