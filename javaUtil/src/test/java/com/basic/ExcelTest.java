package com.basic;

import com.util.file.FileInputAndOutputStreamUtil;
import com.util.file.FileReaderAndWriter;
import com.util.file.FileUtil;
import com.util.log.MyLogger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Chad.long
 * Date: 2019-03-30 10:49
 * Version 1.0
 * //todo 只能用与xls的文件？？
 */
public class ExcelTest {
    private static final MyLogger mylogger = MyLogger.getLogger(ExcelTest.class);

    @Test
    public void excelWrite() {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("fileInput");
        HSSFRow hssfRow = hssfSheet.createRow(0);
        hssfRow.createCell(0).setCellValue("Micheal Owen");
        hssfRow.createCell(1).setCellValue("England");
        hssfRow.createCell(2).setCellValue(39);
        hssfRow.createCell(3).setCellValue(true);

        HSSFCell hssfCell = hssfRow.createCell(4);
        hssfCell.setCellValue(6000);
        HSSFCellStyle hssfCellStyle = hssfWorkbook.createCellStyle();
        hssfCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
        hssfCell.setCellStyle(hssfCellStyle);

        HSSFCreationHelper hssfCreationHelper = hssfWorkbook.getCreationHelper();
        HSSFCellStyle hssfCellStyle1 = hssfWorkbook.createCellStyle();
        hssfCellStyle1.setDataFormat(hssfCreationHelper.createDataFormat().getFormat("yyyy-MM-dd"));
        HSSFCell cell5 = hssfRow.createCell(5);

        cell5.setCellValue(new Date());
        cell5.setCellStyle(hssfCellStyle1);


        File file = new File("./src/main/resource/excellTest.xls");
//        if (!file.exists()) {
//            mylogger.info("file Not exist, finished!");
//            FileUtil.createFile("./src/main/resource/excellTest.xls");
//        }
        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream(file);
//            hssfWorkbook.write(fileOutputStream);
//            hssfWorkbook.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            mylogger.info(e.getMessage());
//        }

        try {
            InputStream inputStream = new FileInputStream(file);
            POIFSFileSystem poifsFileSystem = new POIFSFileSystem(inputStream);
            HSSFWorkbook hssfWorkbook1 = new HSSFWorkbook(poifsFileSystem);
            HSSFSheet hssfSheet1 = hssfWorkbook1.getSheetAt(0);
            if (hssfSheet1 == null) {
                return;
            }

            for (int i = 0; i <= hssfSheet1.getLastRowNum(); i++) {
                HSSFRow hssfRow1 = hssfSheet1.getRow(i);
                if (hssfRow1 == null) {
                    continue;
                }

                for (int j = 0; j <= hssfRow1.getLastCellNum(); j++) {
                    HSSFCell hssfCell1 = hssfRow1.getCell(j);

                    if (hssfCell1 == null) {
                        continue;
                    }

                    String string = "";

                    if (hssfCell1.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                        if (HSSFDateUtil.isCellDateFormatted(hssfCell1)) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            string = simpleDateFormat.format(HSSFDateUtil.getJavaDate(hssfCell1.getNumericCellValue())).toString();
                        }else {
                            string = String.valueOf(hssfCell1.getNumericCellValue());
                        }
                    } else if (hssfCell1.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
                        string = String.valueOf(hssfCell1.getBooleanCellValue() );
                    }else {
                        string = hssfCell1.getStringCellValue();

                    }

                    if (j == 2){
                        string = string.substring(0, string.indexOf("."));
                    }

                    if (j == 3){
                        string = string.toUpperCase();
                    }
                    mylogger.info(string);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
