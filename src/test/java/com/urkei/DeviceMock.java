package com.urkei;

import java.lang.reflect.Method;

import com.urkei.annotation.TestCase;

public class DeviceMock implements Device {

	public boolean start() {
        boolean isTestCase = false;
        String caseId = null;
		
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		
		endit:
		for (StackTraceElement stackTraceElement : stackTraceElements) {
			String className = stackTraceElement.getClassName();
			String methodName = stackTraceElement.getMethodName();
			try {
				Class<?> clazz = Class.forName(className);
				Method[] clazzMethodz = clazz.getMethods();
				for (Method method : clazzMethodz) {
					if (methodName.equals(method.getName())) {
						if (method.isAnnotationPresent(TestCase.class)) {
							isTestCase = true;
							TestCase testCaseAnnotation = method.getAnnotation(TestCase.class);
							caseId = testCaseAnnotation.caseId();
							break endit;
						}
					}
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (isTestCase) {
			switch (caseId) {
			case "case_one":
				return true;
			case "case_two":
				return false;
			default:
				throw new RuntimeException("Khaaa");
			}
		} else {
			throw new RuntimeException("Brhrrr");
		}
	}
}
