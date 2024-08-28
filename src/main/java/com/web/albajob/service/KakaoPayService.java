package com.web.albajob.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.web.albajob.domain.KakaoPayApproveRequest;
import com.web.albajob.domain.KakaoPayReadyRequest;
import com.web.albajob.domain.KakaoPayReadyResponse;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class KakaoPayService {
	@Value("DEVE672874A8D98C32490C70FC395E178522B2E0")
	private String kakaopaySecretKey;
	
	@Value("TC0ONETIME")
	private String cid;
	
	@Value("http://localhost:8080/Albajob")
	private String sampleHost;
	
	private String tid;
	
	// 결제에 필요한 정보를 api 양식에 맞게 호출하여 결제 준비 후 사용자에게 결제 승인 요청
	public KakaoPayReadyResponse ready() {
		log.info("");
		
		// Request header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "DEV_SECRET_KEY " + kakaopaySecretKey);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// Request param
		KakaoPayReadyRequest readyRequest = KakaoPayReadyRequest.builder()
			.cid(cid)
			.partner_order_id("")
			.partner_user_id("")
			.item_name("")
			.quantity(1)
			.total_amount("")
			.tax_free_amount(0)
			.vat_amount(0)
			.approval_url(sampleHost + "/approve")
			.cancel_url(sampleHost + "/cancel")
			.fail_url(sampleHost + "/fail")
			.build();
		
			// Send Request(파라미터 + 헤더)
			HttpEntity<KakaoPayReadyRequest> entityMap = new HttpEntity<>(readyRequest, headers);
			ResponseEntity<KakaoPayReadyResponse> response = new RestTemplate().postForEntity(
					"https://open-api.kakaopay.com/online/v1/payment/ready",
					entityMap,
					KakaoPayReadyResponse.class);
			KakaoPayReadyResponse readyResponse = response.getBody();
			
			log.info("readyResponse : " + readyResponse);
			
			// 주문번호와 TID를 매핑해서 저장
			this.tid = readyResponse.getTid();
			return readyResponse;
	} // end ready()
	
	// 사용자에게 결제 요청을 승인 하면 결제한 정보를 바탕으로 결제 완료 후 알림톡 송신
	public String approve(String pgToken) {
		// ready()를 진행할 때 저장해 놓은 TID로 승인 요청
		
		// Request header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "DEV_SECRET_KEY " + kakaopaySecretKey);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// Request param
		KakaoPayApproveRequest approveRequest = KakaoPayApproveRequest.builder()
				.cid(cid)
				.tid(tid)
				.partner_order_id("")
				.partner_user_id("")
				.pg_token(pgToken)
				.build();
		
		// Send Request
		HttpEntity<KakaoPayApproveRequest> entityMap = new HttpEntity<>(approveRequest);
		try {
			ResponseEntity<String> response = new RestTemplate().postForEntity(
					"https://open-api.kakaopay.com/online/v1/payment/approve",
					entityMap,
					String.class);
			
			// 승인 결과를 저장
			String approveResponse = response.getBody();
			log.info("approve()end");
			return approveResponse;
		} catch (HttpStatusCodeException ex) {
			log.info("approve()end");
			return ex.getResponseBodyAsString();
		}
	}
}
