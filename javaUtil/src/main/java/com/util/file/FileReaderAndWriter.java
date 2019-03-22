package com.util.file;

import com.util.log.MyLogger;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderAndWriter {
    private static final MyLogger mylogger = MyLogger.getLogger(FileReaderAndWriter.class);

    public void FileWriterTo(File file, String content) {
        FileWriter fileWriter = null;

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write(content + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileWriter)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        mylogger.info("内容已写入！");
    }

    public void FileReaderTo(File file) {
        FileReader fileReader = null;
        if (null != file) {
            if (file.length() == 0) {
                mylogger.info("文件中的文本为空！！");
            } else {
                try {
                    fileReader = new FileReader(file);
                    char[] chars = new char[1024];
                    int hasRead = -1;
                    while ((hasRead = fileReader.read(chars)) != -1) {
                        mylogger.info("文件中的内容为：" + new String(chars, 0, hasRead));
                    }
                } catch (IOException e) {
                    mylogger.info("file reader exception!");
                } finally {
                    if (null != fileReader) {
                        try {
                            fileReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
