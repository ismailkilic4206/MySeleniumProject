package no01_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_FirstTest {
    public static void main(String[] args) {
        //1. Amazon sayfasina gidelim. https://www.amazon.com/
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));


        //2. Sayfa basligini(title) yazdirin
        System.out.println("Title of page is: " + driver.getTitle()); //Sayfa Basligi: Amazon.com


        //3. Sayfa basliginin “Amazon” icerdigini test edin
        String searchedTitle = "Amazon";
        String title = driver.getTitle();

        if (title.contains(searchedTitle)){
            System.out.println("Title contains " + searchedTitle + " and test of title PASSED");
        }  //Title contains Amazon and test of title PASSED
        else {
            System.out.println("Title don't contain " + searchedTitle + " and test of title FAILED");
        }


        //4. Sayfa adresini(url) yazdirin
        System.out.println("URL of page is : " + driver.getCurrentUrl());  //URL of page: https://www.amazon.com/


        //5. Sayfa url’inin “amazon” icerdigini test edin.


        String url = driver.getCurrentUrl();
        String searchedWord = "amazon";

        if (url.contains(searchedWord)){
            System.out.println("URL of page contains " + searchedWord + " and test of URL PASSED");
        } //URL of page contains amazon and test of URL PASSED
        else {
            System.out.println("URL of page don't contain " + searchedWord + " and test of URL FAILED");
        }
        //8. Sayfa handle degerini yazdirin
        System.out.println("Handle of page is: " + driver.getWindowHandle()); //Handle of page is: 8E970C4CC5FC3AEC7580F604738E2279


        //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
        String actuelPageSource = driver.getPageSource();
        String searchedWordInActuelPageSource = "alisveris";

        if (actuelPageSource.contains(searchedWordInActuelPageSource)) {
            System.out.println("HTML codes of the page contains " + searchedWordInActuelPageSource + " adn test PASSED");
        }
        else
            System.out.println("HTML codes of the page don't contain " + searchedWordInActuelPageSource + " adn test FAILED");
        //HTML codes of the page don't contain alisveris adn test FAILED


        //10. Sayfayi kapatin.
        driver.close();
    }
}
