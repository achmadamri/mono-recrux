package com.api.rec.resume.util;

import java.lang.reflect.Method;

public class SimpleMapper {
	
	public Object assign(Object objectFrom, Object objectTo) {
		Class classFrom = objectFrom.getClass();
		Class classTo = objectTo.getClass();

		Method methodsFrom[] = classFrom.getDeclaredMethods();

		for (Method methodFrom : methodsFrom) {
			if ("get".equals(methodFrom.getName().substring(0, 3))) {
				try {
					Object outputGet = methodFrom.invoke(objectFrom, null);
					
					if (outputGet != null) {
						String strMethodName = "s" + methodFrom.getName().substring(1);
						
						Method methodTo = classTo.getMethod(strMethodName, outputGet.getClass());
						methodTo.invoke(objectTo, outputGet);
					}
				} catch (Exception e) {}
			}
		}
		
		return objectTo;
	}
}
