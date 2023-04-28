package com.api.rec.resume.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {
	
	private Logger log = LoggerFactory.getLogger(StringUtil.class);
	static final SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
	static final SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
	public Date stringToDate(String strDate) {		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			String str =	strDate.substring(0, 4)		+ "-" + 
							strDate.substring(5, 7)		+ "-" +
							strDate.substring(8, 10)	+ " " +
							strDate.substring(11, 13)	+ ":" +
							strDate.substring(14, 16)	+ ":" +
							strDate.substring(17, 19);
			date = sdf.parse(str);
		} catch (ParseException e) {
			log.error(e.getMessage());			
		}
		
		return date;
	}
	
	public Integer stringToInteger(String str) {
		if (str.equals("")) {
			return 0;
		} else if (str.equals("undefined")) {
			return 0;
		} else {
			return Integer.valueOf(str);
		}
	}
	public String toTimeString(Date date) {
		if(date == null)
			return "";
		else
			return sdfTime.format(date);
	}
	public String toDateString(Date date) {
		if(date == null)
			return "";
		else
			return sdfDate.format(date);
	}
}
