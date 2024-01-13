package no02_JUnit;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClass_AfterClass {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
    }
    @AfterClass
    public static void last(){
        driver.close();
    }
    @Test
    public void test1(){
        driver.get("https://www.instagram.com");
    }
    //@Ignore bulundugu notasyonu gormezden gelir
    @Test
    public void test2(){
        driver.get("https://www.youtube.com");
    }
    @Test
    public void test3(){
        driver.get("https://www.trendyol.com");
    }


}
