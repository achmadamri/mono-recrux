package com.api.rec.member;

import java.util.Date;
import java.util.HashMap;

public class RateLimiter {
	
	class Rate {
		private Integer i = Integer.valueOf(1);
		private Date date = new Date();
		
		public void increment(Date date) {
			this.i = this.i + 1;
			this.date = date;
		}
    }

	public static HashMap<String, Rate> keyMap = new HashMap<String, Rate>();
	
	public static RateLimiter instance = new RateLimiter();
	
	public boolean check(String api, Integer millis, Integer counter) {
		Rate rate = keyMap.get(api);
		
		if (rate == null) {
			keyMap.put(api, new Rate());
			
			return true;
		} else {
			long i = new Date().getTime() - rate.date.getTime();
			
			if (i <= millis) {
				if (rate.i < counter) {
					rate.increment(new Date());
					keyMap.put(api, rate);
					
					return true;
				} else {
					return false;
				}
			} else {
				keyMap.put(api, new Rate());
				
				return true;
			}
		}
	}
}
