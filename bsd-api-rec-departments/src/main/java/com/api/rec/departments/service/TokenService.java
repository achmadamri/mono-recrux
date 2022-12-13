package com.api.rec.departments.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.db.repository.TbUserRepository;
import com.api.rec.departments.model.token.PostSyncRequestModel;
import com.api.rec.departments.model.token.PostSyncResponseModel;
import com.api.rec.departments.util.TokenUtil;

@Service
public class TokenService {

	private TokenUtil tokenUtil = new TokenUtil();
	
	@Autowired
	private TbUserRepository tbUserRepository;
	
	public PostSyncResponseModel postSync(PostSyncRequestModel requestModel) throws Exception {
		PostSyncResponseModel responseModel = new PostSyncResponseModel(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			tokenUtil.store(requestModel.getEmail(), requestModel.getSalt());
			
			tbUser.setTbuUpdateDate(new Date());
			tbUser.setTbuUpdateId(tbUser.getTbuId());			
			tbUser.setTbuTokenSalt(TokenUtil.keyMap.get(tbUser.getTbuEmail()));
			tbUserRepository.save(tbUser);
			
			responseModel.setStatus("200");
			responseModel.setMessage("User ok");
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});
		
		return responseModel;
	}
}
