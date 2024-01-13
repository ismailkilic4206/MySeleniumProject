package no02_JUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JUnit {

    @Test
    public  void  test01(){
        //1. Trendyol sayfasina gidelim. "https://www.trendyol.com"
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.trendyol.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));

        //2- cereleri kabul et
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        //3.arama kutusunu aktif hale getirin
        WebElement aramaKutusu = driver.findElement(By.className("V8wbcUhU"));
        aramaKutusu.click();

        //4.arama cubuguna "ahsap 3d puzzle" yazdirin
        aramaKutusu.sendKeys("ahsap 3d puzzle");

        //5.enter tusuna basarak yazilan keys i aratin
        driver.findElement(By.className("cyrzo7gC")).click();

        //6.bulunan sonuc sayisini yazdirin
        WebElement sonuc = driver.findElement(By.xpath("//div[@class='dscrptn dscrptn-V2']"));
        System.out.println(sonuc.getText());
        //.
    }
}
