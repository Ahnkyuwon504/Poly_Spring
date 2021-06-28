package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVWriter;

public class CollectIdol {
    
    static ArrayList<ArrayList<String>> news = new ArrayList<ArrayList<String>>(); // 1번은 date, 2번은 title
    
    public static WebDriver driver;
    public static String base_url = "https://search.naver.com/search.naver?where=news&sm=tab_jum&query=제국의+아이들";
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:\\Users\\kyuwon\\Desktop\\library\\chromedriver.exe";

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        driver = new ChromeDriver();
        crawl();
        restoreCSV();
    }
    
    static void crawl() {
        try {
            driver.get(base_url); // 검색창 접속
            Thread.sleep(2000);
            /*
             * Thread.sleep(2000);
             * driver.findElement(By.xpath("/html/body/div/table/tbody/tr[3]/td[2]/a")).
             * click(); Thread.sleep(2000);
             * driver.findElement(By.xpath("/html/body/div/button")).click();
             */
            driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[1]/div[1]/div/div[2]/a")).click();
            Thread.sleep(2000);
            
            driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[1]/div[2]/ul/li[2]/div/div[1]/a[5]")).click();
            Thread.sleep(2000);
            
            int cnt = 0;
            boolean isLast = false;
            
            while (true) {
                for (int i = 1; i <= 10; i++) {
                    String time = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/section/div/div[2]/ul/li[" + i + "]/div[1]/div/div[1]/div[2]/span")).getText();
                    String name = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/section/div/div[2]/ul/li[" + i + "]/div/div/a")).getText();
                    
                    news.add(new ArrayList<String>());
                    news.get(cnt).add(Integer.toString(cnt + 1));
                    news.get(cnt).add(time);
                    news.get(cnt).add(name);
                    cnt++;
                    Thread.sleep(1000);
                }
                    driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[2]/div/a[2]")).click();
                    Thread.sleep(1000);
                    
                    WebElement last = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[2]/div/a[2]"));
                    
                    if (isLast) break; 
                    if (last.getAttribute("aria-disabled").equals("true")) isLast = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           // driver.close();
        }
    }
    
    static void restoreCSV() {
        try {
            String writeFileName = "C:\\Users\\kyuwon\\Desktop\\art\\idol.csv";
            //CSVWriter cw = new CSVWriter(new FileWriter(writeFileName));
            CSVWriter cw = new CSVWriter(new OutputStreamWriter(new FileOutputStream(writeFileName), "EUC-KR"));
            
            for (int i = 0; i < news.size(); i++) {
                String[] data = new String[3];
                data[0] = news.get(i).get(0);
                data[1] = news.get(i).get(1);
                data[2] = news.get(i).get(2);
                cw.writeNext(data);
            }
            
            cw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
