package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestingBoard {
    public static WebDriver driver;
    public static String base_url = "http://192.168.23.20:8080/board2/board.jsp";
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:\\Users\\kyuwon\\Desktop\\library\\chromedriver.exe";

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        driver = new ChromeDriver();
        crawl();
    }
    
    static void crawl() {
        try {
            driver.get(base_url); // 검색창 접속
            Thread.sleep(2000);
            
            driver.findElement(By.xpath("/html/body/form[1]/button")).click();
            Thread.sleep(2000);
            
            for (int i = 0; i < 3; i++) {
                int ran = (int)(1 + 10 * Math.random());
                
                driver.findElement(By.xpath("/html/body/form[2]/button")).click();
                Thread.sleep(2000);
                
                driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[3]/td[2]/input")).sendKeys("Testing : " + Integer.toString(ran));
                Thread.sleep(2000);
                driver.findElement(By.xpath("/html/body/button")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("/html/body/form/button")).click();
                Thread.sleep(2000);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           // driver.close();
        }
    }
}
