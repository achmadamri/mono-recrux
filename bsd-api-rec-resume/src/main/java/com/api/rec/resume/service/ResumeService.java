package com.api.rec.resume.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONTokener;
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

	// Will be scaled horizontally
	public synchronized PostUploadResumeResponseModel postUploadResume(PostUploadResumeRequestModel requestModel, MultipartFile file) throws Exception {
		PostUploadResumeResponseModel responseModel = new PostUploadResumeResponseModel(requestModel);
	
		String fileName = StringUtils.cleanPath(file.getOriginalFilename()) + "_" + (new Uid().generateString(5)) + ".pdf";
		Files.copy(file.getInputStream(), Paths.get(env.getProperty("file.resume.dir") + fileName), StandardCopyOption.REPLACE_EXISTING);
		String filePath = env.getProperty("file.resume.dir") + fileName;

		ResumeParserProgram resumeParserProgram = new ResumeParserProgram();
		File tikkaConvertedFile = resumeParserProgram.parseToHTMLUsingApacheTikka(filePath);
		JSONObject parsedJSON = resumeParserProgram.loadGateAndAnnie(tikkaConvertedFile);
	
		try {
			// Build the command to call the pyresparser tool
			List<String> command = new ArrayList<>();
			command.add("pyresparser");
			command.add("-f");
			command.add(filePath);
		
			// Start the process to execute the command
			ProcessBuilder builder = new ProcessBuilder(command);
			Process process = builder.start();
		
			// Read the output of the process and extract the JSON data
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			StringBuilder output = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line);
			}
			int startIndex = output.indexOf("'skills': [");
			int endIndex = output.lastIndexOf("],");
		
			String jsonStr = output.substring(startIndex, endIndex+1);
			parsedJSON.put("pyresparser_skills", jsonStr);
		} catch (Exception ex) {
			log.error("Error while parsing the resume using pyresparser", ex);
		}

		responseModel.setJson(parsedJSON);
		responseModel.setHttpStatus(HttpStatus.OK);
	
		return responseModel;
	}
	
}
