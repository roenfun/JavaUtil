package com.util;

import com.util.http.HttpRequest;
import com.util.log.MyLogger;
import org.junit.Ignore;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestHttpRequest {
	private static MyLogger logger = MyLogger.getLogger(TestHttpRequest.class);
	
	@BeforeTest
	public void beforeTest() {

	}

	@AfterTest
	public void afterTest() {
	}

	@Ignore
	@Test
	public void testHttpRequest() {
		String header = "http://zs.accp-teem.com.cn/";
		String param = "yw";

		String response = HttpRequest.sendGet(header, param);
		System.out.println(response);
		logger.info("SampleTestNGTest");
	}

}
