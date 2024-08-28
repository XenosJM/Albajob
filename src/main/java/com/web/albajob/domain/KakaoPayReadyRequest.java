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
public class KakaoPayReadyRequest {
	private String cid; // 가맹점 코드, 10자
	private String partner_order_id; // 가맹점 주문번호, 최대 100자
	private String partner_user_id; // 가맹점 회원 id, 최대 100자
	private String item_name; // 상품명, 최대 100자
	private int quantity; // 상품 수량
	private String total_amount; // 상품 총액
	private int tax_free_amount; // 상품 비과세 금액 = 원가
	private int vat_amount; // 상품 부가세 금액 = 원가 * 0.1
	private String approval_url; // 결제 성공시 연결될 url
	private String cancel_url; // 결제 취소시 연결될 url
	private String fail_url; // 결제 실패시 연결될 url
}
