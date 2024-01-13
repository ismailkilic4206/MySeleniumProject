package no03_JUnitAssertions;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
    }
    //@AfterClass
    //public static void last(){
    //    driver.close();
    //}
    @Test
    public void test1 (){
        //1. Trendyol sayfasina gidelim. "https://www.trendyol.com"
        driver.get("https://www.trendyol.com");
        //2- cereleri kabul edelim
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        //3.arama kutusunu aktif hale getirin
        WebElement aramaKutusu = driver.findElement(By.className("V8wbcUhU"));
        aramaKutusu.click();
        //4.arama cubuguna "ahsap 3d puzzle" yazdirin
        aramaKutusu.sendKeys("bilgisayar");
        //5.enter tusuna basarak yazilan keys i aratin
        driver.findElement(By.className("cyrzo7gC")).click();
        //6.bulunan sonuc sayisini yazdirin
        WebElement sonuc = driver.findElement(By.xpath("//div[@class='dscrptn dscrptn-V2']"));
        String actuelYazi = sonuc.getText();
        System.out.println(actuelYazi);
        String expectedYazi = "bilgisayar";
        Assert.assertTrue(actuelYazi.contains(expectedYazi));
    }
}
