package no01_driverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C08_TestExercise {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        //2-  "https://www.trendyol.com" adresine gidin
        driver.get("https://www.trendyol.com");


        Thread.sleep(1000);
        //3- cereleri kabul et
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();


        Thread.sleep(1000);
        //4-  Browseri tam sayfa yapin
        driver.manage().window().maximize();


        //5-  Sayfayi “refresh” yapin
        driver.navigate().refresh();


        //6-  Sayfa basliginin “Online” ifadesi icerdigini test edin
        String title = driver.getTitle();
        String searchedWord = "Online";
        if (title.contains(searchedWord)){
            System.out.println("Title contains " + searchedWord + " and test of title PASSED");
        }
        else
            System.out.println("Title don't contain " + searchedWord + " and test of title FAILED");


        //7-  "Sen De Al" a basin
        driver.findElement(By.cssSelector("img[loading='lazy']")).click();


        Thread.sleep(1000);
        //8-  'kuponlu urunler' butonuna basin
        driver.findElement(By.xpath("(//button[@class='quick-filters-item'])[1]")).click();


        Thread.sleep(3000);
        //9-  kuponlu urunler bolumunden ikinci urunu tiklayin
        driver.findElement(By.xpath("(//div[@class='p-card-wrppr with-campaign-view'])[2]")).click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));


        Thread.sleep(5000);
        //urunu sepete ekleyin
        driver.findElement(By.xpath("//div[@class='add-to-basket-button-text']")).click();


        Thread.sleep(3000);
        //sepete gidin
        driver.findElement(By.xpath("(//p[@class='link-text'])[3]")).click();


        //Sepete urun eklenip eklenmedigini kontrol ediniz eklendi ise eklediginiz urunun ismini ve fiyatini yazdirin
        WebElement urunEklendimi = driver.findElement(By.xpath("//div[@class='pb-header']"));
        WebElement name = driver.findElement(By.className("pb-item"));
        WebElement price = driver.findElement(By.xpath("(//div[@class='pb-basket-item-price'])"));
        if (urunEklendimi.getText() == "Sepetim (0 Ürün)") {
            System.out.println("Test FAILED");
        }
        else
        System.out.println("Test PASSED" +
                "\n" + "Sepete eklediginiz urunun ismi: " + name.getText() +
                "\n" + "Sepete eklediginiz urunun fiyati: " + price.getText());

        //11- Sayfalari kapatin
        driver.quit();
    }
}
