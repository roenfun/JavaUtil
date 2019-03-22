package com.util.http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;

import com.util.log.MyLogger;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;

public class SmbService {

	/**
	 * copy the test result reports into remote server
	 */
	private static MyLogger logger = MyLogger.getLogger(SmbService.class);
	InputStream inputStream = null;
	OutputStream outputStream = null;

	public SmbService() {
		logger.info(SmbService.class.getName().toString());
	}
	
	public static void main(String[] args) {
		copyFilesToSharFolder("login-name", "login-password",
				"smb://PCName/Users/roenfun/apktool/framework/",
				"smb://PCName/Users/roenfun/apktool/testreport/");
	}

	// public void connectShareFolder() throws Exception {
	//
	// try {
	// String remoteUrl =
	// "smb:PCname:PCPassword@//PCName/Users/roenfun/apktool/framework";
	// SmbFile smbFile = new SmbFile(remoteUrl);
	// // System.out.println(smbFile.getDiskFreeSpace());
	// } catch (MalformedURLException e) {
	// e.printStackTrace();
	// }
	// }
	/**
	 * 把本地磁盘中的文件上传到局域网共享文件下
	 * 
	 * @param remoteUrl
	 *            共享电脑路径 如：smb//administrator:123456@172.16.10.136/smb,
	 *            "smb://roenfun:19roenfun@ROENFUN-PC/Users/roenfun/apktool/framework"
	 * @param localFilePath
	 *            本地路径 如：
	 *            "D:/Java_Andriod/github/sample-code-master/sample-code/examples/java/generic"
	 */
	public static void copyFileToShareFolder(String remoteUrl,
			String localFilePath) {
		InputStream in = null;
		OutputStream out = null;
		try {
			File localFile = new File(localFilePath);
			String fileName = localFile.getName();
			SmbFile remoteFile = new SmbFile(remoteUrl + "/" + fileName);
			in = new BufferedInputStream(new FileInputStream(localFile));
			out = new BufferedOutputStream(new SmbFileOutputStream(remoteFile));
			byte[] buffer = new byte[1024];
			while ((in.read(buffer)) != -1) {
				out.write(buffer);
				buffer = new byte[1024];
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 从局域网中共享文件中得到文件并保存在本地磁盘上
	 * 
	 * @param remoteUrl
	 *            共享电脑路径 如：smb//administrator:123456@172.16.10.136/smb/1221.zip
	 *            , smb为共享文件 注：如果一直出现连接不上，有提示报错，并且错误信息是 用户名活密码错误 则修改共享机器的文件夹选项
	 *            查看 去掉共享简单文件夹的对勾即可。
	 * @param localDir
	 *            本地路径 如：D:/
	 */
	public static void copyFileFromShareFolder(String remoteUrl, String localDir) {
		InputStream in = null;
		OutputStream out = null;
		try {
			SmbFile smbFile = new SmbFile(remoteUrl);
			String fileName = smbFile.getName();
			File localFile = new File(localDir + File.separator + fileName);
			in = new BufferedInputStream(new SmbFileInputStream(smbFile));
			out = new BufferedOutputStream(new FileOutputStream(localFile));
			byte[] buffer = new byte[1024];
			while ((in.read(buffer)) != -1) {
				out.write(buffer);
				buffer = new byte[1024];
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * copy files from local folder into remote share folder
	 * 
	 * @param user
	 *            the user name of PC login, such as: roenfun
	 * @param password
	 *            the password of PC login, such as: 123456
	 * @param destPath
	 *            the path of remote share folder, such as:
	 *            "smb://PCName/Users/roenfun/apktool/framework/???"
	 * @param sourPath
	 *            the path of files will be copied, such as:
	 *            "smb://PCName/Users/roenfun/apktool/testreport/"
	 */
	public static void copyFilesToSharFolder(String user, String password,
			String destPath, String sourPath) {
		NtlmPasswordAuthentication authentication = new NtlmPasswordAuthentication(
				null, user, password);
		logger.info("Starting to copy reports to remote folder in server....");
		try {
			SmbFile dFile = new SmbFile(destPath, authentication);
			SmbFile sFile = new SmbFile(sourPath, authentication);
			sFile.copyTo(dFile);
			logger.info("Submit Test Result successfully!");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			logger.error("Encounter error during copying files to remote folder, pleas have a check...");
		} catch (SmbException e) {
			e.printStackTrace();
			logger.error("Encounter error during copying files to remote folder, pleas have a check...");
		}
	}

}
