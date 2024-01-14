package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class T09_SearchProduct extends TestBase {

    @Test
    public void searchProduct() throws InterruptedException {
        // Test Case 9: Search Product
        // 1. Launch browser
        Actions actions = new Actions(driver);
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");
        // 3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        String  actuelUrl = driver.getCurrentUrl();

        // 4. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        // 5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//*[text()='All Products']"));
        String allPro = allProducts.getText();

        Assert.assertEquals(allPro, "ALL PRODUCTS");

        // 6. Enter product name in search input and click search button
        WebElement searchProduct = driver.findElement(By.xpath("//input[@type='text']"));
        actions.click(searchProduct)
                .sendKeys("tshirt").perform();
        WebElement searchButton = driver.findElement(By.xpath("//*[@type='button']"));
        searchButton.click();
        //Thread.sleep(5000);

        // 7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement textElement = driver.findElement(By.xpath("//*[text()='Searched Products']"));
        String text = textElement.getText();
        Assert.assertEquals(text,"SEARCHED PRODUCTS");

        // 8. Verify all the products related to search are visible
        List<WebElement> bulunanUrunElementleriList= driver.findElements(By.xpath("//div/div/div/div/div[@class='col-sm-4']"));
        int expectedElement = 6;
        int actuelElement = bulunanUrunElementleriList.size();

        Assert.assertEquals(expectedElement, actuelElement);
    }
}
