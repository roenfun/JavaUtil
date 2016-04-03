package com.java.util.log;

import org.apache.log4j.Logger;

public class MyLogger {
	private Logger logger;

	protected MyLogger(String name) {
		this.logger = Logger.getLogger(name);
	}

	public static MyLogger getLogger(String name) {
		return new MyLogger(name);
	}

	public static MyLogger getLogger(Class<?> clazz) {
		return new MyLogger(clazz);
	}

	private MyLogger(Class<?> clazz) {
		this.logger = Logger.getLogger(clazz);
	}

	public void error(String message) {
		logger.error(message);
	}

	public void info(String message) {
		logger.info(message);
	}

	public void warn(String message) {
		logger.warn(message);
	}

	public void error(StringBuilder message) {
		logger.error(message.toString());
	}

	public void info(StringBuilder message) {
		logger.info(message.toString());
	}

	public void warn(StringBuilder message) {
		logger.warn(message.toString());
	}

}
