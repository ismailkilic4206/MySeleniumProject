package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T07_TestCasesPage extends TestBase {

    @Test
    public void testCasesPage () throws InterruptedException {
        // Test Case 7: Verify Test Cases Page
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");
        // 3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        String  actuelUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actuelUrl);


        // 4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//a[@href='/test_cases']")).click();
        Thread.sleep(5000);

        // 5. Verify user is navigated to test cases page successfully
        WebElement testCases = driver.findElement(By.xpath("//*[text()='Test Cases']"));
        Assert.assertTrue(testCases.isDisplayed());
    }
}
