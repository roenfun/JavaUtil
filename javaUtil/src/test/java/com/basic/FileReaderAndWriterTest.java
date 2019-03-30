package com.basic;

import com.util.file.FileReaderAndWriter;
import com.util.log.MyLogger;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileReaderAndWriterTest {
    private static final MyLogger mylogger = MyLogger.getLogger(FileReaderAndWriter.class);

    public static void main(String[] args) {
        while (true) {
            File file = new File("./src/main/resource/fileTest.txt");
            if (!file.exists()) {
                mylogger.info("file Not exist, finished!");
                return;
            }

            FileReaderAndWriter fileReaderAndWriter = new FileReaderAndWriter();

            mylogger.info("请输入要操作的类型：1为写入，2为读取");

            try {
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        String tempStr = scanner.next();//获取输入的内容
                        fileReaderAndWriter.FileWriterTo(file, tempStr, false);
                        break;
                    case 2:
                        fileReaderAndWriter.FileReaderTo(file);
                        break;
                }
            } catch (InputMismatchException e) {
                e.printStackTrace();
            }

        }
    }

}
