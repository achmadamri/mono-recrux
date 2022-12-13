package com.api.rec.member.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.api.rec.member.db.entity.TbUser;
import com.api.rec.member.db.repository.TbUserRepository;
import com.api.rec.member.model.token.PostSyncRequestModel;
import com.api.rec.member.model.token.PostSyncResponseModel;
import com.api.rec.member.util.TokenUtil;

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
