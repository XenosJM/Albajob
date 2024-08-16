package com.web.albajob.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CityVO {
	private int cityId; // 시.도 인덱스
	private String cityName; // 시.도 이름
}
