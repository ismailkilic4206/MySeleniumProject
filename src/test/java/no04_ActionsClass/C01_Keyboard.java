package no04_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C01_Keyboard {
    @Test
    public void test() throws InterruptedException {
        //Test Case 1: Register User
        //1. Launch browser
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        Actions actions = new Actions(driver);

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement userSignUp = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(userSignUp.isDisplayed());

        //6. Enter name and email address
        //7. Click 'Signup' button
        WebElement name = driver.findElement(By.cssSelector("input[type='text']"));
        actions.click(name)
                .sendKeys("kemal")
                .sendKeys(Keys.TAB)
                .sendKeys("selam@lai.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInformation = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccountInformation.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        WebElement title = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        actions.click(title)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("lacin")
                .sendKeys(Keys.TAB)
                .sendKeys("9")
                .sendKeys(Keys.TAB)
                .sendKeys("April")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("kemal")
                .sendKeys(Keys.TAB)
                .sendKeys("lacin")
                .sendKeys(Keys.TAB)
                .sendKeys("company")
                .sendKeys(Keys.TAB)
                .sendKeys("address")
                .sendKeys(Keys.TAB)
                .sendKeys("address2")
                .sendKeys(Keys.TAB)
                .sendKeys("United States")
                .sendKeys(Keys.TAB)
                .sendKeys("NY")
                .sendKeys(Keys.TAB)
                .sendKeys("NY")
                .sendKeys(Keys.TAB)
                .sendKeys("01000")
                .sendKeys(Keys.TAB)
                .sendKeys("05000000000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreated = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.xpath("(//a[@href='/'])[3]")).click();

        //16. Verify that 'Logged in as username' is visible
        WebElement visible = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(visible.isDisplayed());

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeleted = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(accountDeleted.isDisplayed());

        //19. Close driver
        driver.close();
    }
}
