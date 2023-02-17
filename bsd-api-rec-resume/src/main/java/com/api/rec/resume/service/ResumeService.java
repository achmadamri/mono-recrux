package com.api.rec.resume.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.api.rec.resume.model.resume.PostUploadResumeRequestModel;
import com.api.rec.resume.model.resume.PostUploadResumeResponseModel;
import com.api.rec.resume.util.TokenUtil;
import com.api.rec.resume.util.Uid;

@Service
public class ResumeService {

	private Logger log = LoggerFactory.getLogger(ResumeService.class);

	@Autowired
	private Environment env;

	private TokenUtil tokenUtil = new TokenUtil();

	@Autowired
	private ResumeParserProgram resumeParserProgram;

	public PostUploadResumeResponseModel postUploadResume(PostUploadResumeRequestModel requestModel, MultipartFile file) throws Exception {
		PostUploadResumeResponseModel responseModel = new PostUploadResumeResponseModel(requestModel);

		String fileName = StringUtils.cleanPath(file.getOriginalFilename()) + "_" + (new Uid().generateString(5)) + ".pdf";
		Files.copy(file.getInputStream(), Paths.get(env.getProperty("file.resume.dir") + fileName), StandardCopyOption.REPLACE_EXISTING);
		String filePath = env.getProperty("file.resume.dir") + fileName;
		
		File tikkaConvertedFile = resumeParserProgram.parseToHTMLUsingApacheTikka(filePath);
		JSONObject parsedJSON = resumeParserProgram.loadGateAndAnnie(tikkaConvertedFile);

		responseModel.setParsedJSON(parsedJSON);
		responseModel.setHttpStatus(HttpStatus.OK);
		
		return responseModel;
	}
}
