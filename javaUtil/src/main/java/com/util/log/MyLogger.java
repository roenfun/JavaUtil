package com.util.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyLogger {
	private Logger logger;

	protected MyLogger(String name) {
		this.logger = Logger.getLogger(name);
	}

	public static MyLogger getLogger(String name) {
		return new MyLogger(name);
	}

	public static MyLogger getLogger(Class<?> clazz) {
		PropertyConfigurator.configure("./src/log4j.properties"); //当前项目路径为.
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
