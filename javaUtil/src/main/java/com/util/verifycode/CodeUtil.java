package com.util.verifycode;

import com.util.http.HttpRequest;
import com.util.log.MyLogger;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * Created by chad on 2017/3/18.
 * get the verify code from picture
 */
public class CodeUtil {
    private static MyLogger logger = MyLogger.getLogger(HttpRequest.class);

//    URL url = ClassLoader.getSystemResource("tessdata");
//    String path = url.getPath().substring(1);
//        instance.(path);
    // 默认是英文（识别字母和数字），如果要识别中文(数字 + 中文），需要制定语言包
//        instance.setLanguage("chi_sim");

    public static void main(String[] args){
        CodeUtil codeUtil = new CodeUtil();
        codeUtil.transferCode();
    }

    public String transferCode(){

        File imageFile = new File("./src/main/resource/test.png");
        ITesseract instance = new Tesseract();
        instance.setDatapath("./src/main/java/ocr/tessdata");

        try{
            String result1 = instance.doOCR(imageFile);
            System.out.println(result1);

            return result1;
        }catch(TesseractException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "";
    }
}
