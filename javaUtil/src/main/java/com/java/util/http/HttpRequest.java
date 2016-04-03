package com.java.util.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import com.java.util.log.MyLogger;

public class HttpRequest {
	private static MyLogger logger = MyLogger.getLogger(HttpRequest.class);
	
	public HttpRequest() {
		System.out.println("test Construtor");
		logger.info(HttpRequest.class.toString());
	}

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 * @param param
	 * @return Get the full path of Url
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader reader = null;

		try {
			URL fullUrl = new URL(url + "?" + param);
			logger.info("The url is: " + fullUrl.toString());
			URLConnection urlConnection = fullUrl.openConnection(); // open the
																	// url link
			// set the general properties
			urlConnection.setRequestProperty("accept", "*/*");
			urlConnection.setRequestProperty("connection", "Keep-Alive");
			urlConnection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// request the url
			urlConnection.connect();

			// read the response of the connection
			reader = new BufferedReader(new InputStreamReader(
					urlConnection.getInputStream(), "UTF-8"));
			String line;
			while ((line = reader.readLine()) != null) {
				result = result + line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e2) {
					logger.error(e2.getLocalizedMessage());
				}
			}
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
}
