package com.api.rec.resumescheduler.util;

import java.util.HashMap;

import com.api.rec.resumescheduler.exception.ForbiddenException;
import com.api.rec.resumescheduler.model.RequestModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class TokenUtil {

	public static HashMap<String, String> keyMap;

	public TokenUtil() {
		keyMap = new HashMap<String, String>();
	}

	public void store(String email, String salt) {
		keyMap.put(email, salt);
	}

	public Claims claims(RequestModel requestModel) throws Exception {
		try {
			return Jwts.parser().setSigningKey(keyMap.get(requestModel.getEmail())).parseClaimsJws(requestModel.getToken()).getBody();
		} catch (Exception ex) {
			throw new ForbiddenException();
		}
	}
}
