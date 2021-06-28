package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class ReadArt {
    
    static String writeFileName = "C:\\Users\\kyuwon\\Desktop\\art\\artReport.csv";
    static int numberOfFile = 5;
    static double[] result = new double[4];
    static double[] max_result = new double[4];
    static double[] min_result = new double[4];
    
    static String getFileName(int i) {
        String fileName = "";
        switch(i) {
        case 1 : fileName = "C:\\Users\\kyuwon\\Desktop\\art\\미술분야_1997.csv"; break;
        case 2 : fileName = "C:\\Users\\kyuwon\\Desktop\\art\\미술분야_2000.csv"; break;
        case 3 : fileName = "C:\\Users\\kyuwon\\Desktop\\art\\미술분야_2003.csv"; break;
        case 4 : fileName = "C:\\Users\\kyuwon\\Desktop\\art\\미술분야_2006.csv"; break;
        case 5 : fileName = "C:\\Users\\kyuwon\\Desktop\\art\\미술분야_2009.csv"; break;
        }
        return fileName;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(getFileName(1)), "CP949"));
            Arrays.fill(result, 0);
            Arrays.fill(max_result, Integer.MIN_VALUE);
            Arrays.fill(min_result, Integer.MAX_VALUE);
            
            for (int i = 1; i<= numberOfFile; i++) {
                csvReader = new CSVReader(new InputStreamReader(new FileInputStream(getFileName(i)), "CP949"));
                
                String[] nextLine;
                
                int cnt = 0;
                while ((nextLine = csvReader.readNext()) != null) {
                    cnt++;
                    if (cnt < 3) continue;
                    if (cnt == 7) break;
                    
                    result[cnt - 3] += Double.parseDouble(nextLine[2]);
                    max_result[cnt - 3] = Math.max(max_result[cnt - 3], Double.parseDouble(nextLine[2]));
                    min_result[cnt - 3] = Math.min(min_result[cnt - 3], Double.parseDouble(nextLine[2]));
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
            String[] data = new String[] {"", "all", "dongyang", "seoyang", "jogag"};
            cw.writeNext(data);
            
            data = new String[5];
            for (int i = 0; i < data.length; i++) {
                if (i == 0) {
                    data[i] = "average";
                    continue;
                }
                data[i] = Double.toString(result[i - 1] / 5);
            }
            cw.writeNext(data);
            
            data = new String[5];
            for (int i = 0; i < data.length; i++) {
                if (i == 0) {
                    data[i] = "max";
                    continue;
                }
                data[i] = Double.toString(max_result[i - 1]);
            }
            cw.writeNext(data);
            
            data = new String[5];
            for (int i = 0; i < data.length; i++) {
                if (i == 0) {
                    data[i] = "min";
                    continue;
                }
                data[i] = Double.toString(min_result[i - 1]);
            }
            cw.writeNext(data);
            
            cw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
