package com.api.rec.departments.service;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.db.repository.TbUserRepository;
import com.api.rec.departments.model.auth.PostAddRequestModel;
import com.api.rec.departments.model.auth.PutUpdateRequestModel;
import com.api.rec.departments.model.user.PostUserAddRequestModel;
import com.api.rec.departments.model.user.PostUserAddResponseModel;
import com.api.rec.departments.model.user.PostUserChangePasswordRequestModel;
import com.api.rec.departments.model.user.PostUserChangePasswordResponseModel;
import com.api.rec.departments.model.user.PostUserEditRequestModel;
import com.api.rec.departments.model.user.PostUserEditResponseModel;
import com.api.rec.departments.model.user.PostUserRegisterRequestModel;
import com.api.rec.departments.model.user.PostUserRegisterResponseModel;
import com.api.rec.departments.util.MD5;
import com.api.rec.departments.util.TokenUtil;
import com.api.rec.departments.util.Uid;

@Service
public class UserService {

	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private Environment env;
	
	private TokenUtil tokenUtil = new TokenUtil();
	
	@Autowired
	private TbUserRepository tbUserRepository;
	
	public PostUserAddResponseModel postUserAdd(PostUserAddRequestModel requestModel) throws Exception {
		PostUserAddResponseModel responseModel = new PostUserAddResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			TbUser exampleTbUserNew = new TbUser();
			exampleTbUserNew.setTbuEmail(requestModel.getTbUser().getTbuEmail());
			Optional<TbUser> optTbUserNew = tbUserRepository.findOne(Example.of(exampleTbUserNew));
			
			if (optTbUserNew.isPresent()) {
				responseModel.setStatus("403");
				responseModel.setMessage("Data already exists. Email : " + requestModel.getTbUser().getTbuEmail());
			} else {
				TbUser tbUser = new TbUser();
				tbUser.setTbuEmail(requestModel.getTbUser().getTbuEmail());
				tbUser.setTbuFirstname(requestModel.getTbUser().getTbuFirstname());
				tbUser.setTbuLastname(requestModel.getTbUser().getTbuLastname());
				tbUser.setTbuPassword(new MD5().get(requestModel.getTbUser().getTbuPassword()));
				tbUser.setTbuCreateDate(new Date());
				tbUser.setTbuCreateId(optTbUser.get().getTbuId());
				tbUser.setTbuStatus(TbUserRepository.Active);
				tbUser.setTbuTokenSalt(new Uid().generateString(36));
				tbUser.setTbuRole(requestModel.getTbUser().getTbuRole());
				tbUserRepository.save(tbUser);
				
				RestTemplate restTemplate = new RestTemplate();
				
				PostAddRequestModel postAddRequestModel = new PostAddRequestModel();				
				postAddRequestModel.setEmail(requestModel.getEmail());
				postAddRequestModel.setToken(requestModel.getToken());
				postAddRequestModel.setTbaEmail(tbUser.getTbuEmail());
				postAddRequestModel.setTbaRole(tbUser.getTbuRole());
				postAddRequestModel.setTbaPassword(tbUser.getTbuPassword());
				postAddRequestModel.setTbaStatus(tbUser.getTbuStatus());
				postAddRequestModel.setTbaTokenSalt(tbUser.getTbuTokenSalt());
				postAddRequestModel.setTbaRole(tbUser.getTbuRole());
				HttpEntity<PostAddRequestModel> requestPostAdd = new HttpEntity<>(postAddRequestModel);
				restTemplate.postForEntity(env.getProperty("services.bsd.api.rec.auth") + "auth/postadd", requestPostAdd, String.class);
			}
			
			responseModel.setStatus("200");
			responseModel.setMessage("User created");
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		}
		
		return responseModel;
	}

	public PostUserRegisterResponseModel postUserRegister(PostUserRegisterRequestModel requestModel) throws Exception {
		PostUserRegisterResponseModel responseModel = new PostUserRegisterResponseModel(requestModel);
		
		TbUser exampleTbUserNew = new TbUser();
		exampleTbUserNew.setTbuEmail(requestModel.getTbUser().getTbuEmail());
		Optional<TbUser> optTbUserNew = tbUserRepository.findOne(Example.of(exampleTbUserNew));
		
		if (optTbUserNew.isPresent()) {
			responseModel.setStatus("403");
			responseModel.setMessage("Data already exists. Email : " + requestModel.getTbUser().getTbuEmail());
		} else {
			TbUser tbUser = new TbUser();
			tbUser.setTbuEmail(requestModel.getTbUser().getTbuEmail());
			tbUser.setTbuFirstname(requestModel.getTbUser().getTbuFirstname());
			tbUser.setTbuLastname(requestModel.getTbUser().getTbuLastname());
			tbUser.setTbuPassword(new MD5().get(requestModel.getTbUser().getTbuPassword()));
			tbUser.setTbuCreateDate(new Date());
			tbUser.setTbuCreateId(null);
			tbUser.setTbuStatus(TbUserRepository.NeedConfirmation);
			tbUser.setTbuTokenSalt(new Uid().generateString(36));
			tbUser.setTbuRole(requestModel.getTbUser().getTbuRole());
			tbUserRepository.save(tbUser);
		}
		
		responseModel.setStatus("200");
		responseModel.setMessage("User created");
		
		return responseModel;
	}
	
	public PostUserEditResponseModel postUserEdit(PostUserEditRequestModel requestModel) throws Exception {
		PostUserEditResponseModel responseModel = new PostUserEditResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			TbUser exampleTbUserExisting = new TbUser();
			exampleTbUserExisting.setTbuEmail(requestModel.getTbUser().getTbuEmail());
			Optional<TbUser> optTbUserExisting = tbUserRepository.findOne(Example.of(exampleTbUserExisting));
			
			if (optTbUserExisting.isPresent()) {
				optTbUserExisting.get().setTbuRole(requestModel.getTbUser().getTbuRole());
				optTbUserExisting.get().setTbuFirstname(requestModel.getTbUser().getTbuFirstname());
				optTbUserExisting.get().setTbuLastname(requestModel.getTbUser().getTbuLastname());				
				
				if (!requestModel.getTbUser().getTbuPassword().equals("")) {
					optTbUserExisting.get().setTbuPassword(new MD5().get(requestModel.getTbUser().getTbuPassword()));	
				}
				
				optTbUserExisting.get().setTbuUpdateDate(new Date());
				optTbUserExisting.get().setTbuUpdateId(optTbUser.get().getTbuId());
				tbUserRepository.save(optTbUserExisting.get());
				
				RestTemplate restTemplate = new RestTemplate();
				
				PutUpdateRequestModel putUpdateRequestModel = new PutUpdateRequestModel();
				putUpdateRequestModel.setTbaRole(optTbUserExisting.get().getTbuRole());
				putUpdateRequestModel.setTbaEmail(optTbUserExisting.get().getTbuEmail());
				putUpdateRequestModel.setTbaPassword(optTbUserExisting.get().getTbuPassword());
				putUpdateRequestModel.setTbaStatus(optTbUserExisting.get().getTbuStatus());
				HttpEntity<PutUpdateRequestModel> requestPutUpdate = new HttpEntity<>(putUpdateRequestModel);
				restTemplate.put(env.getProperty("services.bsd.api.rec.auth") + "auth/putupdate", requestPutUpdate, String.class);
				
				responseModel.setStatus("200");
				responseModel.setMessage("User " + optTbUserExisting.get().getTbuEmail() + " updated");
			} else {
				responseModel.setStatus("404");
				responseModel.setMessage("Not found");
			}
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		}
		
		return responseModel;
	}
	
	public PostUserChangePasswordResponseModel postUserChangePassword(PostUserChangePasswordRequestModel requestModel) throws Exception {
		PostUserChangePasswordResponseModel responseModel = new PostUserChangePasswordResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			TbUser exampleTbUserExisting = new TbUser();
			exampleTbUserExisting.setTbuEmail(requestModel.getTbUser().getTbuEmail());
			Optional<TbUser> optTbUserExisting = tbUserRepository.findOne(Example.of(exampleTbUserExisting));
			
			if (optTbUserExisting.isPresent()) {
				optTbUserExisting.get().setTbuPassword(new MD5().get(requestModel.getTbUser().getTbuPassword()));
				optTbUserExisting.get().setTbuUpdateDate(new Date());
				optTbUserExisting.get().setTbuUpdateId(optTbUser.get().getTbuId());
				tbUserRepository.save(optTbUserExisting.get());
				
				RestTemplate restTemplate = new RestTemplate();
				
				PutUpdateRequestModel putUpdateRequestModel = new PutUpdateRequestModel();
				putUpdateRequestModel.setTbaRole(optTbUserExisting.get().getTbuRole());
				putUpdateRequestModel.setTbaEmail(optTbUserExisting.get().getTbuEmail());
				putUpdateRequestModel.setTbaPassword(optTbUserExisting.get().getTbuPassword());
				putUpdateRequestModel.setTbaStatus(optTbUserExisting.get().getTbuStatus());
				HttpEntity<PutUpdateRequestModel> requestPutUpdate = new HttpEntity<>(putUpdateRequestModel);
				restTemplate.put(env.getProperty("services.bsd.api.rec.auth") + "auth/putupdate", requestPutUpdate, String.class);
				
				responseModel.setStatus("200");
				responseModel.setMessage("User change password");
			} else {
				responseModel.setStatus("404");
				responseModel.setMessage("Not found");
			}
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		}
		
		return responseModel;
	}
}
