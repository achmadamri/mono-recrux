package com.api.rec.member.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.api.rec.member.db.entity.TbUser;
import com.api.rec.member.db.repository.TbUserRepository;
import com.api.rec.member.model.payment.PostAddRequestModel;
import com.api.rec.member.model.payment.PostAddResponseModel;
import com.api.rec.member.util.TokenUtil;

@Service
public class PaymentService {

	private Logger log = LoggerFactory.getLogger(PaymentService.class);
	
	@Autowired
	private Environment env;
	
	private TokenUtil tokenUtil = new TokenUtil();
	
	@Autowired
	private TbUserRepository tbUserRepository;
	
	public PostAddResponseModel postAdd(PostAddRequestModel requestModel) throws Exception {
		PostAddResponseModel responseModel = new PostAddResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			responseModel.setStatus("200");
			responseModel.setMessage(env.getProperty("service.payment.postadd.ok"));
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage(env.getProperty("service.payment.postadd.notfound"));
		}
		
		return responseModel;
	}
}
