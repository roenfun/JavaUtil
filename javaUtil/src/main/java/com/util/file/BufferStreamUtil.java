package com.util.file;

import com.util.log.MyLogger;

import java.io.*;

public class BufferStreamUtil {
    private static final MyLogger myLogger = MyLogger.getLogger(BufferStreamUtil.class);

    public void bufferOutStreamTo(File file, String[] contens) {
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        String newLine = System.getProperty("line.separator");

        try {
            fileOutputStream = new FileOutputStream(file);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] bContent = new byte[1024];
            for (String content : contens) {
                bContent = content.getBytes(); //转为字节数组
                bufferedOutputStream.write(bContent);
                bufferedOutputStream.write(newLine.getBytes());//换行符
            }

            myLogger.info("写入成功!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void bufferInputStreamFrom(File file) {
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);

            byte[] bContent = new byte[1024];
            int len = bufferedInputStream.read(bContent);

            myLogger.info("文件中的信息是：" + new String(bContent, 0, len));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedInputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
