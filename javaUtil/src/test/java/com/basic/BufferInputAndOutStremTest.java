package com.basic;

import com.util.file.BufferReaderAndWriter;
import com.util.file.BufferStreamUtil;
import com.util.file.FileReaderAndWriter;
import com.util.log.MyLogger;

import java.io.BufferedInputStream;
import java.io.File;

public class BufferInputAndOutStremTest {
    private static final MyLogger mylogger = MyLogger.getLogger(FileReaderAndWriter.class);

    public static void main(String[] args) {
        File file = new File("./src/main/resource/fileTest.txt");
        String[] contents = {"bufferOutStreamTo", "缓冲ouput and input写入文件中", "bufferInputStreamFrom"};

        if (!file.exists()) {
            mylogger.info("file Not exist, finished!");
            return;
        }

        BufferStreamUtil bufferStreamUtil = new BufferStreamUtil();

        bufferStreamUtil.bufferOutStreamTo(file, contents);
        bufferStreamUtil.bufferInputStreamFrom(file);

    }

}
