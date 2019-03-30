package com.basic;

import com.util.file.FileReaderAndWriter;
import com.util.file.FileInputAndOutputStreamUtil;
import com.util.log.MyLogger;

import java.io.File;

public class InputAndOutputStreamTest {
    private static final MyLogger mylogger = MyLogger.getLogger(FileReaderAndWriter.class);

    public static void main(String[] args) {
        File file = new File("./src/main/resource/fileTest.txt");
        if (!file.exists()) {
            mylogger.info("file Not exist, finished!");
            return;
        }

        FileInputAndOutputStreamUtil inputAndOutputStreamUtil = new FileInputAndOutputStreamUtil();
        inputAndOutputStreamUtil.readInputFileStream(file);
        inputAndOutputStreamUtil.readFileOutputStream(file, false);

    }

}
