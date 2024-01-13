package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class T06_ContactUsForm extends TestBase {
    @Test
    public void testContactUsForm () throws InterruptedException {
        //Test Case 6: Contact Us Form
        //1. Launch browser
        Actions actions = new Actions(driver);

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());
        System.out.println("\"Home page\" is visible successfully");

        //4. Click on 'Contact Us' button
        driver.findElement(By.cssSelector("a[href='/contact_us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        Assert.assertTrue(getInTouch.isDisplayed());
        System.out.println("\"Get In Touch\" is visible successfully");

        //6. Enter name, email, subject and message
        WebElement name = driver.findElement(By.cssSelector("input[name='name']"));
        actions.click(name)
                .sendKeys("Name")
                .sendKeys(Keys.TAB)
                .sendKeys("Email@email")
                .sendKeys(Keys.TAB)
                .sendKeys("Subject")
                .sendKeys(Keys.TAB)
                .sendKeys("Your Message").perform();

        //7. Upload file
        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
        String dosyaYolu = "C:\\Users\\kauni\\OneDrive\\Masaüstü\\soru.jpg";
        fileInput.sendKeys(dosyaYolu);

        //8. Click 'Submit' button
        WebElement submit = driver.findElement(By.cssSelector("input[type='submit']"));
        actions.click(submit)
                .sendKeys(Keys.ENTER).perform();

        //9. Click OK button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement success = driver.findElement(By.cssSelector("div[class='status alert alert-success']"));
        Assert.assertTrue(getInTouch.isDisplayed());
        System.out.println("\"Success! Your details have been submitted successfully.\" is visible");

        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("(//a[@href=\"/\"])[3]")).click();
        WebElement logoAnaSayfa = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoAnaSayfa.isDisplayed());
        System.out.println("Returned to home page successfully");

    }
}


