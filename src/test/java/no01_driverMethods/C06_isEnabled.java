package no01_driverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_isEnabled {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        driver.manage().window().maximize();

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com");


        //3- Sayfada 147 adet link bulundugunu test edin.
        int link = 147;
        List<WebElement> tag = driver.findElements(By.xpath("//a"));
        if (tag.size() == link){
            System.out.println("Test is PASSED");
        }
        else
            System.out.println("Test is FAILED");


        //4- Products linkine tiklayin
        driver.findElement(By.xpath("//a[@href='/products']")).click();


        //5- special offer yazisinin gorundugunu test edin
        WebElement elementOfSpecialOffer = driver.findElement(By.xpath("//img[@id='sale_image']"));

        if (elementOfSpecialOffer.isDisplayed()){
            System.out.println("Test is PASSED");
        }
        else
            System.out.println("Test is FAILED");


        //6- Sayfayi kapatin
        driver.close();
    }
}
