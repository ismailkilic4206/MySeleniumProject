package no02_JUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class C02_TestNotasyonu {
    @Test
    public void test1(){

        //1. Trendyol"https://www.trendyol.com"
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        driver.get("https://www.trendyol.com");
        driver.close();
    }
    @Test
    public void test2(){
        //2. Instagram https://www.instagram.com
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        driver.get("https://www.instagram.com");
        driver.close();
    }
    @Test
    public   void  test3(){
        //3. Youtube https://www.youtube.com
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        driver.get("https://www.youtube.com");
        driver.close();
    }
}
