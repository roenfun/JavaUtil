package com.util.file;

import com.util.log.MyLogger;

import java.io.*;

public class BufferReaderAndWriter {
    private static final MyLogger myLogger = MyLogger.getLogger(BufferReaderAndWriter.class);

    public void bufferReaderFrom(File file) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            int i = 0;
            String temp = null;
            while (null != (temp = bufferedReader.readLine())) {//readLine 一行一行读
                i++;
                myLogger.info("读取第" + i + "行内容是：" + temp); //read则是读取单个字符
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void bufferWriterTo(String[] contents, File file) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (String content : contents) {
                myLogger.info("写入这一行内容是:" + content);
                bufferedWriter.write(content);
                bufferedWriter.newLine();//行分隔符
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
