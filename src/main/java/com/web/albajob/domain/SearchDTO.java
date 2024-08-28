package com.web.albajob.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class SearchDTO {
	// TODO DTO 만들어야함.
	private String keyword; // 기본적인 사용자 검색어
	private CityVO city; // 시, 도 지역 검색시 사용
}
