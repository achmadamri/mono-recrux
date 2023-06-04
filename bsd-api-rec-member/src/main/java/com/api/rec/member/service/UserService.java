package com.api.rec.member.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.api.rec.member.db.entity.TbCompany;
import com.api.rec.member.db.entity.TbNotification;
import com.api.rec.member.db.entity.TbNotificationData;
import com.api.rec.member.db.entity.TbUser;
import com.api.rec.member.db.entity.TbUserMenu;
import com.api.rec.member.db.entity.ViewUserMenu;
import com.api.rec.member.db.repository.TbCompanyRepository;
import com.api.rec.member.db.repository.TbNotificationDataRepository;
import com.api.rec.member.db.repository.TbNotificationRepository;
import com.api.rec.member.db.repository.TbUserMenuRepository;
import com.api.rec.member.db.repository.TbUserRepository;
import com.api.rec.member.db.repository.ViewUserMenuRepository;
import com.api.rec.member.model.auth.PostAddRequestModel;
import com.api.rec.member.model.auth.PutUpdateRequestModel;
import com.api.rec.member.model.user.GetUserListRequestModel;
import com.api.rec.member.model.user.GetUserListResponseModel;
import com.api.rec.member.model.user.GetUserMenuListRequestModel;
import com.api.rec.member.model.user.GetUserMenuListResponseModel;
import com.api.rec.member.model.user.GetUserRequestModel;
import com.api.rec.member.model.user.GetUserResponseModel;
import com.api.rec.member.model.user.PostConfirmationRequestModel;
import com.api.rec.member.model.user.PostConfirmationResponseModel;
import com.api.rec.member.model.user.PostSyncCompanyRequestModel;
import com.api.rec.member.model.user.PostSyncCompanyResponseModel;
import com.api.rec.member.model.user.PostUserAddRequestModel;
import com.api.rec.member.model.user.PostUserAddResponseModel;
import com.api.rec.member.model.user.PostUserChangePasswordRequestModel;
import com.api.rec.member.model.user.PostUserChangePasswordResponseModel;
import com.api.rec.member.model.user.PostUserEditRequestModel;
import com.api.rec.member.model.user.PostUserEditResponseModel;
import com.api.rec.member.model.user.PostUserRegisterRequestModel;
import com.api.rec.member.model.user.PostUserRegisterResponseModel;
import com.api.rec.member.util.MD5;
import com.api.rec.member.util.SimpleMapper;
import com.api.rec.member.util.TokenUtil;
import com.api.rec.member.util.Uid;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.resource.Emailv31;

@Service
public class UserService {

	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private Environment env;
	
	private TokenUtil tokenUtil = new TokenUtil();
	
	@Autowired
	private TbUserRepository tbUserRepository;
	
	@Autowired
	private TbUserMenuRepository tbUserMenuRepository;
	
	@Autowired
	private ViewUserMenuRepository viewUserMenuRepository;
	
	@Autowired
	private TbNotificationRepository tbNotificationRepository;
	
	@Autowired
	private TbNotificationDataRepository tbNotificationDataRepository;
	
	@Autowired
	private TbCompanyRepository tbCompanyRepository;

	public PostSyncCompanyResponseModel postSyncCompany(PostSyncCompanyRequestModel requestModel) throws Exception {
		PostSyncCompanyResponseModel responseModel = new PostSyncCompanyResponseModel(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		optTbUser.ifPresentOrElse(tbUser -> {
			TbCompany tbCompany = requestModel.getTbCompany();			
			tbCompanyRepository.save(tbCompany);
			
			responseModel.setStatus("200");
			responseModel.setMessage("Company ok");
		}, () -> {
			responseModel.setStatus("404");
			responseModel.setMessage("Not found");
		});
		
		return responseModel;
	}
	
	public GetUserResponseModel getUser(String tbuId, GetUserRequestModel requestModel) throws Exception {
		GetUserResponseModel responseModel = new GetUserResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		
		if (tbuId.equals("")) {
			exampleTbUser.setTbuEmail(requestModel.getEmail());
		} else {
			exampleTbUser.setTbuId(Integer.valueOf(tbuId));
		}
		
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			responseModel.setTbUser(optTbUser.get());

			TbCompany exampleTbCompany = new TbCompany();
			exampleTbCompany.setTbcId(optTbUser.get().getTbuCreateIdc());
			Optional<TbCompany> optTbCompany = tbCompanyRepository.findOne(Example.of(exampleTbCompany));
			responseModel.setTbCompany(optTbCompany.get());
			
			ViewUserMenu exampleViewUserMenu = new ViewUserMenu();
			exampleViewUserMenu.setTbuId(optTbUser.get().getTbuId());
			List<ViewUserMenu> lstViewUserMenu = viewUserMenuRepository.findAll(Example.of(exampleViewUserMenu), Sort.by("tbmName").ascending());
			responseModel.setLstViewUserMenu(lstViewUserMenu);
			
			responseModel.setStatus("200");
			responseModel.setMessage(env.getProperty("service.user.getuser.userok"));
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage(env.getProperty("service.user.getuser.notfound"));
		}
		
		return responseModel;
	}
	
	public GetUserListResponseModel getUserList(String tbuEmail, String tbuFirstname, String tbuLastname, String length, String pageSize, String pageIndex, GetUserListRequestModel requestModel) throws Exception {
		GetUserListResponseModel responseModel = new GetUserListResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("tbuEmail", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				.withMatcher("tbuFirstname", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				.withMatcher("tbuLastname", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
				;
	
			exampleTbUser = new TbUser();
			exampleTbUser.setTbuEmail(tbuEmail);
			exampleTbUser.setTbuFirstname(tbuFirstname);
			exampleTbUser.setTbuLastname(tbuLastname);
			
			Page<TbUser> pgTbUser = tbUserRepository.findAll(Example.of(exampleTbUser, matcher), PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbuId").ascending()));
			
			if (pgTbUser.toList().size() > 0) {
				List<TbUser> lstTbUser = pgTbUser.toList();
				responseModel.setLstTbUser(lstTbUser);
				
				responseModel.setLength(tbUserRepository.count(Example.of(exampleTbUser, matcher)));
				
				responseModel.setStatus("200");
				responseModel.setMessage(env.getProperty("service.user.getuser.userok"));
			} else {
				responseModel.setStatus("404");
				responseModel.setMessage(env.getProperty("service.user.getuser.notfound"));
			}
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage(env.getProperty("service.user.getuser.notfound"));
		}
		
		return responseModel;
	}
	
	public GetUserMenuListResponseModel getUserMenuList(String tbuEmail, GetUserMenuListRequestModel requestModel) throws Exception {
		GetUserMenuListResponseModel responseModel = new GetUserMenuListResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			ViewUserMenu exampleViewUserMenu = new ViewUserMenu();	
			exampleViewUserMenu.setTbuEmail(tbuEmail.equals("") ? "admin@mail.com" : tbuEmail);
			
			List<ViewUserMenu> lstViewUserMenu = viewUserMenuRepository.findAll(Example.of(exampleViewUserMenu), Sort.by("tbmSort").ascending());
			
			if (tbuEmail.equals("")) {
				for (ViewUserMenu viewUserMenu : lstViewUserMenu) {
					viewUserMenu.setTbumAdd(0);
					viewUserMenu.setTbumEdit(0);
					viewUserMenu.setTbumDelete(0);
					viewUserMenu.setTbumView(0);
				}
			}
			
			responseModel.setLstViewUserMenu(lstViewUserMenu);
			
			responseModel.setStatus("200");
			responseModel.setMessage(env.getProperty("service.user.getuser.userok"));
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage(env.getProperty("service.user.getuser.notfound"));
		}
		
		return responseModel;
	}
	
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
				responseModel.setMessage(env.getProperty("service.user.postadd.emailalreadyexist") + requestModel.getTbUser().getTbuEmail());
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
				tbUserRepository.save(tbUser);
				
				for (ViewUserMenu viewUserMenu : requestModel.getLstViewUserMenu()) {
					TbUserMenu tbUserMenu = new TbUserMenu();
					tbUserMenu.setTbumCreateDate(new Date());
					tbUserMenu.setTbumCreateId(optTbUser.get().getTbuId());
					tbUserMenu.setTbuId(tbUser.getTbuId());
					tbUserMenu.setTbmId(viewUserMenu.getTbmId());
					tbUserMenu.setTbumAdd(viewUserMenu.getTbumAdd());
					tbUserMenu.setTbumEdit(viewUserMenu.getTbumEdit());
					tbUserMenu.setTbumDelete(viewUserMenu.getTbumDelete());
					tbUserMenu.setTbumView(viewUserMenu.getTbumView());
					tbUserMenuRepository.save(tbUserMenu);
				}
				
				RestTemplate restTemplate = new RestTemplate();
				
				PostAddRequestModel postAddRequestModel = new PostAddRequestModel();				
				postAddRequestModel.setEmail(requestModel.getEmail());
				postAddRequestModel.setToken(requestModel.getToken());
				postAddRequestModel.setTbaEmail(tbUser.getTbuEmail());
				postAddRequestModel.setTbaPassword(tbUser.getTbuPassword());
				postAddRequestModel.setTbaStatus(tbUser.getTbuStatus());
				postAddRequestModel.setTbaTokenSalt(tbUser.getTbuTokenSalt());
				HttpEntity<PostAddRequestModel> requestPostAdd = new HttpEntity<>(postAddRequestModel);
				restTemplate.postForEntity(env.getProperty("services.bsd.api.rec.auth") + "auth/postadd", requestPostAdd, String.class);
				
				SimpleMapper simpleMapper = new SimpleMapper();
				
				com.api.rec.member.model.departments.PostUserAddRequestModel postUserAddOrderRequestModel = new com.api.rec.member.model.departments.PostUserAddRequestModel();
				postUserAddOrderRequestModel.setEmail(requestModel.getEmail());
				postUserAddOrderRequestModel.setToken(requestModel.getToken());
				com.api.rec.member.model.departments.TbUser postUserAddOrderTbUser = new com.api.rec.member.model.departments.TbUser();
				postUserAddOrderTbUser = (com.api.rec.member.model.departments.TbUser) simpleMapper.assign(tbUser, postUserAddOrderTbUser);
				postUserAddOrderRequestModel.setTbUser(postUserAddOrderTbUser);
				HttpEntity<com.api.rec.member.model.departments.PostUserAddRequestModel> requestPostUserAddOrder = new HttpEntity<>(postUserAddOrderRequestModel);
				restTemplate.postForEntity(env.getProperty("services.bsd.api.rec.departments") + "user/postuseradd", requestPostUserAddOrder, String.class);
			}
			
			responseModel.setStatus("200");
			responseModel.setMessage(env.getProperty("service.user.postadd.usercreated"));
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage(env.getProperty("service.user.postadd.notfound"));
		}
		
		return responseModel;
	}

	public PostUserRegisterResponseModel postUserRegister(PostUserRegisterRequestModel requestModel) throws Exception {
		PostUserRegisterResponseModel responseModel = new PostUserRegisterResponseModel(requestModel);

		if (requestModel.getAgree() == null) requestModel.setAgree("false");

		if (requestModel.getAgree().equals("true")) {
			TbUser exampleTbUserNew = new TbUser();
			exampleTbUserNew.setTbuEmail(requestModel.getTbUser().getTbuEmail());
			Optional<TbUser> optTbUserNew = tbUserRepository.findOne(Example.of(exampleTbUserNew));
			
			if (optTbUserNew.isPresent()) {
				responseModel.setStatus("403");
				responseModel.setMessage(env.getProperty("service.user.postregister.emailalreadyexist") + requestModel.getTbUser().getTbuEmail());
			} else {
				TbUser tbUser = new TbUser();
				tbUser.setTbuEmail(requestModel.getTbUser().getTbuEmail());
				tbUser.setTbuFirstname(requestModel.getTbUser().getTbuFirstname());
				tbUser.setTbuLastname(requestModel.getTbUser().getTbuLastname());
				tbUser.setTbuMobilePhone(requestModel.getTbUser().getTbuMobilePhone());
				tbUser.setTbuPassword(new MD5().get(requestModel.getTbUser().getTbuPassword()));
				tbUser.setTbuCreateDate(new Date());
				tbUser.setTbuCreateId(null);
				tbUser.setTbuStatus(TbUserRepository.NeedConfirmation);
				tbUser.setTbuType("alpha");
				LocalDateTime expired = LocalDateTime.now(ZoneOffset.UTC);
				expired = expired.plusDays(7);
				tbUser.setTbuExpired(Date.from(expired.toInstant(ZoneOffset.UTC)));
				tbUser.setTbuUid(new Uid().generateString(100));
				tbUser.setTbuTokenSalt(new Uid().generateString(36));
				tbUserRepository.save(tbUser);

				TbNotification exampleTbNotification = new TbNotification();
				exampleTbNotification.setTbnCode("EMAIL.CONFIRMATION");
				exampleTbNotification.setTbnStatus(TbNotificationRepository.statusActive);
				Optional<TbNotification> optTbNotification = tbNotificationRepository.findOne(Example.of(exampleTbNotification));
	
				TbNotificationData tbNotificationData = new TbNotificationData();
				tbNotificationData.setTbndCreateDate(new Date());
				tbNotificationData.setTbndCreateId(0);
				tbNotificationData.setTbnId(optTbNotification.get().getTbnId());
				tbNotificationData.setTbndTo(tbUser.getTbuEmail());
				tbNotificationData.setTbndSubject(optTbNotification.get().getTbnSubject());

				String strHtml = optTbNotification.get().getTbnHtml();
				strHtml = strHtml.replaceAll("\\$\\{NAME\\}", tbUser.getTbuFirstname());
				strHtml = strHtml.replaceAll("\\$\\{EMAIL\\}", tbUser.getTbuEmail());

				strHtml = strHtml.replaceAll("\\$\\{URL\\}", "http://" + env.getProperty("services.domain") + ":4200/#/confirmation?uuid=" + tbUser.getTbuUid());
				tbNotificationData.setTbndHtml(strHtml);

				tbNotificationDataRepository.save(tbNotificationData);

				RestTemplate restTemplate = new RestTemplate();
			
				PostAddRequestModel postAddRequestModel = new PostAddRequestModel();				
				postAddRequestModel.setEmail(requestModel.getEmail());
				postAddRequestModel.setToken(requestModel.getToken());
				postAddRequestModel.setTbaEmail(tbUser.getTbuEmail());
				postAddRequestModel.setTbaPassword(tbUser.getTbuPassword());
				postAddRequestModel.setTbaStatus(tbUser.getTbuStatus());
				postAddRequestModel.setTbaTokenSalt(tbUser.getTbuTokenSalt());
				HttpEntity<PostAddRequestModel> requestPostAdd = new HttpEntity<>(postAddRequestModel);
				restTemplate.postForEntity(env.getProperty("services.bsd.api.rec.auth") + "auth/postadd", requestPostAdd, String.class);
				
				SimpleMapper simpleMapper = new SimpleMapper();
				
				com.api.rec.member.model.departments.PostUserRegisterRequestModel postUserRegisterOrderRequestModel = new com.api.rec.member.model.departments.PostUserRegisterRequestModel();
				postUserRegisterOrderRequestModel.setEmail(requestModel.getEmail());
				postUserRegisterOrderRequestModel.setToken(requestModel.getToken());
				com.api.rec.member.model.departments.TbUser postUserRegisterOrderTbUser = new com.api.rec.member.model.departments.TbUser();
				postUserRegisterOrderTbUser = (com.api.rec.member.model.departments.TbUser) simpleMapper.assign(tbUser, postUserRegisterOrderTbUser);
				postUserRegisterOrderRequestModel.setTbUser(postUserRegisterOrderTbUser);
				HttpEntity<com.api.rec.member.model.departments.PostUserRegisterRequestModel> requestPostUserRegisterOrder = new HttpEntity<>(postUserRegisterOrderRequestModel);
				restTemplate.postForEntity(env.getProperty("services.bsd.api.rec.departments") + "user/postuserregister", requestPostUserRegisterOrder, String.class);
	
				MailjetClient client = new MailjetClient("6d10186c41f3306a6e26576d8d9ea3c0", "04aa043913dd20aa5d3edd88cdefb546", new ClientOptions("v3.1"));
				MailjetRequest request = new MailjetRequest(Emailv31.resource)
											.property(Emailv31.MESSAGES, new JSONArray().put(new JSONObject()
											.put(Emailv31.Message.FROM, new JSONObject()
											.put("Email", "no-reply@dafba.com")
											.put("Name", "no-reply"))
											.put(Emailv31.Message.TO, new JSONArray().put(new JSONObject()
											.put("Email", tbNotificationData.getTbndTo())
											.put("Name", tbUser.getTbuFirstname())))
											.put(Emailv31.Message.SUBJECT, tbNotificationData.getTbndSubject())
											.put(Emailv31.Message.HTMLPART, tbNotificationData.getTbndHtml())
											.put(Emailv31.Message.CUSTOMID, "AppGettingStartedTest")));
				MailjetResponse response = client.post(request);
				
				if (response.getStatus() == 200) {
					tbNotificationData.setTbndStatus(TbNotificationDataRepository.statusSend);
				} else {
					tbNotificationData.setTbndStatus(TbNotificationDataRepository.statusError);
				}

				tbNotificationDataRepository.save(tbNotificationData);

				responseModel.setStatus("200");
				responseModel.setMessage(env.getProperty("service.user.postregister.usercreated"));
			}
		} else {
			responseModel.setStatus("403");
			responseModel.setMessage(env.getProperty("service.user.postregister.notagree"));
		}
		
		return responseModel;
	}

	public PostConfirmationResponseModel postConfirmation(PostConfirmationRequestModel requestModel) {
		PostConfirmationResponseModel responseModel = new PostConfirmationResponseModel(requestModel);

		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuUid(requestModel.getTbuUid());
		exampleTbUser.setTbuStatus(TbUserRepository.NeedConfirmation);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));

		if (optTbUser.isPresent()) {
			optTbUser.get().setTbuUpdateDate(new Date());
			optTbUser.get().setTbuUpdateId(0);
			optTbUser.get().setTbuStatus(TbUserRepository.Active);

			tbUserRepository.save(optTbUser.get());

			RestTemplate restTemplate = new RestTemplate();

			PutUpdateRequestModel putUpdateRequestModel = new PutUpdateRequestModel();
			putUpdateRequestModel.setTbaEmail(optTbUser.get().getTbuEmail());
			putUpdateRequestModel.setTbaStatus(optTbUser.get().getTbuStatus());
			HttpEntity<PutUpdateRequestModel> requestPutUpdate = new HttpEntity<>(putUpdateRequestModel);
			restTemplate.put(env.getProperty("services.bsd.api.rec.auth") + "auth/putupdate", requestPutUpdate, String.class);

			PostConfirmationRequestModel postConfirmationRequestModel = new PostConfirmationRequestModel();				
			postConfirmationRequestModel.setEmail(optTbUser.get().getTbuEmail());
			postConfirmationRequestModel.setTbuUid(optTbUser.get().getTbuUid());
			HttpEntity<PostConfirmationRequestModel> requestPostAdd = new HttpEntity<>(postConfirmationRequestModel);
			restTemplate.postForEntity(env.getProperty("services.bsd.api.rec.departments") + "user/postconfirmation", requestPostAdd, String.class);

			responseModel.setTbUsers(optTbUser.get());
			responseModel.setStatus("200");
			responseModel.setMessage(env.getProperty("service.user.postconfirmation.postconfirmation"));
		} else {
			responseModel.setStatus("401");
			responseModel.setMessage(env.getProperty("service.user.postconfirmation.datanotfound"));
		}

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
				optTbUserExisting.get().setTbuFirstname(requestModel.getTbUser().getTbuFirstname());
				optTbUserExisting.get().setTbuLastname(requestModel.getTbUser().getTbuLastname());				
				
				if (!requestModel.getTbUser().getTbuPassword().equals("")) {
					optTbUserExisting.get().setTbuPassword(new MD5().get(requestModel.getTbUser().getTbuPassword()));	
				}
				
				optTbUserExisting.get().setTbuUpdateDate(new Date());
				optTbUserExisting.get().setTbuUpdateId(optTbUser.get().getTbuId());
				tbUserRepository.save(optTbUserExisting.get());
				
				TbUserMenu exampleTbUserMenu = new TbUserMenu();
				exampleTbUserMenu.setTbuId(optTbUserExisting.get().getTbuId());
				List<TbUserMenu> lstTbUserMenu = tbUserMenuRepository.findAll(Example.of(exampleTbUserMenu));
				tbUserMenuRepository.deleteAll(lstTbUserMenu);
				for (ViewUserMenu viewUserMenu : requestModel.getLstViewUserMenu()) {
					TbUserMenu tbUserMenu = new TbUserMenu();
					tbUserMenu.setTbumCreateDate(new Date());
					tbUserMenu.setTbumCreateId(optTbUser.get().getTbuId());
					tbUserMenu.setTbuId(optTbUserExisting.get().getTbuId());
					tbUserMenu.setTbmId(viewUserMenu.getTbmId());
					tbUserMenu.setTbumAdd(viewUserMenu.getTbumAdd());
					tbUserMenu.setTbumEdit(viewUserMenu.getTbumEdit());
					tbUserMenu.setTbumDelete(viewUserMenu.getTbumDelete());
					tbUserMenu.setTbumView(viewUserMenu.getTbumView());
					tbUserMenuRepository.save(tbUserMenu);
				}
				
				RestTemplate restTemplate = new RestTemplate();
				
				PutUpdateRequestModel putUpdateRequestModel = new PutUpdateRequestModel();
				putUpdateRequestModel.setTbaEmail(optTbUserExisting.get().getTbuEmail());
				putUpdateRequestModel.setTbaPassword(optTbUserExisting.get().getTbuPassword());
				putUpdateRequestModel.setTbaStatus(optTbUserExisting.get().getTbuStatus());
				HttpEntity<PutUpdateRequestModel> requestPutUpdate = new HttpEntity<>(putUpdateRequestModel);
				restTemplate.put(env.getProperty("services.bsd.api.rec.auth") + "auth/putupdate", requestPutUpdate, String.class);
				
				SimpleMapper simpleMapper = new SimpleMapper();
				
				com.api.rec.member.model.departments.PostUserEditRequestModel postUserEditOrderRequestModel = new com.api.rec.member.model.departments.PostUserEditRequestModel();
				postUserEditOrderRequestModel.setEmail(requestModel.getEmail());
				postUserEditOrderRequestModel.setToken(requestModel.getToken());
				com.api.rec.member.model.departments.TbUser postUserEditOrderTbUser = new com.api.rec.member.model.departments.TbUser();
				postUserEditOrderTbUser = (com.api.rec.member.model.departments.TbUser) simpleMapper.assign(optTbUserExisting.get(), postUserEditOrderTbUser);
				postUserEditOrderRequestModel.setTbUser(postUserEditOrderTbUser);
				HttpEntity<com.api.rec.member.model.departments.PostUserEditRequestModel> requestPostUserEditOrder = new HttpEntity<>(postUserEditOrderRequestModel);
				restTemplate.postForEntity(env.getProperty("services.bsd.api.rec.departments") + "user/postuseredit", requestPostUserEditOrder, String.class);
				
				responseModel.setStatus("200");
				responseModel.setMessage("User " + optTbUserExisting.get().getTbuEmail() + env.getProperty("service.user.postedit.userupdated"));
			} else {
				responseModel.setStatus("404");
				responseModel.setMessage(env.getProperty("service.user.postedit.notfound"));
			}
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage(env.getProperty("service.user.postedit.notfound"));
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
				putUpdateRequestModel.setTbaEmail(optTbUserExisting.get().getTbuEmail());
				putUpdateRequestModel.setTbaPassword(optTbUserExisting.get().getTbuPassword());
				putUpdateRequestModel.setTbaStatus(optTbUserExisting.get().getTbuStatus());
				HttpEntity<PutUpdateRequestModel> requestPutUpdate = new HttpEntity<>(putUpdateRequestModel);
				restTemplate.put(env.getProperty("services.bsd.api.rec.auth") + "auth/putupdate", requestPutUpdate, String.class);
				
				SimpleMapper simpleMapper = new SimpleMapper();
				
				com.api.rec.member.model.departments.PostUserChangePasswordRequestModel postUserChangePasswordOrderRequestModel = new com.api.rec.member.model.departments.PostUserChangePasswordRequestModel();
				postUserChangePasswordOrderRequestModel.setEmail(requestModel.getEmail());
				postUserChangePasswordOrderRequestModel.setToken(requestModel.getToken());
				com.api.rec.member.model.departments.TbUser postUserChangePasswordOrderTbUser = new com.api.rec.member.model.departments.TbUser();
				postUserChangePasswordOrderTbUser = (com.api.rec.member.model.departments.TbUser) simpleMapper.assign(optTbUserExisting.get(), postUserChangePasswordOrderTbUser);
				postUserChangePasswordOrderRequestModel.setTbUser(postUserChangePasswordOrderTbUser);
				HttpEntity<com.api.rec.member.model.departments.PostUserChangePasswordRequestModel> requestPostUserChangePasswordOrder = new HttpEntity<>(postUserChangePasswordOrderRequestModel);
				restTemplate.postForEntity(env.getProperty("services.bsd.api.rec.order") + "user/postuserchangepassword", requestPostUserChangePasswordOrder, String.class);
				
				responseModel.setStatus("200");
				responseModel.setMessage(env.getProperty("service.user.postuserchange.ok"));
			} else {
				responseModel.setStatus("404");
				responseModel.setMessage(env.getProperty("service.user.postuserchange.notfound"));
			}
		} else {
			responseModel.setStatus("404");
			responseModel.setMessage(env.getProperty("service.user.postuserchange.notfound"));
		}
		
		return responseModel;
	}
}
