package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T08_ProductDetailPage extends TestBase {

    @Test
    public void productDetailPage () throws InterruptedException {
        // Test Case 8: Verify All Products and product detail page

        Actions actions = new Actions(driver);
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");
        // 3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        String  actuelUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actuelUrl);

        // 4. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        // 5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//*[text()='All Products']"));
        String allPro = allProducts.getText();

        Assert.assertEquals(allPro, "ALL PRODUCTS");

        // 6. Click on 'View Product' of first product
        driver.findElement(By.xpath("//*[@href='/product_details/1']")).click();

        // 7. User is landed to product detail page
        Thread.sleep(2000);
        WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
        actions.click(name)
                .sendKeys("Ahmet").perform();
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        actions.click(email)
                .sendKeys("ahmet@mail").perform();
        Thread.sleep(2000);
        WebElement text = driver.findElement(By.xpath("//textarea[@id='review']"));
        actions.click(text)
                .sendKeys("ahmet@ sdfghj dfgh dfghj dfgh rtyui zxcvbn mail").perform();
        Thread.sleep(5000);
        // 8. Verify that detail is visible: product name, category, price,
        //    availability, condition, brand
        WebElement productName = driver.findElement(By.xpath("//*[text()='Blue Top']"));
        Assert.assertTrue(productName.isDisplayed());
        WebElement category = driver.findElement(By.xpath("//*[text()='Category: Women > Tops']"));
        Assert.assertTrue(category.isDisplayed());
        WebElement price = driver.findElement(By.xpath("//*[text()='Rs. 500']"));
        Assert.assertTrue(price.isDisplayed());
        WebElement availability = driver.findElement(By.xpath("//*[text()=' In Stock']"));
        Assert.assertTrue(availability.isDisplayed());
        WebElement condition = driver.findElement(By.xpath("//*[text()=' New']"));
        Assert.assertTrue(condition.isDisplayed());
        WebElement brand = driver.findElement(By.xpath("//*[text()=' Polo']"));
        Assert.assertTrue(brand.isDisplayed());
    }
}
