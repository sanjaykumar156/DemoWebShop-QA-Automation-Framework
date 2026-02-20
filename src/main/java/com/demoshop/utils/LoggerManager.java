package com.demoshop.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerManager {
	
	private static final Logger logger =LogManager.getLogger(LoggerManager.class);
	
	private LoggerManager() {
		
	}
	public static Logger getLogger(Class<?> clazz) {
		return LogManager.getLogger(clazz);
	}
}
