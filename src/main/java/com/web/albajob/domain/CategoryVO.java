package com.web.albajob.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoryVO {
	private int categoryId; // 대분류 인덱스
	private String categoryName; // 대분류 이름
}
