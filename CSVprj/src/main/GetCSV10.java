package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class GetCSV10 {
    
    static String writeFileName = "C:\\Users\\kyuwon\\Desktop\\art\\csv\\report.csv";
    static int numberOfFile = 10;
    static List<ArrayList<String>> report = new ArrayList<ArrayList<String>>();
    
    static double[] totalHome = new double[3]; // 세대의 총합, 최댓값, 최솟값
    static double[] total = new double[3];     // 등록인구의 총합, 최댓값, 최솟값
    static double[] totalMale = new double[3]; // 남자 
    static double[] totalFemale = new double[3];// 여자
    
    static String getFileName(int i) {
        String fileName = "C:\\Users\\kyuwon\\Desktop\\art\\csv\\등록인구추이_";
        switch(i) {
        case 1 : fileName += "2009.csv"; break;
        case 2 : fileName += "2010.csv"; break;
        case 3 : fileName += "2011.csv"; break;
        case 4 : fileName += "2012.csv"; break;
        case 5 : fileName += "2013.csv"; break;
        case 6 : fileName += "2014.csv"; break;
        case 7 : fileName += "2015.csv"; break;
        case 8 : fileName += "2016.csv"; break;
        case 9 : fileName += "2017.csv"; break;
        case 10 : fileName += "2018.csv"; break;
        }
        return fileName;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(getFileName(1)), "CP949"));
            Arrays.fill(totalHome, 0); totalHome[2] = Integer.MAX_VALUE;
            Arrays.fill(total, 0); total[2] = Integer.MAX_VALUE;
            Arrays.fill(totalMale, 0); totalMale[2] = Integer.MAX_VALUE;
            Arrays.fill(totalFemale, 0); totalFemale[2] = Integer.MAX_VALUE;
            
            for (int i = 1; i <= numberOfFile + 5; i++) {
                report.add(new ArrayList<String>());
            }
             
            for (int i = 1; i<= numberOfFile; i++) {
                csvReader = new CSVReader(new InputStreamReader(new FileInputStream(getFileName(i)), "CP949"));
                
                String[] nextLine;
                
                int cnt = 0;
                while ((nextLine = csvReader.readNext()) != null) {
                    if (i == 1 && (cnt == 1 || cnt == 2)) {
                        if (cnt == 1) {
                            for (int j = 0; j < 5; j++) {
                                report.get(0).add(nextLine[j]);
                            }
                        } else {
                            for (int j = 0; j < 5; j++) {
                                report.get(1).add(nextLine[j]);
                            }
                        }
                    }
                    cnt++;
                    if (cnt < 3) continue;
                    if (cnt == 4) break;
                    
                    for (int j = 0; j < 5; j++) {
                        report.get(i + 1).add(nextLine[j]);
                    }
                    
                    totalHome[0] += Double.parseDouble(nextLine[1]);
                    totalHome[1] = Math.max(totalHome[1], Double.parseDouble(nextLine[1]));
                    totalHome[2] = Math.min(totalHome[2], Double.parseDouble(nextLine[1]));
                    
                    total[0] += Double.parseDouble(nextLine[2]);
                    total[1] = Math.max(total[1], Double.parseDouble(nextLine[2]));
                    total[2] = Math.min(total[2], Double.parseDouble(nextLine[2]));
                    
                    totalMale[0] += Double.parseDouble(nextLine[3]);
                    totalMale[1] = Math.max(totalMale[1], Double.parseDouble(nextLine[3]));
                    totalMale[2] = Math.min(totalMale[2], Double.parseDouble(nextLine[3]));
                    
                    totalFemale[0] += Double.parseDouble(nextLine[4]);
                    totalFemale[1] = Math.max(totalFemale[1], Double.parseDouble(nextLine[4]));
                    totalFemale[2] = Math.min(totalFemale[2], Double.parseDouble(nextLine[4]));
                }
            }
            
            csvReader.close();
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            CSVWriter cw = new CSVWriter(new FileWriter(writeFileName));
            
            String[] data = {"year", "totalGagu", "total", "totalMale", "totalFeMale"};
            cw.writeNext(data);
            
            for (int i = 2; i < 12; i++) {
                data = new String[5];
                for (int j = 0; j < 5; j++) {
                    data[j] = report.get(i).get(j);
                }
                cw.writeNext(data);
            }
            
            data = new String[5];
            data[0] = "Average";
            data[1] = Double.toString(totalHome[0] / 10);
            data[2] = Double.toString(total[0] / 10);
            data[3] = Double.toString(totalMale[0] / 10);
            data[4] = Double.toString(totalFemale[0] / 10);
            cw.writeNext(data);
            
            data = new String[5];
            data[0] = "Max";
            data[1] = Double.toString(totalHome[1]);
            data[2] = Double.toString(total[1]);
            data[3] = Double.toString(totalMale[1]);
            data[4] = Double.toString(totalFemale[1]);
            cw.writeNext(data);
            
            data = new String[5];
            data[0] = "Min";
            data[1] = Double.toString(totalHome[2]);
            data[2] = Double.toString(total[2]);
            data[3] = Double.toString(totalMale[2]);
            data[4] = Double.toString(totalFemale[2]);
            cw.writeNext(data);
            
            cw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
