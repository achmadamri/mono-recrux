package com.api.rec.auth.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.api.rec.auth.db.entity.TbAuth;
import com.api.rec.auth.db.repository.TbAuthRepository;
import com.api.rec.auth.model.auth.GetInvalidateRequestModel;
import com.api.rec.auth.model.auth.GetInvalidateResponseModel;
import com.api.rec.auth.model.auth.PostAddRequestModel;
import com.api.rec.auth.model.auth.PostAddResponseModel;
import com.api.rec.auth.model.auth.PostCheckRequestModel;
import com.api.rec.auth.model.auth.PostCheckResponseModel;
import com.api.rec.auth.model.auth.PostGenerateRequestModel;
import com.api.rec.auth.model.auth.PostGenerateResponseModel;
import com.api.rec.auth.model.auth.PutUpdateRequestModel;
import com.api.rec.auth.model.auth.PutUpdateResponseModel;
import com.api.rec.auth.util.SimpleMapper;
import com.api.rec.auth.util.TokenUtil;

import io.jsonwebtoken.Claims;

@Service
public class AuthService {
	
	private TokenUtil tokenUtil = new TokenUtil();
	
	@Autowired
	private Environment env;
	
	@Autowired
	private TbAuthRepository tbAuthRepository;
	
	public PutUpdateResponseModel putUpdate(PutUpdateRequestModel requestModel) {
		PutUpdateResponseModel responseModel = new PutUpdateResponseModel(requestModel);
		
		TbAuth exampleTbAuth = new TbAuth();
		exampleTbAuth.setTbaEmail(requestModel.getTbaEmail());
		Optional<TbAuth> optTbAuth = tbAuthRepository.findOne(Example.of(exampleTbAuth));
		
		optTbAuth.ifPresentOrElse(tbAuth -> {
			SimpleMapper simpleMapper = new SimpleMapper();
			tbAuth = (TbAuth) simpleMapper.assign(requestModel, tbAuth);
			
			tbAuth.setTbaUpdateDate(new Date());
			tbAuth.setTbaUpdateId(0);
			
			if (requestModel.getNewPassword() != null) {
				tbAuth.setTbaPassword(requestModel.getNewPassword());
			}

			responseModel.setStatus("200");
			responseModel.setMessage("Auth updated");
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});		
		
		
		return responseModel;
	}
	
	public PostAddResponseModel postAdd(PostAddRequestModel requestModel) {
		PostAddResponseModel responseModel = new PostAddResponseModel(requestModel);
		
		TbAuth exampleTbAuth = new TbAuth();
		exampleTbAuth.setTbaEmail(requestModel.getTbaEmail());
		Optional<TbAuth> optTbAuth = tbAuthRepository.findOne(Example.of(exampleTbAuth));

		if (optTbAuth.isPresent()) {
			responseModel.setStatus("208");
			responseModel.setMessage("Email already exists");
		} else {
			TbAuth tbAuth = new TbAuth();
			SimpleMapper simpleMapper = new SimpleMapper();
			tbAuth = (TbAuth) simpleMapper.assign(requestModel, tbAuth);
			
			tbAuth.setTbaStatus(requestModel.getTbaStatus());
			tbAuth.setTbaCreateDate(new Date());
			tbAuth.setTbaCreateId(0);
			tbAuthRepository.save(tbAuth);
			
			TokenUtil.keyMap.put(tbAuth.getTbaEmail(), tbAuth.getTbaTokenSalt());
			
			responseModel.setStatus("200");
			responseModel.setMessage("Email added");
		}
		
		return responseModel;
	}
	
	public PostGenerateResponseModel postGenerate(PostGenerateRequestModel requestModel) {
		PostGenerateResponseModel responseModel = new PostGenerateResponseModel(requestModel);
		
		TbAuth exampleTbAuthByEMail = new TbAuth();
		exampleTbAuthByEMail.setTbaEmail(requestModel.getTbaEmail());
		exampleTbAuthByEMail.setTbaPassword(requestModel.getTbaPassword());
		exampleTbAuthByEMail.setTbaStatus(TbAuthRepository.Active);
		Optional<TbAuth> optTbAuthByEmail = tbAuthRepository.findOne(Example.of(exampleTbAuthByEMail));

		optTbAuthByEmail.ifPresentOrElse(tbAuth -> {
			String token = tokenUtil.generate(optTbAuthByEmail.get().getTbaEmail(), new String[] {
					env.getProperty("services.bsd.api.rec.member")
			}, requestModel.getRemember() == null ? false : (requestModel.getRemember().equals("true") ? true : false));
			
			tbAuth.setTbaUpdateDate(new Date());
			tbAuth.setTbaUpdateId(0);
			tbAuth.setTbaTokenSalt(TokenUtil.keyMap.get(tbAuth.getTbaEmail()));
			tbAuthRepository.save(tbAuth);
			
			try {
				requestModel.setEmail(optTbAuthByEmail.get().getTbaEmail());
				requestModel.setToken(token);
				Claims claims = tokenUtil.claims(requestModel);
				responseModel.setClaims(claims);
				
				responseModel.setToken(token);
				responseModel.setStatus("200");
				responseModel.setMessage("Auth generated");
			} catch (Exception e) {
				responseModel.setStatus("500");
				responseModel.setMessage(e.getMessage());
			}
		}, () -> {
			responseModel.setStatus("401");
			responseModel.setMessage("Invalid login");
		});
		
		return responseModel;
	}
	
	public PostCheckResponseModel postCheck(PostCheckRequestModel requestModel) {
		PostCheckResponseModel responseModel = new PostCheckResponseModel(requestModel);
		
		try {
			requestModel.setEmail(requestModel.getTbaEmail());
			requestModel.setToken(requestModel.getTbaToken());
			Claims claims = tokenUtil.claims(requestModel);
			responseModel.setClaims(claims);
			
			responseModel.setStatus("200");
			responseModel.setMessage("Auth checked");
		} catch (Exception e) {
			responseModel.setStatus("500");
			responseModel.setMessage(e.getMessage());
		}
		
		return responseModel;
	}
	
	public GetInvalidateResponseModel getInvalidate(GetInvalidateRequestModel requestModel) throws Exception {
		GetInvalidateResponseModel responseModel = new GetInvalidateResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbAuth exampleTbAuth = new TbAuth();
		exampleTbAuth.setTbaEmail(requestModel.getEmail());
		exampleTbAuth.setTbaStatus(TbAuthRepository.Active);
		Optional<TbAuth> optTbAuth = tbAuthRepository.findOne(Example.of(exampleTbAuth));
		
		optTbAuth.ifPresentOrElse(tbAuth -> {
			tokenUtil.invalidate(tbAuth.getTbaEmail(), new String[] {
					env.getProperty("services.bsd.api.rec.member"),
					env.getProperty("services.bsd.api.rec.order"),
					env.getProperty("services.bsd.api.rec.product"),
					env.getProperty("services.bsd.api.rec.report")
			});
			
			responseModel.setStatus("200");
			responseModel.setMessage("Auth invalidated");
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});
		
		return responseModel;
	}
}
