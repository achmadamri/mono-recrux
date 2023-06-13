package com.api.rec.member.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.api.rec.member.db.entity.TbCompany;
import com.api.rec.member.db.entity.TbPayment;
import com.api.rec.member.db.entity.TbUser;
import com.api.rec.member.db.repository.TbCompanyRepository;
import com.api.rec.member.db.repository.TbPaymentRepository;
import com.api.rec.member.db.repository.TbUserRepository;
import com.api.rec.member.model.payment.PostAddRequestModel;
import com.api.rec.member.model.payment.PostAddResponseModel;
import com.api.rec.member.model.user.PostSyncCompanyRequestModel;
import com.api.rec.member.util.SimpleMapper;
import com.api.rec.member.util.TokenUtil;
import com.api.rec.member.util.Uid;

@Service
public class PaymentService {

	private Logger log = LoggerFactory.getLogger(PaymentService.class);
	
	@Autowired
	private Environment env;
	
	private TokenUtil tokenUtil = new TokenUtil();
	
	@Autowired
	private TbUserRepository tbUserRepository;
	
	@Autowired
	private TbPaymentRepository tbPaymentRepository;
	
	@Autowired
	private TbCompanyRepository tbCompanyRepository;

	private static String accessToken = "";

	private String getAccessToken() {
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Accept-Language", "en_US");

		byte[] encodedAuth = Base64.encodeBase64((env.getProperty("paypall.client_id") + ":" + env.getProperty("paypall.client_secret")).getBytes());
		String authHeader = "Basic " + new String(encodedAuth );
		headers.set("Authorization", authHeader);
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("grant_type", "client_credentials");
		
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange("https://api-m.sandbox.paypal.com/v1/oauth2/token", HttpMethod.POST, httpEntity, String.class);
		
		JSONObject jsonObject = new JSONObject(responseEntity.getBody());
		
		return jsonObject.getString("access_token");
	}
	
	private JSONObject getPaymentDetail(String id) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			headers.add("Authorization", "Bearer " + PaymentService.accessToken);
			HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange("https://api.sandbox.paypal.com/v2/checkout/orders/" + id, HttpMethod.GET, httpEntity, String.class);
			
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				return new JSONObject(responseEntity.getBody());			
			} else {
				return null;
			}
		} catch (HttpClientErrorException e) {
			if (e.getMessage().equals("401 Unauthorized")) {
				PaymentService.accessToken = getAccessToken();
				
				RestTemplate restTemplate = new RestTemplate();
				HttpHeaders headers = new HttpHeaders();
				headers.add("Content-Type", "application/json");
				headers.add("Authorization", "Bearer " + PaymentService.accessToken);
				HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
				ResponseEntity<String> responseEntity = restTemplate.exchange("https://api.sandbox.paypal.com/v2/checkout/orders/" + id, HttpMethod.GET, httpEntity, String.class);
				
				if (responseEntity.getStatusCode() == HttpStatus.OK) {
					return new JSONObject(responseEntity.getBody());
				} else {
					return null;
				}
			} else {
				throw e;				
			}
		}
	}
	
	public PostAddResponseModel postAdd(PostAddRequestModel requestModel) throws Exception {
		PostAddResponseModel responseModel = new PostAddResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			JSONObject paymentDetail = getPaymentDetail(requestModel.getTbPayment().getTbpOrderId());

			if (paymentDetail != null) {
				if (paymentDetail.getString("status").equals("COMPLETED")) {
					TbPayment tbPayment = requestModel.getTbPayment();
					tbPayment.setTbpCreateId(optTbUser.get().getTbuId());
					tbPayment.setTbpCreateDate(new Date());
					tbPayment.setTbpCreateIdc(optTbUser.get().getTbuCreateIdc());			
					tbPaymentRepository.save(tbPayment);

					int parse = 3000;
					int token = 1500000;
					TbCompany exampleTbCompany = new TbCompany();
					exampleTbCompany.setTbcId(optTbUser.get().getTbuCreateIdc());
					Optional<TbCompany> optTbCompany = tbCompanyRepository.findOne(Example.of(exampleTbCompany));
					optTbCompany.get().setTbcParse(optTbCompany.get().getTbcParse() + parse);
					optTbCompany.get().setTbcToken(optTbCompany.get().getTbcToken() + token);
					tbCompanyRepository.save(optTbCompany.get());

					RestTemplate restTemplate = new RestTemplate();

					HttpHeaders headersPost = new HttpHeaders();
					headersPost.setContentType(MediaType.APPLICATION_JSON);
					SimpleMapper simpleMapper = new SimpleMapper();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS000");
					PostSyncCompanyRequestModel postSyncCompanyRequestModel = new PostSyncCompanyRequestModel();
					postSyncCompanyRequestModel.setRequestDate(sdf.format(new Date()));
					postSyncCompanyRequestModel.setRequestId(new Uid().generateString(10));
					postSyncCompanyRequestModel.setEmail(optTbUser.get().getTbuEmail());
					com.api.rec.member.model.user.TbCompany postSyncCompanyTbCompany = new com.api.rec.member.model.user.TbCompany();
					postSyncCompanyTbCompany = (com.api.rec.member.model.user.TbCompany) simpleMapper.assign(optTbCompany.get(), postSyncCompanyTbCompany);
					postSyncCompanyRequestModel.setTbCompany(postSyncCompanyTbCompany);
					HttpEntity<PostSyncCompanyRequestModel> requestPostUserRegisterOrder = new HttpEntity<>(postSyncCompanyRequestModel, headersPost);
					restTemplate.postForEntity(env.getProperty("services.bsd.api.rec.departments") + "user/postsynccompany", requestPostUserRegisterOrder, String.class);
					
					responseModel.setStatus("200");
					responseModel.setMessage(env.getProperty("service.payment.postadd.ok"));
				} else {
					responseModel.setStatus("404");
					responseModel.setMessage(env.getProperty("service.payment.postadd.notfound"));
				}
			} else {
				responseModel.setStatus("404");
				responseModel.setMessage(env.getProperty("service.payment.postadd.notfound"));
			}
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage(env.getProperty("service.payment.postadd.notfound"));
		}
		
		return responseModel;
	}
}
