package no03_JUnitAssertions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {

    @Test
    public void test1(){
        //Test Case 4: Logout User
        //1. Launch browser
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));

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

        //6. Enter correct email address and password
        WebElement email = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        email.click();
        email.sendKeys("kaunistr@gmail.com");
        WebElement password = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
        password.click();
        password.sendKeys("123456");

        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //8. Verify that 'Logged in as username' is visible
        WebElement visible = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(visible.isDisplayed());
        System.out.println(visible.getText());

        //9. Click 'Logout' button
        driver.findElement(By.xpath("//a[@href='/logout']")).click();

        //10. Verify that user is navigated to login page
        String expectedUrl = "https://automationexercise.com/login";
        String actuelUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actuelUrl);

        //11. Close driver
        driver.close();

    }
}
