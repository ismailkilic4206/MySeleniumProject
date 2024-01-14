package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class T10_Subscription extends TestBase {

    @Test
    public void subscription (){
        // Test Case 10: Verify Subscription in home page
        // 1. Launch browser
        Actions actions = new Actions(driver);
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");
        // 3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        String  actuelUrl = driver.getCurrentUrl();


        // 4. Scroll down to footer
        // 5. Verify text 'SUBSCRIPTION'
        WebElement subscription = driver.findElement(By.xpath("//*[text()='Subscription']"));
        String subsText = subscription.getText();

        Assert.assertEquals(subsText, "SUBSCRIPTION");


        // 6. Enter email address in input and click arrow button
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        actions.click(email)
                .sendKeys("adsghkd@jkiy")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        // 7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement message = driver.findElement(By.xpath("//div[@id='success-subscribe']"));
        Assert.assertTrue(message.isDisplayed());
    }
}
