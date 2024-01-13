package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T05_RegisterWithExistingEmail extends TestBase {
    @Test
    public void testRegisterWithExistingEmail() {
        //Test Case 5: Register User with existing email
        //1. Launch browser
        Actions actions = new Actions(driver);

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());
        System.out.println("Home page is visible successfully");

        //4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement userSignUp = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(userSignUp.isDisplayed());
        System.out.println("'New User Signup!' is visible");

        //6. Enter name and already registered email address
        //7. Click 'Signup' button
        WebElement name = driver.findElement(By.cssSelector("input[type='text']"));
        actions.click(name)
                .sendKeys("turan")
                .sendKeys(Keys.TAB)
                .sendKeys("kau@kl")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //8. Verify error 'Email Address already exist!' is visible
        WebElement errorVisible = driver.findElement(By.cssSelector("p[style='color: red;']"));
        Assert.assertTrue(errorVisible.isDisplayed());
        System.out.println("'Email Address already exist!' is visible");

        //9. Close driver
    }
}
