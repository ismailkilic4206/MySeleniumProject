package no01_driverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_FindElement {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        driver.manage().window().maximize();

        //Trendyol sayfasina gidiniz
        driver.get("https://www.trendyol.com");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        driver.findElement(By.className("V8wbcUhU")).click();
        driver.findElement(By.className("V8wbcUhU")).sendKeys("Oyuncak");
    }
}
