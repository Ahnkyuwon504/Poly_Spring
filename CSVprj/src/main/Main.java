package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String readFileName = "C:\\Users\\kyuwon\\Desktop\\subway_0625.csv";
        String writeFilename = "C:\\Users\\kyuwon\\Desktop\\test.csv";
        
        CSVReader csvReader;
        
        try {
            csvReader = new CSVReader(new InputStreamReader(new FileInputStream(readFileName), "CP949"));
            String[] nextLine;
            
            while ((nextLine = csvReader.readNext()) != null) {
                System.out.println(nextLine.length + " : " + String.join("|", nextLine));
            }
            
            csvReader.close();
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            CSVWriter cw = new CSVWriter(new FileWriter(writeFilename));
            String[] data = {"abc", "def", "ghi"};
            cw.writeNext(data);
            cw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
