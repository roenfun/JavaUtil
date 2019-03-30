package com.basic;

import com.util.file.BufferReaderAndWriter;
import com.util.file.FileReaderAndWriter;
import com.util.log.MyLogger;

import java.io.File;

public class BufferReaderAndWriterTest {
    private static final MyLogger mylogger = MyLogger.getLogger(FileReaderAndWriter.class);

    public static void main(String[] args) {
        File file = new File("./src/main/resource/fileTest.txt");
        String[] contents = {"bufferWriter", "缓冲写入文件中", "test buffer"};

        if (!file.exists()) {
            mylogger.info("file Not exist, finished!");
            return;
        }

        BufferReaderAndWriter fileReaderAndWriter = new BufferReaderAndWriter();

//        fileReaderAndWriter.bufferWriterTo(contents, file);

        fileReaderAndWriter.bufferReaderFrom(file);


    }

}
