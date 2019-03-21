package com.java.util.file;

import com.java.util.log.MyLogger;

import java.io.*;

public class FileStreamUtil {
    private static final MyLogger myLogger = MyLogger.getLogger(FileUtil.class);

    public void readInputFileStream(File file) {
        try {
            FileInputStream in = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len = in.read(bytes);
            in.close();
            myLogger.info("文件中的信息是：" + new String(bytes, 0, len));
        } catch (IOException e) {
            e.printStackTrace();

        }


    }

    public void readFileOutputStream(File file) {
        try {
            FileOutputStream out = new FileOutputStream(file);
            String content = "测试 FileIOutputStream.";
            byte[] bytes = content.getBytes();
            out.write(bytes);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
