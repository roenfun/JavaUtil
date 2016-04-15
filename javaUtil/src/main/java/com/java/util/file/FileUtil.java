package com.java.util.file;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.java.util.log.MyLogger;;

public class FileUtil {
	private static final MyLogger myLogger = MyLogger.getLogger(FileUtil.class);

    public static boolean createDirectory(String folderName) {
        File folder = new File(folderName);
        if (folder.exists()) {
            myLogger.info("Error！>> The directory is exists, create directory " + folderName + " failed.");
            return false;
        }
        if (!folderName.endsWith(File.separator)) {
            folderName = folderName + File.separator;
        }
        if (folder.mkdirs()) {
            myLogger.info("Create directory " + folderName + " success.");
            return true;
        } else {
            myLogger.info("Error！>> Create directory " + folderName + " failed.");
            return false;
        }
    }

    public static boolean deleteEmptyDirectory(String folderName) {
        File folder = new File(folderName);
        if (!folder.exists()) {
            myLogger.info("Error！>> The directory is not exists, delete directory " + folderName + " failed.");
            return false;
        }
        if (folder.delete()) {
            myLogger.info("Delete directory " + folderName + " success.");
            return true;
        } else {
            myLogger.info("Error！>> Delete directory " + folderName + " failed.");
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
                    myLogger.info("Error！>> Delete file " + filePath + " failed.");
                    return false;
                }
            }
            return true;
        } else {
            myLogger.info("Error！>> The directory is not exists, delete directory " + filePath + " failed.");
            return false;
        }
    }

    public static boolean createFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            myLogger.info("Error！>> The file is exists, create file " + fileName + " failed.");
            return false;
        }
        if (fileName.endsWith(File.separator)) {
            myLogger.info("Error！>> Create file " + fileName + " failed.");
            return false;
        }
        if (!file.getParentFile().exists()) {
            myLogger.info(file.getParentFile().getAbsolutePath().toString());
            myLogger.info("The directory is not exists. Creating the directory.");
            if (!file.getParentFile().mkdirs()) {
                myLogger.info("Error！>> Create directory failed.");
                return false;
            }
        }
        try {
            if (file.createNewFile()) {
                myLogger.info("Create file " + fileName + " success.");
                return true;
            } else {
                myLogger.info("Error！>> Create file " + fileName + " failed.");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            myLogger.info("Error！>> Create file " + fileName + " failed." + e.getMessage());
            return false;
        }
    }

    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            myLogger.info("Create file " + fileName + " success.");
            return true;
        } else {
            myLogger.info("Error！>> Create file " + fileName + " failed.");
            return false;
        }
    }
    /*
    读文件，生成String流
     */
    public static String FileInputStream(String path)

    {

        File file = new File(path);
        if (!file.exists() || file.isDirectory())
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] buf = new byte[1024];
        StringBuffer sb = new StringBuffer();
        try {
            while ((fis.read(buf)) != -1){
            sb.append(new String(buf));
            buf = new byte[1024];//重新生成，避免和上次读取的数据重复
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


        /*
        以文件流的方式复制文件
         */
    public static void copyFile(String src,String dest) {
        FileInputStream in= null;
        try {
            in = new FileInputStream(src);

            File file=new File(dest);
        if(!file.exists())

            file.createNewFile();
        FileOutputStream out=new FileOutputStream(file);
        int c;
        byte buffer[]=new byte[1024];
        while((c=in.read(buffer))!=-1){
            for(int i=0;i<c;i++)
                out.write(buffer[i]);
        }
        in.close();
        out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myLogger.info("copy file done");
    }






    public static void main(String[] args) throws IOException {
        /*
        myLogger.info("Create the directory: " + "1");
        FileUtils.createDirectory(System.getProperty("user.dir")+"/target/");
        String dirName = "/Users/tomi.xu/Desktop/Directory1/";
        myLogger.info("createDirectory(dirName)");
        FileUtils.createDirectory(dirName);
        myLogger.info("deleteEmptyDirectory(dirName)");
        FileUtils.deleteEmptyDirectory(dirName);
        myLogger.info("createDirectory(/Users/tomi.xu/Desktop/Directory2/)");
        FileUtils.createDirectory("/Users/tomi.xu/Desktop/Directory2/");
        String fileName = dirName + "test.txt";
        String fileName1 = "/Users/tomi.xu/Desktop/Directory2/" + "test1.txt";
        myLogger.info("createFile(fileName)");
        FileUtils.createFile(fileName);
        myLogger.info("createFile(fileName1)");
        FileUtils.createFile(fileName1);
        File f = new File("/Users/tomi.xu/Desktop/Directory2/");
        myLogger.info("deleteDirectory(f)");
        FileUtils.deleteDirectory(f);
        FileUtils.deleteFile(fileName);
        */
        //String srcName = "/Users/longdun/Documents/lls/shell/output.txt";
        //String destName = "/Users/longdun/Documents/lls/shell/j.txt";
        //FileUtils.copyFile(srcName,destName);
        //String shell = "killall Charles";
        //String shell = "open /Applications/Charles.app";
        //FileUtils.callShell(shell);
    }
}
