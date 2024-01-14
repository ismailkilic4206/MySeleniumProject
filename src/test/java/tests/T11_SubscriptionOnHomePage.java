package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T11_SubscriptionOnHomePage extends TestBase {

    @Test
    public void subscriptionOnHomePage(){
        // Test Case 11: Verify Subscription in Cart page
        // 1. Launch browser
        Actions actions = new Actions(driver);
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");
        // 3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        String  actuelUrl = driver.getCurrentUrl();

        // 4. Click 'Cart' button
        driver.findElement(By.xpath("//*[@*='/view_cart']")).click();

        // 5. Scroll down to footer
        // 6. Verify text 'SUBSCRIPTION'
        WebElement subscription = driver.findElement(By.xpath("//*[text()='Subscription']"));
        String subsText = subscription.getText();

        Assert.assertEquals(subsText, "SUBSCRIPTION");

        // 7. Enter email address in input and click arrow button
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        actions.click(email)
                .sendKeys("adsghkd@jkiy")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        // 8. Verify success message 'You have been successfully subscribed!' is visible
        WebElement message = driver.findElement(By.xpath("//div[@id='success-subscribe']"));
        Assert.assertTrue(message.isDisplayed());
    }
}
