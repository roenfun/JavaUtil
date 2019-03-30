package com.util.file;

import com.util.log.MyLogger;

import java.io.*;

public class FileInputAndOutputStreamUtil {
    private static final MyLogger myLogger = MyLogger.getLogger(FileUtil.class);

    public void readInputFileStream(File file) {
        try {
            FileInputStream in = new FileInputStream(file);
            int num = 0;
            while ((num = in.read()) != -1){//读取字节
                myLogger.info("字节num是：" + num);
                myLogger.info("字节num转为字符：" + (char)num);
            }

            byte[] bytes = new byte[1024];
            int len = in.read(bytes);
            in.close();
            myLogger.info("文件中的信息是：\n" + new String(bytes, 0, len));
        } catch (IOException e) {
            e.printStackTrace();

        }


    }

    public void readFileOutputStream(File file, boolean append) {
        try {
            FileOutputStream out = new FileOutputStream(file,append);
            String content = "测试 FileIOutputStream.";
            byte[] bytes = content.getBytes();
            out.write(bytes);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
