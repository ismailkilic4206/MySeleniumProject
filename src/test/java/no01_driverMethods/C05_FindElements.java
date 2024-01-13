package no01_driverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_FindElements {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        driver.manage().window().maximize();

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com");


        //3- Category bolumundeki elementleri locate edin
        List<WebElement> categoryList = driver.findElements(By.className("panel-heading"));
        System.out.println(categoryList);


        //4- Category bolumunde 3 element oldugunu test edin
        int in = 3;
        int panelTitleSize = categoryList.size();
        if (panelTitleSize == in){
            System.out.println("Kategori sayisi testi PASSED");
        }
        else
            System.out.println("Kategori sayisi testi FAILED");


        //5- Category isimlerini yazdirin
        for (WebElement eachElements : categoryList) {
            System.out.println(eachElements.getText());
        }


        //6- Sayfayi kapatin
        driver.close();
    }
}
