package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static WebDriver driver;
    public static String base_url = "http://192.168.23.34:8080/BoardProject/index.jsp";
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:\\Users\\kyuwon\\Desktop\\library\\chromedriver.exe";

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        driver = new ChromeDriver();
        Crawl();

    }
    
    static void Crawl() {
        try {
            driver.get(base_url);
            //System.out.println(driver.getPageSource());
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div/table/tbody/tr[3]/td[2]/a")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div/button")).click();
            Thread.sleep(2000);
           // String temp = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div/div[1]/ul/li[1]/a/div[2]/strong")).getText();
           // System.out.println(temp);
            
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[3]/td/input")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[3]/td/input")).sendKeys("정자동 샹크스 김범주!정자동 샹크스 김범주!");
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[4]/td/input")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[4]/td/input")).sendKeys("한열");
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[6]/td/textarea")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[6]/td/textarea")).sendKeys("정자동 붉은까마귀 김범주 화이팅!정자동 붉은까마귀 김범주 화이팅!정자동 붉은까마귀 김범주 화이팅!정자동 붉은까마귀 김범주 화이팅!정자동 붉은까마귀 김범주 화이팅!정자동 붉은까마귀 김범주 화이팅!정자동 붉은까마귀 김범주 화이팅!정자동 붉은까마귀 김범주 화이팅!정자동 붉은까마귀 김범주 화이팅!정자동 붉은까마귀 김범주 화이팅!정자동 붉은까마귀 김범주 화이팅!");
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div/form/input")).click();
//            Thread.sleep(2000);
//            driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/form/fieldset/input[3]")).click();
//            Thread.sleep(2000);
//            driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/form/fieldset/input[3]")).sendKeys("CB");
//            Thread.sleep(2000);
//            driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/form/fieldset/button")).click();
            
            
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           // driver.close();
        }
    }

}
