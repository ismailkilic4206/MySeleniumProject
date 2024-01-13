package no03_JUnitAssertions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {

    @Test
    public void test(){
        //Test Case 9: Search Product
        //1. Launch browser
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement element = driver.findElement(By.xpath("(//div[@class='col-sm-6'])[1]"));
        Assert.assertTrue(element.isDisplayed());

        //4. Click on 'Products' button
        driver.findElement(By.xpath("(//a[@href='/products'])[1]")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(allProducts.isDisplayed());

        //6. Enter product name in search input and click search button
        WebElement search = driver.findElement(By.xpath("//input[@name='search']"));
        search.click();
        search.sendKeys("dress");
        driver.findElement(By.xpath("//button[@type='button']")).click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProducts = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(searchedProducts.isDisplayed());

        //8. close driver
        driver.close();
    }
}
