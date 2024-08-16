package com.web.albajob.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class VillageVO {
	private int townId; // 시.구.군 인덱스
	private int villageId; // 동.읍.면 인덱스
	private String villageName; // 동.읍.면 이름
}
