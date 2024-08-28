package com.web.albajob.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@ToString
public class KakaoPayApproveRequest {
	private String cid; // 가맹점 코드
	private String tid; // 결제 고유번호
	private String partner_order_id; // 가맹점 주문번호
	private String partner_user_id; // 가맹점 회원 id
	private String pg_token; // 결제승인 요청을 인증하는 토큰
}
