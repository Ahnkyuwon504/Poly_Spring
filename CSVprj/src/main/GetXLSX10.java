package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetXLSX10 {
    
    static List<ArrayList<String>> report = new ArrayList<ArrayList<String>>();
    static double[] totalHome = new double[3]; // 세대의 총합, 최댓값, 최솟값
    static double[] total = new double[3];     // 등록인구의 총합, 최댓값, 최솟값
    static double[] totalMale = new double[3]; // 남자 
    static double[] totalFemale = new double[3];// 여자
    
    static String getFileName(int i) {
        String fileName = "";
        switch(i + 1) {
        case 1 : fileName = "C:\\Users\\kyuwon\\Desktop\\art\\excel\\등록인구추이_2009.xlsx"; break;
        case 2 : fileName = "C:\\Users\\kyuwon\\Desktop\\art\\excel\\등록인구추이_2010.xlsx"; break;
        case 3 : fileName = "C:\\Users\\kyuwon\\Desktop\\art\\excel\\등록인구추이_2011.xlsx"; break;
        case 4 : fileName = "C:\\Users\\kyuwon\\Desktop\\art\\excel\\등록인구추이_2012.xlsx"; break;
        case 5 : fileName = "C:\\Users\\kyuwon\\Desktop\\art\\excel\\등록인구추이_2013.xlsx"; break;
        case 6 : fileName = "C:\\Users\\kyuwon\\Desktop\\art\\excel\\등록인구추이_2014.xlsx"; break;
        case 7 : fileName = "C:\\Users\\kyuwon\\Desktop\\art\\excel\\등록인구추이_2015.xlsx"; break;
        case 8 : fileName = "C:\\Users\\kyuwon\\Desktop\\art\\excel\\등록인구추이_2016.xlsx"; break;
        case 9 : fileName = "C:\\Users\\kyuwon\\Desktop\\art\\excel\\등록인구추이_2017.xlsx"; break;
        case 10 : fileName = "C:\\Users\\kyuwon\\Desktop\\art\\excel\\등록인구추이_2018.xlsx"; break;
        }
        return fileName;
    }

    public static void main(String[] args) {
        try {
            Arrays.fill(totalHome, 0); totalHome[2] = Integer.MAX_VALUE;
            Arrays.fill(total, 0); total[2] = Integer.MAX_VALUE;
            Arrays.fill(totalMale, 0); totalMale[2] = Integer.MAX_VALUE;
            Arrays.fill(totalFemale, 0); totalFemale[2] = Integer.MAX_VALUE;
            
            for (int i = 0; i < 10; i++) {
                report.add(new ArrayList<String>());
            }
            
            XSSFWorkbook workbook = null;
            
            for (int i = 0; i < 10; i++) {
                String filePath = getFileName(i);
                FileInputStream fis = new FileInputStream(filePath);
                workbook = new XSSFWorkbook(fis);
                XSSFSheet sheet = workbook.getSheet("데이터");
                
                int cnt = 1;
                for (int row = 1; row < sheet.getPhysicalNumberOfRows(); row++) {
                    if (cnt == 1) {
                        cnt++;
                        continue;
                    }
                    XSSFRow rows = sheet.getRow(row);
                    if (rows != null) {
                        String value = "";
                        for (int column = 0; column < 5; column++) {
                            XSSFCell cell = rows.getCell(column);
                            if (cell != null) {
                                switch (cell.getCellType()) {
                                
                                case NUMERIC : 
                                    value = cell.getNumericCellValue() + "";
                                    break;
                                case STRING : 
                                    value = cell.getStringCellValue() + "";
                                    break;
                                case BLANK : 
                                    value = cell.getBooleanCellValue() + "";
                                    break;
                                case ERROR : 
                                    value = cell.getErrorCellValue() + "";
                                    break;
                                default : 
                                    break;
                                }
                            }
                            report.get(i).add(value);
                            
                            if (column == 1) {
                                totalHome[0] += Double.parseDouble(value);
                                totalHome[1] = Math.max(totalHome[1], Double.parseDouble(value));
                                totalHome[2] = Math.min(totalHome[2], Double.parseDouble(value));
                            }
                            if (column == 2) {
                                total[0] += Double.parseDouble(value);
                                total[1] = Math.max(total[1], Double.parseDouble(value));
                                total[2] = Math.min(total[2], Double.parseDouble(value));
                            }
                            if (column == 3) {
                                totalMale[0] += Double.parseDouble(value);
                                totalMale[1] = Math.max(totalMale[1], Double.parseDouble(value));
                                totalMale[2] = Math.min(totalMale[2], Double.parseDouble(value));
                            }
                            if (column == 4) {
                                totalFemale[0] += Double.parseDouble(value);
                                totalFemale[1] = Math.max(totalFemale[1], Double.parseDouble(value));
                                totalFemale[2] = Math.min(totalFemale[2], Double.parseDouble(value));
                            }
                        }
                        cnt++;
                    }
                }
                
            }

            workbook.close();
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        XSSFWorkbook xssfWb = null; 
        XSSFSheet xssfSheet = null; 
        XSSFRow xssfRow = null; 
        XSSFCell xssfCell = null;
        
        try {

            int rowNo = 0;
            xssfWb = new XSSFWorkbook();
            xssfSheet = xssfWb.createSheet("sheet1");
            /*
             * XSSFFont font = xssfWb.createFont();
             * 
             * font.setFontName(HSSFFont.FONT_ARIAL); font.setBold(true);
             */
            xssfRow = xssfSheet.createRow(rowNo++); 
            xssfCell = xssfRow.createCell((short) 0); 
            xssfCell.setCellValue("year");
            xssfCell = xssfRow.createCell((short) 1); 
            xssfCell.setCellValue("home"); 
            xssfCell = xssfRow.createCell((short) 2); 
            xssfCell.setCellValue("people"); 
            xssfCell = xssfRow.createCell((short) 3);
            xssfCell.setCellValue("Male");
            xssfCell = xssfRow.createCell((short) 4);
            xssfCell.setCellValue("Female");
            System.out.println(report.size());

            for (int i = 0; i < report.size(); i++) {
                xssfRow = xssfSheet.createRow(rowNo++);
                xssfCell = xssfRow.createCell((short) 0); 
                xssfCell.setCellValue(report.get(i).get(0));
                xssfCell = xssfRow.createCell((short) 1); 
                xssfCell.setCellValue(report.get(i).get(1)); 
                xssfCell = xssfRow.createCell((short) 2); 
                xssfCell.setCellValue(report.get(i).get(2)); 
                xssfCell = xssfRow.createCell((short) 3);
                xssfCell.setCellValue(report.get(i).get(3));
                xssfCell = xssfRow.createCell((short) 4);
                xssfCell.setCellValue(report.get(i).get(4));
            }

            
            xssfRow = xssfSheet.createRow(rowNo++); 
            xssfCell = xssfRow.createCell((short) 0); 
            xssfCell.setCellValue("Average");
            xssfCell = xssfRow.createCell((short) 1); 
            xssfCell.setCellValue(totalHome[0] / 10); 
            xssfCell = xssfRow.createCell((short) 2); 
            xssfCell.setCellValue(total[0] / 10); 
            xssfCell = xssfRow.createCell((short) 3);
            xssfCell.setCellValue(totalMale[0] / 10);
            xssfCell = xssfRow.createCell((short) 4);
            xssfCell.setCellValue(totalFemale[0] / 10);
            
            xssfRow = xssfSheet.createRow(rowNo++); 
            xssfCell = xssfRow.createCell((short) 0); 
            xssfCell.setCellValue("Max");
            xssfCell = xssfRow.createCell((short) 1); 
            xssfCell.setCellValue(totalHome[1]); 
            xssfCell = xssfRow.createCell((short) 2); 
            xssfCell.setCellValue(total[1]); 
            xssfCell = xssfRow.createCell((short) 3);
            xssfCell.setCellValue(totalMale[1]);
            xssfCell = xssfRow.createCell((short) 4);
            xssfCell.setCellValue(totalFemale[1]);
            
            xssfRow = xssfSheet.createRow(rowNo++); 
            xssfCell = xssfRow.createCell((short) 0); 
            xssfCell.setCellValue("Min");
            xssfCell = xssfRow.createCell((short) 1); 
            xssfCell.setCellValue(totalHome[2]); 
            xssfCell = xssfRow.createCell((short) 2); 
            xssfCell.setCellValue(total[2]); 
            xssfCell = xssfRow.createCell((short) 3);
            xssfCell.setCellValue(totalMale[2]);
            xssfCell = xssfRow.createCell((short) 4);
            xssfCell.setCellValue(totalFemale[2]);
            
            String localFile = "C:\\Users\\kyuwon\\Desktop\\art\\excel\\report.xlsx";
            
            File file = new File(localFile);
            FileOutputStream fos = new FileOutputStream(file);
            xssfWb.write(fos);
            
            if (fos != null) fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
