package com.util.file;

import com.util.log.MyLogger;

import java.io.*;
import java.util.Properties;

public class FileDirectoryUtil {
    private static final MyLogger myLogger = MyLogger.getLogger(FileDirectoryUtil.class);
    private static Properties props = new Properties();

    public static String getProperty(String key) {
        String fileName = "test.properties";
        String path = Thread.currentThread().getContextClassLoader().getResource("test.properties").getPath();
//        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        //读取Properties文件
        try {
            props.load(new FileInputStream(path));

//            props.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props.getProperty(key);

//        Properties prop = new Properties();
//        InputStream input;
//        String fileName = "/test.properties";
//        try {
////            input = new FileInputStream(new File(fileName));
//            ClassLoader loader = Thread.currentThread().getContextClassLoader();
//            input = loader.getResourceAsStream(fileName);
//
//            prop.load(input);
//
//        } catch (IOException e) {
//
//        }
//
//        return prop.getProperty(key);

    }

    public String getFilePathToSave() {

        Properties prop = new Properties();

        String result = "";

        try (
                InputStream inputStream = getClass()
                .getClassLoader().getResourceAsStream("test.properties")) {

            prop.load(inputStream);
            result = prop.getProperty("PLATFORM_VERSION");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

    public static boolean createDirectory(String folderName) {
        File folder = new File(folderName);
        if (folder.exists()) {
            myLogger.info("Error！>> The directory is exists, create directory "
                    + folderName + " failed.");
            return false;
        }
        if (!folderName.endsWith(File.separator)) {
            folderName = folderName + File.separator;
        }
        if (folder.mkdirs()) {
            myLogger.info("Create directory " + folderName + " success.");
            return true;
        } else {
            myLogger.info("Error！>> Create directory " + folderName
                    + " failed.");
            return false;
        }
    }

    public static boolean deleteEmptyDirectory(String folderName) {
        File folder = new File(folderName);
        if (!folder.exists()) {
            myLogger.info("Error！>> The directory is not exists, delete directory "
                    + folderName + " failed.");
            return false;
        }
        if (folder.delete()) {
            myLogger.info("Delete directory " + folderName + " success.");
            return true;
        } else {
            myLogger.info("Error！>> Delete directory " + folderName
                    + " failed.");
            return false;
        }
    }

    private static boolean deleteDirectory(File file) {
        String filePath = file.getAbsolutePath().toString();
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    deleteDirectory(files[i]);
                }
            }
            if (file.exists()) {
                if (file.delete()) {
                    myLogger.info("Delete file " + filePath + " success.");
                    return true;
                } else {
                    myLogger.info("Error！>> Delete file " + filePath
                            + " failed.");
                    return false;
                }
            }
            return true;
        } else {
            myLogger.info("Error！>> The directory is not exists, delete directory "
                    + filePath + " failed.");
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        /*
         * myLogger.info("Create the directory: " + "1");
         * FileUtils.createDirectory(System.getProperty("user.dir")+"/target/");
         * String dirName = "/Users/tomi.xu/Desktop/Directory1/";
         * myLogger.info("createDirectory(dirName)");
         * FileUtils.createDirectory(dirName);
         * myLogger.info("deleteEmptyDirectory(dirName)");
         * FileUtils.deleteEmptyDirectory(dirName);
         * myLogger.info("createDirectory(/Users/tomi.xu/Desktop/Directory2/)");
         * FileUtils.createDirectory("/Users/tomi.xu/Desktop/Directory2/");
         * String fileName = dirName + "test.txt"; String fileName1 =
         * "/Users/tomi.xu/Desktop/Directory2/" + "test1.txt";
         * myLogger.info("createFile(fileName)");
         * FileUtils.createFile(fileName);
         * myLogger.info("createFile(fileName1)");
         * FileUtils.createFile(fileName1); File f = new
         * File("/Users/tomi.xu/Desktop/Directory2/");
         * myLogger.info("deleteDirectory(f)"); FileUtils.deleteDirectory(f);
         * FileUtils.deleteFile(fileName);
         */
        // String srcName = "/Users/longdun/Documents/lls/shell/output.txt";
        // String destName = "/Users/longdun/Documents/lls/shell/j.txt";
        // FileUtils.copyFile(srcName,destName);
        // String shell = "killall Charles";
        // String shell = "open /Applications/Charles.app";
        // FileUtils.callShell(shell);
        new FileDirectoryUtil().getFilePathToSave();
        String test = FileDirectoryUtil.getProperty("DEVICE_NAME");

        File dir = new File("./src/main/resource/directory");
        boolean flag = dir.mkdir();
        boolean flag2 = dir.mkdirs();
        myLogger.info("create directory:" + flag);
        myLogger.info("create many directories:" + flag2);

//		boolean del = dir.delete();
//		myLogger.info("delete directory:" + del);

        File file = new File("./src/main/resources");
        File[] files = file.listFiles();

        if (null != files) {
            for (File f : files) {
                if (f.isFile()) {
                    myLogger.info("file is:" + f.getName());
                } else if (f.isDirectory()) {
                    myLogger.info("directory is:" + f.getName());
                }
            }
        }


    }
}
