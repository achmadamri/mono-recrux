package com.api.rec.resume.util;

import java.util.Random;

public class Uid {

	public String generateString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		Random rnd = new Random();
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rnd.nextInt(characters.length()));
		}
		return new String(text);
	}
}
