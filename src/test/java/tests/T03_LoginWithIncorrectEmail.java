package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T03_LoginWithIncorrectEmail extends TestBase {
    @Test
    public void testLoginWithIncorrectEmail() {
        //Test Case 3: Login User with incorrect email and password
        //1. Launch browser
        Actions actions = new Actions(driver);

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        WebElement loginAccount = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginAccount.isDisplayed());

        //6. Enter incorrect email address and password
        WebElement email = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        email.click();
        email.sendKeys("tr@l.com");
        WebElement password = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
        password.click();
        password.sendKeys("123456");

        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement accountIncorrect = driver.findElement(By.cssSelector("p[style='color: red;']"));
        Assert.assertTrue(accountIncorrect.isDisplayed());

        //9. Close driver
    }
}
